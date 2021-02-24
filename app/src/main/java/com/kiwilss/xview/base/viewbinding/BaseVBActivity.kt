package com.kiwilss.xview.base.viewbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.dylanc.loadinghelper.LoadingHelper
import com.dylanc.loadinghelper.ViewType
import com.dylanc.viewbinding.inflateBindingWithGeneric
import com.gyf.immersionbar.ImmersionBar
import com.gyf.immersionbar.ktx.immersionBar
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.loading.adapter.TitleAdapter

/**
 * @author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/27
 *  desc   :
 */
abstract class BaseVBActivity<VB : ViewBinding> : AppCompatActivity(),
    LoadingHelper.OnReloadListener {

    lateinit var binding: VB

    val EXTRA_SAMPLE = "sample"
    val EXTRA_TYPE = "type"
    val EXTRA_TITLE = "title"
    val TYPE_PROGRAMMATICALLY = 0
    val TYPE_XML = 1
    lateinit var mLoadingHelper: LoadingHelper

    override fun onReload() {
        //出错或是别的情况,再次点击时调用
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        beforeSetContent(savedInstanceState)
        super.onCreate(savedInstanceState)
        binding = inflateBindingWithGeneric(layoutInflater)
        setContentView(binding.root)
        //设置状态栏
        setStatusBar()
        //设置切换状态相关
        initLoadingHelp(initIsToolbar())
        //初始化界面
        initInterface(savedInstanceState)
        //初始化点击
        initEvent()
        //初始化数据
        initData()

    }

    /**
     * 设置状态栏
     */
    open fun setStatusBar() {
        immersionBar {
            fitsSystemWindows(true)
            statusBarColor(R.color.white)
            statusBarDarkFont(true,0f)
            init()
        }
    }

    abstract fun initData()

    abstract fun initEvent()

    abstract fun initInterface(savedInstanceState: Bundle?)


    //控制是否显示标题栏
    open fun initIsToolbar(): Boolean = true

    var mTitleBar: CharSequence? = null

    open fun initLoadingHelp(isUseToolbar: Boolean) {
        initTitleBar(null)
        mLoadingHelper = LoadingHelper(this)
        if (isUseToolbar) {
            val titleBar = mTitleBar ?: "标题"
            mLoadingHelper.register(ViewType.TITLE, TitleAdapter(titleBar.toString()))
            mLoadingHelper.addChildDecorHeader(ViewType.TITLE)
        }
        //监听重新点击
        mLoadingHelper.setOnReloadListener(this)
    }

    open fun initTitleBar(titleC: CharSequence?) {
        mTitleBar =
            if (titleC.isNullOrEmpty()) {
                title
            } else {
                titleC
            }
    }

    open fun beforeSetContent(savedInstanceState: Bundle?) {

    }
}