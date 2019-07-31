package com.module.marketpulse.views.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class CriteriaResponse(

    @SerializedName("type")
    var type: String?,

    @SerializedName("text")
    var text: String?,

    @SerializedName("variable")
    var variable: VariableResponse?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(VariableResponse::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(text)
        parcel.writeParcelable(variable, flags)
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