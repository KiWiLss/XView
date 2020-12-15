package com.kiwilss.xview.ui.anim.transition.two.shared

import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 *@FileName: ShareElementActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/15
 * @desc   : {单独的activity之间跳转}
 */
class ShareElementActivity : BaseActivity(R.layout.activity_share_element) {
    override fun initData() {

    }

    override fun initEvent() {
        iv_layout_toolbar_back?.setOnClickListener {
            finishAfterTransition()
        }

    }

    override fun initInterface() {
        setupWindowAnimations()


    }

    private fun setupWindowAnimations() {
        // We are not interested in defining a new Enter Transition. Instead we change default transition duration
        window.enterTransition.duration = 500
    }
}