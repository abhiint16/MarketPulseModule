package com.module.marketpulse.views.criteria.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.module.marketpulse.datamanager.DataManager

class CriteriaViewModel : ViewModel {
    var dataManager: DataManager

    internal var dataLiveData = MutableLiveData<Boolean>()

    constructor(dataManager: DataManager) : super() {
        this.dataManager = dataManager
    }

    fun observeForLiveData(): LiveData<Boolean> {
        return dataLiveData
    }
}