package com.kiwilss.xview.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.dylanc.loadinghelper.LoadingHelper

/**
 *@FileName: BaseActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/28
 * @desc   : {简单设置全局状态切换,可以自由选择是否使用toolbar}
 */
abstract class BaseActivity(contentLayoutId: Int): AppCompatActivity(contentLayoutId) {

    lateinit var mLoadingHelper: LoadingHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //初始化界面
        initInterface(savedInstanceState)
        //初始化点击
        initEvent()
        //初始化数据
        initData()
        //设置切换状态相关
        initLoadingHelp(true)
    }

    private fun initLoadingHelp(isUseToolbar: Boolean) {
        if (isUseToolbar){

        }else{
            mLoadingHelper = LoadingHelper(this)
        }
    }

    abstract fun initData()

    abstract fun initEvent()

    abstract fun initInterface(savedInstanceState: Bundle?)


}