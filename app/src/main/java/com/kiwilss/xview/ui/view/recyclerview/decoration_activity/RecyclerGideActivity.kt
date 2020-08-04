/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: RecyclerGideActivity
 * Author:   Administrator
 * Date:     2020/8/2 16:05
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.xview.ui.view.recyclerview.decoration_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.view.recyclerview.adapter.RecyclerGideAdapter

import com.kiwilss.xview.ui.view.recyclerview.decoration.GridItemDecoration
import com.kiwilss.xview.ui.view.recyclerview.decoration.ItemDivider
import kotlinx.android.synthetic.main.activity_recyclerview_grid.*

/**
 *@FileName: RecyclerGideActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/2
 * @desc   : {DESCRIPTION}
 */
class RecyclerGideActivity : AppCompatActivity(){

    val list = arrayListOf("测试数据一","测试数据二","测试数据三","测试数据四","测试数据五","测试数据六"
        ,"测试数据七","测试数据八","测试数据九","测试数据一","测试数据二","测试数据三","测试数据四","测试数据五","测试数据六"
        )

    val list2 = arrayListOf("测试数据一","测试数据二","测试数据三","测试数据四"
        ,"测试数据七","测试数据八","测试数据九","测试数据一","测试数据二","测试数据三","测试数据四","测试数据五","测试数据六")
    private val mAdapter by lazy { RecyclerGideAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview_grid)

        val color = ContextCompat.getColor(this, R.color.red)
        val divider = GridItemDecoration.Builder(this)
            .setColor(color)
            .setHorizontalSpan(R.dimen.m10)
            .setVerticalSpan(R.dimen.m10)
            .setShowLastLine(false)
            .build()
        rv_recycler_grid_list?.let {
            it.layoutManager = GridLayoutManager(this,5)
            it.adapter = mAdapter
            //设置自定义分割线
            it.addItemDecoration(ItemDivider().setDividerColor(color))
            //设置系统默认的分割线
            //it.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        }
        mAdapter.setList(list2)
    }
}