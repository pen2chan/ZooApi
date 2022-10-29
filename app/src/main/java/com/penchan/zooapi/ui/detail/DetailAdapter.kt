package com.penchan.zooapi.ui.detail

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.penchan.zooapi.model.entity.PlantEntity
import com.penchan.zooapi.model.entity.PlantResult
import com.penchan.zooapi.model.entity.ZoneEntity
import com.penchan.zooapi.ui.detail.viewholder.DetailViewHolderFactory
import com.penchan.zooapi.ui.detail.viewholder.PlantItemViewHolder
import com.penchan.zooapi.ui.detail.viewholder.ZoneDetailViewHolder

class DetailAdapter(val mEntity: ZoneEntity, val mView: DetailContract.View) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: MutableList<PlantEntity> = mutableListOf()
    var count = 0
    var offset = 0

    fun addHeader() {
        if (list.size == 0) {
            list.add(PlantEntity(DetailViewHolderFactory.TYPE_HEADER))
            notifyItemChanged(0)
        }
    }

    fun clear() {
        count = 0
        offset = 0
        list.clear()
        notifyDataSetChanged()
    }

    fun updateResult(result: PlantResult) {
        count = result.count
        offset += result.results.size
        updateList(result.results)
    }

    fun updateList(items: List<PlantEntity>) {
        val firstUpdatePos = list.size
        items.forEach { this.list.add(it) }

        notifyItemRangeChanged(firstUpdatePos, items.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DetailViewHolderFactory.getViewHolderByType(parent, viewType, mView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ZoneDetailViewHolder) {
            holder.bindData(mEntity)
        } else if (holder is PlantItemViewHolder) {
            holder.bindData(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    fun hasMore(): Boolean {
        if (count == 0 && offset == 0) {
            return true
        } else if (count > offset) {
            return true
        }
        return false
    }
}