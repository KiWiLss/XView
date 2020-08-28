package com.kiwilss.xview.ui.loading

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.dylanc.loadinghelper.LoadingHelper
import com.dylanc.loadinghelper.ViewType
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.loading.adapter.TitleAdapter
import kotlinx.android.synthetic.main.activity_loading_title.*

/**
 *@FileName: LoadingTitleActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/28
 * @desc   : {DESCRIPTION}
 */
class LoadingTitleActivity: AppCompatActivity(R.layout.activity_loading_title) {

    lateinit var mLoadingHelper: LoadingHelper
    private val mHandler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        mLoadingHelper = LoadingHelper(this)
        mLoadingHelper.register(ViewType.TITLE,TitleAdapter("带标题的测试"))
        mLoadingHelper.setDecorHeader(ViewType.TITLE)


        btn_loading_title_loading.setOnClickListener {
            mLoadingHelper.showLoadingView()
            handlerContent()
        }
        btn_loading_title_empty.setOnClickListener {
            mLoadingHelper.showEmptyView()
        }


        mLoadingHelper.showLoadingView()
        handlerContent()
        mLoadingHelper.setOnReloadListener {
            mLoadingHelper.showLoadingView()
            handlerContent()
        }


    }

    private fun handlerContent() {
        mHandler.postDelayed({
            mLoadingHelper.showContentView()
        },2000)
    }
}