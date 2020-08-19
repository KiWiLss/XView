/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: TabAdapter
 * Author:   Administrator
 * Date:     2020/8/19 17:01
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.design.toolbar.vp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 *@FileName: TabAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/19
 * @desc   : {DESCRIPTION}
 */
class TabAdapter(fragmentActivity: FragmentActivity,
                 private val fragments: List<Fragment>): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}