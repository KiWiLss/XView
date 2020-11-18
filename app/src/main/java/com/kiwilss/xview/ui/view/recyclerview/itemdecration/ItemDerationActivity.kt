package com.kiwilss.xview.ui.view.recyclerview.itemdecration

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.view.recyclerview.decoration.BaseItemIntervalDecoration
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
        val baseItemIntervalDecoration =
            BaseItemIntervalDecoration(resources.getDimensionPixelOffset(R.dimen.m10), 3)
        baseItemIntervalDecoration.setDividerHorizontal(resources.getDimensionPixelOffset(R.dimen.m15))

        val itemDecoration = CommonItemDecoration(
            resources.getDimensionPixelOffset(R.dimen.m10),
            resources.getDimensionPixelOffset(R.dimen.m10),
            resources.getDimensionPixelOffset(R.dimen.m15) * 2,resources.getDimensionPixelOffset(R.dimen.m15) * 2,
            resources.getDimensionPixelOffset(R.dimen.m15) * 2,0
        )
        val gridLayoutManager = GridLayoutManager(this@ItemDerationActivity, 3)
        gridLayoutManager.orientation = GridLayoutManager.HORIZONTAL
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        //线性布局,垂直方向
        rv_item?.run {
            layoutManager = gridLayoutManager
            adapter = adapterVertical
            addItemDecoration(itemDecoration)
        }

        val list = ArrayList<String>()
        for (i in 0..20){
            list.add("$i ====")
        }
        adapterVertical.setList(list)

//        val inflate = layoutInflater.inflate(R.layout.empty_quick_hf, null)
//        adapterVertical.addHeaderView(inflate)

    }


}