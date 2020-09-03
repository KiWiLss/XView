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
    }

    override fun initInterface() {
    }

    override fun onReload() {
    }
}