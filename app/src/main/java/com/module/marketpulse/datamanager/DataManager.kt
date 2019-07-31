package com.module.marketpulse.datamanager

import com.module.marketpulse.datamanager.apihelper.ApiHelper
import com.module.marketpulse.datamanager.dbhelper.DBHelper
import com.module.marketpulse.datamanager.prefhelper.PreferenceHelper

interface DataManager : ApiHelper, DBHelper, PreferenceHelper {
}