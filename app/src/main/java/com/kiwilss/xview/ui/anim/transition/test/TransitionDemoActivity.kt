package com.kiwilss.xview.ui.anim.transition.test

import android.content.Intent
import android.view.View
import androidx.core.util.Pair
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.help.TransitionHelper
import com.kiwilss.xview.utils.test.ResUtils
import kotlinx.android.synthetic.main.activity_transition_demo.*

/**
 *@FileName: TransitionDemoActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/21
 * @desc   : {DESCRIPTION}
 */
class TransitionDemoActivity : BaseActivity(R.layout.activity_transition_demo) {

    override fun initData() {

    }

    override fun initEvent() {

        iv_transition_demo_pic.setOnClickListener {
            goToDetail(it)
        }


    }

    private fun goToDetail(it: View?) {
        val paris = TransitionHelper.createSafeTransitionParticipants(this,true,
        Pair(it,ResUtils.getString(R.string.transition_demo_pic)),
        Pair(iv_transition_demo_header,ResUtils.getString(R.string.transition_demo_header)),
        Pair(tv_transition_demo_name,ResUtils.getString(R.string.transition_demo_nickname))
        )
        val intent = Intent(this,TransitionDemoDetailActivity::class.java)
        transitionTo(intent,*paris)
    }

    override fun initInterface() {



    }
}