package com.kiwilss.xview.design.toolbar

import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.design.toolbar.vp.TabAdapter
import com.kiwilss.xview.design.toolbar.vp.TabFragment
import kotlinx.android.synthetic.main.activity_search_tab.*
import kotlinx.android.synthetic.main.activity_tabvp.*

/**
 *@FileName: SearchTabActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/10/26
 * @desc   : {DESCRIPTION}
 */
class SearchTabActivity: BaseActivity(R.layout.activity_search_tab) {

    val tabs = arrayOf("关注", "推荐", "最新")

    override fun initIsToolbar(): Boolean {
        return false
    }
    override fun initData() {

    }

    override fun initEvent() {
    }

    override fun initInterface() {


        val fragments = arrayListOf<Fragment>()
        for ( i in 0..2) {
            val instance = TabFragment.instance(i)
            fragments.add(instance)
        }
        //fragments.add(TabFragment.instance(0))
        val adapter = TabAdapter(this,fragments)
        vp_search_tab_vp.adapter = adapter

        //将TabLayout和ViewPager2关联起来
        val metiaor: TabLayoutMediator = TabLayoutMediator(tl_search_tab_tab,vp_search_tab_vp,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = tabs[position]
            })
        metiaor.attach()

    }
}