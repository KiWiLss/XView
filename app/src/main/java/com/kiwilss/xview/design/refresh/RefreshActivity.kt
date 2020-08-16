/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: RefreshActivity
 * Author:   kiwilss
 * Date:     2020/8/16 11:33
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.design.refresh

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.activity_collasping_one.*
import kotlinx.android.synthetic.main.activity_refresh.*

/**
 *@FileName: RefreshActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/16
 * @desc   : {DESCRIPTION}
 */
class RefreshActivity:AppCompatActivity() {

    val list = arrayListOf("测试数据一","测试数据二","测试数据三","测试数据四","测试数据五","测试数据六"
        ,"测试数据七","测试数据八","测试数据九","测试数据一","测试数据二","测试数据三","测试数据四","测试数据五","测试数据六"
        ,"测试数据七","测试数据八","测试数据九")

    val mAdapter by lazy { RefreshAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refresh)

        rv_refresh_refresh?.run {
            layoutManager = LinearLayoutManager(this@RefreshActivity)
            adapter = mAdapter
            setHasFixedSize(true)
        }
        mAdapter.setList(list)
        //mAdapter.setNewInstance()
        srl_refresh_refresh.setOnRefreshListener {
            srl_refresh_refresh.postDelayed({
                srl_refresh_refresh.isRefreshing = false
            },1000)
        }
        fab_refresh_fab.setOnClickListener {
            Snackbar.make(fab_refresh_fab,"hello", Snackbar.LENGTH_SHORT)
                .show()
        }
    }
}