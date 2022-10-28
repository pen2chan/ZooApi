package com.penchan.zooapi.ui.detail.viewholder

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.penchan.zooapi.base.BaseViewHolder
import com.penchan.zooapi.ui.detail.DetailContract

class DetailViewHolderFactory {

    companion object {

        const val TYPE_DATA = 0
        const val TYPE_HEADER = 1

        fun getViewHolderByType(parent: ViewGroup, viewType: Int, view: DetailContract.View): RecyclerView.ViewHolder {
            return when (viewType) {
                TYPE_DATA -> PlantItemViewHolder.newInstance(parent, view)
                else -> ZoneDetailViewHolder.newInstance(parent)
            }
        }
    }
}