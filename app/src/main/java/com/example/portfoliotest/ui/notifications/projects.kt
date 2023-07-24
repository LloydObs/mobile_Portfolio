package com.example.portfoliotest.ui.notifications

import android.os.Parcel
import android.os.Parcelable

data class projects(val image:Int, val projectTitle:String, val secondTitle:String, val titleTags:String, val titleDescription: String) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(projectTitle)
        parcel.writeString(secondTitle)
        parcel.writeString(titleTags)
        parcel.writeString(titleDescription)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<projects> {
        override fun createFromParcel(parcel: Parcel): projects {
            return projects(parcel)
        }

        override fun newArray(size: Int): Array<projects?> {
            return arrayOfNulls(size)
        }
    }
}
