package com.nader.marvelheroes.home.domain

import com.nader.marvelheroes.core.model.APIResponse
import com.nader.marvelheroes.core.model.CommonResponse
import com.nader.marvelheroes.home.data.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface HomeUseCase {
    suspend fun getAllCharacters(): Flow<APIResponse<CommonResponse<List<CharacterModel>>>>
}