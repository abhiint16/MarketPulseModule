package com.module.marketpulse.di.builder

import com.module.marketpulse.views.criteria.CriteriaActivity
import com.module.marketpulse.views.criteria.di.CriteriaActivityModule
import com.module.marketpulse.views.home.HomeActivity
import com.module.marketpulse.views.home.di.HomeActivityModule
import com.module.marketpulse.views.variable.VariableActivity
import com.module.marketpulse.views.variable.di.VariableActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewBuilderProvider {

    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun homeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [CriteriaActivityModule::class])
    abstract fun criteriaActivity(): CriteriaActivity

    @ContributesAndroidInjector(modules = [VariableActivityModule::class])
    abstract fun variableActivity(): VariableActivity
}