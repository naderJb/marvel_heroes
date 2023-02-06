package com.nader.marvelheroes.core.extensions


@JvmOverloads
fun Int?.safe(defaultValue: Int = 0) = this ?: defaultValue