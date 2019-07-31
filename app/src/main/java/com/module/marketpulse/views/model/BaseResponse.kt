package com.module.marketpulse.views.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class BaseResponse(
    @SerializedName("id")
    var id: String?,

    @SerializedName("name")
    var name: String?,

    @SerializedName("tag")
    var tag: String?,

    @SerializedName("color")
    var color: String?,

    @SerializedName("criteria")
    var criteria: List<CriteriaResponse>?
) : Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(CriteriaResponse)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(tag)
        parcel.writeString(color)
        parcel.writeTypedList(criteria)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BaseResponse> {
        override fun createFromParcel(parcel: Parcel): BaseResponse {
            return BaseResponse(parcel)
        }

        override fun newArray(size: Int): Array<BaseResponse?> {
            return arrayOfNulls(size)
        }
    }


}