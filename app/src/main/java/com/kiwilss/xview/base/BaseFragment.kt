package com.kiwilss.xview.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.dylanc.loadinghelper.LoadingHelper

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/14
 *  desc   :
 */

abstract class BaseFragment<VB : ViewBinding> : Fragment(), LoadingHelper.OnReloadListener {

    val mVb by lazy {
        vb!!
    }
    private var vb: VB? = null
    var mLoadingHelper: LoadingHelper? = null

    override fun onReload() {
        //出错或是别的情况,再次点击时调用

    }

//    fun getLoadingHelper(): LoadingHelper?{
//        return if (activity is BaseActivity2<*>)  null
//       else (activity as BaseActivity2<*>).mLoadingHelper
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = initViewBinding(inflater, container, false)
        val view = vb?.root
        mLoadingHelper = view?.let { LoadingHelper(it) }
        mLoadingHelper?.setOnReloadListener(this)
        initInterface()
        initEvent()
        initData()
        return mLoadingHelper?.decorView
    }

    abstract fun initData()

    abstract fun initEvent()

    abstract fun initInterface()


    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    abstract fun initViewBinding(inflater: LayoutInflater, container: ViewGroup?, b: Boolean): VB?


}