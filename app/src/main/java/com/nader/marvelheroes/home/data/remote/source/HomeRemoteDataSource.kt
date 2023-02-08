package com.nader.marvelheroes.home.data.remote.source

import com.nader.marvelheroes.core.model.CommonResponse
import com.nader.marvelheroes.home.data.model.CharacterModel

interface HomeRemoteDataSource {
    suspend fun getAllCharacters(
        nameStartsWith: String?
    ): CommonResponse<List<CharacterModel>>
}