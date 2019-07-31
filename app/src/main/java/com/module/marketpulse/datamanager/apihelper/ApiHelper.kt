package com.module.marketpulse.datamanager.apihelper

import com.module.marketpulse.views.home.model.BaseResponse
import io.reactivex.Single
import retrofit2.Response

interface ApiHelper {
    fun getData(): Single<Response<BaseResponse>>
}