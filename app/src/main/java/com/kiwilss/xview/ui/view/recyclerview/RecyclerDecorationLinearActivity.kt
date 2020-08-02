/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: RecyclerDecorationLinearActivity
 * Author:   Administrator
 * Date:     2020/8/1 15:05
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.xview.ui.view.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.view.recyclerview.adapter.RecyclerLinearLayoutAdapter
import com.kiwilss.xview.ui.view.recyclerview.adapter.RecyclerWrapAdapter
import com.kiwilss.xview.ui.view.recyclerview.decoration.IntervalDecoration
import com.kiwilss.xview.ui.view.recyclerview.decoration.ItemDivider
import kotlinx.android.synthetic.main.activity_recyclerview_wrap.*

/**
 *@FileName: RecyclerDecorationLinearActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/1
 * @desc   : {分割线测试}
 */
class RecyclerDecorationLinearActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview_wrap)

        val list = arrayListOf("测试数据一","测试数据二","测试数据三","测试数据四","测试数据五","测试数据六"
            ,"测试数据七","测试数据八","测试数据九","测试数据一","测试数据二","测试数据三","测试数据四","测试数据五","测试数据六"
            ,"测试数据七","测试数据八","测试数据九")
        val adapter by lazy { RecyclerLinearLayoutAdapter() }
        val color = ContextCompat.getColor(this, R.color.red)
        rv_recycler_wrap_list?.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = adapter
            //设置自定义分割线
            it.addItemDecoration(ItemDivider(color = color))
            //设置系统默认的分割线
            //it.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        }
        adapter.setList(list)

    }
}