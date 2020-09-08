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
class ScrollTitleActivity : BaseActivity(R.layout.activity_scroll_title) {
    override fun initData() {

    }
    private var hasMeasured = false
    override fun initEvent() {
        //onCreate中获取控件的高度,参考: https://blog.csdn.net/wangzhongshun/article/details/105196366
        //方法一
//        tv_scroll_title_one.post {
//            val height = tv_scroll_title_one.height
//            LogUtils.e("height=$height")//height=750
//        }
        //方法二
        tv_scroll_title_one.viewTreeObserver.addOnPreDrawListener {
            //不做处理会一直重复调用,调用一次就够了
            if (!hasMeasured){
                val height = tv_scroll_title_one.height
                LogUtils.e("height=$height")//height=750
                hasMeasured = true
            }
            true//返回true为可用状态
        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        //方法三,会重复调用,当Activity的窗口得到焦点和失去焦点时均会被调用一次，如果频繁地进行onResume和onPause，那么onWindowFocusChanged也会被频繁地调用，不太适合处理一些复杂的业务逻辑
        val height = tv_scroll_title_one.height
        LogUtils.e("height=$height")
    }



    @RequiresApi(Build.VERSION_CODES.M)
    override fun initInterface() {
        //1.监听滚动,只控制显示和隐藏,布局初始隐藏,不用设置渐变度
        //scrollListener()
        //2.监听滚动,通过设置alpha(范围0~1),实现布局渐变
        //scrollListener2()
        //3,监听滚动,通过设置背景颜色alpha(范围0~255),实现布局渐变
        //scrollListener3()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun scrollListener3() {
        //初始进入隐藏,Color.argb转换工具https://www.wanandroid.com/tools/color
        rl_scroll_title_titleWhite.visibility = View.GONE
        rl_scroll_title_title.visibility = View.VISIBLE
        sv_scroll_title_outer.setOnScrollChangeListener { view, i, i2, i3, i4 ->
            val height = rl_scroll_title_title.height
            LogUtils.e("i2 = $i2 ----------- height = $height")
            if (i2 <= 0){
                LogUtils.e("gone")
                rl_scroll_title_titleWhite.visibility = View.GONE
                rl_scroll_title_titleWhite.setBackgroundColor(Color.argb(0, 255, 255, 255))
            }else if (i2 <= height){
                rl_scroll_title_titleWhite.visibility = View.VISIBLE
                val scale = i2.toFloat() / height
                val alpha = (scale * 255).toInt()
                LogUtils.e("scale = $scale ---- alpha = $alpha")
                rl_scroll_title_titleWhite.setBackgroundColor(Color.argb(alpha, 255, 255, 255))
            }else{
                LogUtils.e("visible")
                rl_scroll_title_titleWhite.visibility = View.VISIBLE
                rl_scroll_title_titleWhite.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
            }
        }
    }

    /**
     * 监听滚动,通过设置alpha,实现布局渐变
     */
    @RequiresApi(Build.VERSION_CODES.M)
    private fun scrollListener2() {
        rl_scroll_title_titleWhite.alpha = 0f
        rl_scroll_title_titleWhite.visibility = View.VISIBLE
        //这种情况,height不会为0,不需要处理
        sv_scroll_title_outer.setOnScrollChangeListener { p0, p1, p2, p3, p4 ->
            LogUtils.e("p2=$p2")
            if (p2 <= 0) {
                rl_scroll_title_titleWhite.alpha = 0f
            } else if (p2 < rl_scroll_title_titleWhite.height) {
                //1.监听滚动,直接设置控件的透明度来实现标题渐变
                //3,根据某个控件设置滚动到某个控件时,完全不透明
                val scale = p2.toFloat() / (rl_scroll_title_titleWhite.height)
                rl_scroll_title_titleWhite.alpha = scale
            } else {
                rl_scroll_title_titleWhite.alpha = 1f
            }
        }
    }


    /**
     * 监听滚动,只控制显示和隐藏,布局初始隐藏,不用设置渐变度
     */
    @RequiresApi(Build.VERSION_CODES.M)
    private fun scrollListener() {
        //初始进入隐藏
        rl_scroll_title_titleWhite.visibility = View.GONE
        sv_scroll_title_outer.setOnScrollChangeListener { p0, p1, p2, p3, p4 ->
            //获取rl_scroll_title_title控件的高度
            val height = rl_scroll_title_titleWhite.height
            LogUtils.e("p2=$p2---height=$height")
            if (p2 <= height) {
                //1.监听滚动,直接设置控件的透明度来实现标题渐变
                rl_scroll_title_titleWhite.visibility = View.GONE
                LogUtils.e("gone")
            } else {
                //初始进入 height 为 0
                if (height == 0){
                    rl_scroll_title_titleWhite.visibility = View.INVISIBLE
                }else{
                    rl_scroll_title_titleWhite.visibility = View.VISIBLE
                }
                LogUtils.e("visible")
            }
        }
    }

    override fun initIsToolbar(): Boolean {
        return false
    }

    override fun onReload() {
    }
}