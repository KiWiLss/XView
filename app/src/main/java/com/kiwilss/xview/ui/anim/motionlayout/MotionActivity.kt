package com.kiwilss.xview.ui.anim.motionlayout

import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.ktx.IntentKtx.startActivity2
import kotlinx.android.synthetic.main.activity_motion_all.*

/**
 *@FileName: MotionActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/9
 * @desc   : {DESCRIPTION}
 */
class MotionActivity: BaseActivity(R.layout.activity_motion_all) {
    override fun initData() {

    }

    override fun initEvent() {
        btn_motion_one.setOnClickListener {
            startActivity2<MotionLayoutActivity>()
        }
    }

    override fun initInterface() {
    }
}