package com.kiwilss.xview.ui.aac.viewbinding.basic

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kiwilss.xview.base.BaseActivity2
import com.kiwilss.xview.base.BaseFragment
import com.kiwilss.xview.databinding.FgVbBinding

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/14
 *  desc   :
 */
class VBFg: BaseFragment<FgVbBinding>() {
    override fun initData() {

    }

    override fun initEvent() {
        //getLoadingHelper()?.showLoadingView()

    }

    override fun initInterface() {
        mVb.tvFgVbTest.text = " 这是对fragment 的测试"
    }

    override fun initViewBinding(inflater: LayoutInflater, container: ViewGroup?, b: Boolean) = FgVbBinding.inflate(inflater,container,b)
}