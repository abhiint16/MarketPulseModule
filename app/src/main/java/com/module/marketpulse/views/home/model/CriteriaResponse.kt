package com.module.marketpulse.views.home.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CriteriaResponse() : Parcelable {

    @SerializedName("type")
    var type: String? = null

    @SerializedName("text")
    var text: String? = null

    @SerializedName("variable")
    var variable: Map<String, InnerVariableResponse> = HashMap()

    lateinit var finalString: String

    constructor(parcel: Parcel) : this() {
        type = parcel.readString()
        text = parcel.readString()
        parcel.readMap(variable, InnerVariableResponse::class.java.getClassLoader())
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(text)
        parcel.writeMap(variable)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CriteriaResponse> {
        override fun createFromParcel(parcel: Parcel): CriteriaResponse {
            return CriteriaResponse(parcel)
        }

        override fun newArray(size: Int): Array<CriteriaResponse?> {
            return arrayOfNulls(size)
        }
    }

}