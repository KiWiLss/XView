/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: ViewPagerFragment
 * Author:   Administrator
 * Date:     2020/8/4 17:52
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.viewpager

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.fg_viewpager.*

/**
 *@FileName: ViewPagerFragment
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/4
 * @desc   : {DESCRIPTION}
 */
class ViewPagerFragment: Fragment() {

    companion object{
        fun instance(type: Int): ViewPagerFragment{
            val bundle = Bundle()
            bundle.putInt("type",type)
            val viewPagerFragment = ViewPagerFragment()
            viewPagerFragment.arguments = bundle
            return viewPagerFragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fg_viewpager, null)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val type = arguments?.getInt("type")
        tv_fg_vp_text.text = "第${type}个fragment"


    }
}