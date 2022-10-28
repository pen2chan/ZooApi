package com.penchan.zooapi.ui.plant

import com.penchan.zooapi.base.BasePresenter
import com.penchan.zooapi.base.BaseView
import com.penchan.zooapi.model.entity.PlantEntity

interface PlantContract {

    interface Presenter : BasePresenter {
        fun start()
    }

    interface View : BaseView<Presenter> {
        fun updateActionBar(name: String)
        fun updateUI(entity: PlantEntity)
    }
}