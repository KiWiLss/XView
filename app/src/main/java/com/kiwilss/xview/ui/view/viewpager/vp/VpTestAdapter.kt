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
class VpTestAdapter(fragmentManager: FragmentManager, val data: ArrayList<Fragment>) :
    FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = data[position]

    override fun getCount(): Int = Int.MAX_VALUE


    override fun instantiateItem(container: ViewGroup,  position: Int): Any {
        //处理position。让数组下标落在[0,fragmentList.size)中，防止越界
        var position = position
        position %= data.size
        return super.instantiateItem(container, position)
    }
}