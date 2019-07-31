package com.module.marketpulse.datamanager.apihelper

import com.module.marketpulse.views.home.model.BaseResponse
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl : ApiHelper {

    var apiService: ApiService

    @Inject
    constructor(apiService: ApiService) {
        this.apiService = apiService
    }

    override fun getData() : Single<Response<BaseResponse>> {
        return apiService.getData()
    }
}