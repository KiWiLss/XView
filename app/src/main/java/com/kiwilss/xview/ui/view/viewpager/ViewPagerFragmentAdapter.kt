/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: ViewPagerFragmentAdapter
 * Author:   Administrator
 * Date:     2020/8/4 17:49
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 *@FileName: ViewPagerFragmentAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/4
 * @desc   : {DESCRIPTION}
 */
class ViewPagerFragmentAdapter(fragmentActivity: FragmentActivity,
                               private val fragments: List<Fragment>):
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}