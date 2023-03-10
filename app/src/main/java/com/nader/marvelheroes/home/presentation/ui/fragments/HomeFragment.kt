package com.nader.marvelheroes.home.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isGone
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nader.marvelheroes.core.base.BaseFragment
import com.nader.marvelheroes.core.extensions.isNotEmptyOrNull
import com.nader.marvelheroes.core.extensions.onTextChangedListener
import com.nader.marvelheroes.core.model.DataStatus
import com.nader.marvelheroes.core.utils.Prefs
import com.nader.marvelheroes.core.utils.Throttler
import com.nader.marvelheroes.databinding.FragmentHomeBinding
import com.nader.marvelheroes.home.presentation.ui.adapters.CharactersAdapter
import com.nader.marvelheroes.home.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var adapter: CharactersAdapter

    private val throttler: Throttler by lazy { Throttler() }
    private val prefs: Prefs by lazy { Prefs(requireActivity()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
        initObservers()
    }


    private fun initViews() {
        binding.rvCharacters.adapter = adapter
        homeViewModel.getCategories()
        AppCompatDelegate.setDefaultNightMode(prefs.getTheme())
    }

    private fun initListeners() {
        binding.header.ivSwitchTheme.setOnClickListener {
            val nightMode = when (AppCompatDelegate.getDefaultNightMode()) {
                AppCompatDelegate.MODE_NIGHT_YES -> AppCompatDelegate.MODE_NIGHT_NO
                else -> AppCompatDelegate.MODE_NIGHT_YES
            }
            AppCompatDelegate.setDefaultNightMode(nightMode)
            prefs.setTheme(nightMode)
        }

        binding.header.svSearch.onTextChangedListener {
            throttler.throttle {
                homeViewModel.getCategories(it.isNotEmptyOrNull())
            }
        }
        adapter.setOnItemClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToCharactersFragment(it)
            )
        }
    }

    private fun initObservers() {
        homeViewModel.characters.observe(viewLifecycleOwner) {
            adapter.addData(ArrayList(it))
        }
        homeViewModel.status.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let { dataStatus ->
                when (dataStatus) {
                    DataStatus.DataLoading -> showLoading(true)
                    DataStatus.DataLoaded -> showLoading(false)
                    is DataStatus.DataError -> {
                        showLoading(false)
                        handleException(dataStatus.exception)
                    }
                }
            }
        }
    }

    private fun showLoading(isLoading: Boolean) =
        apply {
            binding.laLoading.isGone = isLoading.not()
            binding.rvCharacters.isGone = isLoading
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}