package com.kiwilss.xview.ui.anim.property

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_property.*

/**
 *@FileName: PropertyActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/11/6
 * @desc   : {DESCRIPTION}
 */
class PropertyActivity : BaseActivity(R.layout.activity_property) {
    override fun initData() {

    }

    override fun initEvent() {
        btn_property_valueAnimator.setOnClickListener {
            testValueAnimator()
        }
    }

    private fun testValueAnimator() {
        val valueAnimator = ValueAnimator.ofFloat(0f,1f)
        valueAnimator.duration = 1000
        valueAnimator.addUpdateListener {
            LogUtils.e(it.animatedValue)
        }
        valueAnimator.start()
    }

    override fun initInterface() {
        initBkAnim()



    }

    private fun initBkAnim() {
        btn_property_bkAlpha.setOnClickListener {
            ObjectAnimator.ofFloat()
        }
    }
}