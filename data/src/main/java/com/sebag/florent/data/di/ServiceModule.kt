package com.sebag.florent.data.di

import com.sebag.florent.data.api.RickAndMortyApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit) : RickAndMortyApi = retrofit.create(RickAndMortyApi::class.java)
}