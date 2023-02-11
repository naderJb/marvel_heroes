package com.nader.marvelheroes.home.domain

import com.nader.marvelheroes.core.model.APIResponse
import com.nader.marvelheroes.core.model.CommonResponse
import com.nader.marvelheroes.home.data.model.CharacterInfoModel
import kotlinx.coroutines.flow.Flow

interface CharacterUseCase {
    suspend fun getCharacters(
        characterId: String
    ): Flow<APIResponse<CommonResponse<List<CharacterInfoModel>>>>

    suspend fun getCharactersComics(
        characterId: String
    ): Flow<APIResponse<CommonResponse<List<CharacterInfoModel>>>>

    suspend fun getCharactersEvents(
        characterId: String
    ): Flow<APIResponse<CommonResponse<List<CharacterInfoModel>>>>

    suspend fun getCharactersSeries(
        characterId: String
    ): Flow<APIResponse<CommonResponse<List<CharacterInfoModel>>>>

    suspend fun getCharactersStories(
        characterId: String
    ): Flow<APIResponse<CommonResponse<List<CharacterInfoModel>>>>
}