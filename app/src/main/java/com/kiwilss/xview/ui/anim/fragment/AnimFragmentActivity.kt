package com.kiwilss.xview.ui.anim.fragment

import android.graphics.drawable.AnimationDrawable
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_anim_fragment.*

/**
 *@FileName: AnimFragmentActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/2
 * @desc   : {https://www.jianshu.com/p/225fe1feba60}
 */
class AnimFragmentActivity: BaseActivity(R.layout.activity_anim_fragment) {
    override fun initData() {

    }

    override fun initEvent() {
        //xml设置实现方式
        iv_anim_fragment_one.setImageResource(R.drawable.anim_list)
        val drawable: AnimationDrawable = iv_anim_fragment_one.drawable as AnimationDrawable
        btn_anim_fragment_xmlStart.setOnClickListener {
            drawable.start()
        }

        btn_anim_fragment_xmlStop.setOnClickListener {
            drawable.stop()
        }
        //代码实现方式
        val animationDrawable = AnimationDrawable()
        for (i in 0..59){
            val db = resources.getIdentifier("p$i","mipmap",packageName)
            val drawable2 = resources.getDrawable(db)
            animationDrawable.addFrame(drawable2,50)
        }
        animationDrawable.isOneShot = false
        iv_anim_fragment_two.setImageDrawable(animationDrawable)

        btn_anim_fragment_codeStart.setOnClickListener {
            animationDrawable.start()
        }
        btn_anim_fragment_codeStop.setOnClickListener {
            animationDrawable.stop()
        }
    }

    override fun initInterface() {

    }

    override fun onReload() {

    }
}