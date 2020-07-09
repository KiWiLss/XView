/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: App
 * Author:   kiwilss
 * Date:     2020/7/8 23:04
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss

import android.app.Application
import android.content.Context

/**
 *@FileName: App
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/7/8
 * @desc   : {DESCRIPTION}
 */
class App : Application(){
    override fun onCreate() {
        super.onCreate()
        mContext = this

    }
    companion object{
        var mContext: Context? = null

    }
}