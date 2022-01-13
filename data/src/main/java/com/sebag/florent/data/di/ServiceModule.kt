package com.sebag.florent.data.di

import com.sebag.florent.data.api.MarvelApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit) : MarvelApi = retrofit.create(MarvelApi::class.java)
}