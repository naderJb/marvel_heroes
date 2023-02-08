package com.nader.marvelheroes.home.domain

import com.nader.marvelheroes.core.model.APIResponse
import com.nader.marvelheroes.core.model.CommonResponse
import com.nader.marvelheroes.home.data.model.CharacterModel
import com.nader.marvelheroes.home.data.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeUseCaseImpl @Inject constructor(
    private val homeRepository: HomeRepository
) : HomeUseCase {
    override suspend fun getAllCharacters(
        nameStartsWith: String?
    ): Flow<APIResponse<CommonResponse<List<CharacterModel>>>> =
        homeRepository.getAllCharacters(nameStartsWith)
}