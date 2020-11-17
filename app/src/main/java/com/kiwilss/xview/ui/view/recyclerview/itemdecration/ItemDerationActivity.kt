package com.kiwilss.xview.ui.view.recyclerview.itemdecration

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_item_decration.*

/**
 *@FileName: ItemDerationActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/11/17
 * @desc   : {DESCRIPTION}
 */
class ItemDerationActivity : BaseActivity(R.layout.activity_item_decration){
    override fun initData() {

    }

    override fun initEvent() {
    }

    val adapterVertical by lazy { ItemDecrationAdapter() }
    override fun initInterface() {
        val itemDecoration = CommonItemDecoration(resources.getDimensionPixelOffset(R.dimen.m10),
            resources.getDimensionPixelOffset(R.dimen.m10),
            resources.getDimensionPixelOffset(R.dimen.m10)
        )
        val gridLayoutManager = GridLayoutManager(this@ItemDerationActivity, 2)
        val linearLayoutManager = LinearLayoutManager(this)
        //线性布局,垂直方向
        rv_item?.run {
            layoutManager = gridLayoutManager
            adapter = adapterVertical
            addItemDecoration(itemDecoration)
        }

        val list = ArrayList<String>()
        for (i in 0..19){
            list.add("$i ====")
        }
        adapterVertical.setList(list)


    }


}