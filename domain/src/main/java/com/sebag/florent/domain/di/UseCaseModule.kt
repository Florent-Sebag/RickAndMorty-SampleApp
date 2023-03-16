package com.sebag.florent.domain.di

import com.sebag.florent.domain.repositories.MarvelRepository
import com.sebag.florent.domain.usecases.CharacterDetailsUseCase
import com.sebag.florent.domain.usecases.CharacterDetailsUseCaseImpl
import com.sebag.florent.domain.usecases.CharacterListUseCase
import com.sebag.florent.domain.usecases.CharacterListUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideCharacterListUseCase(marvelRepository: MarvelRepository) : CharacterListUseCase =
        CharacterListUseCaseImpl(marvelRepository)

    @Provides
    @Singleton
    fun provideCharacterDetailsUseCase(marvelRepository: MarvelRepository) : CharacterDetailsUseCase =
        CharacterDetailsUseCaseImpl(marvelRepository)
}