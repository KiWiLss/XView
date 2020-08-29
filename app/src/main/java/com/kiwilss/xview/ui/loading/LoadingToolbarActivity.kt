package com.kiwilss.xview.ui.loading

import android.os.Bundle
import android.os.Handler
import androidx.annotation.IdRes
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_loading_toolbar.*

/**
 *@FileName: LoadingToolbarActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/28
 * @desc   : {DESCRIPTION}
 */
class LoadingToolbarActivity: BaseActivity(R.layout.activity_loading_toolbar) {

    private val mHandler = Handler()

    override fun initData() {
        mLoadingHelper.showLoadingView()
        //模仿请求 2 秒后获取数据
        mHandler.postDelayed({
            mLoadingHelper.showContentView()
            tv_loading_toolbar_init.text = "测试获取数据后初始化"
        },2000)


    }

    override fun initEvent() {
        btn_loading_toolbar_loading.setOnClickListener {
            mLoadingHelper.showLoadingView()
            mHandler.postDelayed({
                mLoadingHelper.showContentView()
                tv_loading_toolbar_init.text = "测试点击后显示"
            },2000)
        }
        btn_loading_toolbar_empty.setOnClickListener {
            mLoadingHelper.showEmptyView()
        }

    }

    override fun initInterface() {
        LogUtils.e("initInterface")
        tv_loading_toolbar_init.text = "初始化initInterface"


    }


    override fun initIsToolbar(): Boolean {
        //设置是否需要标题栏
        return true
    }

    override fun onReload() {
        mLoadingHelper.showLoadingView()
        mHandler.postDelayed({
            mLoadingHelper.showContentView()
            tv_loading_toolbar_init.text = "测试为空后点击重试显示"
        },2000)
    }
}