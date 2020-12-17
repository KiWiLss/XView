package com.kiwilss.xview.ui.click

import android.view.View
import android.widget.Toast
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.click.java.ClickProxy
import com.kiwilss.xview.ui.click.java.CustomClickListener
import com.kiwilss.xview.ui.click.kotlin.click
import com.kiwilss.xview.ui.click.kotlin.clickWithTrigger
import com.kiwilss.xview.ui.click.kotlin.withTrigger
import kotlinx.android.synthetic.main.activity_click_all.*

/**
 *@FileName: ClickAllActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/17
 * @desc   : {DESCRIPTION}
 */
class ClickAllActivity: BaseActivity(R.layout.activity_click_all) {
    override fun initData() {

    }

    override fun initEvent() {
        btn_click_all_one.clickWithTrigger {
            Toast.makeText(this, "hai", Toast.LENGTH_SHORT).show()
        }
        btn_click_all_two.withTrigger().click {
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()
        }

        btn_click_all_three.setOnClickListener(object : CustomClickListener(){
            override fun onSingleClick(view: View?) {
                Toast.makeText(this@ClickAllActivity, "单击", Toast.LENGTH_SHORT).show()
            }

            override fun onFastClick(view: View?) {
                super.onFastClick(view)
                Toast.makeText(this@ClickAllActivity, "快速点击", Toast.LENGTH_SHORT).show()
            }

        })

        btn_click_all_four.setOnClickListener(ClickProxy(View.OnClickListener {
            Toast.makeText(this@ClickAllActivity, "单击", Toast.LENGTH_SHORT).show()
        }, ClickProxy.IAgain {
            Toast.makeText(this@ClickAllActivity, "再次点击", Toast.LENGTH_SHORT).show()
        }))



    }

    override fun initInterface() {

    }
}