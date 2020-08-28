package com.kiwilss.xview.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 *@FileName: BaseActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/28
 * @desc   : {简单设置全局状态切换,可以自由选择是否使用toolbar}
 */
abstract class BaseActivity(layoutId: Int): AppCompatActivity(layoutId) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }




}