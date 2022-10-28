package com.penchan.zooapi.ui.zone

import com.penchan.zooapi.data.remote.ZooRepo
import com.penchan.zooapi.model.entity.ApiResult
import com.penchan.zooapi.model.entity.ZoneResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ZonePresenter(private var mView: ZoneContract.View?) : ZoneContract.Presenter {

    override fun start() {
        mView?.showProgress()
        getZoneList(0)
    }

    override fun onLoadMore(offset: Int) {
        mView?.showProgress()
        getZoneList(offset)
    }

    override fun refreshList() {
        mView?.clearList()
        getZoneList(0)
    }

    override fun onDestroy() {
        mView = null
    }

    private fun getZoneList(offset: Int) {
        ZooRepo.getZoneList(offset, object: Callback<ApiResult<ZoneResult>> {
            override fun onResponse(call: Call<ApiResult<ZoneResult>>, response: Response<ApiResult<ZoneResult>>) {
                if (response.body() != null) {
                    val result = response.body()
                    val zoneResult = result!!.result
                    mView?.updateResult(zoneResult)
                }
                mView?.hideProgress()
            }

            override fun onFailure(call: Call<ApiResult<ZoneResult>>, t: Throwable) {
                mView?.hideProgress()
            }
        })
    }

}