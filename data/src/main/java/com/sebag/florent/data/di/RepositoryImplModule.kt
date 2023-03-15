package com.sebag.florent.data.di

import com.sebag.florent.data.api.MarvelApi
import com.sebag.florent.data.repositories.CharacterPagingSource
import com.sebag.florent.data.repositories.MarvelRepositoryImpl
import com.sebag.florent.domain.repositories.MarvelRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryImplModule {

    @Provides
    @Singleton
    fun provideCharacterPagingSource(service: MarvelApi) : CharacterPagingSource =
        CharacterPagingSource(service)

    @Singleton
    @Provides
    fun provideMarvelRepository(service: MarvelApi, characterPagingSource: CharacterPagingSource) : MarvelRepository =
        MarvelRepositoryImpl(service, characterPagingSource)
}