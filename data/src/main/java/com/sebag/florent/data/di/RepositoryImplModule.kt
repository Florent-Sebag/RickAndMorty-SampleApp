package com.sebag.florent.data.di

import com.sebag.florent.data.api.RickAndMortyApi
import com.sebag.florent.data.repositories.CharacterPagingSource
import com.sebag.florent.data.repositories.RickAndMortyRepositoryImpl
import com.sebag.florent.domain.repositories.RickAndMortyRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryImplModule {

    @Provides
    @Singleton
    fun provideCharacterPagingSource(service: RickAndMortyApi, moshi: Moshi) : CharacterPagingSource =
        CharacterPagingSource(service, moshi)

    @Singleton
    @Provides
    fun provideRickAndMortyRepository(
        service: RickAndMortyApi,
        characterPagingSource: CharacterPagingSource
    ) : RickAndMortyRepository =
        RickAndMortyRepositoryImpl(service, characterPagingSource)
}