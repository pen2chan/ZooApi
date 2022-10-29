package com.penchan.zooapi.ui.detail

import android.util.Log
import com.penchan.zooapi.data.remote.ZooRepo
import com.penchan.zooapi.model.entity.ApiResult
import com.penchan.zooapi.model.entity.PlantResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPresenter(private var mView: DetailContract.View?) : DetailContract.Presenter {

    override fun start() {
        mView?.initHeader()
        mView?.showProgress()
        getPlantList(0)
    }

    override fun onLoadMore(offset: Int) {
        mView?.showProgress()
        getPlantList(offset)
    }

    override fun refreshList() {
        mView?.clearList()
        mView?.initHeader()
        getPlantList(0)
    }

    override fun onDestroy() {
        mView = null
    }

    private fun getPlantList(offset: Int) {
        ZooRepo.getPlantList(offset, object: Callback<ApiResult<PlantResult>> {
            override fun onResponse(call: Call<ApiResult<PlantResult>>, response: Response<ApiResult<PlantResult>>) {
                if (response.body() != null) {
                    val result = response.body()
                    val plantResult = result!!.result
                    mView?.updateResult(plantResult)
                }
                mView?.hideProgress()
            }

            override fun onFailure(call: Call<ApiResult<PlantResult>>, t: Throwable) {
                mView?.hideProgress()
            }
        })
    }
}