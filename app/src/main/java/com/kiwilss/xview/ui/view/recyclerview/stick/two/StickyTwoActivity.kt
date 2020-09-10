package com.kiwilss.xview.ui.view.recyclerview.stick.two

import androidx.recyclerview.widget.LinearLayoutManager
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_sticky_two.*

/**
 *@FileName: StickyTwoActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/10
 * @desc   : {DESCRIPTION}
 */
class StickyTwoActivity : BaseActivity(R.layout.activity_sticky_two) {


    val mAdapter by lazy { StickyTwoAdapter() }


    override fun initData() {

    }

    override fun initEvent() {
    }

    override fun initInterface() {
        rv_sticky_two_list?.run {
            layoutManager = LinearLayoutManager(this@StickyTwoActivity)
            adapter = mAdapter
        }




    }
}