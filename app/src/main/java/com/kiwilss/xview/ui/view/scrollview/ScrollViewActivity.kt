package com.kiwilss.xview.ui.view.scrollview

import android.content.Intent
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.view.scrollview.scroll.NestScrollStickActivity
import com.kiwilss.xview.ui.view.scrollview.scroll.ScrollStickActivity
import com.kiwilss.xview.ui.view.scrollview.scroll.ScrollStickActivity2
import com.kiwilss.xview.ui.view.scrollview.scroll.ScrollTitleActivity
import kotlinx.android.synthetic.main.activity_scrollview.*

/**
 *@FileName: ScrollViewActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/7
 * @desc   : {DESCRIPTION}
 */
class ScrollViewActivity : BaseActivity(R.layout.activity_scrollview) {
    override fun initData() {

    }

    override fun initEvent() {
        btn_scrollview_top.setOnClickListener {
            startActivity(Intent(this,ScrollTitleActivity::class.java))
        }
        btn_scrollview_stick.setOnClickListener {
            startActivity(Intent(this,ScrollStickActivity::class.java))
        }
        btn_scrollview_stick2.setOnClickListener {
            startActivity(Intent(this, ScrollStickActivity2::class.java))
        }
        btn_scrollview_stick3.setOnClickListener {
            startActivity(Intent(this, NestScrollStickActivity::class.java))
        }
    }

    override fun initInterface() {


    }

    override fun onReload() {
    }
}