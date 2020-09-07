package com.kiwilss.xview.ui.view.scrollview.scroll

import android.graphics.Color
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_scroll_title.*


/**
 *@FileName: ScrollTitleActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/7
 * @desc   : {DESCRIPTION}
 */
class ScrollTitleActivity: BaseActivity(R.layout.activity_scroll_title) {
    override fun initData() {

    }

    override fun initEvent() {
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun initInterface() {
        //监听滚动
        sv_scroll_title_outer.setOnScrollChangeListener { p0, p1, p2, p3, p4 ->

            if (p2 <= 0){
                rl_scroll_title_title.visibility = View.GONE
                rl_scroll_title_title.setBackgroundColor(
                    Color.argb(
                        0,
                        227,
                        29,
                        26
                    )
                )
            }else if (p2 > 0 && p2 < rl_scroll_title_title.height){
                //1.监听滚动,直接设置控件的透明度来实现标题渐变
//                rl_scroll_title_title.visibility = View.VISIBLE
//                //val scale = p2.toFloat() * 2 / tv_scroll_title_one.height
//                LogUtils.e("scrollx=$p1,scrolly=$p2----height=${tv_scroll_title_one.height}")
//                //LogUtils.e(scale)
//                //rl_scroll_title_title.alpha = scale
                //2.监听滚动,不依赖任意控件,直接根据滚动高度实现标题渐变
//                rl_scroll_title_title.visibility = View.VISIBLE
//                //val scale = p2.toFloat() * 2 / tv_scroll_title_one.height
//                LogUtils.e("scrollx=$p1,scrolly=$p2----height=${tv_scroll_title_one.height}")
//                //LogUtils.e(scale)
//                //rl_scroll_title_title.alpha = scale
//                if (p2 >= 255){
//                    rl_scroll_title_title.background.alpha = 255
//                }else{
//                    rl_scroll_title_title.background.alpha = p2
//                }
                //3,根据某个控件设置滚动到某个控件时,完全不透明
                rl_scroll_title_title.visibility = View.VISIBLE
                val scale = p2.toFloat() / (rl_scroll_title_title.height)
                LogUtils.e("p2=$p2,height=,scale=$scale")
                rl_scroll_title_title.setBackgroundColor(Color.argb((255 * scale).toInt(), 255, 255, 255))
            }else{
                rl_scroll_title_title.visibility = View.VISIBLE
                rl_scroll_title_title.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
            }
        }


    }

    override fun initIsToolbar(): Boolean {
        return false
    }

    override fun onReload() {
    }
}