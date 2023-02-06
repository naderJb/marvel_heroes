package com.nader.marvelheroes.home.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.nader.marvelheroes.core.model.CommonType
import com.nader.marvelheroes.core.model.UrlModel

@Keep
data class CharacterModel(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailModel?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("comics")
    val comics: CommonType?,
    @SerializedName("series")
    val series: CommonType?,
    @SerializedName("stories")
    val stories: CommonType?,
    @SerializedName("events")
    val events: CommonType?,
    @SerializedName("urls")
    val urls: List<UrlModel>?,
)
