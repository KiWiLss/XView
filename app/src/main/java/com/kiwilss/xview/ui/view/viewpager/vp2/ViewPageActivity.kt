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

package com.kiwilss.xview.ui.view.viewpager.vp2

import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kiwilss.xview.R
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_viewpager.*
import kotlinx.android.synthetic.main.nav_header_main.*

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

        vp_viewpager_icon.isUserInputEnabled = false
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
            val instance =
                ViewPagerFragment.instance(
                    i
                )
            fragments.add(instance)
        }
        val adapter =
            ViewPagerFragmentAdapter(
                this,
                fragments
            )
        vp_viewpager_fg.adapter = adapter
        vp_viewpager_fg.offscreenPageLimit = 3

        //tablyout + viewpager test
        initTab1()
        initTab2()


    }

    private val  activeColor = R.color.blue_74D3FF
    private val  normalColor = R.color.black_666666
    private val activeSize = 20f
     var  normalSize : Float = 18f
    private fun initTab2() {
        normalSize = resources.getDimensionPixelSize(R.dimen.m12).toFloat()
        val tabs = arrayOf("关注", "推荐", "最新","关注", "推荐", "最新")
        //禁用预加载
        vp_viewpager_tb2.offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
        val fragments = arrayListOf<Fragment>()
        for ( i in 0..5) {
            val instance =
                ViewPagerFragment.instance(
                    i
                )
            fragments.add(instance)
        }
        val adapter =
            ViewPagerFragmentAdapter(
                this,
                fragments
            )
        vp_viewpager_tb2.adapter = adapter
        //将TabLayout和ViewPager2关联起来
        val metiaor: TabLayoutMediator = TabLayoutMediator(tl_vp_tab2,vp_viewpager_tb2,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = tabs[position]
                //这里可以自定义view,最后调用tab.setCustomView()将自定义布局设置上去
            })
        metiaor.attach()
        //自定义tablayout相关
        val mediator = TabLayoutMediator(tl_vp_tab3,vp_viewpager_tb2,
        TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            val textView = TextView(this)
            textView.run {
                text = tabs[position]
                setTextSize(TypedValue.COMPLEX_UNIT_PX,normalSize)
                typeface = Typeface.DEFAULT
                setTextColor(ContextCompat.getColor(this@ViewPageActivity,normalColor))
            }
            tab.customView = textView
        })
        mediator.attach()
        //滚动监听,切换标题
        tl_vp_tab3.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
               val view = tab?.customView as TextView?
                view?.run {
                   setTextColor(ContextCompat.getColor(this@ViewPageActivity,normalColor))
                    setTextSize(TypedValue.COMPLEX_UNIT_PX,normalSize)
                    typeface =  Typeface.defaultFromStyle(Typeface.NORMAL)
                }

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val view = tab?.customView as TextView?
                view?.run {
                   setTextColor(ContextCompat.getColor(this@ViewPageActivity,activeColor))
                    setTextSize(TypedValue.COMPLEX_UNIT_PX,activeSize)
                   typeface =  Typeface.defaultFromStyle(Typeface.BOLD)
                }

            }

        })
    }

    private fun initTab1() {
        val tabs = arrayOf("关注", "推荐", "最新")
        //禁用预加载
        vp_viewpager_tb.offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
        val fragments = arrayListOf<Fragment>()
        //for (i in 0 until 3)
        for ( i in 0..2) {
            val instance =
                ViewPagerFragment.instance(
                    i
                )
            fragments.add(instance)
        }
        val adapter =
            ViewPagerFragmentAdapter(
                this,
                fragments
            )
        vp_viewpager_tb.adapter = adapter
        //将TabLayout和ViewPager2关联起来
        val metiaor: TabLayoutMediator = TabLayoutMediator(tl_vp_tab1,vp_viewpager_tb,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = tabs[position]
            })
       metiaor.attach()
    }
}