/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: App
 * Author:   kiwilss
 * Date:     2020/7/8 23:04
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.dylanc.loadinghelper.LoadingHelper
import com.dylanc.loadinghelper.ViewType
import com.kiwilss.xview.R
import com.kiwilss.xview.help.ActivityManager
import com.kiwilss.xview.ui.loading.adapter.EmptyAdapter
import com.kiwilss.xview.ui.loading.adapter.LoadingAdapter
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*

/**
 *@FileName: App
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/7/8
 * @desc   : {DESCRIPTION}
 */
class App : Application(){
    override fun onCreate() {
        super.onCreate()
        mContext = this
        app = this
        //对Activity生命周期监听
        monitorActivityLife()
        //初始化话全局状态
        initStatus()

    }

    private fun initStatus() {
        val adapterPool: LoadingHelper.AdapterPool.() -> Unit = {
            register(ViewType.LOADING, LoadingAdapter())
            register(ViewType.EMPTY, EmptyAdapter())
        }
        LoadingHelper.setDefaultAdapterPool(adapterPool)
    }


    companion object{
        var mContext: Context? = null
        var app: App? = null
    }

    private fun monitorActivityLife() {
        registerActivityLifecycleCallbacks(object :Application.ActivityLifecycleCallbacks{

            override fun onActivityPaused(p0: Activity) {

            }

            override fun onActivityStarted(p0: Activity) {
                //LogUtils.e("onActivityStarted")
            }

            override fun onActivityDestroyed(p0: Activity) {
                LogUtils.e("onActivityDestroyed")
                //ActivityManager.instance.finishActivity(p0)
                ActivityManager.instance.removeActivity(p0)
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {

            }

            override fun onActivityStopped(p0: Activity) {

            }

            override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                LogUtils.e("onActivitycreate")
                ActivityManager.instance.addActivity(p0)
                //初始化标题栏
                //initToolbar(p0,p1)
            }


            override fun onActivityResumed(p0: Activity) {
//                val back = p0.findViewById<View>(R.id.iv_layout_toolbar_back)
//                LogUtils.e(back == null, " back resume")
//                back?.setOnClickListener { p0.finish() }
            }

        })
    }
    /**
     * 无效方法
    */
    private fun initToolbar(p0: Activity, p1: Bundle?) {
        LogUtils.e("initToolbar")
        val back = p0.findViewById<View>(R.id.iv_layout_toolbar_back)
        LogUtils.e(back == null, " back")
        p0.run {
            //返回点击
            val ivback = findViewById<View>(R.id.iv_layout_toolbar_back)
            LogUtils.e((ivback == null))
            LogUtils.e(iv_layout_toolbar_back == null,"--////")
            findViewById<View>(R.id.iv_layout_toolbar_back)?.setOnClickListener {
                finish()
            }
            LogUtils.e(title,"title-->")
            //设置标题
            tv_layout_toolbar_title?.text = title ?: "标题"

        }
    }
}