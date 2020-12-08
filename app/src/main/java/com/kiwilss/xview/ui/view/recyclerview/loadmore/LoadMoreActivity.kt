package com.kiwilss.xview.ui.view.recyclerview.loadmore

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_load_more.*

/**
 *@FileName: LoadMoreActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/8
 * @desc   : {DESCRIPTION}
 */
class LoadMoreActivity: BaseActivity(R.layout.activity_load_more),SwipeRefreshLayout.OnRefreshListener
,OnLoadMoreListener{

    var page = 1
    var num = 20

    val mAdapter by lazy { LoadMoreAdapter() }


    override fun initData() {
        LogUtils.e("-----------------")
        rv_load_more_list.postDelayed(runnable,2000)
    }

    val runnable = Runnable {
        val list = arrayListOf<String>()
        for (i in 0 until num){
            list.add("$page---view $i")
        }
        srl_load_more_refresh.isRefreshing = false
        if (page == 1){
            mAdapter.setList(list)
        }else{
            mAdapter.addData(list)
            mAdapter.loadMoreModule.loadMoreComplete()
        }
        if (page == 5){
            mAdapter.loadMoreModule.loadMoreEnd()
        }

    }

    override fun initEvent() {
        btn_load_more_update.setOnClickListener {
            srl_load_more_refresh.isRefreshing = true
            onRefresh()
        }
    }

    override fun initInterface() {
        srl_load_more_refresh.setOnRefreshListener(this)
        srl_load_more_refresh.isRefreshing = true

        rv_load_more_list?.run {
            layoutManager = LinearLayoutManager(this@LoadMoreActivity)
            adapter = mAdapter
        }

        mAdapter.loadMoreModule.setOnLoadMoreListener(this)
    }

    override fun onRefresh() {
        page = 1
        initData()
    }

    override fun onLoadMore() {
        page ++
        initData()
    }
}