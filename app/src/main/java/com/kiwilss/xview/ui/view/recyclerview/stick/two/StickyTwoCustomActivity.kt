package com.kiwilss.xview.ui.view.recyclerview.stick.two

import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.view.recyclerview.stick.DataUtil
import com.kiwilss.xview.ui.view.recyclerview.stick.itemdecration.PowerfulStickyDecoration
import com.kiwilss.xview.ui.view.recyclerview.stick.itemdecration.listener.OnGroupClickListener
import com.kiwilss.xview.ui.view.recyclerview.stick.itemdecration.listener.PowerGroupListener
import com.kiwilss.xview.ui.view.recyclerview.stick.two.adapter.StickyTwoCustomAdapter
import com.kiwilss.xview.utils.DensityUtils
import kotlinx.android.synthetic.main.activity_sticky_twocustom.*
import kotlinx.android.synthetic.main.item_sticky_custom_top.view.*

/**
 *@FileName: StickyTwoCustomActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/18
 * @desc   : {DESCRIPTION}
 */
class StickyTwoCustomActivity: BaseActivity(R.layout.activity_sticky_twocustom) {

    val mAdapter by lazy { StickyTwoCustomAdapter() }

    override fun initData() {
        val lists = DataUtil.getCategoryList()
        lists.addAll(lists)
        mAdapter.setList(lists)
    }

    override fun initEvent() {

    }

    override fun initInterface() {
        val red = ContextCompat.getColor(this,R.color.red)
        val yellow = ContextCompat.getColor(this,R.color.yellow_FF9B52)

        val builder = PowerfulStickyDecoration.Builder.init(object : PowerGroupListener{
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

        }).setDivideColor(red)
            .setDivideHeight(DensityUtils.dp2px(this, 1f))
            .setOnClickListener { position, id ->
                val datas = mAdapter.data
                if (datas.size > position) {
                    Toast.makeText(this, "--${datas[position].tag}", Toast.LENGTH_SHORT).show()
                }
            }


        rv_sticky_twocustom_list?.run {
            layoutManager = LinearLayoutManager(this@StickyTwoCustomActivity)
            adapter = mAdapter
            addItemDecoration(builder.build())
        }
    }
}