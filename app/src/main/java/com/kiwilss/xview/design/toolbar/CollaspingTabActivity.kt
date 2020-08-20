/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: CollaspingTabActivity
 * Author:   Administrator
 * Date:     2020/8/19 18:03
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.design.toolbar

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.gyf.immersionbar.ktx.immersionBar
import com.kiwilss.xview.R
import com.kiwilss.xview.design.toolbar.vp.TabAdapter
import com.kiwilss.xview.design.toolbar.vp.TabFragment
import com.kiwilss.xview.utils.StatusBarUtils
import kotlinx.android.synthetic.main.activity_collasping_tab.*
import kotlinx.android.synthetic.main.activity_tabvp.*

/**
 *@FileName: CollaspingTabActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/19
 * @desc   : {DESCRIPTION}
 */
class CollaspingTabActivity: AppCompatActivity() {
    val tabs = arrayOf("关注", "推荐", "最新")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collasping_tab)

        //设置透明状态栏,设置状态栏颜色无效
        //StatusBarUtils.initStatusBarStyle(this,true,R.color.blue_74D3FF)
        //StatusBarUtils.initStatusBarStyleColor(this,true, Color.parseColor("#74D3FF"))
        immersionBar {
            transparentStatusBar()
            //statusBarColor(R.color.blue_74D3FF)
            //fitsSystemWindows(true)
        }

        tb_collasping_tab_tb.setNavigationOnClickListener { finish() }

        val fragments = arrayListOf<Fragment>()
        for ( i in 0..2) {
            val instance = TabFragment.instance(i)
            fragments.add(instance)
        }
        //fragments.add(TabFragment.instance(0))
        val adapter = TabAdapter(this,fragments)
        vp_collasping_tab_vp.adapter = adapter

        //将TabLayout和ViewPager2关联起来
        val metiaor: TabLayoutMediator = TabLayoutMediator(tl_collasping_tab_tab,vp_collasping_tab_vp,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = tabs[position]
            })
        metiaor.attach()

        //设置标题相关
        ctl_collasping_tab_collapsing.run {
            setExpandedTitleColor(ContextCompat.getColor(this@CollaspingTabActivity,R.color.transparent))
            setCollapsedTitleTextColor(ContextCompat.getColor(this@CollaspingTabActivity,R.color.white))
        }
    }
}