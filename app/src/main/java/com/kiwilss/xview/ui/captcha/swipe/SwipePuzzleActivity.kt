package com.kiwilss.xview.ui.captcha.swipe

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.captcha.swipe.SwipeCaptchaView.OnCaptchaMatchCallback
import kotlinx.android.synthetic.main.activity_swipe_captcha.*


/**
 *@FileName: SwipePuzzleActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/16
 * @desc   : {DESCRIPTION}
 */
class SwipePuzzleActivity: BaseActivity(R.layout.activity_swipe_captcha) {
    override fun initData() {

    }

    override fun initEvent() {
        btnChange.setOnClickListener {
            swipeCaptchaView.createCaptcha()
            dragBar.setEnabled(true)
            dragBar.setProgress(0)
        }
    }

    override fun initInterface() {

        swipeCaptchaView.setOnCaptchaMatchCallback(object : OnCaptchaMatchCallback {
            override fun matchSuccess(swipeCaptchaView: SwipeCaptchaView) {
                Toast.makeText(this@SwipePuzzleActivity, "恭喜你啊 验证成功 可以搞事情了", Toast.LENGTH_SHORT).show()
                //swipeCaptcha.createCaptcha();
                dragBar.setEnabled(false)
            }

            override fun matchFailed(swipeCaptchaView: SwipeCaptchaView) {
                Log.d(
                    "zxt",
                    "matchFailed() called with: swipeCaptchaView = [$swipeCaptchaView]"
                )
                Toast.makeText(this@SwipePuzzleActivity, "你有80%的可能是机器人，现在走还来得及", Toast.LENGTH_SHORT).show()
                swipeCaptchaView.resetCaptcha()
                dragBar.setProgress(0)
            }
        })
        dragBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(
                seekBar: SeekBar,
                progress: Int,
                fromUser: Boolean
            ) {
                swipeCaptchaView.setCurrentSwipeValue(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //随便放这里是因为控件
                dragBar.setMax(swipeCaptchaView.getMaxSwipeValue())
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                Log.d("zxt", "onStopTrackingTouch() called with: seekBar = [$seekBar]")
                swipeCaptchaView.matchCaptcha()
            }
        })



        //测试从网络加载图片是否ok
//        Glide.with(this).asBitmap()
//            .load("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1733226354,2596892520&fm=26&gp=0.jpg")
//            .into(object : CustomTarget<Bitmap>(){
//                override fun onLoadCleared(placeholder: Drawable?) {
//                }
//
//                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
//                    swipeCaptchaView.setImageBitmap(resource)
//                    swipeCaptchaView.createCaptcha()
//                }
//
//            })

    }
}