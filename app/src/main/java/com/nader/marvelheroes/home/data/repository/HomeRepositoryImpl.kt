package com.nader.marvelheroes.home.data.repository

import com.nader.marvelheroes.core.model.APIResponse
import com.nader.marvelheroes.core.model.CommonResponse
import com.nader.marvelheroes.home.data.model.CharacterModel
import com.nader.marvelheroes.home.data.remote.source.HomeRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeRemoteDataSource: HomeRemoteDataSource
) : HomeRepository {
    override suspend fun getAllCharacters(nameStartsWith: String?): Flow<APIResponse<CommonResponse<List<CharacterModel>>>> =
        flow {
            emit(APIResponse.loading())
            try {
                val response = homeRemoteDataSource.getAllCharacters(nameStartsWith)
                emit(APIResponse.success(response))
            } catch (e: Exception) {
                emit(APIResponse.error(e))
            }
        }
}