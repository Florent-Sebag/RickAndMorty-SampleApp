package com.sebag.florent.data.di

import com.sebag.florent.data.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class OkHttpModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val url = chain
                    .request()
                    .url
                    .newBuilder()
                    .addQueryParameter("ts", "1")
                    .addQueryParameter("apikey", BuildConfig.apiKey)
                    .addQueryParameter("hash", BuildConfig.apiKeyHash)
                    .build()
                chain.proceed(chain.request().newBuilder().url(url).build())
            }
            .build()
    }
}