package com.kiwilss.xview.ui.startforresulthelp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.xview.R
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_help_result.*

/**
 *@FileName: HelpResultActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/20
 * @desc   : {DESCRIPTION}
 */
class HelpResultActivity: AppCompatActivity(R.layout.activity_help_result) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       val key =  intent.getStringExtra("key")
        LogUtils.e(key)

        btn_help_result_callback.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        btn_help_result_callback2.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result","hello")
            intent.putExtra("callback","world")
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}