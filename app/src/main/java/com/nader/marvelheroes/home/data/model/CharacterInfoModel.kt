package com.nader.marvelheroes.home.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.nader.marvelheroes.core.model.UrlModel
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class CharacterInfoModel(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailModel?,
    @SerializedName("urls")
    val urlModel: List<UrlModel>?,
) : Parcelable
