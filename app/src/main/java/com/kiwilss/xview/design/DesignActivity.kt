/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: DesignActivity
 * Author:   Administrator
 * Date:     2020/8/12 9:27
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.xview.design

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.xview.R
import com.kiwilss.xview.design.toolbar.ToolbarActivity
import kotlinx.android.synthetic.main.activity_design.*

/**
 *@FileName: DesignActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/12
 * @desc   : {DESCRIPTION}
 */
class DesignActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_design)

        btn_design_toolbar.setOnClickListener {
            startActivity(Intent(this,ToolbarActivity::class.java))
        }



    }
}