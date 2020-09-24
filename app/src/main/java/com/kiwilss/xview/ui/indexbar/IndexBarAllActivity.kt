package com.kiwilss.xview.ui.indexbar

import android.content.Intent
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_indexbar_all.*

/**
 *@FileName: IndexBarAllActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/24
 * @desc   : {DESCRIPTION}
 */
class IndexBarAllActivity : BaseActivity(R.layout.activity_indexbar_all) {
    override fun initData() {

    }

    override fun initEvent() {
        btn_indexbar_sideindexbar.setOnClickListener {
            startActivity(Intent(this,IndexBarActivity::class.java))
        }


    }

    override fun initInterface() {
    }
}