package com.module.marketpulse.views.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.module.marketpulse.datamanager.DataManager

class HomeActivityViewModel : ViewModel {
    var dataManager: DataManager

    internal var mutableLiveData = MutableLiveData<Boolean>()

    constructor(dataManager: DataManager) : super() {
        this.dataManager = dataManager
    }

    fun testFun() {
        mutableLiveData.value = true
    }

    fun observeForLiveData(): LiveData<Boolean> {
        return mutableLiveData
    }
}