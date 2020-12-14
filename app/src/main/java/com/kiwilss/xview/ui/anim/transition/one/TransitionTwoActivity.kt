package com.kiwilss.xview.ui.anim.transition.one

import android.os.Bundle
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.LogUtils
import com.kogitune.activity_transition.ActivityTransition
import com.kogitune.activity_transition.ExitActivityTransition
import kotlinx.android.synthetic.main.activity_transition_two.*
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 *@FileName: TransitionTwoActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/11
 * @desc   : {DESCRIPTION}
 */
class TransitionTwoActivity: BaseActivity(R.layout.activity_transition_two) {

    lateinit var mExitTransition: ExitActivityTransition

    override fun initData() {

    }

    override fun initEvent() {
        //对标题栏反悔按钮重置
        iv_layout_toolbar_back.setOnClickListener {
            onBackPressed()
        }
        iv_transition_two_one.setOnClickListener {
            onBackPressed()
        }

    }

    override fun initInterface2(savedInstanceState: Bundle?) {
        super.initInterface2(savedInstanceState)

        val value = intent.getStringExtra("key")
        LogUtils.e(value)

         mExitTransition = ActivityTransition.with(intent)
            .to(iv_transition_two_one)
             //.to(tv_transition_two_name)
            .start(savedInstanceState)




    }

//    override fun finish() {
//        mExitTransition.exit(this)
//        super.finish()
//    }
    override fun onBackPressed() {
        mExitTransition.exit(this)
        //super.onBackPressed()
    }

    override fun initInterface() {



    }
}