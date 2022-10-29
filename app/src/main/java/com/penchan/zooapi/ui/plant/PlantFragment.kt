package com.penchan.zooapi.ui.plant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.penchan.zooapi.R
import com.penchan.zooapi.databinding.FragmentPlantBinding
import com.penchan.zooapi.model.entity.PlantEntity
import com.penchan.zooapi.model.entity.ZoneEntity
import com.penchan.zooapi.ui.detail.DetailFragment


class PlantFragment : Fragment(), PlantContract.View {

    companion object {
        val EXTRA_DATA = "data"
    }

    private lateinit var mPresenter: PlantPresenter

    private var mRoot: View? = null
    private lateinit var mBinding: FragmentPlantBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRoot == null) {

            mBinding = FragmentPlantBinding.inflate(inflater, container, false)
            mRoot = mBinding.root

            mPresenter = PlantPresenter(this)
            mPresenter.start()

            initArgs()
        }
        return mBinding.root
    }

    private fun initArgs() {
        val plantEntity: PlantEntity? = arguments?.getParcelable(EXTRA_DATA)
        mPresenter.updateEntity(plantEntity)
    }

    override fun onDestroy() {
        mPresenter.onDestroy()
        super.onDestroy()
    }

    override fun updateActionBar(name: String) {
        (activity as AppCompatActivity)?.supportActionBar?.apply {
            title = name
        }
    }

    override fun updateUI(entity: PlantEntity) {
        Glide.with(mBinding.root)
            .load(entity.picUrl1)
            .placeholder(R.drawable.ic_loading)
            .into(mBinding.ivPlant)

        mBinding.tvChName.text = entity.chineseName
        mBinding.tvEnName.text = entity.englishName

        mBinding.tvAlsoKnown.text = entity.alsoKnown

        mBinding.tvBrief.text = entity.brief

        mBinding.tvFeature.text = entity.feature

        mBinding.tvFunction.text = entity.function

        mBinding.tvUpdate.text = entity.update

    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }
}