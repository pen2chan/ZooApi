package com.penchan.zooapi.data.remote

import com.penchan.zooapi.model.entity.ApiResult
import com.penchan.zooapi.model.entity.PlantResult
import com.penchan.zooapi.model.entity.ZoneResult
import com.penchan.zooapi.util.RetrofitUtils
import retrofit2.Callback

class ZooRepo {

    companion object {

        private const val SCOPE = "resourceAquire"
        private const val ZONE_ID = "5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a"
        private const val BOTANIC_ID = "f18de02f-b6c9-47c0-8cda-50efad621c14"
        private const val PAGE_SIZE = 20

        fun getZoneList(offset: Int, callback: Callback<ApiResult<ZoneResult>>) {
            RetrofitUtils.zooService.getZoneList(SCOPE, ZONE_ID, PAGE_SIZE, offset).enqueue(callback)
        }

        fun getPlantList(offset: Int, callback: Callback<ApiResult<PlantResult>>) {
            RetrofitUtils.zooService.getPlantList(SCOPE, BOTANIC_ID, PAGE_SIZE, offset).enqueue(callback)
        }
    }
}