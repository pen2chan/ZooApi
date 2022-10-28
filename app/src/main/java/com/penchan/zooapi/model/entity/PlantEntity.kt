package com.penchan.zooapi.model.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.penchan.zooapi.ui.detail.viewholder.DetailViewHolderFactory
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlantEntity(
    @SerializedName("_id") val id: Int = 0,
    @SerializedName("\uFEFFF_Name_Ch") val chineseName: String = "",
    @SerializedName("F_Summary") val summary: String = "",
    @SerializedName("F_Keywords") val keyword: String = "",
    @SerializedName("F_AlsoKnown") val alsoKnown: String = "",
    @SerializedName("F_Geo") val geo: String = "",
    @SerializedName("F_Location") val location: String = "",
    @SerializedName("F_Name_En") val englishName: String = "",
    @SerializedName("F_Name_Latin") val latinName: String = "",
    @SerializedName("F_Family") val family: String = "",
    @SerializedName("F_Genus") val genus: String = "",
    @SerializedName("F_Brief") val brief: String = "",
    @SerializedName("F_Feature") val feature: String = "",
    @SerializedName("F_Function＆Application")val function : String = "",
    @SerializedName("F_Code")val code: String = "",
    @SerializedName("F_Pic01_ALT") val picAlt1: String = "",
    @SerializedName("F_Pic01_URL") val picUrl1: String = "",
    @SerializedName("F_Pic02_ALT") val picAlt2: String = "",
    @SerializedName("F_Pic02_URL") val picUrl2: String = "",
    @SerializedName("F_Pic03_ALT") val picAlt3: String = "",
    @SerializedName("F_Pic03_URL") val picUrl3: String = "",
    @SerializedName("F_Pic04_ALT") val picAlt4: String = "",
    @SerializedName("F_Pic04_URL") val picUrl4: String = "",
    @SerializedName("F_pdf01_ALT") val pdfAlt1: String = "",
    @SerializedName("F_pdf01_URL") val pdfUrl1: String = "",
    @SerializedName("F_pdf02_ALT") val pdfAlt2: String = "",
    @SerializedName("F_pdf02_URL") val pdfUrl2: String = "",
    @SerializedName("F_Voice01_ALT") val voiceAlt1: String = "",
    @SerializedName("F_Voice01_URL") val voiceUrl1: String = "",
    @SerializedName("F_Voice02_ALT") val voiceAlt2: String = "",
    @SerializedName("F_Voice02_URL") val voiceUrl2: String = "",
    @SerializedName("F_Voice03_ALT") val voiceAlt3: String = "",
    @SerializedName("F_Voice03_URL") val voiceUrl3: String = "",
    @SerializedName("F_Vedio_URL") val videoUrl: String = "",
    @SerializedName("F_Update") val update: String = "",
    @SerializedName("F_CID") val cid: String = "",
    var type: Int = DetailViewHolderFactory.TYPE_DATA
) : Parcelable {

    constructor(type: Int) : this() {
        this.type = type
    }
}
