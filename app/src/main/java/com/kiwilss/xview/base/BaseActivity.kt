package com.kiwilss.xview.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.dylanc.loadinghelper.LoadingHelper
import com.dylanc.loadinghelper.ViewType
import com.kiwilss.xview.ui.loading.adapter.TitleAdapter
import com.kiwilss.xview.utils.LogUtils
import java.util.logging.Handler

/**
 *@FileName: BaseActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/28
 * @desc   : {简单设置全局状态切换,可以自由选择是否使用toolbar}
 */
abstract class BaseActivity(contentLayoutId: Int = 0): AppCompatActivity(contentLayoutId)
    , LoadingHelper.OnReloadListener{

    override fun onReload() {
        //出错或是别的情况,再次点击时调用

    }

    lateinit var mLoadingHelper: LoadingHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtils.e("oncreate")
        //设置切换状态相关
        initLoadingHelp(initIsToolbar())
        //初始化界面
        initInterface()
        //初始化点击
        initEvent()
        //初始化数据
        initData()

    }

    //控制是否显示标题栏
    open fun initIsToolbar(): Boolean = true

    open fun initLoadingHelp(isUseToolbar: Boolean) {
        LogUtils.e("initLoadinghelp")
        mLoadingHelper = LoadingHelper(this)
        if (isUseToolbar){
            val titleBar = title ?: "标题"
            mLoadingHelper.register(ViewType.TITLE,TitleAdapter(titleBar.toString()))
            mLoadingHelper.addChildDecorHeader(ViewType.TITLE)
        }
        //监听重新点击
        mLoadingHelper.setOnReloadListener(this)
    }

    abstract fun initData()

    abstract fun initEvent()

    abstract fun initInterface()


}