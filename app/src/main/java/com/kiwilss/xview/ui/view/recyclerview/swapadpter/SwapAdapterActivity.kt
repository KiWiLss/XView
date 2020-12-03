package com.kiwilss.xview.ui.view.recyclerview.swapadpter

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.view.recyclerview.stick.DataUtil
import kotlinx.android.synthetic.main.activity_swapadapter.*

/**
 *@FileName: SwapAdapterActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/2
 * @desc   : {DESCRIPTION}
 */
class SwapAdapterActivity: BaseActivity(R.layout.activity_swapadapter) {

    private val mLinearAdapter by lazy { SwapAdapterLinearAdapter() }

    private val mLinearLayoutManager by lazy { LinearLayoutManager(this) }

    private val mGridLayoutManager by lazy { GridLayoutManager(this,2) }

    private val mGridAdapter by lazy { SwapAdapterTwoAdapter() }

    private var isGrid = false

    val list = arrayListOf<String>()

    override fun initData() {
        for (i in 0..19){
            list.add("this is $i")
        }
        mLinearAdapter.setList(list)
        mGridAdapter.setList(list)

    }

    override fun initEvent() {
        //切换方法一
        btn_swapadapter_change.setOnClickListener {
            if (isGrid){
                rv_swapadapter_list.run {
                    layoutManager = mLinearLayoutManager
                    adapter = mLinearAdapter
                }
                mLinearAdapter.setList(list)
            }else{
                rv_swapadapter_list.run {
                    layoutManager = mGridLayoutManager
                    adapter = mGridAdapter
                }
                mGridAdapter.setList(list)
            }
            isGrid = !isGrid
        }
        btn_swapadapter_change2.setOnClickListener {
            if (isGrid){
                rv_swapadapter_list.run {
                    layoutManager = mLinearLayoutManager
                }
                rv_swapadapter_list.swapAdapter(mLinearAdapter,false)
            }else{
                rv_swapadapter_list.run {
                    layoutManager = mGridLayoutManager
                }
                rv_swapadapter_list.swapAdapter(mGridAdapter,false)
            }
            isGrid = !isGrid
        }
    }

    override fun initInterface() {
        //默认展示线性界面
        rv_swapadapter_list.run {
            layoutManager = mLinearLayoutManager
            adapter = mLinearAdapter
        }


    }
}