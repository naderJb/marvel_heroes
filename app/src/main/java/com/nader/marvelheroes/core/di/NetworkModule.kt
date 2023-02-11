package com.nader.marvelheroes.core.di

import android.content.Context
import com.google.gson.Gson
import com.lembergsolutions.retrofitretry.implementation.RetrofitRetryCallAdapterFactory
import com.nader.marvelheroes.BuildConfig
import com.nader.marvelheroes.core.interceptors.AppSecretsInterceptor
import com.nader.marvelheroes.core.interceptors.NetworkConnectionInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    fun provideRestService(
        networkConnectionInterceptor: NetworkConnectionInterceptor,
        loggingInterceptor: HttpLoggingInterceptor,
        appSecretsInterceptor: AppSecretsInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()

        builder.readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(appSecretsInterceptor)
            .addInterceptor(networkConnectionInterceptor)
            .addInterceptor(loggingInterceptor)

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideNetworkConnectionInterceptor(@ApplicationContext context: Context): NetworkConnectionInterceptor {
        return NetworkConnectionInterceptor(context)
    }

    @Provides
    @Singleton
    fun provideAppSecretsInterceptor(): AppSecretsInterceptor {
        return AppSecretsInterceptor()
    }

    @Provides
    @Singleton
    fun loggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
        return interceptor
    }

    @Provides
    @Singleton
    fun getGson(): Gson = Gson()

    @Provides
    fun getRetrofit(
        gson: Gson,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RetrofitRetryCallAdapterFactory.createCoroutineAdapter())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()
    }

}