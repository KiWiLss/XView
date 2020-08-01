/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: RecyclerViewActivity
 * Author:   Administrator
 * Date:     2020/7/17 21:48
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.xview.ui.view.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.activity_recyclerview.*

/**
 *@FileName: RecyclerViewActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/7/17
 * @desc   : {DESCRIPTION}
 */
class RecyclerViewActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        btn_recycler_itemFixed.setOnClickListener {
            startActivity(Intent(this,RecyclerItemFixedActivity::class.java))
        }

        btn_recycler_itemWrap1.setOnClickListener {
            startActivity(Intent(this,RecyclerWrapActivity::class.java))
        }
        btn_recycler_itemWrap.setOnClickListener {
            startActivity(Intent(this,RecyclerViewWrapActivity::class.java))
        }

        btn_recycler_decoration.setOnClickListener {
            startActivity(Intent(this,RecyclerDecorationLinearActivity::class.java))
        }

        btn_recycler_interval.setOnClickListener {
            startActivity(Intent(this,RecyclerIntervalActivity::class.java))
        }
    }
}