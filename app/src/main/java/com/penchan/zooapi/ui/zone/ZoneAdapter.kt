package com.penchan.zooapi.ui.zone


import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.penchan.zooapi.model.entity.ZoneEntity
import com.penchan.zooapi.model.entity.ZoneResult
import com.penchan.zooapi.ui.zone.viewholder.ZoneItemViewHolder

class ZoneAdapter(val mView: ZoneContract.View) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: MutableList<ZoneEntity> = mutableListOf()
    var count = 0
    var offset = 0

    fun clear() {
        offset = 0
        count = 0
        list.clear()
        notifyDataSetChanged()
    }

    fun updateResult(result: ZoneResult) {
        count = result.count
        offset += result.results.size
        updateList(result.results)
    }

    fun updateList(items: List<ZoneEntity>) {
        items.forEach { this.list.add(it) }

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return ZoneItemViewHolder.newInstance(parent, mView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ZoneItemViewHolder) {
            holder.bindData(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
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