package com.kiwilss.xview.ui.anim.viewanim

import android.view.animation.*
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.anim.AnimatorUtil
import kotlinx.android.synthetic.main.activity_anim_view.*

/**
 *@FileName: AnimViewActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/3
 * @desc   : {}
 */
class AnimViewActivity : BaseActivity(R.layout.activity_anim_view) {

    override fun initData() {

    }

    override fun initEvent() {
        //xml实现方式
        btn_anim_view_alpha.setOnClickListener {
            val alpha = AnimationUtils.loadAnimation(this, R.anim.alpha_view)
            alpha.fillAfter = true//保持动画后的状态
            tv_anim_view_anim.startAnimation(alpha)
        }
        btn_anim_view_translate.setOnClickListener {
            val translate = AnimationUtils.loadAnimation(this, R.anim.translate_view)
            tv_anim_view_anim.startAnimation(translate)
        }
        btn_anim_view_rotate.setOnClickListener {
            val rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_view)
            tv_anim_view_anim.startAnimation(rotate)
        }
        btn_anim_view_scale.setOnClickListener {
            val scale = AnimationUtils.loadAnimation(this, R.anim.scale_view)
            tv_anim_view_anim.startAnimation(scale)
        }
        btn_anim_view_set.setOnClickListener {
            val set = AnimationUtils.loadAnimation(this,R.anim.view_set)
            tv_anim_view_anim.startAnimation(set)
        }
    }

    override fun initInterface() {
        //代码实现动画
        btn_anim_view_alpha2.setOnClickListener {
            val alpha = AlphaAnimation(1f, 0f)
            alpha.duration = 2000
            tv_anim_view_anim.startAnimation(alpha)
        }
        btn_anim_view_translate2.setOnClickListener {
            val translate = TranslateAnimation(0f, 200f, 0f, 200f)
            translate.duration = 3000
            tv_anim_view_anim.startAnimation(translate)
        }
        btn_anim_view_rotate2.setOnClickListener {
            //相对自身中心位置顺时针旋转180,不设置默认控件左上角
            val rotate = RotateAnimation(
                0f, 180f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
            )
            rotate.duration = 3000
            tv_anim_view_anim.startAnimation(rotate)
        }
        btn_anim_view_scale2.setOnClickListener {
            //不设置缩放中心,默认在控件左上角
            //val scale = ScaleAnimation(1f,0.5f,1f,0.5f)
            val scale = ScaleAnimation(1f, 0.5f, 1f, 0.5f,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
            scale.fillAfter = true
            scale.duration = 2000
            tv_anim_view_anim.startAnimation(scale)
        }
        btn_anim_view_set2.setOnClickListener {
            val set = AnimationSet(true)
            val alpha = AlphaAnimation(1f,0.5f)
            val rotate = RotateAnimation(0f,180f)
            set.fillAfter = true
            set.duration = 2000
            set.addAnimation(alpha)
            set.addAnimation(rotate)
            tv_anim_view_anim.startAnimation(set)
        }

    }

    override fun onReload() {
    }
}