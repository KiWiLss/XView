/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: RecyclerItemFixedActivity
 * Author:   kiwilss
 * Date:     2020/7/31 22:43
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.recyclerview.fixed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.view.recyclerview.adapter.RecyclerItemFixedAdapter
import kotlinx.android.synthetic.main.activity_recycler_item_fixed.*

/**
 *@FileName: RecyclerItemFixedActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/7/31
 * @desc   : {item高度固定,设置显示的item个数}
 */
class RecyclerItemFixedActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_item_fixed)

        val list = arrayListOf<String>("测试数据一","测试数据二","测试数据三","测试数据四")
        val adapter by lazy { RecyclerItemFixedAdapter() }
        rv_recycler_fixed_one?.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = adapter
            it.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
        }
        adapter.setList(list)
    }
}