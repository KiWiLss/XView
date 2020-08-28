package com.kiwilss.xview.ui.loading

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.dylanc.loadinghelper.LoadingHelper
import com.kiwilss.xview.R
import com.kiwilss.xview.help.ActivityManager
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_loading.*
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 *@FileName: LoadingActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/28
 * @desc   : {全局状态切换,不使用库里面提供的toolbar方法}
 */
class LoadingActivity: AppCompatActivity(R.layout.activity_loading) {

    private lateinit var loadingHelper: LoadingHelper
    val handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        LogUtils.e("loading oncreate")
        loadingHelper = LoadingHelper(this)

        loadingHelper.setOnReloadListener {
            loadingHelper.showLoadingView()
            handlerContent()
        }

        btn_loading_finish.setOnClickListener {
            ActivityManager.instance.finishCurrentActivity()
        }

        btn_loading_exit.setOnClickListener {
            ActivityManager.instance.exitApp()
        }
        btn_loading_exitT.setOnClickListener {
            moveTaskToBack(true)
        }
        tv_layout_toolbar_right.visibility = View.VISIBLE
        tv_layout_toolbar_right.setOnClickListener {
            ActivityManager.instance.getList()
        }
        btn_loading_loading.setOnClickListener {
            loadingHelper.showLoadingView()
            handlerContent()
        }
        btn_loading_empty.setOnClickListener {
            loadingHelper.showEmptyView()
            //handlerContent()
        }
        btn_loading_title.setOnClickListener {
            startActivity(Intent(this,LoadingTitleActivity::class.java))
        }

        loadingHelper.showLoadingView()

        handlerContent()




    }

    private fun handlerContent() {
        handler.postDelayed({
            loadingHelper.showContentView()
        },2000)
    }


    override fun onStart() {
        super.onStart()
        LogUtils.e("onStart")
    }

    override fun onResume() {
        super.onResume()
        LogUtils.e("onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.e("loading destroy--${isFinishing}")
    }
}