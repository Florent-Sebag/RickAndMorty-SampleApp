package com.sebag.florent.marvel_sample_app.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.sebag.florent.marvel_sample_app.MarvelApp
import com.sebag.florent.presenter.di.utils.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideContext(baseApp: MarvelApp) : Context = baseApp.applicationContext

    @Provides
    @Singleton
    fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory = factory
}