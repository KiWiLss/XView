package com.kiwilss.xview.ui.view.viewpager.vp

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 *@FileName: VpTestAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/4
 * @desc   : {DESCRIPTION}
 */
class VpTestAdapter2(fragmentManager: FragmentManager, val data: ArrayList<Fragment>) :
    FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = data[position]

    override fun getCount(): Int = data.size

}