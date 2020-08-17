/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: TopScaleActivity
 * Author:   Administrator
 * Date:     2020/8/17 15:23
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.design.behavioractivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kiwilss.xview.R
import com.kiwilss.xview.design.refresh.RefreshAdapter
import kotlinx.android.synthetic.main.activity_refresh.*
import kotlinx.android.synthetic.main.activity_topscale.*

/**
 *@FileName: TopScaleActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/17
 * @desc   : {顶部控件缩放的折叠布局}
 */
class TopScaleActivity: AppCompatActivity() {

    val list = arrayListOf("测试数据一","测试数据二","测试数据三","测试数据四","测试数据五","测试数据六"
        ,"测试数据七","测试数据八","测试数据九","测试数据一","测试数据二","测试数据三","测试数据四","测试数据五","测试数据六"
        ,"测试数据七","测试数据八","测试数据九","测试数据七","测试数据八","测试数据九","测试数据一","测试数据二","测试数据三","测试数据四","测试数据五","测试数据六"
        ,"测试数据七","测试数据八","测试数据九")

    val mAdapter by lazy { RefreshAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topscale)

        rv_topscale_list?.run {
            layoutManager = LinearLayoutManager(this@TopScaleActivity)
            adapter = mAdapter
            setHasFixedSize(true)
        }
        mAdapter.setList(list)

    }
}