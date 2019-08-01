package com.module.marketpulse.views.variable.di

import androidx.lifecycle.ViewModelProvider
import com.module.marketpulse.datamanager.DataManager
import com.module.marketpulse.utils.ViewModelProviderFactory
import com.module.marketpulse.views.variable.viewmodel.VariableActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class VariableActivityModule {

    @Provides
    fun providesVariableActivityViewModel(dataManager: DataManager): VariableActivityViewModel {
        return VariableActivityViewModel(dataManager)
    }

    @Provides
    fun providesViewModelProvider(variableActivityViewModel: VariableActivityViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(variableActivityViewModel)
    }
}