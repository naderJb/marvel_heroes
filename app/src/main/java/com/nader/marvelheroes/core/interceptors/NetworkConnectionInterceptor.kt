package com.nader.marvelheroes.core.interceptors

import android.content.Context
import com.nader.marvelheroes.core.exceptions.NoInternetException
import com.nader.marvelheroes.core.extensions.isOnline
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class NetworkConnectionInterceptor constructor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (context.isOnline().not()) {
            throw NoInternetException()
        }

        val builder: Request.Builder = chain
            .request()
            .newBuilder()

        return chain.proceed(builder.build())
    }
}