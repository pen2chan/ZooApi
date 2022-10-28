package com.penchan.zooapi.ui.plant

import com.penchan.zooapi.model.entity.PlantEntity

class PlantPresenter(private var mView: PlantContract.View?) : PlantContract.Presenter {

    override fun start() {

    }

    fun updateEntity(entity: PlantEntity?) {
        if (entity == null) {
            return
        }
        mView?.updateActionBar(entity.chineseName)
        mView?.updateUI(entity)
    }

    override fun onDestroy() {
        mView = null
    }

}