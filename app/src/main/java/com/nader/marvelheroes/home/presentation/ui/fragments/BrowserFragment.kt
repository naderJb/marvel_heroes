package com.nader.marvelheroes.home.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.nader.marvelheroes.R
import com.nader.marvelheroes.core.base.BaseFragment
import com.nader.marvelheroes.databinding.FragmentBrowoserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BrowserFragment : BaseFragment() {

    private var _binding: FragmentBrowoserBinding? = null
    private val binding get() = _binding!!

    private val args: BrowserFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBrowoserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.webView.loadUrl(args.url)

        binding.webView.apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}