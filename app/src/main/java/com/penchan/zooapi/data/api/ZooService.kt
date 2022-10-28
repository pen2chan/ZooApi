package com.penchan.zooapi.data.api

import com.penchan.zooapi.model.entity.ApiResult
import com.penchan.zooapi.model.entity.PlantResult
import com.penchan.zooapi.model.entity.ZoneResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ZooService {

    /**
     * get Zone List
     */
    @GET("/api/v1/dataset/5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a")
    fun getZoneList(
        @Query("scope") scope: String,
        @Query("resource_id") resourceId: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ) : Call<ApiResult<ZoneResult>>

    /**
     * get Plant List
     */
    @GET("/api/v1/dataset/f18de02f-b6c9-47c0-8cda-50efad621c14")
    fun getPlantList(
        @Query("scope") scope: String,
        @Query("resource_id") resourceId: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ) : Call<ApiResult<PlantResult>>
}