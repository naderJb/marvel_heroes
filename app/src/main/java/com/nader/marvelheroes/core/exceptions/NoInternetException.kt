package com.nader.marvelheroes.core.exceptions

import java.io.IOException

class NoInternetException constructor(private val errorMessage: String = "") : IOException(errorMessage)