package com.nader.marvelheroes.core.extensions

import android.net.Uri
import com.nader.marvelheroes.BuildConfig
import com.nader.marvelheroes.core.utils.CommonUtils
import java.security.MessageDigest

fun String.toMD5(): String {
    val bytes = MessageDigest.getInstance("MD5").digest(this.toByteArray())
    return bytes.toHex()
}

@JvmOverloads
fun String?.safe(defaultValue: String = ""): String = this ?: defaultValue

fun String.injectQueries() = Uri.parse(this)
    .buildUpon()
    .appendQueryParameter("ts", System.currentTimeMillis().toString())
    .appendQueryParameter("apikey", BuildConfig.PUBLIC_KEY)
    .appendQueryParameter("hash", CommonUtils.getApiHash())
    .build()
    .toString()
