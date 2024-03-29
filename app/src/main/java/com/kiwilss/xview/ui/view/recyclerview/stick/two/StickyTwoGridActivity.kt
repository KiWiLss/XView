package com.kiwilss.xview.ui.view.recyclerview.stick.two

import android.graphics.Color
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.view.recyclerview.stick.DataUtil
import com.kiwilss.xview.ui.view.recyclerview.stick.itemdecration.StickyDecoration
import com.kiwilss.xview.ui.view.recyclerview.stick.two.adapter.StickyTwoGridAdapter
import com.kiwilss.xview.utils.DensityUtils
import kotlinx.android.synthetic.main.activity_sticky_twogrid.*

/**
 *@FileName: StickyTwoGridActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/18
 * @desc   : {DESCRIPTION}
 */
class StickyTwoGridActivity: BaseActivity(R.layout.activity_sticky_twogrid) {

    val mAdapter by lazy { StickyTwoGridAdapter() }

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
        //------------- StickyDecoration 使用部分  ----------------
        val builder: StickyDecoration.Builder = StickyDecoration.Builder
            .init { position ->
                //组名回调
                if (mAdapter.data.size > position && position > -1) {
                    //获取组名，用于判断是否是同一组
                    mAdapter.data[position].tag
                } else null
            } //背景色
            .setGroupBackground(red) //高度
            .setGroupHeight(DensityUtils.dp2px(this, 40f)) //分割线颜色
            .setDivideColor(yellow) //分割线高度 (默认没有分割线)
            .setDivideLeftPadding(DensityUtils.dp2px(this, 10f))//设置分割线左侧间距,默认0
            .setDivideRightPadding(DensityUtils.dp2px(this, 10f))//设置分割线右侧间距,默认0
            .setDivideHeight(DensityUtils.dp2px(this, 1f)) //字体颜色 （默认）
            .setGroupTextColor(Color.BLACK) //字体大小
            .setGroupTextSize(DensityUtils.dp2px(this, 15f)) // 边距   靠左时为左边距  靠右时为右边距
            .setTextSideMargin(DensityUtils.dp2px(this, 10f)) // header数量（默认0）
            //.setHeaderCount(1)
            //Group点击事件
            .setOnClickListener { position, id -> //点击事件，返回当前分组下的第一个item的position
                val content = "onGroupClick --> " + position + " " +mAdapter.data[position].tag
                Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
            }

        val manager = GridLayoutManager(this@StickyTwoGridActivity,2)
        builder.resetSpan(rv_sticky_twogrid_list, manager)

        rv_sticky_twogrid_list?.run {
            layoutManager = manager
            adapter = mAdapter
            addItemDecoration(builder.build())
        }

        mAdapter.setOnItemClickListener { adapter, view, position ->
            val content = "normal --> " + position + " " +mAdapter.data[position].categoryName
            Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
        }

    }
}