/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: RecyclerIntervalActivity
 * Author:   Administrator
 * Date:     2020/8/1 15:39
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
import com.kiwilss.xview.ui.view.recyclerview.adapter.RecyclerWrapAdapter
import com.kiwilss.xview.ui.view.recyclerview.decoration.IntervalDecoration
import kotlinx.android.synthetic.main.activity_recyclerview_wrap.*

/**
 *@FileName: RecyclerIntervalActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/1
 * @desc   : {DESCRIPTION}
 */
class RecyclerIntervalActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview_wrap)

        val list = arrayListOf("测试数据一","测试数据二","测试数据三","测试数据四","测试数据五","测试数据六"
            ,"测试数据七","测试数据八","测试数据九","测试数据一","测试数据二","测试数据三","测试数据四","测试数据五","测试数据六"
            ,"测试数据七","测试数据八","测试数据九")
        val adapter by lazy { RecyclerWrapAdapter() }
        val dimension = resources.getDimensionPixelOffset(R.dimen.m10)
        rv_recycler_wrap_list?.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = adapter
            //设置分割线,实现item间隔,可以自由组合
            it.addItemDecoration(IntervalDecoration(left = dimension,right = dimension,top = dimension))
        }
        adapter.setList(list)

    }
}