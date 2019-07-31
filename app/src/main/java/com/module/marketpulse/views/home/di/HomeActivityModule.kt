package com.module.marketpulse.views.home.di

import androidx.lifecycle.ViewModelProvider
import com.module.marketpulse.datamanager.DataManager
import com.module.marketpulse.utils.ViewModelProviderFactory
import com.module.marketpulse.views.home.viewmodel.HomeActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {

    @Provides
    fun providesHomeActivityViewModel(dataManager: DataManager): HomeActivityViewModel {
        return HomeActivityViewModel(dataManager)
    }

    @Provides
    fun providesViewModelProvider(homeActivityViewModel: HomeActivityViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(homeActivityViewModel)
    }
}