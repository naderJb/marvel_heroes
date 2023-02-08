package com.nader.marvelheroes.home.data.repository

import com.nader.marvelheroes.core.model.APIResponse
import com.nader.marvelheroes.core.model.CommonResponse
import com.nader.marvelheroes.home.data.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getAllCharacters(
        nameStartsWith: String?
    ): Flow<APIResponse<CommonResponse<List<CharacterModel>>>>
}