package com.kiwilss.xview.ui.keyboard

import android.view.KeyEvent
import android.view.MotionEvent
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.KeyboardUtils2
import com.kiwilss.xview.utils.LogUtils
import com.kiwilss.xview.utils.keyboard.KbUtils
import com.kiwilss.xview.utils.keyboard.KeyboardUtils
import kotlinx.android.synthetic.main.activity_keyboard.*

/**
 *@FileName: KeyboardActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/11/8
 * @desc   : {DESCRIPTION}
 */
class KeyboardActivity : BaseActivity(R.layout.activity_keyboard) {
    override fun initData() {

    }

    override fun initEvent() {

        //KeyboardUtils.setSoftInputAdjustPan(this)

        btn_keyboard_show.setOnClickListener {
            KbUtils.showSoftInput()
        }
        btn_keyboard_show2.setOnClickListener {
            KbUtils.showSoftInput(this)
        }
        btn_keyboard_show3.setOnClickListener {
            KbUtils.showSoftInput(et_keyboard_et)
        }
        btn_keyboard_show4.setOnClickListener {
            KbUtils.toggleSoftInput()
        }

        btn_keyboard_hide.setOnClickListener {
            KeyboardUtils2.hideSoftInput(et_keyboard_top)
        }
        btn_keyboard_hide2.setOnClickListener {
            KbUtils.hideSoftInput(this)
        }
        btn_keyboard_hide3.setOnClickListener {
            KbUtils.hideSoftInput(window)
        }
        btn_keyboard_hide4.setOnClickListener {
            KbUtils.hideSoftInputByToggle(this)
        }

        KeyboardUtils.registerSoftInputChangedListener(this,object : KeyboardUtils.OnSoftInputChangedListener{
            override fun onSoftInputChanged(height: Int) {
                LogUtils.e(height)
            }

        })

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return KeyboardUtils.onDisableBackKeyDown(keyCode) && super.onKeyDown(keyCode, event)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        KeyboardUtils.dispatchTouchEvent(ev,this)
//        KeyboardUtils.dispatchTouchEvent(ev,window)
        return super.dispatchTouchEvent(ev)
    }


    override fun initInterface() {

    }
}