package com.sebag.florent.data.di

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import android.content.Context
import okhttp3.ResponseBody.Companion.toResponseBody

class CustomOkInterceptor(
    private val context: Context
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val jsonString = context.assets.open("MockedData.json").bufferedReader().use { it.readText() }

        return chain.proceed(chain.request())
            .newBuilder()
            .code(200)
            .protocol(Protocol.HTTP_2)
            .message(jsonString)
            .body(
                jsonString.toByteArray()
                    .toResponseBody("application/json".toMediaTypeOrNull())
            )
            .addHeader("content-type", "application/json")
            .build()
    }
}