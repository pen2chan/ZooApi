package com.penchan.zooapi.ui.zone.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.penchan.zooapi.base.BaseViewHolder
import com.penchan.zooapi.databinding.ViewholderZoneItemBinding
import com.penchan.zooapi.model.entity.ZoneEntity
import com.penchan.zooapi.ui.zone.ZoneContract

class ZoneItemViewHolder (mBinding: ViewholderZoneItemBinding, mView: ZoneContract.View) :
    BaseViewHolder<ViewholderZoneItemBinding>(mBinding) {

    companion object {
        fun newInstance(viewGroup: ViewGroup, view: ZoneContract.View): ZoneItemViewHolder {
            return ZoneItemViewHolder(ViewholderZoneItemBinding.inflate(
                LayoutInflater.from(viewGroup.context), viewGroup, false
            ), view)
        }
    }

    init {
        itemView.setOnClickListener {
            mView.onItemClick(itemView.tag as ZoneEntity)
        }
    }

    fun bindData(data: ZoneEntity) {
        itemView.tag = data

        Glide.with(mContext)
            .load(data.picUrl)
            .into(mBinding.ivZonePic)

        mBinding.tvName.text = data.name
        mBinding.tvInfo.text = data.info
        mBinding.tvMemo.text = data.memo

    }
}