package com.kiwilss.xview.ui.aac.hilt

import android.app.Activity
import android.app.Application
import android.content.Context
import android.widget.Toast
import com.kiwilss.App
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

/**
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2021/7/27
 * @desc   : {预置类}
 */
//预初始化 applicationContext
@Singleton
class ContextApplication @Inject constructor(@ApplicationContext val context: Context){
    fun testContext(){
        Toast.makeText(context, "ContextApplication", Toast.LENGTH_SHORT).show()
    }
}

class ContextApplication2 @Inject constructor(val context: Application)
//预初始化自定义 application
class ContextApp @Inject constructor(val context: App)

//预 初始化 Activity 的 context
@ActivityScoped
class ContextActivity @Inject constructor(@ActivityContext val context: Context){
    fun testContext(){
        Toast.makeText(context, "ContextActivity", Toast.LENGTH_SHORT).show()
    }
}

class ContextActivity2 @Inject constructor(val context: Activity)

