package com.nader.marvelheroes.core.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Data<T>(
    @SerializedName("offset")
    val offset: Int?,
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("total")
    val total: Int?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("results")
    val results: T,
)
