package com.nader.marvelheroes.home.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class ThumbnailModel(
    @SerializedName("path")
    val path: String?,
    @SerializedName("extension")
    val extension: String?,
) : Parcelable {
    fun getImage() = "$path.$extension"
}
