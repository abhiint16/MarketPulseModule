package com.module.marketpulse.datamanager.apihelper

import com.module.marketpulse.views.home.model.BaseResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("data")
    fun getData(): Single<Response<BaseResponse>>

}