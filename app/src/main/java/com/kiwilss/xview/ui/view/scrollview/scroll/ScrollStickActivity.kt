package com.kiwilss.xview.ui.view.scrollview.scroll

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_scroll_stick.*

/**
 *@FileName: ScrollStickActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/7
 * @desc   : {原理,两个view,控制view的显示和隐藏}
 */
class ScrollStickActivity : BaseActivity(R.layout.activity_scroll_stick) {
    override fun initData() {

    }

    override fun initEvent() {
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun initInterface() {
        //监听滚动
        sv_scroll_stick_scroll.setOnScrollChangeListener { view, i, i2, i3, i4 ->
            if (i2 > tv_scroll_stick_one.height){
                tv_scroll_stick_stick2.visibility = View.VISIBLE
            }else{
                tv_scroll_stick_stick2.visibility = View.GONE
            }

        }

    }

    override fun onReload() {
    }
}