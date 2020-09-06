package com.kiwilss.xview.ui.view.viewpager.vp

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Message
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_vp_test.*
import kotlinx.android.synthetic.main.nav_header_main.*

/**
 *@FileName: VpTestTwoActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/4
 * @desc   : {DESCRIPTION}
 */
class VpTestTwoActivity: BaseActivity(R.layout.activity_vp_test) ,Runnable{

    private val mDelayTime: Long = 3000

    private val mHandler = @SuppressLint("HandlerLeak")
    object : Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
        }
    }

    override fun run() {
        var currentItem = vp_vp_test_vp.currentItem
        currentItem ++
       vp_vp_test_vp.currentItem = currentItem
        mHandler.postDelayed(this,mDelayTime)
    }

    override fun onResume() {
        super.onResume()
        mHandler.postDelayed(this,mDelayTime)
    }

    override fun onPause() {
        super.onPause()
        mHandler.removeCallbacks(this)
    }





    override fun initData() {

    }

    override fun initEvent() {
    }

    lateinit var dataList: ArrayList<Fragment>
    var mCurrent2 = 1
    @SuppressLint("ClickableViewAccessibility")
    override fun initInterface() {

         dataList = arrayListOf<Fragment>()
        //第一个位置加上最后一个 fragment,最后一个位置加上第一个 fragment
        dataList.add(VpTestFg.newInstance(3))
        for (i in 0..3){
            dataList.add(VpTestFg.newInstance(i))
        }
        dataList.add(VpTestFg.newInstance(0))


        val adapter = VpTestAdapter2(supportFragmentManager,dataList)
        vp_vp_test_vp.adapter = adapter

        vp_vp_test_vp.currentItem = mCurrent2

        //设置圆点指示器
        ll_vp_test_indicator.removeAllViews()
        val dimen = resources.getDimensionPixelOffset(R.dimen.m10)
        for (i in 0..3){
            val image = ImageView(this)
            image.setBackgroundResource(R.drawable.circle_white)
            ll_vp_test_indicator.addView(image)
            //设置间隔
            val layoutParams: LinearLayout.LayoutParams = image.layoutParams as LinearLayout.LayoutParams
            layoutParams.setMargins(dimen,0,dimen,0)
            image.layoutParams = layoutParams
        }

        //设置第一个指示器是红色
        ll_vp_test_indicator.getChildAt(0)?.setBackgroundResource(R.drawable.circle_red)

        vp_vp_test_vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
                //判断是否滑动结束
                if (state == ViewPager.SCROLL_STATE_IDLE){
                    if (mCurrent2 == 0){
                        vp_vp_test_vp.setCurrentItem(dataList.size - 2, false);//切換，不要動畫效果
                    }else if (mCurrent2 == dataList.size - 1){
                        vp_vp_test_vp.setCurrentItem(1, false);//切換，不要動畫效果
                    }
                }
            }

            @SuppressLint("MissingSuperCall")
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                //这里可以自定义指示器切换动画效果

            }

            override fun onPageSelected(position: Int) {
                mCurrent2 = position
                //切换指示器
                changeIndicator(position)
            }

        })

        //监听,手动滑动时取消轮播
        vp_vp_test_vp.setOnTouchListener { v, event ->
            when(event.action){
                MotionEvent.ACTION_DOWN -> {
                    LogUtils.e("action-down")
                    mHandler.removeCallbacks(this)
                }
                MotionEvent.ACTION_UP -> {
                    LogUtils.e("action-up")
                    mHandler.postDelayed(this,mDelayTime)
                }
                MotionEvent.ACTION_MOVE -> {
                    //LogUtils.e("action-move")
                    //mHandler.removeCallbacks(this)
                }
            }
            false
        }
    }

    private fun changeIndicator(position: Int) {
        val size = ll_vp_test_indicator.childCount
        for (i in 0..size){
            ll_vp_test_indicator.getChildAt(i)?.setBackgroundResource(R.drawable.circle_white)
        }
        when (position) {
            0 -> {
                ll_vp_test_indicator.getChildAt(size - 1)?.setBackgroundResource(R.drawable.circle_red)
            }
            dataList.size - 1 -> {
                ll_vp_test_indicator.getChildAt(0)?.setBackgroundResource(R.drawable.circle_red)
            }
            else -> {
                ll_vp_test_indicator.getChildAt(position - 1)?.setBackgroundResource(R.drawable.circle_red)
            }
        }
    }

    override fun onReload() {
    }
}