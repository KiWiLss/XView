package com.kiwilss.xview.ui.anim.transition

import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.anim.transition.explode.ExplodeAActivity
import com.kiwilss.xview.ui.anim.transition.one.TransitionOneActivity
import com.kiwilss.xview.utils.ktx.IntentKtx.startActivity2
import kotlinx.android.synthetic.main.activity_transition.*

/**
 *@FileName: TransitionActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/8
 * @desc   : {DESCRIPTION}
 */
class TransitionActivity: BaseActivity(R.layout.activity_transition) {
    override fun initData() {

    }

    override fun initEvent() {
        btn_transition_explode.setOnClickListener {
            startActivity2<ExplodeAActivity>()
        }
        btn_transition_one.setOnClickListener {
            startActivity2<TransitionOneActivity>()
        }
    }

    override fun initInterface() {
    }
}