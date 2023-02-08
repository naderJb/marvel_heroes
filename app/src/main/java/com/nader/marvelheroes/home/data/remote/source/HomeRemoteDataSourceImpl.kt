package com.nader.marvelheroes.home.data.remote.source

import com.nader.marvelheroes.core.extensions.dataOrException
import com.nader.marvelheroes.core.model.CommonResponse
import com.nader.marvelheroes.home.data.model.CharacterModel
import com.nader.marvelheroes.home.data.remote.services.HomeService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(
    private val service: HomeService
) : HomeRemoteDataSource {
    override suspend fun getAllCharacters(nameStartsWith: String?): CommonResponse<List<CharacterModel>> =
        withContext(Dispatchers.IO) {
            try {
                val response = service.getAllCharacters(nameStartsWith)
                response.dataOrException("Cannot get characters")
            } catch (exception: Exception) {
                throw exception
            }
        }
}