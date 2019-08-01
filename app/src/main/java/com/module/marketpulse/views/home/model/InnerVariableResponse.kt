package com.module.marketpulse.views.home.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class InnerVariableResponse(
    @SerializedName("type")
    var type: String?,

    @SerializedName("values")
    var values: FloatArray?,

    @SerializedName("study_type")
    var study_type: String?,

    @SerializedName("parameter_name")
    var parameter_name: String?,

    @SerializedName("min_value")
    var min_value: String?,

    @SerializedName("max_value")
    var max_value: String?,

    @SerializedName("default_value")
    var default_value: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.createFloatArray(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeFloatArray(values)
        parcel.writeString(study_type)
        parcel.writeString(parameter_name)
        parcel.writeString(min_value)
        parcel.writeString(max_value)
        parcel.writeString(default_value)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<InnerVariableResponse> {
        override fun createFromParcel(parcel: Parcel): InnerVariableResponse {
            return InnerVariableResponse(parcel)
        }

        override fun newArray(size: Int): Array<InnerVariableResponse?> {
            return arrayOfNulls(size)
        }
    }

}