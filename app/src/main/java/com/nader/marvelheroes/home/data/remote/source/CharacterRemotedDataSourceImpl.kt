package com.nader.marvelheroes.home.data.remote.source

import com.nader.marvelheroes.core.extensions.dataOrException
import com.nader.marvelheroes.core.model.CommonResponse
import com.nader.marvelheroes.home.data.model.CharacterInfoModel
import com.nader.marvelheroes.home.data.remote.services.CharactersService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterRemotedDataSourceImpl @Inject constructor(
    private val service: CharactersService
) : CharacterRemotedDataSource {
    override suspend fun getCharacters(characterId: String): CommonResponse<List<CharacterInfoModel>> =
        withContext(Dispatchers.IO) {
            try {
                val response = service.getCharacters(characterId)
                response.dataOrException("Cannot get characters")
            } catch (exception: Exception) {
                throw exception
            }
        }

    override suspend fun getCharactersComics(characterId: String): CommonResponse<List<CharacterInfoModel>> =
        withContext(Dispatchers.IO) {
            try {
                val response = service.getCharactersComics(characterId)
                response.dataOrException("Cannot get characters comics")
            } catch (exception: Exception) {
                throw exception
            }
        }

    override suspend fun getCharactersEvents(characterId: String): CommonResponse<List<CharacterInfoModel>> =
        withContext(Dispatchers.IO) {
            try {
                val response = service.getCharactersEvents(characterId)
                response.dataOrException("Cannot get characters events")
            } catch (exception: Exception) {
                throw exception
            }
        }

    override suspend fun getCharactersSeries(characterId: String): CommonResponse<List<CharacterInfoModel>> =
        withContext(Dispatchers.IO) {
            try {
                val response = service.getCharactersSeries(characterId)
                response.dataOrException("Cannot get characters series")
            } catch (exception: Exception) {
                throw exception
            }
        }

    override suspend fun getCharactersStories(characterId: String): CommonResponse<List<CharacterInfoModel>> =
        withContext(Dispatchers.IO) {
            try {
                val response = service.getCharactersStories(characterId)
                response.dataOrException("Cannot get characters stories")
            } catch (exception: Exception) {
                throw exception
            }
        }


}