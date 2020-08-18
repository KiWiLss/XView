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
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.snackbar.Snackbar
import com.kiwilss.xview.R
import com.kiwilss.xview.design.appbar.AppBarStateChangeListener
import kotlinx.android.synthetic.main.activity_collasping_one.*
import kotlinx.android.synthetic.main.activity_refresh.*
import kotlinx.android.synthetic.main.activity_refresh.appbar_refresh_appbar
import kotlinx.android.synthetic.main.activity_refresh.fab_refresh_fab
import kotlinx.android.synthetic.main.activity_refresh.rv_refresh_refresh
import kotlinx.android.synthetic.main.activity_refresh.srl_refresh_refresh
import kotlinx.android.synthetic.main.activity_refresh2.*

/**
 *@FileName: RefreshActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/16
 * @desc   : {DESCRIPTION}
 */
class Refresh2Activity:AppCompatActivity() {

    val list = arrayListOf("测试数据一","测试数据二","测试数据三","测试数据四","测试数据五","测试数据六"
        ,"测试数据七","测试数据八","测试数据九","测试数据一","测试数据二","测试数据三","测试数据四","测试数据五","测试数据六"
        ,"测试数据七","测试数据八","测试数据九")

    val mAdapter by lazy { RefreshAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refresh2)

        rv_refresh_refresh?.run {
            layoutManager = LinearLayoutManager(this@Refresh2Activity)
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
        //下拉刷新和下拉会有冲突
        appbar_refresh_appbar.addOnOffsetChangedListener(object : AppBarStateChangeListener(){
            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?, i: Int) {
                if( state == State.EXPANDED ) {
                    //展开状态
                    srl_refresh_refresh.isEnabled = true
                }else if(state == State.COLLAPSED){
                    //折叠状态
                    srl_refresh_refresh.isEnabled = false
                }else {
                    //中间状态
                    srl_refresh_refresh.isEnabled = false
                }
            }

        })
        //悬浮按钮
        fab_refresh_fab.setOnClickListener {
            Snackbar.make(fab_refresh_fab,"hello", Snackbar.LENGTH_SHORT)
                .show()
        }
    }
}