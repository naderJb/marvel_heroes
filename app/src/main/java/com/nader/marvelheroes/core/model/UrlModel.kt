package com.nader.marvelheroes.core.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class UrlModel(
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?,
) : Parcelable
