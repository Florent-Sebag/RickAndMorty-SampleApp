package com.sebag.florent.data.di

import okhttp3.Interceptor
import okhttp3.Response
import android.content.Context

class CustomOkInterceptor(
    private val apiKey: String,
    private val apiKeyHash: String,
    context: Context
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain
            .request()
            .url
            .newBuilder()
            .addQueryParameter("ts", "1")
            .addQueryParameter("apikey", apiKey)
            .addQueryParameter("hash", apiKeyHash)
            .build()
        return chain.proceed(chain.request().newBuilder().url(url).build())
    }

}