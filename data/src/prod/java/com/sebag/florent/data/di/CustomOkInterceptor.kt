package com.sebag.florent.data.di

import okhttp3.Interceptor
import okhttp3.Response
import android.content.Context

class CustomOkInterceptor(
    context: Context
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}