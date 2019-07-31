package com.module.marketpulse.di

import android.app.Application
import com.module.marketpulse.MarketPulseApp
import com.module.marketpulse.di.builder.ViewBuilderProvider
import com.module.marketpulse.di.modules.AppModule
import com.module.marketpulse.di.modules.ContextModule
import com.module.marketpulse.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, ContextModule::class, NetworkModule::class,
        AndroidInjectionModule::class, ViewBuilderProvider::class]
)
interface AppComponent {

    fun inject(marketPulseApp: MarketPulseApp)

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}