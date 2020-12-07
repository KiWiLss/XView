package com.kiwilss.xview.ui.anim.layout

import android.animation.Animator
import android.animation.LayoutTransition
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.annotation.SuppressLint
import android.view.animation.LayoutAnimationController
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_layout.*


/**
 *@FileName: LayoutActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/7
 * @desc   : {DESCRIPTION}
 */
class LayoutActivity : BaseActivity(R.layout.activity_layout) {
    override fun initData() {

    }

    override fun initEvent() {
    }

    override fun initInterface() {
        //默认动画,渐变效果
        btn_layout_add.setOnClickListener {
            addListener()
        }
        btn_layout_reduce.setOnClickListener {
            reduceListener()
        }

        //通过代码设置
////设置过渡动画
//        val scaleAnimation = ScaleAnimation(0f, 1f, 0f, 1f)
//        scaleAnimation.duration = 2000
////设置布局动画的显示属性,第一个参数是动画,第二个参数是每个控件完成动画的延迟,为0时不能设置执行顺序
////设置布局动画的显示属性,第一个参数是动画,第二个参数是每个控件完成动画的延迟,为0时不能设置执行顺序
//        val layoutAnimationController =
//            LayoutAnimationController(scaleAnimation, 0.5f)
////设置执行顺序,LayoutAnimationController.ORDER_NORMAL,顺序;ORDER_RANDOM,随机;ORDER_REVERSE逆序
////设置执行顺序,LayoutAnimationController.ORDER_NORMAL,顺序;ORDER_RANDOM,随机;ORDER_REVERSE逆序
//        layoutAnimationController.order = LayoutAnimationController.ORDER_NORMAL
//        ll_layout_two.layoutAnimation = layoutAnimationController

//        val layoutTransition = LayoutTransition()
//        layoutTransition.setAnimator(LayoutTransition.APPEARING,getOutAnim())




    }

    @SuppressLint("ObjectAnimatorBinding")
    private fun getOutAnim(): Animator? {
        val trY2 = PropertyValuesHolder.ofFloat("translationY", 0f, -100f)
        val trX = PropertyValuesHolder.ofFloat("translationX", 0f, 0f)
        val trAlpha2 = PropertyValuesHolder.ofFloat("alpha", 1f, 0f)
        return ObjectAnimator.ofPropertyValuesHolder(this, trY2, trAlpha2, trX)
    }

    private fun reduceListener() {
        val childCount = ll_layout_one.childCount
        if (childCount > 0) {
            ll_layout_one.removeViewAt(childCount - 1)
        }
    }

    private fun addListener() {
        val inflate = layoutInflater.inflate(R.layout.rl_test_button, null)
        ll_layout_one.addView(inflate)
    }
}