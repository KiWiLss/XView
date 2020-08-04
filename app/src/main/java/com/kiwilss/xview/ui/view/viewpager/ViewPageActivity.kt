/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: ViewPageActivity
 * Author:   Administrator
 * Date:     2020/8/4 17:11
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.kiwilss.xview.R
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_viewpager.*

/**
 *@FileName: ViewPageActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/4
 * @desc   : {DESCRIPTION}
 */
class ViewPageActivity: AppCompatActivity() {

    private var colors = arrayOf("#CCFF99","#41F1E5","#8D41F1","#FF99CC")

    val mAdapter by lazy { ViewPagerAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)

        val dataList = colors.toList()
        vp_viewpager_icon.adapter = mAdapter
        mAdapter.setList(dataList)

        btn_vp_horizontal.setOnClickListener {
            vp_viewpager_icon.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
        btn_vp_vertical.setOnClickListener {
            vp_viewpager_icon.orientation = ViewPager2.ORIENTATION_VERTICAL
        }
        vp_viewpager_icon.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                LogUtils.e(position,"---position---")
            }
        })
        //设置边距
        vp_viewpager_icon.setPageTransformer(MarginPageTransformer(resources.getDimension(R.dimen.dp_10).toInt()))

        //fragment切换相关
        val fragments = arrayListOf<Fragment>()
        //for (i in 0 until 3)
        for ( i in 0..2) {
            LogUtils.e(i)
            val instance = ViewPagerFragment.instance(i)
            fragments.add(instance)
        }
        val adapter = ViewPagerFragmentAdapter(this,fragments)
        vp_viewpager_fg.adapter = adapter
        vp_viewpager_fg.offscreenPageLimit = 3

        //tablyout + viewpager


    }
}