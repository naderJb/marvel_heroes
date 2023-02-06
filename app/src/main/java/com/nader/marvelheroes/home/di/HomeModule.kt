package com.nader.marvelheroes.home.di

import com.nader.marvelheroes.home.data.remote.services.HomeService
import com.nader.marvelheroes.home.data.remote.source.HomeRemoteDataSource
import com.nader.marvelheroes.home.data.remote.source.HomeRemoteDataSourceImpl
import com.nader.marvelheroes.home.data.repository.HomeRepository
import com.nader.marvelheroes.home.data.repository.HomeRepositoryImpl
import com.nader.marvelheroes.home.domain.HomeUseCase
import com.nader.marvelheroes.home.domain.HomeUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class HomeModule {


    @Provides
    fun providesHomeUseCase(homeRepository: HomeRepository): HomeUseCase =
        HomeUseCaseImpl(homeRepository)

    @Provides
    fun providesHomeRepository(homeRemoteDataSource: HomeRemoteDataSource): HomeRepository =
        HomeRepositoryImpl(homeRemoteDataSource)


    @Provides
    fun providesHomeRemoteDataSource(
        homeService: HomeService
    ): HomeRemoteDataSource =
        HomeRemoteDataSourceImpl(homeService)

    @Provides
    fun providesHomeService(retrofit: Retrofit): HomeService =
        retrofit.create(HomeService::class.java)
}