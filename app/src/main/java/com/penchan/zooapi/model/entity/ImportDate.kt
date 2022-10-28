package com.penchan.zooapi.model.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImportDate(
    val date: String = "",
    @SerializedName("timezone") val timeZone: String = "",
    @SerializedName("timezone_type") val timeZoneType: Int = 0
) : Parcelable
