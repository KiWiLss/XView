package com.kiwilss.xview.ui.aac.viewbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.databinding.ActivityAacBinding
import com.kiwilss.xview.databinding.ActivityMainBinding
import com.kiwilss.xview.databinding.ActivityViewbindingBinding

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/13
 *  desc   :
 */
class ViewBindingActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = ActivityViewbindingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //获取name进行赋值
        binding.textAccount.text = "viewBinding test"



    }

}