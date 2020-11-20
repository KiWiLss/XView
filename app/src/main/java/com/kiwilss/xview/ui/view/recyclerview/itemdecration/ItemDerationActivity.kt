package com.kiwilss.xview.ui.view.recyclerview.itemdecration

import androidx.core.content.ContextCompat
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

        val itemDecoration2 = MyDivider(this,resources.getDimensionPixelOffset(R.dimen.m2),
            ContextCompat.getColor(this,R.color.red))

        val gridLayoutManager = GridLayoutManager(this@ItemDerationActivity, 3)
        gridLayoutManager.orientation = GridLayoutManager.HORIZONTAL
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        //线性布局,垂直方向
        rv_item?.run {
            layoutManager = linearLayoutManager
            adapter = adapterVertical
            //addItemDecoration(itemDecoration)
            addItemDecoration(itemDecoration2)
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