package com.penchan.zooapi.ui.zone

import com.penchan.zooapi.base.BasePresenter
import com.penchan.zooapi.base.BaseView
import com.penchan.zooapi.model.entity.ZoneEntity
import com.penchan.zooapi.model.entity.ZoneResult

interface ZoneContract {

    interface Presenter : BasePresenter {
        fun start()

        fun onLoadMore(offset: Int)

        fun refreshList()
    }

    interface View : BaseView<Presenter> {
        fun updateResult(result: ZoneResult)

        fun clearList()

        fun onItemClick(entity: ZoneEntity)
    }

}