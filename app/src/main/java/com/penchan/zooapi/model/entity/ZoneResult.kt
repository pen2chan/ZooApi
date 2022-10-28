package com.penchan.zooapi.model.entity

data class ZoneResult(
    val count: Int = 0,
    val limit: Int = 0,
    val offset: Int = 0,
    val results: MutableList<ZoneEntity> = mutableListOf(),
    val sort: String = ""
)