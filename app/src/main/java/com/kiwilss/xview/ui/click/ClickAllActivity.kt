package com.kiwilss.xview.ui.click

import android.content.Context
import android.view.View
import android.widget.Toast
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.click.aop.SingleClick
import com.kiwilss.xview.ui.click.aop.XClickUtil
import com.kiwilss.xview.ui.click.java.ClickProxy
import com.kiwilss.xview.ui.click.java.CustomClickListener
import com.kiwilss.xview.ui.click.kotlin.click
import com.kiwilss.xview.ui.click.kotlin.clickWithTrigger
import com.kiwilss.xview.ui.click.kotlin.withTrigger
import com.kiwilss.xview.ui.click.time.LCountDownTimer
import com.kiwilss.xview.ui.click.time.TimerListener
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_click_all.*

/**
 *@FileName: ClickAllActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/17
 * @desc   : {DESCRIPTION}
 */

@SingleClick(value = 1000)
class ClickAllActivity : BaseActivity(R.layout.activity_click_all), View.OnClickListener {
    override fun initData() {

    }


    override fun initEvent() {
        btn_click_all_one.clickWithTrigger {
            Toast.makeText(this, "hai", Toast.LENGTH_SHORT).show()
        }
        btn_click_all_two.withTrigger().click {
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()
        }

        btn_click_all_three.setOnClickListener(object : CustomClickListener() {
            override fun onSingleClick(view: View?) {
                Toast.makeText(this@ClickAllActivity, "单击", Toast.LENGTH_SHORT).show()
            }

            override fun onFastClick(view: View?) {
                super.onFastClick(view)
                Toast.makeText(this@ClickAllActivity, "快速点击", Toast.LENGTH_SHORT).show()
            }

        })

        btn_click_all_four.setOnClickListener(ClickProxy(View.OnClickListener {
            Toast.makeText(this@ClickAllActivity, "单击", Toast.LENGTH_SHORT).show()
        }, ClickProxy.IAgain {
            Toast.makeText(this@ClickAllActivity, "再次点击", Toast.LENGTH_SHORT).show()
        }))


        btn_click_all_aop1.setOnClickListener(object : View.OnClickListener {

            override fun onClick(p0: View?) {
                if (XClickUtil.isFastDoubleClick(p0,1000)) {
                    LogUtils.e("多次点击")
                }else{
                    LogUtils.e("aop")
                }

            }

        })

        btn_click_all_aop2.setOnClickListener(this)

    }

     var mCountTime: LCountDownTimer? = null
    override fun initInterface() {
        //倒计时相关
        mCountTime = LCountDownTimer(60*1000 + 100, 1000)

        btn_click_all_start.setOnClickListener {
            mCountTime?.start()
        }

        btn_click_all_restart.setOnClickListener {
            mCountTime?.resume()
        }

        btn_click_all_pause.setOnClickListener {
            mCountTime?.pause()
        }
        btn_click_all_stop.setOnClickListener {
            mCountTime?.cancel()
        }

        mCountTime?.setCountDownListener(object : TimerListener{
            override fun onFinish() {
                LogUtils.e("onFinish")
            }

            override fun onTick(millisUntilFinished: Long) {
                tv_click_all_num.text = "${millisUntilFinished / 1000}, 倒计时"
                LogUtils.e("onTick--${millisUntilFinished/1000}")
            }

            override fun onStart() {
                LogUtils.e("onStart")
            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        mCountTime?.run {
            cancel()
        }
        mCountTime = null
    }

    override fun onClick(p0: View?) {
        if (XClickUtil.isFastDoubleClick(p0,1000)) {
            LogUtils.e("多次点击--")
        }else{
            LogUtils.e("已经登录过了")
        }


    }
}


