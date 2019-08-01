package com.module.marketpulse.views.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.module.marketpulse.datamanager.DataManager
import com.module.marketpulse.views.home.model.BaseResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomeActivityViewModel : ViewModel {
    var dataManager: DataManager

    internal var dataLiveData = MutableLiveData<List<BaseResponse>>()
    internal var itemClickLiveData = MutableLiveData<BaseResponse>()

    lateinit var disposable: Disposable

    constructor(dataManager: DataManager) : super() {
        this.dataManager = dataManager
    }

    fun getApiData() {
        disposable = dataManager.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                dataLiveData.value = it.body()
            }, {
                it.printStackTrace()
            })
    }

    fun recyclerItemClick(baseResponse: BaseResponse) {
        itemClickLiveData.value = baseResponse
    }

    fun observeForLiveData(): LiveData<List<BaseResponse>> {
        return dataLiveData
    }

    fun observeForItemClickLiveData(): LiveData<BaseResponse> {
        return itemClickLiveData
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

}