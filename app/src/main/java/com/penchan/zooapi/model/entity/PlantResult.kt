package com.penchan.zooapi.model.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlantResult(
    val count: Int = 0,
    val limit: Int = 0,
    val offset: Int = 0,
    val results: MutableList<PlantEntity> = mutableListOf(),
    val sort: String = ""
) : Parcelable
