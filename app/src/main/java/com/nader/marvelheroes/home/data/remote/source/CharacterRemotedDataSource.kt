package com.nader.marvelheroes.home.data.remote.source

import com.nader.marvelheroes.core.model.CommonResponse
import com.nader.marvelheroes.home.data.model.CharacterInfoModel

interface CharacterRemotedDataSource {
    suspend fun getCharacters(
        characterId: String
    ): CommonResponse<List<CharacterInfoModel>>

    suspend fun getCharactersComics(
        characterId: String
    ): CommonResponse<List<CharacterInfoModel>>

    suspend fun getCharactersEvents(
        characterId: String
    ): CommonResponse<List<CharacterInfoModel>>

    suspend fun getCharactersSeries(
        characterId: String
    ): CommonResponse<List<CharacterInfoModel>>

    suspend fun getCharactersStories(
        characterId: String
    ): CommonResponse<List<CharacterInfoModel>>
}