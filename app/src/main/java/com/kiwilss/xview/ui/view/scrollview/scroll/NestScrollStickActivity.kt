package com.kiwilss.xview.ui.view.scrollview.scroll

import androidx.core.widget.NestedScrollView
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_nestscroll_stick.*

/**
 *@FileName: NestScrollStickActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/8
 * @desc   : {DESCRIPTION}
 */
class NestScrollStickActivity : BaseActivity(R.layout.activity_nestscroll_stick) {

    override fun initData() {
    }

    override fun initEvent() {
    }

    override fun initInterface() {

        //滚动监听,可以直接调用
        nsv_scroll_stick_outer.setOnScrollChangeListener { v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            LogUtils.e("x = $scrollX --- y = $scrollY")

        }

    }


    override fun initIsToolbar(): Boolean {
        return false
    }

}