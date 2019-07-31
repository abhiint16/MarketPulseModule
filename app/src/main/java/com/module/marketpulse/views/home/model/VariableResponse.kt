package com.module.marketpulse.views.home.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class VariableResponse() : Parcelable {

    @SerializedName("variable")
    @Expose
    private val variable: Map<String, InnerVariableResponse>? = HashMap()

    constructor(parcel: Parcel) : this() {
        parcel.readMap(variable, InnerVariableResponse::class.java.getClassLoader())
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeMap(variable);
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VariableResponse> {
        override fun createFromParcel(parcel: Parcel): VariableResponse {
            return VariableResponse(parcel)
        }

        override fun newArray(size: Int): Array<VariableResponse?> {
            return arrayOfNulls(size)
        }
    }


}