package com.nader.marvelheroes.core.extensions

@JvmOverloads
fun Boolean?.safe(defaultValue: Boolean = false) = this ?: defaultValue