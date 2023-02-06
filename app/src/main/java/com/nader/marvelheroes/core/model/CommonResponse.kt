package com.nader.marvelheroes.core.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CommonResponse<T>(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("attributionText")
    val attributionText: String?,
    @SerializedName("attributionHTML")
    val attributionHTML: String?,
    @SerializedName("etag")
    val eTag: String?,
    @SerializedName("data")
    val data: Data<T>?
    )
