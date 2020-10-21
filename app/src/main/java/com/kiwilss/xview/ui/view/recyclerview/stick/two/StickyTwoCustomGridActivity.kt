package com.kiwilss.xview.ui.view.recyclerview.stick.two

import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.view.recyclerview.stick.DataUtil
import com.kiwilss.xview.ui.view.recyclerview.stick.itemdecration.PowerfulStickyDecoration
import com.kiwilss.xview.ui.view.recyclerview.stick.itemdecration.listener.PowerGroupListener
import com.kiwilss.xview.ui.view.recyclerview.stick.two.adapter.StickyTwoCustomAdapter
import com.kiwilss.xview.utils.DensityUtils
import kotlinx.android.synthetic.main.activity_sticky_two_custom_grid.*
import kotlinx.android.synthetic.main.activity_sticky_twocustom.*
import kotlinx.android.synthetic.main.item_sticky_custom_top.view.*

/**
 *@FileName: StickyTwoCustomGridActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/10/20
 * @desc   : {网格布局,悬浮自定义布局}
 */
class StickyTwoCustomGridActivity : BaseActivity(R.layout.activity_sticky_two_custom_grid) {
    override fun initData() {
        val lists = DataUtil.getCategoryList()
        //lists.addAll(lists)
        mAdapter.setList(lists)
    }

    override fun initEvent() {
    }

    val mAdapter by lazy { StickyTwoCustomAdapter() }

    override fun initInterface() {
        val yellow = ContextCompat.getColor(this,R.color.yellow_FF9B52)

       val builder =  PowerfulStickyDecoration.Builder.init(object : PowerGroupListener{
            override fun getGroupName(position: Int): String {
                //获取组名，用于判断是否是同一组
                val datas = mAdapter.data
                return if (datas.size > position) {
                    datas[position].tag
                } else{
                    ""
                }
            }

            override fun getGroupView(position: Int): View {
                val datas = mAdapter.data
                val topView =  layoutInflater.inflate(R.layout.item_sticky_custom_top,null,false)
                if (datas.size > position) {
                    topView.tv_item_sticky_custom_top_title.text = datas[position].tag
                }
                return topView
            }

        }).setDivideColor(yellow)
            .setDivideHeight(DensityUtils.dp2px(this, 1f))
            .setOnClickListener { position, id ->
                val datas = mAdapter.data
                if (datas.size > position) {
                    Toast.makeText(this, "--${datas[position].tag}", Toast.LENGTH_SHORT).show()
                }
            }

        val gridLayoutManager = GridLayoutManager(this@StickyTwoCustomGridActivity,2)
        val itemDecoration = builder.build()
        itemDecoration.resetSpan(rv_sticky_two_custom_grid_list,gridLayoutManager)
        rv_sticky_two_custom_grid_list?.run {
            layoutManager = gridLayoutManager
            adapter = mAdapter
            addItemDecoration(itemDecoration)
        }

    }
}