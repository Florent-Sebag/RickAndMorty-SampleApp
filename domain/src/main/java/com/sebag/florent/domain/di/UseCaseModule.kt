package com.sebag.florent.domain.di

import com.sebag.florent.domain.repositories.MarvelRepository
import com.sebag.florent.domain.usecases.CharacterDetailsUseCase
import com.sebag.florent.domain.usecases.CharacterListUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideCharacterListUseCase(marvelRepository: MarvelRepository) : CharacterListUseCase =
        CharacterListUseCase(marvelRepository)

    @Provides
    @Singleton
    fun provideCharacterDetailsUseCase(marvelRepository: MarvelRepository) : CharacterDetailsUseCase =
        CharacterDetailsUseCase(marvelRepository)
}