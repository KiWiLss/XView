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
import com.kiwilss.xview.model.banner.BannerBean

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

    var imageUrls = listOf(
        "https://video.dakale.net/image/cover/61CFD4772F0D4B5199002F2739DA2D25-6-2.png",
        "https://video.dakale.net/image/cover/50D7058C125B4894BD19EB3A7B7A686D-6-2.png",
        "https://video.dakale.net/image/cover/BC3B229822254442B1A96BF6B16649DB-6-2.png",
        "https://video.dakale.net/image/cover/23265659207A4E479500C344D4895F10-6-2.png",
        "https://video.dakale.net/image/cover/F86AE51D775D4E90A126E1B0B495E26E-6-2.png",
        "https://video.dakale.net/image/cover/820BA482154E4930B362D93970AA2278-6-2.png"
    )
    fun getBannerList1(): List<BannerBean>{
        val list = arrayListOf<BannerBean>()
        for (index in imageUrls.indices){
            val bannerBean = BannerBean(null,null, imageUrls[index],false)
            list.add(bannerBean)
        }
        return list
    }
    fun getBannerList2(): List<BannerBean>{
        val list = arrayListOf<BannerBean>()
        for (index in imageUrls.indices){
            val bannerBean = BannerBean("测试看标题$index",null, imageUrls[index],true)
            list.add(bannerBean)
        }
        return list
    }
}