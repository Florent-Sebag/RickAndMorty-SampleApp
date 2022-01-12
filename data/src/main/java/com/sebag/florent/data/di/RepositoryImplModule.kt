package com.sebag.florent.data.di

import com.sebag.florent.data.api.MarvelApi
import com.sebag.florent.data.repositories.MarvelRepositoryImpl
import com.sebag.florent.domain.repositories.MarvelRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryImplModule {

    @Singleton
    @Provides
    fun provideMarvelRepository(service: MarvelApi) : MarvelRepository =
        MarvelRepositoryImpl(service)
}