package com.kiwilss.xview.ui.anim.transition.two.transition

import android.content.Intent
import android.transition.Fade
import android.transition.Slide
import android.transition.Visibility
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.anim.transition.bean.Sample
import kotlinx.android.synthetic.main.activity_transition1.*
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 *@FileName: TransitionActivity1
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/14
 * @desc   : {DESCRIPTION}
 */
class TransitionActivity1 : BaseActivity(R.layout.activity_transition1) {

    lateinit var mSample: Sample

    override fun initData() {

    }

    override fun initEvent() {
        sample1_button6.setOnClickListener {
            /**
             * If no return transition is defined Android will use reversed enter transition
             * In this case, return transition will be a reversed Slide (defined in buildEnterTransition)
             */
            finishAfterTransition()
        }
        sample1_button5.setOnClickListener {
            val returnTransition = buildReturnTransition()
            window.returnTransition = returnTransition
            finishAfterTransition()
        }
        //explode 跳转
        sample1_button1.setOnClickListener {
            transitionTo(Intent(this,TransitionActivity2::class.java))
        }
        sample1_button2.setOnClickListener {
            val intent = Intent(this,TransitionActivity2::class.java)
            intent.putExtra(EXTRA_TYPE,TYPE_XML)
            transitionTo(intent)
        }


    }

    override fun initInterface() {
        //获取数据,设置标题
        mSample = intent.getSerializableExtra(EXTRA_SAMPLE) as Sample
        tv_layout_toolbar_title?.text = mSample.name

        iv_layout_toolbar_back?.setOnClickListener {
            finishAfterTransition()
        }
        setupWindowAnimations()



    }
    private fun setupWindowAnimations() {
        val enterTransition: Visibility = buildEnterTransition()
        window.enterTransition = enterTransition
    }

    private fun buildEnterTransition(): Visibility {
        val enterTransition = Fade()
        enterTransition.duration = 500
        // This view will not be affected by enter transition animation
        //enterTransition.excludeTarget(R.id.square_red, true)
        return enterTransition
    }

    private fun buildReturnTransition(): Visibility {
        val enterTransition: Visibility = Slide()
        enterTransition.duration = 500
        return enterTransition
    }
}