package com.kiwilss.xview.ui.anim.transition.test

import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_transition_demo_detail.*

/**
 *@FileName: TransitionDemoDetailActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/21
 * @desc   : {DESCRIPTION}
 */
class TransitionDemoDetailActivity: BaseActivity(R.layout.activity_transition_demo_detail) {
    override fun initData() {

    }

    override fun initIsToolbar(): Boolean {
        return false
    }

    override fun initEvent() {
        iv_transition_demo_detail_back.setOnClickListener {
            onBackPressed()
        }
    }

    override fun initInterface() {
        //可以设置动画时间
        window.enterTransition.duration = 500
    }
}