/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: RecyclerWrapActivity
 * Author:   Administrator
 * Date:     2020/8/1 14:31
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
import com.kiwilss.xview.ui.view.recyclerview.adapter.RecyclerWrapAdapter
import kotlinx.android.synthetic.main.activity_recyclerview_wrap.*

/**
 *@FileName: RecyclerWrapActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/1
 * @desc   : {动态设置recyclerview高度}
 */
class RecyclerWrapActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview_wrap)

        val list = arrayListOf("测试数据一","测试数据二","测试数据三","测试数据四","测试数据五","测试数据六")
        val adapter by lazy { RecyclerWrapAdapter() }
        rv_recycler_wrap_list?.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = adapter
            it.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        }
        adapter.setList(list)

        //参考https://www.cnblogs.com/guanxinjing/p/13037156.html
        //动态设置recyclerview高度
        rv_recycler_wrap_list?.post {
            //假如固定4个,超过4个才需要设置
            if (list.size <= 4){
                return@post
            }
            val itemView = rv_recycler_wrap_list.getChildAt(0)
            itemView?.let {
                val height = it.height * 4
                val layoutParems = rv_recycler_wrap_list.layoutParams
                layoutParems.height = height
                rv_recycler_wrap_list.layoutParams = layoutParems
            }
        }
    }
}