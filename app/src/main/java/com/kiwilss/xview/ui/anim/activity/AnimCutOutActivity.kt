package com.kiwilss.xview.ui.anim.activity

import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_anim_cutout.*

/**
 *@FileName: AnimCutOutActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/3
 * @desc   : {DESCRIPTION}
 */
class AnimCutOutActivity: BaseActivity(R.layout.activity_anim_cutout) {
    override fun initData() {

    }

    override fun initEvent() {
        //系统自带动画部分
        btn_anim_cutout_no.setOnClickListener {
            finish()
            overridePendingTransition(0,0)
        }
        btn_anim_cutout_default.setOnClickListener {
            finish()
        }
        btn_anim_cutout_alpha.setOnClickListener {
            finish()
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }
        btn_anim_cutout_translate.setOnClickListener {
            finish()
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
        }
    }

    override fun initInterface() {

    }

    override fun onReload() {

    }
}