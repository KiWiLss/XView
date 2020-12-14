package com.kiwilss.xview.ui.anim.transition.two.transition

import android.transition.Explode
import android.transition.Transition
import android.transition.TransitionInflater
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator


import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_transition2.*
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 *@FileName: TransitionActivity2
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/14
 * @desc   : {DESCRIPTION}
 */
class TransitionActivity2 : BaseActivity(R.layout.activity_transition2) {
     var mType : Int = -1

    override fun initData() {

    }

    override fun initEvent() {

        exit_button.setOnClickListener {
            finishAfterTransition()
        }

        iv_layout_toolbar_back?.setOnClickListener {
            finishAfterTransition()
        }

    }

    override fun initInterface() {
        mType = intent.getIntExtra(EXTRA_TYPE,-1)

        setWindowsTransition()


    }

    private fun setWindowsTransition() {
        var transition: Transition = if (mType == TYPE_XML){
            TransitionInflater.from(this).inflateTransition(R.transition.activity_explode)
        }else{
            buildEnterTransition()
        }
        window.enterTransition = transition
    }

    private fun  buildEnterTransition(): Transition {
        val explode = Explode()
        explode.duration = 500
        explode.interpolator = BounceInterpolator()
        return explode
    }
}