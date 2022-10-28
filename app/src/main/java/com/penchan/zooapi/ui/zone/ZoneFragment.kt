package com.penchan.zooapi.ui.zone

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.penchan.zooapi.R
import com.penchan.zooapi.databinding.FragmentZoneBinding
import com.penchan.zooapi.model.entity.ZoneEntity
import com.penchan.zooapi.model.entity.ZoneResult
import com.penchan.zooapi.ui.detail.DetailFragment
import com.penchan.zooapi.util.EndlessScrollListener

class ZoneFragment : Fragment(), ZoneContract.View {

    private lateinit var mPresenter: ZonePresenter
    private lateinit var mAdapter: ZoneAdapter

    private var mRoot: View? = null
    private lateinit var mBinding: FragmentZoneBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRoot == null) {

            mBinding = FragmentZoneBinding.inflate(inflater, container, false)
            mRoot = mBinding.root

            initRecyclerView()
            initLayout()
            initActionBar()
            mPresenter = ZonePresenter(this)
            mPresenter.start()
        }
        return mBinding.root
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context)
        mBinding.recyclerView.itemAnimator = DefaultItemAnimator()
        mBinding.recyclerView.layoutManager = linearLayoutManager

        mAdapter = ZoneAdapter(this)
        mBinding.recyclerView.adapter = mAdapter
        mBinding.recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        mBinding.recyclerView.addOnScrollListener(
            EndlessScrollListener({
                if (mAdapter.hasMore()) {
                    mPresenter.onLoadMore(mAdapter.offset)
                }
            }, linearLayoutManager)
        )
    }

    private fun initLayout() {
        mBinding.swipeRefresh.setOnRefreshListener {
            mBinding.swipeRefresh.isRefreshing = true
            mPresenter.refreshList()
        }
    }

    override fun onStart() {
        super.onStart()
        initActionBar()
    }

    override fun onDestroy() {
        mPresenter.onDestroy()
        super.onDestroy()
    }

    private fun initActionBar() {
        (activity as AppCompatActivity)?.supportActionBar?.apply {
            title = getString(R.string.label_zone)

            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun updateResult(result: ZoneResult) {
        mBinding.swipeRefresh.isRefreshing = false
        mAdapter.updateResult(result)
    }

    override fun clearList() {
        mAdapter.clear()
    }

    override fun onItemClick(entity: ZoneEntity) {
        val bundle = Bundle()
        bundle.putParcelable(DetailFragment.EXTRA_DATA, entity)
        activity?.findNavController(R.id.nav_host_fragment_content_main)?.navigate(R.id.nav_detail, bundle)
    }

    override fun showProgress() {
        mBinding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        mBinding.progressBar.visibility = View.GONE
        mBinding.swipeRefresh.isRefreshing = false
    }
}