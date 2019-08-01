package com.module.marketpulse.views.home.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

class VariableResponse() : Serializable {
    lateinit var variable: HashMap<String, InnerVariableResponse>
}