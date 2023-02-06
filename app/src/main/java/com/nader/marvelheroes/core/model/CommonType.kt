package com.nader.marvelheroes.core.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CommonType(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("collectionURI")
    val collectionURI: String?,
    @SerializedName("items")
    val items: List<ItemsModel>?,
    @SerializedName("returned")
    val returned: Int?
)
