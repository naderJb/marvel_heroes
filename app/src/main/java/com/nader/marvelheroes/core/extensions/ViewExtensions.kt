package com.nader.marvelheroes.core.extensions

import android.view.View

fun View.gone() = apply { this.visibility = View.GONE }

fun View.visible() = apply { this.visibility = View.VISIBLE }