package com.nader.marvelheroes.core.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class UrlModel(
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?,
)
