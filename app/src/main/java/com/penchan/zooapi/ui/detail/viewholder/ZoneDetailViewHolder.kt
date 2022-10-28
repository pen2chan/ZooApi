package com.penchan.zooapi.ui.detail.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.penchan.zooapi.base.BaseViewHolder
import com.penchan.zooapi.databinding.ViewholderZoneDetailBinding
import com.penchan.zooapi.model.entity.ZoneEntity

class ZoneDetailViewHolder(mBinding: ViewholderZoneDetailBinding) :
    BaseViewHolder<ViewholderZoneDetailBinding>(mBinding) {

    companion object {
        fun newInstance(viewGroup: ViewGroup): ZoneDetailViewHolder {
            return ZoneDetailViewHolder(ViewholderZoneDetailBinding.inflate(
                LayoutInflater.from(viewGroup.context), viewGroup, false
            ))
        }
    }

    fun bindData(entity: ZoneEntity) {

        Glide.with(mContext)
            .load(entity.picUrl)
            .into(mBinding.ivZonePic)

        mBinding.tvInfo.text = entity.info
    }
}