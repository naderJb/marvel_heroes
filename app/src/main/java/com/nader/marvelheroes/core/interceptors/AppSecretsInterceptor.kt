package com.nader.marvelheroes.core.interceptors

import com.nader.marvelheroes.BuildConfig
import com.nader.marvelheroes.core.utils.CommonUtils
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class AppSecretsInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        val url: HttpUrl = request
            .url
            .newBuilder()
            .addQueryParameter("ts", System.currentTimeMillis().toString())
            .addQueryParameter("apikey", BuildConfig.PUBLIC_KEY)
            .addQueryParameter("hash", CommonUtils.getApiHash())
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}