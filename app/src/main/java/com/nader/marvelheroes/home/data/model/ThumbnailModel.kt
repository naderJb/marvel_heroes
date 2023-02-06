package com.nader.marvelheroes.home.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ThumbnailModel(
    @SerializedName("path")
    val path: String?,
    @SerializedName("extension")
    val extension: String?,
)
