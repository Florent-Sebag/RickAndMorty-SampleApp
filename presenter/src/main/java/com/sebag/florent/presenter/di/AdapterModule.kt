package com.sebag.florent.presenter.di

import com.sebag.florent.presenter.view.home.adapter.CharacterAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AdapterModule {

    @Singleton
    @Provides
    fun provideCharacterAdapter() = CharacterAdapter()
}