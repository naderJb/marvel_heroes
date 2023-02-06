package com.nader.marvelheroes.core.utils

import com.nader.marvelheroes.BuildConfig
import com.nader.marvelheroes.core.extensions.toMD5

object CommonUtils {
    fun getApiHash() =
        (System.currentTimeMillis()
            .toString() + BuildConfig.PRIVATE_KEY + BuildConfig.PUBLIC_KEY).toMD5()

}