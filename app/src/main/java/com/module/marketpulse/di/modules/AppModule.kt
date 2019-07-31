package com.module.marketpulse.di.modules

import com.module.marketpulse.AppConstants
import com.module.marketpulse.datamanager.DataManager
import com.module.marketpulse.datamanager.DataManagerImpl
import com.module.marketpulse.datamanager.apihelper.ApiHelper
import com.module.marketpulse.datamanager.apihelper.ApiHelperImpl
import com.module.marketpulse.datamanager.apihelper.ApiService
import com.module.marketpulse.datamanager.dbhelper.DBHelper
import com.module.marketpulse.datamanager.dbhelper.DBHelperImpl
import com.module.marketpulse.datamanager.prefhelper.PreferenceHelper
import com.module.marketpulse.datamanager.prefhelper.PreferenceHelperImpl
import com.module.marketpulse.di.qualifier.PreferenceName
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun providesDataManager(dataManagerImpl: DataManagerImpl):
            DataManager {
        return dataManagerImpl
    }

    @Provides
    @Singleton
    fun providesApiHelper(apiHelper: ApiHelperImpl):
            ApiHelper {
        return apiHelper
    }

    @Provides
    fun providesDBHelper(dbHelper: DBHelperImpl):
            DBHelper {
        return dbHelper
    }

    @Provides
    fun providesPrefHelper(preferenceHelper: PreferenceHelperImpl):
            PreferenceHelper {
        return preferenceHelper
    }

    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @PreferenceName
    fun providesSharedPrefName(): String {
        return AppConstants.SHARED_PREFERENCE_NAME;
    }
}