package com.penchan.zooapi.model.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ZoneEntity(
    @SerializedName("_id") val id: Int = 0,
    @SerializedName("_importdate")val importDate: ImportDate,
    @SerializedName("e_no") val number: String = "",
    @SerializedName("e_category") val category: String = "",
    @SerializedName("e_name") val name: String = "",
    @SerializedName("e_pic_url") val picUrl: String = "",
    @SerializedName("e_info") val info: String = "",
    @SerializedName("e_memo") val memo: String = "",
    @SerializedName("e_geo") val geo: String = "",
    @SerializedName("e_url") val url: String = ""
) : Parcelable