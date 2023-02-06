package com.nader.marvelheroes.core.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ItemsModel(
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("type")
    val type: String?,
)
