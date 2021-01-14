package com.kiwilss.xview.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.dylanc.loadinghelper.LoadingHelper
import com.dylanc.loadinghelper.ViewType
import com.kiwilss.xview.ui.loading.adapter.TitleAdapter

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/14
 *  desc   :
 */
abstract class BaseActivity2<VB : ViewBinding> : AppCompatActivity(),
    LoadingHelper.OnReloadListener {

    val EXTRA_SAMPLE = "sample"
    val EXTRA_TYPE = "type"
    val TYPE_PROGRAMMATICALLY = 0
    val TYPE_XML = 1

    protected val mVB by lazy {
        initBinding()
    }
    lateinit var mLoadingHelper: LoadingHelper
    override fun onReload() {
        //出错或是别的情况,再次点击时调用

    }

    abstract fun initBinding(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        beforeSetContent(savedInstanceState)
        super.onCreate(savedInstanceState)
        setContentView(mVB.root)
        //设置切换状态相关
        initLoadingHelp(initIsToolbar())
        //初始化界面
        initInterface(savedInstanceState)
        //初始化点击
        initEvent()
        //初始化数据
        initData()
    }

    abstract fun initData()

    abstract fun initEvent()

    abstract fun initInterface(savedInstanceState: Bundle?)


    //控制是否显示标题栏
    open fun initIsToolbar(): Boolean = true

    open fun initLoadingHelp(isUseToolbar: Boolean) {
        mLoadingHelper = LoadingHelper(this)
        if (isUseToolbar) {
            val titleBar = title ?: "标题"
            mLoadingHelper.register(ViewType.TITLE, TitleAdapter(titleBar.toString()))
            mLoadingHelper.addChildDecorHeader(ViewType.TITLE)
        }
        //监听重新点击
        mLoadingHelper.setOnReloadListener(this)
    }

    open fun beforeSetContent(savedInstanceState: Bundle?) {

    }
}