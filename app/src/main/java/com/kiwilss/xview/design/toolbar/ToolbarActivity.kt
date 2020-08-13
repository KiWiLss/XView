/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: ToolbarActivity
 * Author:   Administrator
 * Date:     2020/8/12 14:56
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.design.toolbar

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.activity_toolbar.*

/**
 *@FileName: ToolbarActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/12
 * @desc   : {DESCRIPTION}
 */
class ToolbarActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)

        tb_toolbar_tb.title = "主标题"//设置标题
        tb_toolbar_tb.setNavigationOnClickListener {
            finish()
        }
        //tb_toolbar_tb.setMenu()//设置菜单
        tb_toolbar_tb.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener,
            androidx.appcompat.widget.Toolbar.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem?): Boolean {

                if (item?.itemId == R.id.action_add){
                    Toast.makeText(this@ToolbarActivity, "add", Toast.LENGTH_SHORT).show()
                    return true
                }else{
                    Toast.makeText(this@ToolbarActivity, "hello", Toast.LENGTH_SHORT).show()
                }
                return false
            }
        })

    }
}