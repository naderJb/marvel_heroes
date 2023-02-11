package com.nader.marvelheroes.home.data.repository

import com.nader.marvelheroes.core.model.APIResponse
import com.nader.marvelheroes.core.model.CommonResponse
import com.nader.marvelheroes.home.data.model.CharacterInfoModel
import com.nader.marvelheroes.home.data.remote.source.CharacterRemotedDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterRemotedDataSource: CharacterRemotedDataSource
) : CharacterRepository {
    override suspend fun getCharacters(characterId: String): Flow<APIResponse<CommonResponse<List<CharacterInfoModel>>>> =
        flow {
            emit(APIResponse.loading())
            try {
                val response = characterRemotedDataSource.getCharacters(characterId)
                emit(APIResponse.success(response))
            } catch (e: Exception) {
                emit(APIResponse.error(e))
            }
        }

    override suspend fun getCharactersComics(characterId: String): Flow<APIResponse<CommonResponse<List<CharacterInfoModel>>>> =
        flow {
            emit(APIResponse.loading())
            try {
                val response = characterRemotedDataSource.getCharactersComics(characterId)
                emit(APIResponse.success(response))
            } catch (e: Exception) {
                emit(APIResponse.error(e))
            }
        }

    override suspend fun getCharactersEvents(characterId: String): Flow<APIResponse<CommonResponse<List<CharacterInfoModel>>>> =
        flow {
            emit(APIResponse.loading())
            try {
                val response = characterRemotedDataSource.getCharactersEvents(characterId)
                emit(APIResponse.success(response))
            } catch (e: Exception) {
                emit(APIResponse.error(e))
            }
        }

    override suspend fun getCharactersSeries(characterId: String): Flow<APIResponse<CommonResponse<List<CharacterInfoModel>>>> =
        flow {
            emit(APIResponse.loading())
            try {
                val response = characterRemotedDataSource.getCharactersSeries(characterId)
                emit(APIResponse.success(response))
            } catch (e: Exception) {
                emit(APIResponse.error(e))
            }
        }

    override suspend fun getCharactersStories(characterId: String): Flow<APIResponse<CommonResponse<List<CharacterInfoModel>>>> =
        flow {
            emit(APIResponse.loading())
            try {
                val response = characterRemotedDataSource.getCharactersStories(characterId)
                emit(APIResponse.success(response))
            } catch (e: Exception) {
                emit(APIResponse.error(e))
            }
        }

}