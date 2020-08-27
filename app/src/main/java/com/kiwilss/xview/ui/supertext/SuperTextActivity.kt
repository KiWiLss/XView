package com.kiwilss.xview.ui.supertext

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.activity_supertext.*

/**
 *@FileName: SuperTextActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/27
 * @desc   : {DESCRIPTION}
 */
class SuperTextActivity: AppCompatActivity(R.layout.activity_supertext) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        stv_supertext_setting.setOnSuperTextViewClickListener {
            Toast.makeText(this, "点击supertextview", Toast.LENGTH_SHORT).show()
        }.setLeftTvClickListener {
            Toast.makeText(this, "点击设置", Toast.LENGTH_SHORT).show()
        }.setRightTvClickListener {
            Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show()
        }.setRightImageViewClickListener {
            Toast.makeText(this, "点击icon", Toast.LENGTH_SHORT).show()
        }


    }
}