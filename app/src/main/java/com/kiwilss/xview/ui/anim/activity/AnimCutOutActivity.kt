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
        //自定义简单动画
        btn_anim_cutout_alpha2.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.activity_fade_in,R.anim.activity_fade_out)
        }
        btn_anim_cutout_left.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.activity_slide_left_in,R.anim.activity_slide_right_out)
        }
        btn_anim_cutout_right.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.activity_slide_right_in,R.anim.activity_slide_left_out)
        }
        btn_anim_cutout_leftRight.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.activity_slide_left_in,R.anim.activity_slide_right_out)
        }
        btn_anim_cutout_top.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.activity_slide_top_in,R.anim.activity_slide_bottom_out)
        }
        btn_anim_cutout_bottom.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.activity_slide_bottom_in,R.anim.activity_slide_top_out)
        }
        btn_anim_cutout_topbottom.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.activity_slide_top_in,R.anim.activity_slide_bottom_out)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        // 添加返回过渡动画.
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun initInterface() {

    }

    override fun onReload() {

    }
}