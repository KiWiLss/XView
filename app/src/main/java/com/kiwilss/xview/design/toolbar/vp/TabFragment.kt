/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: TabFragment
 * Author:   Administrator
 * Date:     2020/8/19 17:08
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.design.toolbar.vp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.view.viewpager.ViewPagerFragment
import com.kiwilss.xview.utils.LogUtils

/**
 *@FileName: TabFragment
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/19
 * @desc   : {DESCRIPTION}
 */
class TabFragment : Fragment() {

    companion object{
        fun instance(type: Int): TabFragment {
            val bundle = Bundle()
            bundle.putInt("type",type)
            val viewPagerFragment = TabFragment()
            viewPagerFragment.arguments = bundle
            return viewPagerFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fg_tabvp,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val type = arguments?.getInt("type")
        LogUtils.e("--------$type")
    }
}