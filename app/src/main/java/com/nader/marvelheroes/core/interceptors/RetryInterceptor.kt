package com.nader.marvelheroes.core.interceptors

import android.util.Log
import kotlinx.coroutines.delay
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class RetryInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        var response = chain.proceed(request)
//        var tryCount = 0
//        while (response.isSuccessful.not() && tryCount < 10) {
//            tryCount++
//            response.close()
//            response = chain.proceed(request)
//        }
        return response
    }

}