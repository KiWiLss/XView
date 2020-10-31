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

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.view.WindowManager
import android.widget.TextView
import com.kiwilss.App
import com.kiwilss.xview.model.banner.BannerBean
import java.io.Closeable
import java.io.IOException


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

    fun getUMChannelName(ctx: Context?, channel: String = "UMENG_CHANNEL"): String? {
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
                channelName = applicationInfo.metaData.getString(channel)
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return channelName
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    fun getContext(): Context {
        val context = App.mContext
        if (context != null) {
            return context
        } else {
            throw NullPointerException("app.mContext should init")
        }
    }

    var imageUrls = listOf(
        "https://video.dakale.net/image/cover/61CFD4772F0D4B5199002F2739DA2D25-6-2.png",
        "https://video.dakale.net/image/cover/50D7058C125B4894BD19EB3A7B7A686D-6-2.png",
        "https://video.dakale.net/image/cover/BC3B229822254442B1A96BF6B16649DB-6-2.png",
        "https://video.dakale.net/image/cover/23265659207A4E479500C344D4895F10-6-2.png",
        "https://video.dakale.net/image/cover/F86AE51D775D4E90A126E1B0B495E26E-6-2.png",
        "https://video.dakale.net/image/cover/820BA482154E4930B362D93970AA2278-6-2.png"
    )

    fun getBannerList1(): List<BannerBean> {
        val list = arrayListOf<BannerBean>()
        for (index in imageUrls.indices) {
            val bannerBean = BannerBean(null, null, imageUrls[index], false)
            list.add(bannerBean)
        }
        return list
    }

    fun getBannerList2(): List<BannerBean> {
        val list = arrayListOf<BannerBean>()
        for (index in imageUrls.indices) {
            val bannerBean = BannerBean("测试看标题$index", null, imageUrls[index], true)
            list.add(bannerBean)
        }
        return list
    }

    /**
     * 根据手机分辨率从dp转成px
     *
     * @param context
     * @param dpValue
     * @return
     */
    fun dip2px(context: Context, dpValue: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * 设置添加屏幕的背景透明度
     * @param bgAlpha
     */
    fun backgroundAlpha(context: Activity, bgAlpha: Float) {
        val lp: WindowManager.LayoutParams = context.window.attributes
        lp.alpha = bgAlpha //0.0-1.0
        context.window.attributes = lp
    }

    /**
     * 安静关闭 IO
     *
     * @param closeables closeables
     */
    fun closeIOQuietly(vararg closeables: Closeable?) {
        for (closeable in closeables) {
            if (closeable != null) {
                try {
                    closeable.close()
                } catch (ignored: IOException) {
                }
            }
        }
    }

    /**
     * 获取textview某行内容
     */
    fun getTextLineContent(textView: TextView?, line: Int, src: String?): String {
        var result: String = ""
        if (textView == null || src.isNullOrEmpty()) {
            return result
        }
        LogUtils.e("$line--line-->${textView.lineCount}"  )
        if (line > textView.lineCount) {
            return result
        }
        val layout = textView.layout
        val sb = StringBuilder(src)
        LogUtils.e("--start-${layout.getLineStart(line)}----end---${layout.getLineEnd(line)}")
        return sb.subSequence(layout.getLineStart(line), layout.getLineEnd(line)).toString()
    }


}