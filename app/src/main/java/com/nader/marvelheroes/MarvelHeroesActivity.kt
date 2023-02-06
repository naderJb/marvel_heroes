package com.nader.marvelheroes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nader.marvelheroes.databinding.ActivityMarvelHeroesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarvelHeroesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMarvelHeroesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarvelHeroesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}