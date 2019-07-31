package com.module.marketpulse.datamanager

import com.module.marketpulse.datamanager.apihelper.ApiHelper
import com.module.marketpulse.datamanager.dbhelper.DBHelper
import com.module.marketpulse.datamanager.prefhelper.PreferenceHelper
import com.module.marketpulse.views.home.model.BaseResponse
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class DataManagerImpl : DataManager {

    var apiHelper: ApiHelper
    var dbHelper: DBHelper
    var preferenceHelper: PreferenceHelper

    @Inject
    constructor(apiHelper: ApiHelper, dbHelper: DBHelper, preferenceHelper: PreferenceHelper) {
        this.apiHelper = apiHelper
        this.dbHelper = dbHelper
        this.preferenceHelper = preferenceHelper
    }


    override fun getData(): Single<Response<BaseResponse>> {
       return apiHelper.getData()
    }
}