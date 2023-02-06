package com.nader.marvelheroes.home.data.remote.services

import com.lembergsolutions.retrofitretry.api.RetryOnError
import com.nader.marvelheroes.core.model.CommonResponse
import com.nader.marvelheroes.home.data.model.CharacterModel
import retrofit2.Response
import retrofit2.http.GET

interface HomeService {

    @RetryOnError(10)
    @GET("/v1/public/characters")
    suspend fun getAllCharacters(): Response<CommonResponse<List<CharacterModel>>>
}