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
import android.media.AudioRecord.MetricsConstants.SOURCE
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dylanc.loadinghelper.LoadingHelper
import com.dylanc.loadinghelper.ViewType
import com.kiwilss.xview.R
import com.kiwilss.xview.config.Constant
import com.kiwilss.xview.help.ActivityManager
import com.kiwilss.xview.ui.loading.adapter.EmptyAdapter
import com.kiwilss.xview.ui.loading.adapter.LoadingAdapter
import com.kiwilss.xview.utils.LogUtils
import com.lqr.emoji.LQREmotionKit
import com.xuexiang.xaop.XAOP
import kotlinx.android.synthetic.main.layout_toolbar.*
import top.wefor.circularanim.CircularAnim
import top.wefor.circularanim.CircularAnim.OnAnimatorDeployListener

/**
 *@FileName: App
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/7/8
 * @desc   : {DESCRIPTION}
 */
class App : Application(){

    var keyboardHeight = 0

    override fun onCreate() {
        super.onCreate()
        mContext = this
        app = this

        //对Activity生命周期监听
        monitorActivityLife()
        //初始化话全局状态
        initStatus()
        //初始化转场动画设置
        initCircularAnim()

        //aop初始化
        XAOP.init(this) //初始化插件
        XAOP.debug(true) //日志打印切片开启
        XAOP.setPriority(Log.INFO) //设置日志打印的等级,默认为0

        LQREmotionKit.init(this) { context, path, imageView ->
            Glide.with(context).load(path).centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(imageView)
        }
    }

    private fun initCircularAnim() {
        // optional. change the default duration and fullActivity resource.
        // the original value is (618, 618,android.R.color.white).
        CircularAnim.init(700, 618, R.color.colorPrimary)
        // optional. set the default duration OnAnimatorDeployListener.
        // optional. set the default duration OnAnimatorDeployListener.
        CircularAnim.initDefaultDeployAnimators(
            OnAnimatorDeployListener { animator ->
                animator.interpolator = AccelerateInterpolator()
            },
            OnAnimatorDeployListener { animator ->
                animator.interpolator = DecelerateInterpolator()
            },
            null,
            null
        )
    }

    private fun initStatus() {
        val adapterPool: LoadingHelper.AdapterPool.() -> Unit = {
            register(ViewType.LOADING, LoadingAdapter())
            register(ViewType.EMPTY, EmptyAdapter())
        }
        LoadingHelper.setDefaultAdapterPool(adapterPool)

    }


    companion object{
        lateinit var mContext: Context
        lateinit var app: App
    }

    private fun monitorActivityLife() {
        registerActivityLifecycleCallbacks(object :Application.ActivityLifecycleCallbacks{

            override fun onActivityPaused(p0: Activity) {

            }

            override fun onActivityStarted(p0: Activity) {
                //LogUtils.e("onActivityStarted")
            }

            override fun onActivityDestroyed(p0: Activity) {
                //ActivityManager.instance.finishActivity(p0)
                ActivityManager.instance.removeActivity(p0)
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {

            }

            override fun onActivityStopped(p0: Activity) {

            }

            override fun onActivityCreated(p0: Activity, p1: Bundle?) {
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

    private fun initToolbar(p0: Activity, p1: Bundle?) {
        LogUtils.e("initToolbar")
        val back = p0.findViewById<View>(R.id.iv_layout_toolbar_back)
        LogUtils.e(back == null, " back")
        LogUtils.e(p0.iv_layout_toolbar_back == null,"kotlin-back-->")
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