package com.module.marketpulse.di.modules

import com.module.marketpulse.BuildConfig
import com.module.marketpulse.di.qualifier.BaseUrl
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {


    @Provides
    @BaseUrl
    fun providesBaseUrl(): String {
        return BuildConfig.BASE_URL
    }

    @Provides
    fun providesRetrofit(@BaseUrl baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(baseUrl)
            .client(OkHttpClient())
            .build()
    }
}