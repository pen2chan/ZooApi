package com.penchan.zooapi.ui.detail

import com.penchan.zooapi.base.BasePresenter
import com.penchan.zooapi.base.BaseView
import com.penchan.zooapi.model.entity.PlantEntity
import com.penchan.zooapi.model.entity.PlantResult

interface DetailContract {

    interface Presenter : BasePresenter {
        fun start()

        fun onLoadMore(offset: Int)

        fun refreshList()
    }

    interface View : BaseView<Presenter> {
        fun updateResult(result: PlantResult)

        fun clearList()

        fun onItemClick(entity: PlantEntity)

        fun updateActionBar(name: String)
    }
}