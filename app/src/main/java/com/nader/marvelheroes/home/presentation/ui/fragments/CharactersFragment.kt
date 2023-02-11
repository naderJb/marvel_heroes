package com.nader.marvelheroes.home.presentation.ui.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.isGone
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.nader.marvelheroes.R
import com.nader.marvelheroes.core.base.BaseFragment
import com.nader.marvelheroes.core.extensions.delayOnLifecycle
import com.nader.marvelheroes.core.extensions.safe
import com.nader.marvelheroes.core.extensions.setWindowsColor
import com.nader.marvelheroes.databinding.FragmentCharactersBinding
import com.nader.marvelheroes.home.presentation.ui.adapters.CharacterPublicationsAdapter
import com.nader.marvelheroes.home.presentation.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class CharactersFragment : BaseFragment() {

    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!

    private val navArgs: CharactersFragmentArgs by navArgs()
    private val characterViewModel: CharacterViewModel by viewModels()

    @Inject
    lateinit var comicsAdapter: CharacterPublicationsAdapter

    @Inject
    lateinit var seriesAdapter: CharacterPublicationsAdapter

    @Inject
    lateinit var eventsAdapter: CharacterPublicationsAdapter

    @Inject
    lateinit var storiesAdapter: CharacterPublicationsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        implementListeners()
        initObservers()
    }

    private fun initViews() {
        binding.hero = navArgs.character
        characterViewModel.getCharactersComics(navArgs.character.id.toString())
        characterViewModel.getCharactersStories(navArgs.character.id.toString())
        characterViewModel.getCharactersEvents(navArgs.character.id.toString())
        characterViewModel.getCharactersSeries(navArgs.character.id.toString())
        binding.layoutComics.tvTitle.setText(R.string.character_type_comics)
        binding.layoutSeries.tvTitle.setText(R.string.character_type_series)
        binding.layoutEvents.tvTitle.setText(R.string.character_type_events)
        binding.layoutStories.tvTitle.setText(R.string.character_type_stories)

        binding.layoutComics.rvPublications.adapter = comicsAdapter
        binding.layoutSeries.rvPublications.adapter = seriesAdapter
        binding.layoutEvents.rvPublications.adapter = eventsAdapter
        binding.layoutStories.rvPublications.adapter = storiesAdapter
        Glide
            .with(requireContext())
            .load(navArgs.character.thumbnail?.getImage())
            .placeholder(R.drawable.bg_marvel_icon)
            .error(R.drawable.bg_marvel_icon)
            .fallback(R.drawable.bg_marvel_icon)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    Palette.from(resource.toBitmap())
                        .generate().darkVibrantSwatch?.rgb?.let { rgb ->
                            binding.collapsingToolbar.setContentScrimColor(rgb)
                            setWindowsColor(rgb)
                        }
                    return false
                }

            })
            .into(binding.ivCharacter)


    }

    private fun implementListeners() {
        comicsAdapter.setOnItemClickListener {
            navigateToWebView(it.urlModel?.firstOrNull()?.url.safe())
        }
        seriesAdapter.setOnItemClickListener {
            navigateToWebView(it.urlModel?.firstOrNull()?.url.safe())
        }
        eventsAdapter.setOnItemClickListener {
            navigateToWebView(it.urlModel?.firstOrNull()?.url.safe())
        }
        storiesAdapter.setOnItemClickListener {
            navigateToWebView(it.urlModel?.firstOrNull()?.url.safe())
        }
    }

    private fun initObservers() {
        characterViewModel.comics.observe(viewLifecycleOwner) {
            comicsAdapter.addData(ArrayList(it))
            binding.layoutComics.root.isGone = it.isEmpty()
        }
        characterViewModel.series.observe(viewLifecycleOwner) {
            seriesAdapter.addData(ArrayList(it))
            binding.layoutSeries.root.isGone = it.isEmpty()
        }
        characterViewModel.events.observe(viewLifecycleOwner) {
            eventsAdapter.addData(ArrayList(it))
            binding.layoutEvents.root.isGone = it.isEmpty()
        }
        characterViewModel.stories.observe(viewLifecycleOwner) {
            storiesAdapter.addData(ArrayList(it))
            binding.layoutStories.root.isGone = it.isEmpty()
        }
    }

    private fun navigateToWebView(url:String){
        findNavController().navigate(
            CharactersFragmentDirections.actionCharactersFragmentToBrowserFragment(url)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}