package com.kiwilss.xview.ui.view.recyclerview.basequick

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.view.recyclerview.basequick.adapter.QuickHeaderFooterAdapter
import kotlinx.android.synthetic.main.activity_quick_hf.*
import kotlinx.android.synthetic.main.header_quick_hf.view.*
import java.util.zip.Inflater

/**
 *@FileName: QucikHeaderFooterActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/8
 * @desc   : {DESCRIPTION}
 */
class QucikHeaderFooterActivity : BaseActivity(R.layout.activity_quick_hf) {

    val mAdapter by lazy { QuickHeaderFooterAdapter() }

    override fun initData() {

    }

    override fun initEvent() {

    }

    override fun initInterface() {

        rv_quick_hf_test.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@QucikHeaderFooterActivity)
            adapter = mAdapter
        }

        val headerView = layoutInflater.inflate(R.layout.header_quick_hf,rv_quick_hf_test,false)
        headerView.tv_header_quick_hf_text.text = "第一个头"
        val headerView2 = layoutInflater.inflate(R.layout.header_quick_hf,rv_quick_hf_test,false)
        headerView2.tv_header_quick_hf_text.text = "第二个头"
        headerView2.setBackgroundColor(ContextCompat.getColor(this,R.color.colorAccent))

        val footerView = layoutInflater.inflate(R.layout.footer_quick_hf,rv_quick_hf_test,false)

        val emptyView = layoutInflater.inflate(R.layout.empty_quick_hf,rv_quick_hf_test,false)
        mAdapter.run {
            addHeaderView(headerView)
            //addHeaderView(headerView2)
            addFooterView(footerView)
            setEmptyView(emptyView)
            //有头时显示
            headerWithEmptyEnable = true
            footerWithEmptyEnable = true
            //开启动画
            animationEnable = true
            setAnimationWithDefault( BaseQuickAdapter.AnimationType.ScaleIn)
            loadMoreModule.setOnLoadMoreListener {
                loadMoreDataTest()
            }
            //loadMoreModule.preLoadNumber =

        }

        val data = arrayListOf<String>()
        for (i in 0..20){
            data.add("this is $i data")
        }
        mAdapter.setList(data)

    }

    private fun loadMoreDataTest() {
        if (mAdapter.data.size > 40){
            mAdapter.loadMoreModule.loadMoreEnd()
            return
        }
        val data = arrayListOf<String>()
        for (i in 0..20){
            data.add("this is $i data")
        }
        mAdapter.loadMoreModule.loadMoreComplete()
        mAdapter.addData(data)
    }
}