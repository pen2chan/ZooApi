package com.penchan.zooapi.ui.detail.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.penchan.zooapi.base.BaseViewHolder
import com.penchan.zooapi.databinding.ViewholderPlantItemBinding
import com.penchan.zooapi.model.entity.PlantEntity
import com.penchan.zooapi.model.entity.ZoneEntity
import com.penchan.zooapi.ui.detail.DetailContract

class PlantItemViewHolder (mBinding: ViewholderPlantItemBinding, mView: DetailContract.View) :
    BaseViewHolder<ViewholderPlantItemBinding>(mBinding)  {

    companion object {
        fun newInstance(viewGroup: ViewGroup, view: DetailContract.View): PlantItemViewHolder {
            return PlantItemViewHolder(
                ViewholderPlantItemBinding.inflate(
                    LayoutInflater.from(viewGroup.context), viewGroup, false
                ), view)
        }
    }

    init {
        itemView.setOnClickListener {
            mView.onItemClick(itemView.tag as PlantEntity)
        }
    }

    fun bindData(data: PlantEntity) {
        itemView.tag = data

        Glide.with(mContext)
            .load(data.picUrl1)
            .into(mBinding.ivPlantPic)

        mBinding.tvName.text = data.chineseName
        mBinding.tvInfo.text = data.brief
    }
}