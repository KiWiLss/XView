package com.kiwilss.xview.design.behavioractivity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import com.kiwilss.xview.R
import com.kiwilss.xview.design.appbar.AppBarStateChangeListener
import com.kiwilss.xview.utils.StatusBarUtils
import kotlinx.android.synthetic.main.activity_header_scroll.*

/**
 *@FileName: HeaderScrollActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/23
 * @desc   : {DESCRIPTION}
 */
class HeaderScrollActivity: AppCompatActivity(R.layout.activity_header_scroll) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        StatusBarUtils.initStatusBarStyle(this,false)
        appbar_header_scroll_appbar.addOnOffsetChangedListener(object : AppBarStateChangeListener(){
            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?, verticalOffset: Int) {

            }

            override fun onStateChangedAny(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                super.onStateChangedAny(appBarLayout, verticalOffset)
                val total = appBarLayout!!.totalScrollRange * 1.0f
                //计算出滑动百分比
                //计算出滑动百分比
                val p: Float = Math.abs(verticalOffset) / total//折叠时是 1,展开时是 0
                if (p > 0.5) {
                    tv_header_scroll_title.alpha = 1.0f / 0.5f * (p - 0.5f)
                    tv_header_scroll_nick.alpha = 0f
                } else {
                    tv_header_scroll_title.alpha = 0f
                    tv_header_scroll_nick.alpha = 1.0f - 1.0f / 0.5f * p
                }
                ibtn_header_scroll_titleico.visibility = if (p == 1f) View.VISIBLE else View.INVISIBLE

            }
        })

    }
}