package com.penchan.zooapi.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.penchan.zooapi.R
import com.penchan.zooapi.databinding.FragmentDetailBinding
import com.penchan.zooapi.model.entity.PlantEntity
import com.penchan.zooapi.model.entity.PlantResult
import com.penchan.zooapi.model.entity.ZoneEntity
import com.penchan.zooapi.ui.plant.PlantFragment
import com.penchan.zooapi.util.EndlessScrollListener

class DetailFragment : Fragment(), DetailContract.View {
    companion object {
        val EXTRA_DATA = "data"
    }

    private lateinit var mPresenter: DetailPresenter
    private lateinit var mAdapter: DetailAdapter

    private var mRoot: View? = null
    private lateinit var mBinding: FragmentDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRoot == null) {

            mBinding = FragmentDetailBinding.inflate(inflater, container, false)
            mRoot = mBinding.root

            initRecyclerView()
            initLayout()
            mPresenter = DetailPresenter(this)
            mPresenter.start()
        }
        return mBinding.root
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context)
        mBinding.recyclerView.itemAnimator = DefaultItemAnimator()
        mBinding.recyclerView.layoutManager = linearLayoutManager

        val zoneEntity: ZoneEntity? = arguments?.getParcelable(EXTRA_DATA)
        if (zoneEntity == null) {
            activity?.findNavController(R.id.nav_host_fragment_content_main)?.navigateUp()
        } else {
            mAdapter = DetailAdapter(zoneEntity, this)
            mBinding.recyclerView.adapter = mAdapter
            mBinding.recyclerView.addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
            mBinding.recyclerView.addOnScrollListener(
                EndlessScrollListener({
                    if (mAdapter.hasMore()) {
                        mPresenter.onLoadMore(mAdapter.offset)
                    }
                }, linearLayoutManager)
            )
        }
    }

    private fun initLayout() {
        mBinding.swipeRefresh.setOnRefreshListener {
            mBinding.swipeRefresh.isRefreshing = true
            mPresenter.refreshList()
        }
    }

    override fun initHeader() {
        mAdapter.addHeader()
    }

    override fun updateResult(result: PlantResult) {
        mBinding.swipeRefresh.isRefreshing = false
        mAdapter.updateResult(result)
    }

    override fun clearList() {
        mAdapter.clear()
        mAdapter.addHeader()
    }

    override fun onItemClick(entity: PlantEntity) {
        val bundle = Bundle()
        bundle.putParcelable(PlantFragment.EXTRA_DATA, entity)
        activity?.findNavController(R.id.nav_host_fragment_content_main)?.navigate(R.id.nav_plant, bundle)
    }

    override fun updateActionBar(name: String) {
        (activity as AppCompatActivity)?.supportActionBar?.apply {
            title = name
        }
    }

    override fun showProgress() {
        mBinding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        mBinding.progressBar.visibility = View.GONE
    }

    override fun onDestroy() {
        mPresenter.onDestroy()
        super.onDestroy()
    }
}