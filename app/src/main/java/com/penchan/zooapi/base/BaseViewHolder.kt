package com.penchan.zooapi.base

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

open class BaseViewHolder<T : ViewBinding?>(val mBinding: T) :
    RecyclerView.ViewHolder(mBinding!!.root) {

    val mContext: Context

    init {
        mContext = mBinding!!.root.context
    }
}