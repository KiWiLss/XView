package com.kiwilss.xview.ui.anim.activity

import android.content.Intent
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_anim_cutin.*

/**
 *@FileName: AnimCutInActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/3
 * @desc   : {DESCRIPTION}
 */
class AnimCutInActivity: BaseActivity(R.layout.activity_anim_cutin) {
    override fun initData() {
    }

    override fun initEvent() {
        //系统自带动画部分
        btn_anim_cutin_no.setOnClickListener {
            startActivity(Intent(this,AnimCutOutActivity::class.java))
            overridePendingTransition(0,0)
        }
        btn_anim_cutin_default.setOnClickListener {
            startActivity(Intent(this,AnimCutOutActivity::class.java))
        }
        btn_anim_cutin_alpha.setOnClickListener {
            startActivity(Intent(this,AnimCutOutActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }
        btn_anim_cutin_translate.setOnClickListener {
            startActivity(Intent(this,AnimCutOutActivity::class.java))
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
        }
        //自定义简单动画
        btn_anim_cutin_alpha2.setOnClickListener {
            startActivity(Intent(this,AnimCutOutActivity::class.java))
            overridePendingTransition(R.anim.activity_fade_in,R.anim.activity_fade_out)
        }
        btn_anim_cutin_left.setOnClickListener {
            startActivity(Intent(this,AnimCutOutActivity::class.java))
            overridePendingTransition(R.anim.activity_slide_left_in,R.anim.activity_slide_right_out)
        }
        btn_anim_cutin_right.setOnClickListener {
            startActivity(Intent(this,AnimCutOutActivity::class.java))
            overridePendingTransition(R.anim.activity_slide_right_in,R.anim.activity_slide_left_out)
        }
        btn_anim_cutin_leftRight.setOnClickListener {
            startActivity(Intent(this,AnimCutOutActivity::class.java))
            overridePendingTransition(R.anim.activity_slide_right_in,R.anim.activity_slide_left_out)
        }
        btn_anim_cutin_top.setOnClickListener {
            startActivity(Intent(this,AnimCutOutActivity::class.java))
            overridePendingTransition(R.anim.activity_slide_top_in,R.anim.activity_slide_bottom_out)
        }
        btn_anim_cutin_bottom.setOnClickListener {
            startActivity(Intent(this,AnimCutOutActivity::class.java))
            overridePendingTransition(R.anim.activity_slide_bottom_in,R.anim.activity_slide_top_out)
        }
        btn_anim_cutin_topbottom.setOnClickListener {
            startActivity(Intent(this,AnimCutOutActivity::class.java))
            overridePendingTransition(R.anim.activity_slide_bottom_in,R.anim.activity_slide_top_out)
        }


    }

    override fun initInterface() {
    }

    override fun onReload() {
    }
}