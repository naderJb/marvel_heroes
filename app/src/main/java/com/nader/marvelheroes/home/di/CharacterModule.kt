package com.nader.marvelheroes.home.di

import com.nader.marvelheroes.home.data.remote.services.CharactersService
import com.nader.marvelheroes.home.data.remote.source.CharacterRemotedDataSource
import com.nader.marvelheroes.home.data.remote.source.CharacterRemotedDataSourceImpl
import com.nader.marvelheroes.home.data.repository.CharacterRepository
import com.nader.marvelheroes.home.data.repository.CharacterRepositoryImpl
import com.nader.marvelheroes.home.domain.CharacterUseCase
import com.nader.marvelheroes.home.domain.CharacterUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class CharacterModule {
    @Provides
    fun providesCharacterUseCase(characterRepository: CharacterRepository): CharacterUseCase =
        CharacterUseCaseImpl(characterRepository)

    @Provides
    fun providesCharacterRemotedDataSourceRepository(characterHomeDataSource: CharacterRemotedDataSource): CharacterRepository =
        CharacterRepositoryImpl(characterHomeDataSource)


    @Provides
    fun providesCharacterRemoteDataSource(
        charactersService: CharactersService
    ): CharacterRemotedDataSource =
        CharacterRemotedDataSourceImpl(charactersService)

    @Provides
    fun providesCharacterService(retrofit: Retrofit): CharactersService =
        retrofit.create(CharactersService::class.java)
}