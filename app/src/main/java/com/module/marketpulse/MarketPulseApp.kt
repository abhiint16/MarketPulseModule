package com.module.marketpulse

import android.app.Activity
import android.app.Application
import com.module.marketpulse.di.AppComponent
import com.module.marketpulse.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MarketPulseApp : Application(), HasActivityInjector {

    @set:Inject
    internal var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null

    internal var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder().application(this)
            .build()
        appComponent!!.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }

}