package com.kiwilss.xview.design.behavioractivity

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.design.appbar.AppBarStateChangeListener
import com.kiwilss.xview.ui.view.viewpager.vp2.ViewPagerFragment
import com.kiwilss.xview.ui.view.viewpager.vp2.ViewPagerFragmentAdapter
import kotlinx.android.synthetic.main.activity_collasping_center.*
import kotlinx.android.synthetic.main.activity_header_zoom.*
import kotlinx.android.synthetic.main.activity_viewpager.*

/**
 *@FileName: HeaderZoomActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/25
 * @desc   : {DESCRIPTION}
 */
class HeaderZoomActivity : BaseActivity(R.layout.activity_header_zoom) {
    override fun initData() {

    }

    override fun initIsToolbar(): Boolean {
        return false
    }

    override fun initEvent() {
        appbar_header_zoom_appbar.addOnOffsetChangedListener(object : AppBarStateChangeListener(){
            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?, i: Int) {
                when (state) {
                    State.EXPANDED -> {//展开
                      civ_header_zoom_icon.visibility = View.VISIBLE
                    }
                    State.COLLAPSED -> {//关闭
                        civ_header_zoom_icon.visibility = View.GONE
                    }
                    else -> {//中间
                        civ_header_zoom_icon.visibility = View.VISIBLE
                    }
                }
            }

        })
    }

    override fun initInterface() {

        val tabs = arrayOf("关注", "推荐", "最新","关注", "推荐", "最新")
        //禁用预加载
        vp_header_zoom_vp.offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT

        val fragments = arrayListOf<Fragment>()
        for ( i in 0..5) {
            val instance =
                HeaderZoomFg.instance(
                    i
                )
            fragments.add(instance)
        }
        val adapter =
            ViewPagerFragmentAdapter(
                this,
                fragments
            )
        vp_header_zoom_vp.adapter = adapter
        //将TabLayout和ViewPager2关联起来
        val metiaor: TabLayoutMediator = TabLayoutMediator(tl_header_zoom_tab,vp_header_zoom_vp,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = tabs[position]
                //这里可以自定义view,最后调用tab.setCustomView()将自定义布局设置上去
            })
        metiaor.attach()

    }
}