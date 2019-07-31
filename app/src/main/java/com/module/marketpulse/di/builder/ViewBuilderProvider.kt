package com.module.marketpulse.di.builder

import com.module.marketpulse.views.HomeActivity
import com.module.marketpulse.views.di.HomeActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewBuilderProvider {

    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun homeActivity(): HomeActivity
}