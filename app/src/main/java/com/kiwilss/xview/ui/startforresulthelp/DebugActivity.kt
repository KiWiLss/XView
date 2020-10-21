package com.kiwilss.xview.ui.startforresulthelp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.xview.R
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_debug.*

/**
 *@FileName: DebugActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/27
 * @desc   : {DESCRIPTION}
 */
class DebugActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_debug)
        super.onCreate(savedInstanceState)

        add1()
        sub()
        btn_debug_alone.setOnClickListener {
            sub()
        }
    }

    private fun sub() {
        for (i in 0..15) {
            LogUtils.e("test about hello dd $i")
        }
    }

    private fun add1() {
        for (i in 0..10) {
            LogUtils.e("I am $i")
        }
    }
}