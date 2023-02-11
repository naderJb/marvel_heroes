package com.nader.marvelheroes.home.domain

import com.nader.marvelheroes.core.model.APIResponse
import com.nader.marvelheroes.core.model.CommonResponse
import com.nader.marvelheroes.home.data.model.CharacterInfoModel
import com.nader.marvelheroes.home.data.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterUseCaseImpl @Inject constructor(
    private val characterRepository: CharacterRepository
) : CharacterUseCase {
    override suspend fun getCharacters(characterId: String): Flow<APIResponse<CommonResponse<List<CharacterInfoModel>>>> =
        characterRepository.getCharacters(characterId)

    override suspend fun getCharactersComics(characterId: String): Flow<APIResponse<CommonResponse<List<CharacterInfoModel>>>> =
        characterRepository.getCharactersComics(characterId)

    override suspend fun getCharactersEvents(characterId: String): Flow<APIResponse<CommonResponse<List<CharacterInfoModel>>>> =
        characterRepository.getCharactersEvents(characterId)

    override suspend fun getCharactersSeries(characterId: String): Flow<APIResponse<CommonResponse<List<CharacterInfoModel>>>> =
        characterRepository.getCharactersSeries(characterId)


    override suspend fun getCharactersStories(characterId: String): Flow<APIResponse<CommonResponse<List<CharacterInfoModel>>>> =
        characterRepository.getCharactersStories(characterId)

}