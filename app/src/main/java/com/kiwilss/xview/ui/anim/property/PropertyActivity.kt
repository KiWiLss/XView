package com.kiwilss.xview.ui.anim.property

import android.animation.*
import androidx.core.animation.addListener
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.DensityUtils
import com.kiwilss.xview.utils.LogUtils
import com.kiwilss.xview.utils.ResUtils
import com.kiwilss.xview.utils.anim.AnimatorUtil
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
        //从布局文件中获取
        btn_property_valueAnimatorxml.setOnClickListener {
            val loadAnimator = AnimatorInflater.loadAnimator(this, R.animator.value_int_test)
            loadAnimator.setTarget(btn_property_valueAnimatorxml)
            loadAnimator.start()
        }
        //代码实现
        btn_property_valueAnimator.setOnClickListener {
            testValueAnimator()
        }
        //通过valueAnimator实现修改控件
        btn_property_valueAnimator2.setOnClickListener {
            testValueAnimatorAnim()
        }
    }

    private fun testValueAnimatorAnim() {
        val width2 = tv_property_anim.layoutParams.width
        val width = tv_property_anim.width
        LogUtils.e("$width----- $width2")
        val valueAnimator = ValueAnimator.ofInt(width, width * 2)
        valueAnimator.duration = 2000
        valueAnimator.addUpdateListener {
            //当前值
            LogUtils.e(it.animatedValue)
            tv_property_anim.layoutParams.width = it.animatedValue as Int
            //刷新视图，即重新绘制，从而实现动画效果
            tv_property_anim.requestLayout()
        }
        valueAnimator.start()
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

        initCodeAnim()

        initTranslation()

        initAimator()
    }

    private fun initAimator() {
        //只执行一次
        iv_header.setOnClickListener {
            iv_header.animate().translationX(500f).rotation(180f)
                .setDuration(1000).start()
        }
        //每次点击会再次执行
        iv_header2.setOnClickListener {
            iv_header2.animate().translationXBy(500f).rotationBy(180f).setDuration(1000).start()
        }

    }

    private fun initTranslation() {
        val translation = DensityUtils.dp2px(-70f).toFloat()
        llAddAccount.setOnClickListener {
            ObjectAnimator.ofFloat(ivMakeNote,AnimatorUtil.ROTATION,0f,45f)
                .setDuration(500)
                .start()
            ObjectAnimator.ofFloat(llAddAccount,AnimatorUtil.TRANSLATION_X,0f,translation)
                .setDuration(500)
                .start()
        }



    }

    /**
     * code 实现
    */
    private fun initCodeAnim() {
        btn_property_alpha2.setOnClickListener {
            val alpha = ObjectAnimator.ofFloat(tv_property_anim,AnimatorUtil.ALPHA,0f,1f,0.5f,1f)
            alpha.duration = 3000
            alpha.start()
        }
        btn_property_scale2.setOnClickListener {
            val scaleX = ObjectAnimator.ofFloat(tv_property_anim,AnimatorUtil.SCALE_X,1f,2f)
            val scaleY = ObjectAnimator.ofFloat(tv_property_anim,AnimatorUtil.SCALE_Y,1f,2f)
            scaleX.duration = 2000
            scaleX.start()
            scaleY.duration = 2000
            scaleY.start()
        }
        btn_property_transe2.setOnClickListener {
            val translation = ObjectAnimator.ofFloat(tv_property_anim,AnimatorUtil.TRANSLATION_X,0f,500f)
            translation.duration = 2000
            translation.start()
        }
        btn_property_rotate2.setOnClickListener {
            val rotation = ObjectAnimator.ofFloat(tv_property_anim,AnimatorUtil.ROTATION,0f, 90f)
            rotation.duration = 2000
            rotation.start()
        }
        btn_property_set2.setOnClickListener {
            val set = AnimatorSet()
            val rotation = ObjectAnimator.ofFloat(tv_property_anim,AnimatorUtil.ROTATION,0f,90f)
            val rotationX = ObjectAnimator.ofFloat(tv_property_anim,AnimatorUtil.ROTATION_X,0f,40f)
            set.play(rotation).with(rotationX)
            set.duration = 2000
            set.start()
        }
        //一个objectanimator实现多个动画效果
        btn_property_transe3.setOnClickListener {
            val anim = ObjectAnimator.ofFloat(
                tv_property_anim,
                "AnimatorUtil.SCALE_X",
                1f, 0f
            ).setDuration(2000)
            anim.start()
            anim.addUpdateListener {
                val fl = it.animatedValue as Float
                tv_property_anim.alpha = fl
                tv_property_anim.scaleX = fl
                tv_property_anim.scaleY = fl
            }
        }
        btn_property_propertyValuesHolder.setOnClickListener {
            val alpha = PropertyValuesHolder.ofFloat(AnimatorUtil.ALPHA, 1f, 0f, 1f)
            val scalex = PropertyValuesHolder.ofFloat(AnimatorUtil.SCALE_X, 1f, 0f, 1f)
            val scaley = PropertyValuesHolder.ofFloat(AnimatorUtil.SCALE_Y, 1f, 0f, 1f)
            ObjectAnimator.ofPropertyValuesHolder(tv_property_anim,alpha,scalex,scaley).setDuration(2000).start()
        }
        btn_property_vertical.setOnClickListener {
            val valueAnimator = ValueAnimator.ofFloat(0f, 500f)
            valueAnimator.setTarget(tv_property_anim)
            valueAnimator.duration = 1000
            valueAnimator.start()
            valueAnimator.addUpdateListener {
                tv_property_anim.translationY = it.animatedValue as Float
            }
        }

    }

    /*
    xml 实现
     */
    private fun initBkAnim() {
        btn_property_bkAlpha.setOnClickListener {
            val alpha = AnimatorInflater.loadAnimator(this, R.animator.alpha_test)
            alpha.setTarget(tv_property_anim)
            alpha.start()
        }
        btn_property_scale.setOnClickListener {
            val scaleX = AnimatorInflater.loadAnimator(this, R.animator.scale_x)
            scaleX.setTarget(tv_property_anim)

            scaleX.start()
        }
        btn_property_rotate.setOnClickListener {
            val rotateZ = AnimatorInflater.loadAnimator(this, R.animator.rorate_x)
            //设置中心
            tv_property_anim.pivotX = 0f
            tv_property_anim.pivotY = 0f
            tv_property_anim.invalidate()
            rotateZ.setTarget(tv_property_anim)
            rotateZ.start()
        }
        btn_property_transe.setOnClickListener {
            val translateZ = AnimatorInflater.loadAnimator(this, R.animator.translate_x)
            translateZ.setTarget(tv_property_anim)
            translateZ.start()
        }
        btn_property_set.setOnClickListener {
            val set = AnimatorInflater.loadAnimator(this, R.animator.set_test)
            set.setTarget(tv_property_anim)
            set.start()
        }
    }
}