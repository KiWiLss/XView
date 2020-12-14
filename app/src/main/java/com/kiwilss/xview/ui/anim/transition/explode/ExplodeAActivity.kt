package com.kiwilss.xview.ui.anim.transition.explode

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.transition.Transition
import android.transition.TransitionInflater
import android.view.View
import android.view.Window
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_exploade_a.*


/**
 *@FileName: ExplodeAActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/8
 * @desc   : {DESCRIPTION}
 */
class ExplodeAActivity : BaseActivity(R.layout.activity_exploade_a) {
    override fun initData() {

    }

    override fun initEvent() {
//        btn_exploade_a_one.setOnClickListener {
//            //startActivity2<ExplodeBActivity>()
//            startActivity(Intent(this,ExplodeBActivity::class.java), ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
//        }

        //单个元素
        ivImage.setOnClickListener {
//                val bundle =
//                    ActivityOptions.makeSceneTransitionAnimation(this, ivImage, "activityTransform")
//                        .toBundle()
//                startActivity(Intent(this, ExplodeBActivity::class.java), bundle)

            startActivity(Intent(this, ExplodeBActivity::class.java),ActivityOptions.makeSceneTransitionAnimation(this).toBundle())

        }
        //多个元素
        tvText.setOnClickListener {
            val imagePair: android.util.Pair<View, String> = android.util.Pair<View,String>(ivImage!!,"activityTransform")
            val textPair = android.util.Pair<View,String>(tvText!!,"textTransform")

            val bundle =
                ActivityOptions.makeSceneTransitionAnimation(this,
                    imagePair,textPair).toBundle()
            startActivity(Intent(this, ExplodeBActivity::class.java), bundle)
        }



    }

    override fun beforeSetContent(savedInstanceState: Bundle?) {
        super.beforeSetContent(savedInstanceState)
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        val explode: Transition =
            TransitionInflater.from(this).inflateTransition(R.transition.activity_explode)
//退出时使用
        window.exitTransition = explode
//第一次进入时使用
        window.enterTransition = explode
//再次进入时使用
        window.reenterTransition = explode
    }

    override fun initInterface() {

    }




}