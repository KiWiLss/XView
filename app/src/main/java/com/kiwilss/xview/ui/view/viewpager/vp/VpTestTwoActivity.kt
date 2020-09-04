package com.kiwilss.xview.ui.view.viewpager.vp

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_vp_test.*

/**
 *@FileName: VpTestTwoActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/4
 * @desc   : {DESCRIPTION}
 */
class VpTestTwoActivity: BaseActivity(R.layout.activity_vp_test) {
    override fun initData() {

    }

    override fun initEvent() {
    }

    var mCurrent2 = 1
    override fun initInterface() {

        val dataList = arrayListOf<Fragment>()
        //第一个位置加上最后一个 fragment,最后一个位置加上第一个 fragment
        dataList.add(VpTestFg.newInstance(1))
        for (i in 0..1){
            dataList.add(VpTestFg.newInstance(i))
        }
        dataList.add(VpTestFg.newInstance(0))


        val adapter = VpTestAdapter2(supportFragmentManager,dataList)
        vp_vp_test_vp.adapter = adapter

        vp_vp_test_vp.currentItem = mCurrent2

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

            }

            override fun onPageSelected(position: Int) {
                mCurrent2 = position
            }

        })
    }

    override fun onReload() {
    }
}