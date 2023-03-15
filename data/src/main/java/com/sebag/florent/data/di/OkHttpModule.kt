package com.sebag.florent.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class OkHttpModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(context: Context) : OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }
}