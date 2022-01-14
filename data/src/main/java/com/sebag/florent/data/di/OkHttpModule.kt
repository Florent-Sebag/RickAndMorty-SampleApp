package com.sebag.florent.data.di

import android.content.Context
import com.sebag.florent.data.BuildConfig
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
            .addInterceptor(CustomOkInterceptor(BuildConfig.apiKey, BuildConfig.apiKeyHash, context))
            .build()
    }
}