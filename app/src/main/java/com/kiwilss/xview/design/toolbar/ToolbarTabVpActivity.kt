/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: ToolbarTabVpActivity
 * Author:   Administrator
 * Date:     2020/8/19 10:06
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.design.toolbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kiwilss.xview.R
import com.kiwilss.xview.design.toolbar.vp.TabAdapter
import com.kiwilss.xview.design.toolbar.vp.TabFragment
import com.kiwilss.xview.ui.view.viewpager.ViewPagerFragment
import com.kiwilss.xview.ui.view.viewpager.ViewPagerFragmentAdapter
import kotlinx.android.synthetic.main.activity_tabvp.*
import kotlinx.android.synthetic.main.activity_viewpager.*

/**
 *@FileName: ToolbarTabVpActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/19
 * @desc   : {DESCRIPTION}
 */
class ToolbarTabVpActivity: AppCompatActivity() {
    val tabs = arrayOf("关注", "推荐", "最新")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabvp)

        tb_tabvp_tb.setNavigationOnClickListener {
            finish()
        }

        val fragments = arrayListOf<Fragment>()
        for ( i in 0..2) {
            val instance = TabFragment.instance(i)
            fragments.add(instance)
        }
        //fragments.add(TabFragment.instance(0))
        val adapter = TabAdapter(this,fragments)
        vp_tabvp_vp.adapter = adapter

        //将TabLayout和ViewPager2关联起来
        val metiaor: TabLayoutMediator = TabLayoutMediator(tl_tabvp_tab,vp_tabvp_vp,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = tabs[position]
            })
        metiaor.attach()

        //tablayout change
        tl_tabvp_tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

            }

        })


    }
}