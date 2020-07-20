/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: Utils
 * Author:   kiwilss
 * Date:     2020/7/5 18:53
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.utils

import android.content.Context
import android.content.pm.PackageManager
import com.kiwilss.App

/**
 *@FileName: Utils
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/7/5
 * @desc   : {DESCRIPTION}
 */
object Utils {
    fun getUMChannelName(ctx: Context?): String? {
        if (ctx == null) {
            return null
        }
        var channelName: String? = null
        try {
            val packageManager: PackageManager = ctx.packageManager
            //注意此处为ApplicationInfo 而不是 ActivityInfo,因为友盟设置的meta-data是在application标签中，而不是某activity标签中，所以用ApplicationInfo
            val applicationInfo = packageManager.getApplicationInfo(
                ctx.packageName,
                PackageManager.GET_META_DATA
            )
            if (applicationInfo.metaData != null) {
                channelName = applicationInfo.metaData.getString("UMENG_CHANNEL")
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return channelName
    }

    fun getList(){

    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    fun getContext(): Context {
        val context = App.mContext
        if (context != null){
            return context
        }else{
            throw NullPointerException("app.mContext should init")
        }

    }

}