package com.sebag.florent.rick_and_morty_sample_app.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.sebag.florent.rick_and_morty_sample_app.RickAndMortyApp
import com.sebag.florent.presenter.di.utils.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideContext(baseApp: RickAndMortyApp) : Context = baseApp.applicationContext

    @Provides
    @Singleton
    fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory = factory
}