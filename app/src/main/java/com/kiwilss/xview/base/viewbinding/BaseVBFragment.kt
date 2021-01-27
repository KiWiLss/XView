package com.kiwilss.xview.base.viewbinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.dylanc.loadinghelper.LoadingHelper
import com.dylanc.viewbinding.inflateBindingWithGeneric
import com.kiwilss.xview.base.BaseActivity2

/**
 * @author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/27
 *  desc   :
 */
abstract class BaseVBFragment<VB : ViewBinding> : Fragment(), LoadingHelper.OnReloadListener {

    private var _binding: VB? = null
    val binding: VB get() = _binding!!

    fun getLoadingHelper(): LoadingHelper? {
        return if (activity is BaseActivity2<*>) null
        else (activity as BaseActivity2<*>).mLoadingHelper
    }

    override fun onReload() {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateBindingWithGeneric(layoutInflater)
        getLoadingHelper()?.setOnReloadListener(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInterface(view, savedInstanceState)
        initEvent()
        initData()
    }

    abstract fun initData()

    abstract fun initEvent()

    abstract fun initInterface(view: View, savedInstanceState: Bundle?)

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}