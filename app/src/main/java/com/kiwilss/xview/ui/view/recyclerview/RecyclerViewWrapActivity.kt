/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: RecyclerViewWrapActivity
 * Author:   Administrator
 * Date:     2020/8/1 13:38
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.view.recyclerview.adapter.RecyclerItemFixedAdapter
import com.kiwilss.xview.ui.view.recyclerview.adapter.RecyclerItemWrapAdapter
import kotlinx.android.synthetic.main.activity_recycler_item_fixed.*
import kotlinx.android.synthetic.main.activity_recyclerview_wrap.*

/**
 *@FileName: RecyclerViewWrapActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/1
 * @desc   : {DESCRIPTION}
 */
class RecyclerViewWrapActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview_wrap)

        val list = arrayListOf("测试数据一","测试数据二","测试数据三","测试数据四")
        val adapter by lazy { RecyclerItemWrapAdapter() }
        rv_recycler_wrap_list?.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = adapter
            it.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        }
        adapter.setList(list)

    }
}