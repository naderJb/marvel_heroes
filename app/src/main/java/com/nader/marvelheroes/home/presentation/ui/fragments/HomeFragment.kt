package com.nader.marvelheroes.home.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nader.marvelheroes.databinding.FragmentHomeBinding
import com.nader.marvelheroes.home.presentation.ui.adapters.CharactersAdapter
import com.nader.marvelheroes.home.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var adapter: CharactersAdapter

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

    }

    private fun initListeners() {
        binding.header.ivSwitchTheme.setOnClickListener {
            val nightMode = when (AppCompatDelegate.getDefaultNightMode()) {
                AppCompatDelegate.MODE_NIGHT_YES -> AppCompatDelegate.MODE_NIGHT_NO
                else -> AppCompatDelegate.MODE_NIGHT_YES
            }
            AppCompatDelegate.setDefaultNightMode(nightMode)
        }
    }

    private fun initObservers() {
        homeViewModel.characters.observe(viewLifecycleOwner) {
            adapter.addData(ArrayList(it))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}