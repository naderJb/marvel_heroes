package com.nader.marvelheroes.home.data.remote.services

import com.lembergsolutions.retrofitretry.api.RetryOnError
import com.nader.marvelheroes.core.model.CommonResponse
import com.nader.marvelheroes.home.data.model.CharacterInfoModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharactersService {

    @RetryOnError
    @GET("/v1/public/characters/{characterId}")
    suspend fun getCharacters(
        @Path("characterId") characterId: String
    ): Response<CommonResponse<List<CharacterInfoModel>>>

    @RetryOnError
    @GET("/v1/public/characters/{characterId}/comics")
    suspend fun getCharactersComics(
        @Path("characterId") characterId: String
    ): Response<CommonResponse<List<CharacterInfoModel>>>

    @RetryOnError
    @GET("/v1/public/characters/{characterId}/events")
    suspend fun getCharactersEvents(
        @Path("characterId") characterId: String
    ): Response<CommonResponse<List<CharacterInfoModel>>>

    @RetryOnError
    @GET("/v1/public/characters/{characterId}/series")
    suspend fun getCharactersSeries(
        @Path("characterId") characterId: String
    ): Response<CommonResponse<List<CharacterInfoModel>>>

    @RetryOnError
    @GET("/v1/public/characters/{characterId}/stories")
    suspend fun getCharactersStories(
        @Path("characterId") characterId: String
    ): Response<CommonResponse<List<CharacterInfoModel>>>
}