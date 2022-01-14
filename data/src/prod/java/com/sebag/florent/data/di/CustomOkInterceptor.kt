package com.sebag.florent.data.di

import okhttp3.Interceptor
import okhttp3.Response
import android.content.Context
import com.sebag.florent.data.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest

class CustomOkInterceptor(
    context: Context
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain
            .request()
            .url
            .newBuilder()
            .addQueryParameter("ts", "1")
            .addQueryParameter("apikey", BuildConfig.apiKey)
            .addQueryParameter("hash", hashApiKey())
            .build()
        return chain.proceed(chain.request().newBuilder().url(url).build())
    }

    private fun hashApiKey() : String {
        val toHash = StringBuilder().append("1").append(BuildConfig.privateKey).append(BuildConfig.publicKey).toString()
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toHash.toByteArray())).toString(16).padStart(32, '0')
    }
}