package com.sebag.florent.data.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class MoshiModule {

    @Singleton
    @Provides
    fun provideMoshi() : Moshi = Moshi.Builder().build()

    @Singleton
    @Provides
    fun provideMoshiConverterFactory() : MoshiConverterFactory = MoshiConverterFactory.create()
}