package com.kiwilss.xview.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.dylanc.loadinghelper.LoadingHelper
import com.dylanc.loadinghelper.ViewType
import com.kiwilss.xview.help.TransitionHelper

import com.kiwilss.xview.ui.loading.adapter.TitleAdapter


/**
 *@FileName: BaseActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/28
 * @desc   : {简单设置全局状态切换,可以自由选择是否使用toolbar}
 */
abstract class BaseActivity(contentLayoutId: Int = 0): AppCompatActivity(contentLayoutId)
    , LoadingHelper.OnReloadListener{

    val EXTRA_SAMPLE = "sample"
    val EXTRA_TYPE = "type"
    val TYPE_PROGRAMMATICALLY = 0
    val TYPE_XML = 1



    override fun onReload() {
        //出错或是别的情况,再次点击时调用

    }

    lateinit var mLoadingHelper: LoadingHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        beforeSetContent(savedInstanceState)
        super.onCreate(savedInstanceState)
        //设置切换状态相关
        initLoadingHelp(initIsToolbar())
        //初始化界面
        initInterface()
        initInterface2(savedInstanceState)
        //初始化点击
        initEvent()
        //初始化数据
        initData()

    }

    open fun beforeSetContent(savedInstanceState: Bundle?) {

    }

    open fun initInterface2(savedInstanceState: Bundle?) {

    }

    //控制是否显示标题栏
    open fun initIsToolbar(): Boolean = true

    open fun initLoadingHelp(isUseToolbar: Boolean) {
        mLoadingHelper = LoadingHelper(this)
        if (isUseToolbar){
            val titleBar = title ?: "标题"
            mLoadingHelper.register(ViewType.TITLE,TitleAdapter(titleBar.toString()))
            mLoadingHelper.addChildDecorHeader(ViewType.TITLE)
        }
        //监听重新点击
        mLoadingHelper.setOnReloadListener(this)
    }

    open fun transitionTo(i: Intent?) {
        val pairs: Array<Pair<View, String>> = TransitionHelper.createSafeTransitionParticipants(this,true)
        val transitionActivityOptions: ActivityOptionsCompat =
            ActivityOptionsCompat.makeSceneTransitionAnimation(this, *pairs)
        startActivity(i, transitionActivityOptions.toBundle())
    }

    abstract fun initData()

    abstract fun initEvent()

    abstract fun initInterface()


}