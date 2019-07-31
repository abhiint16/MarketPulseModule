package com.module.marketpulse.views.criteria.di

import androidx.lifecycle.ViewModelProvider
import com.module.marketpulse.datamanager.DataManager
import com.module.marketpulse.utils.ViewModelProviderFactory
import com.module.marketpulse.views.criteria.viewmodel.CriteriaViewModel
import dagger.Module
import dagger.Provides

@Module
class CriteriaActivityModule {

    @Provides
    fun providesCriteriaActivityViewModel(dataManager: DataManager): CriteriaViewModel {
        return CriteriaViewModel(dataManager)
    }

    @Provides
    fun providesViewModelProvider(criteriaViewModel: CriteriaViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(criteriaViewModel)
    }
}