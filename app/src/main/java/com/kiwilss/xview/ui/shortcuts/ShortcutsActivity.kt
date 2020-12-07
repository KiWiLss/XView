package com.kiwilss.xview.ui.shortcuts

import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.test.NumTest
import kotlinx.android.synthetic.main.activity_shortcuts.*

/**
 *@FileName: ShortcutsActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/7
 * @desc   : {DESCRIPTION}
 */
class ShortcutsActivity: BaseActivity(R.layout.activity_shortcuts) {
    override fun initData() {

        NumTest.testStart(
            "1" to 1,
            "2" to 2
        )
    }

    override fun initEvent() {

    }

    override fun initInterface() {
        btn_shortcuts_static.setOnClickListener {

        }
    }
}