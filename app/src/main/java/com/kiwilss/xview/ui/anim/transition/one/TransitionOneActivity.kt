package com.kiwilss.xview.ui.anim.transition.one

import android.content.Intent
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kogitune.activity_transition.ActivityTransitionLauncher
import kotlinx.android.synthetic.main.activity_transition_one.*

/**
 *@FileName: TransitionOneActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/11
 * @desc   : {DESCRIPTION}
 */
class TransitionOneActivity : BaseActivity(R.layout.activity_transition_one) {
    override fun initData() {


    }

//    override fun initLoadingHelp(isUseToolbar: Boolean) {
//        //super.initLoadingHelp(isUseToolbar)
//    }

    override fun initEvent() {
        iv_transition_one_one.setOnClickListener {
            val intent = Intent(this,TransitionTwoActivity::class.java)
            intent.putExtra("key","value")
            ActivityTransitionLauncher.with(this)
                .from(iv_transition_one_one)
                //.from(tv_transition_one_name)
                .launch(intent)

        }


    }

    override fun initInterface() {



    }
}