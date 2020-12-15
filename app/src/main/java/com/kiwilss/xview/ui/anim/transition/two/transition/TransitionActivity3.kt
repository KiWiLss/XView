package com.kiwilss.xview.ui.anim.transition.two.transition

import android.transition.Slide
import android.transition.Transition
import android.transition.TransitionInflater
import android.view.Gravity
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_transition3.*
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 *@FileName: TransitionActivity3
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/14
 * @desc   : {DESCRIPTION}
 */
class TransitionActivity3 : BaseActivity(R.layout.activity_transition3) {
    var mType: Int = -1


    override fun initData() {

    }

    override fun initEvent() {
        iv_layout_toolbar_back?.setOnClickListener {
            finishAfterTransition()
        }
        exit_button.setOnClickListener {
            finishAfterTransition()
        }

    }

    override fun initInterface() {

        mType = intent.getIntExtra(EXTRA_TYPE, -1)

        setWindowsTransition()

    }

    private fun setWindowsTransition() {
        var transition: Transition = if (mType == TYPE_XML){
            TransitionInflater.from(this).inflateTransition(R.transition.activity_slide)
        }else{
            getEnterTransition()
        }
        window.enterTransition = transition
    }

    private fun getEnterTransition(): Transition {
        val slide = Slide()
        slide.duration = 500
        //不设置方向,默认就是从下到上进入,从上到下退出
        slide.slideEdge = Gravity.RIGHT
        return slide
    }

}