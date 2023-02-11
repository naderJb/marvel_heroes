package com.nader.marvelheroes.core.extensions

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import com.nader.marvelheroes.BuildConfig
import com.nader.marvelheroes.core.utils.CommonUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
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

fun String?.isNotEmptyOrNull() = this?.ifEmpty { null }

suspend fun String?.toBitmap(): Bitmap? = withContext(Dispatchers.IO){
    return@withContext try {
        BitmapFactory.decodeStream(URL(this@toBitmap).openConnection().getInputStream())
    } catch (e: Exception) {
        null
    }
}
