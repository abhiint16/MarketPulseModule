package com.module.marketpulse.views.criteria.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.module.marketpulse.datamanager.DataManager
import com.module.marketpulse.views.home.model.BaseResponse

class CriteriaViewModel : ViewModel {
    var dataManager: DataManager

    internal var dataLiveData = MutableLiveData<BaseResponse>()

    constructor(dataManager: DataManager) : super() {
        this.dataManager = dataManager
    }

    fun ifIntentDataReady(baseResponse: BaseResponse) {
        dataLiveData.value = baseResponse
    }

    fun observeForLiveData(): LiveData<BaseResponse> {
        return dataLiveData
    }
}