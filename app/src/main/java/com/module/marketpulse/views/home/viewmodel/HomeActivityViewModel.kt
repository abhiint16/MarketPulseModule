package com.module.marketpulse.views.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.module.marketpulse.datamanager.DataManager
import com.module.marketpulse.views.home.model.BaseResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class HomeActivityViewModel : ViewModel {
    var dataManager: DataManager

    internal var dataLiveData = MutableLiveData<List<BaseResponse>>()

    constructor(dataManager: DataManager) : super() {
        this.dataManager = dataManager
    }

    fun getApiData() {
        dataManager.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer {
                dataLiveData.value = it.body()
            }, Consumer {

            })
    }

    fun observeForLiveData(): LiveData<List<BaseResponse>> {
        return dataLiveData
    }
}