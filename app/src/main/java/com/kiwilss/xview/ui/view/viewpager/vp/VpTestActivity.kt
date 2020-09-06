package com.kiwilss.xview.ui.view.viewpager.vp

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Message
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.os.postDelayed
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.view.viewpager.transformer.DepthPageTransformer
import com.kiwilss.xview.utils.LogUtils

import kotlinx.android.synthetic.main.activity_vp_test.*

import java.util.logging.LogRecord

/**
 *@FileName: VpTestActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/4
 * @desc   : {无限轮播,Int.Max_value}
 */
class VpTestActivity : BaseActivity(R.layout.activity_vp_test), Runnable {

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
        if (currentItem == vp_vp_test_vp.childCount - 1){//滑到最后一个
            currentItem = 0
            vp_vp_test_vp.setCurrentItem(currentItem,false)
            mHandler.postDelayed(this,mDelayTime)
        }else{
            vp_vp_test_vp.setCurrentItem(currentItem,true)
            mHandler.postDelayed(this,mDelayTime)
        }
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

    @SuppressLint("ClickableViewAccessibility")
    override fun initInterface() {

        val dataList = arrayListOf<Fragment>()
        for (i in 0..3){
            dataList.add(VpTestFg.newInstance(i))
        }
        val adapter = VpTestAdapter(supportFragmentManager,dataList)
        vp_vp_test_vp.adapter = adapter

        //初始位置设置到比较大的位置
        vp_vp_test_vp.currentItem = dataList.size * 1000


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

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                //切换指示器
                changeIndicator(position)
            }

        })

        //设置切换动画
        vp_vp_test_vp.setPageTransformer(true, DepthPageTransformer())

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
        ll_vp_test_indicator.getChildAt(position%size)?.setBackgroundResource(R.drawable.circle_red)

    }

    override fun onReload() {
    }


}