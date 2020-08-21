/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: MeiTuanHomeActivity
 * Author:   kiwilss
 * Date:     2020/8/18 22:11
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.design.imitate

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.appbar.AppBarLayout

import com.kiwilss.xview.R
import com.kiwilss.xview.design.appbar.AppBarStateChangeListener
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_meituan_home.*
import kotlin.math.abs


/**
 *@FileName: MeiTuanHomeActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/18
 * @desc   : {DESCRIPTION}
 */
class MeiTuanHomeActivity : AppCompatActivity(R.layout.activity_meituan_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //tb_mt_toolbar.setNavigationOnClickListener { finish() }
        iv_mt_back.setOnClickListener { finish() }

//        ctl_mt_collapsing.run {
//            title = "个人中心"
//            setExpandedTitleColor(ContextCompat.getColor(this@MeiTuanHomeActivity,R.color.transparent))
//            setCollapsedTitleTextColor(ContextCompat.getColor(this@MeiTuanHomeActivity,R.color.red))
//            expandedTitleGravity = Gravity.CENTER_HORIZONTAL
//            collapsedTitleGravity = Gravity.CENTER_HORIZONTAL
//        }


//        appbar_mt_appbar.addOnOffsetChangedListener(object : AppBarStateChangeListener(){
//            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?, i: Int) {
//                LogUtils.e(i)
//                //对标题设置渐变,向上滑动时i --> 0--- -448,标题先是变不见,后又可见(alpha 0-1)
//
//                when(state){
//                    //折叠 i == -492
//                    State.COLLAPSED -> {
//                        alpha = 1f
//                    }
//                    //展开 i == 0
//                    State.EXPANDED -> {
//                        alpha = 0f
//                    }
//                    //中间状态
//                    State.IDLE -> {
//                        val a = - (i / 200)
//                        val max = 0.3f.coerceAtLeast(a.toFloat())
//                        alpha = max
//                        LogUtils.e("alpha = $alpha ------max = $max","----alpha--->")
//                    }
//                }
//                tv_mt_title.alpha = alpha
//            }
//
//        })

        appbar_mt_appbar.addOnOffsetChangedListener(object : AppBarStateChangeListener() {
            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?, i: Int) {
                when (state) {
                    //折叠 i == -492
                    State.COLLAPSED -> {
                        tv_mt_title.text = "个人中心"
                    }
                    //展开 i == 0
                    State.EXPANDED -> {
                        tv_mt_title.text = "膜拜单车"
                    }
                    //中间状态
                    State.IDLE -> {
                        //LogUtils.e("alpha = $alpha ------max = $max","----alpha--->")
                    }
                }
            }

            override fun onStateChangedAny(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                super.onStateChangedAny(appBarLayout, verticalOffset)
                maxVerticalOffset = appBarLayout?.totalScrollRange?.toFloat()!!
                val a = -(verticalOffset / maxVerticalOffset)//渐变从0 - 1
                //LogUtils.e("verticalOffset = $verticalOffset ---- a = $a ---------max = $maxVerticalOffset")
                if (-verticalOffset <= maxVerticalOffset / 2) {
                    title = "膜拜单车"
                    alpha = (1 + verticalOffset / (maxVerticalOffset / 2))
                } else {
                    title = "个人中心"
                    alpha = -(1 + verticalOffset / (maxVerticalOffset / 2))
                }
                LogUtils.e("$verticalOffset-----${appBarLayout.totalScrollRange / 2 + verticalOffset}")
                //减小判断的范围,在这个范围内调用 settext 方法会一直触发onOffsetChanged,减小范围来减少触发
                if (appBarLayout.totalScrollRange / 2 + verticalOffset in -20..20) {
                    setToolbarTitle()
                }
                tv_mt_title.alpha = alpha
            }
        })

    }

    override fun onResume() {
        super.onResume()
        //appbar_mt_appbar.addOnOffsetChangedListener(this)
    }

    override fun onPause() {
        super.onPause()
        //appbar_mt_appbar.removeOnOffsetChangedListener(this)
    }

    var alpha = 0f//渐变从1 - 0,到达折叠布局中间,再从 0 - 1
    var maxVerticalOffset = 0f//折叠布局最大高度
    var title = ""


//    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
//        if (appBarLayout != null) {
//            //确保折叠和展开状态时,标题一定是对的
//            if (abs(verticalOffset) in -appBarLayout.totalScrollRange + 1 .. -appBarLayout.totalScrollRange + 5){//折叠状态
//                tv_mt_title.text = "个人中心"
//            }else if (verticalOffset in -1 downTo -5){//展开状态
//                tv_mt_title.text = "膜拜单车"
//            }
//        }
//        maxVerticalOffset = appBarLayout?.totalScrollRange?.toFloat()!!
//        val a = -(verticalOffset / maxVerticalOffset)//渐变从0 - 1
//        //LogUtils.e("verticalOffset = $verticalOffset ---- a = $a ---------max = $maxVerticalOffset")
//        if (-verticalOffset <= maxVerticalOffset / 2) {
//            title = "膜拜单车"
//            alpha = (1 + verticalOffset / (maxVerticalOffset / 2))
//        } else {
//            title = "个人中心"
//            alpha = -(1 + verticalOffset / (maxVerticalOffset / 2))
//        }
//        //Toast.makeText(this, "$verticalOffset", Toast.LENGTH_SHORT).show()
////        tv_mt_title.text = title
//        LogUtils.e("$verticalOffset-----${appBarLayout.totalScrollRange / 2 +  verticalOffset}")
//        //减小判断的范围,在这个范围内调用 settext 方法会一直触发onOffsetChanged,减小范围来减少触发
//        if (appBarLayout.totalScrollRange / 2 +  verticalOffset in -20..20){
//            setToolbarTitle()
//        }
//        tv_mt_title.alpha = alpha
//    }

    private fun setToolbarTitle() {
        LogUtils.e("settoolbar---$title")
        tv_mt_title.text = title

    }
}