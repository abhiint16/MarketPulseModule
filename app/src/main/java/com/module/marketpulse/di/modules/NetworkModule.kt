package com.module.marketpulse.di.modules

import android.content.Context
import com.module.marketpulse.BuildConfig
import com.module.marketpulse.di.qualifier.BaseUrl
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
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
    fun providesRetrofit(@BaseUrl baseUrl: String, context: Context): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(baseUrl)
            .client(OkHttpClient.Builder().addInterceptor(ChuckInterceptor(context)).build())
            .build()
    }
}