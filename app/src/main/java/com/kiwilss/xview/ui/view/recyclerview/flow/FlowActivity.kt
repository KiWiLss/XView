package com.kiwilss.xview.ui.view.recyclerview.flow

import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.flexbox.*
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_flow.*

/**
 *@FileName: FlowActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/10
 * @desc   : {DESCRIPTION}
 */
class FlowActivity: BaseActivity(R.layout.activity_flow) {

    val mAdapter by lazy { FlowAdapter() }
    override fun initData() {

    }

    override fun initEvent() {
    }

    private var isExpand = false

    override fun initInterface() {

        val manager: FlexboxLayoutManager? = getFlexboxLayoutManager()
        rv_flow_list?.run {
            layoutManager = manager
            adapter = mAdapter
        }

        val list = arrayListOf<String>()
        val datas = arrayListOf<String>()
        list.add("时尚达人")
        list.add("时尚")
        list.add("时")
        list.add("达人")
        list.add("时尚达人")
        for (i in 0..3){
            list.add("摄影")
        }
        if (list.size <= 4){//完整放下
            list.add("+")
            datas.addAll(list)
        }else if (list.size > 4){
            list.add("+")
            list.add(">")
            datas.add(list[0])
            datas.add(list[1])
            datas.add(list[2])
            datas.add(list[3])
            datas.add("+")
            datas.add(">")
        }
        mAdapter.setList(datas)

        val height = resources.getDimensionPixelOffset(R.dimen.m35)
        mAdapter.setOnItemClickListener { adapter, view, position ->
            if (list.size <= 4){
                if (position == datas.size - 1){
                    //点击增加
                    Toast.makeText(this, "+", Toast.LENGTH_SHORT).show()
                }
            }else{
                if (isExpand){//收起
                    if (list[position] == "+") {
                        //点击增加
                        Toast.makeText(this, "+", Toast.LENGTH_SHORT).show()
                    }else if (list[position] == ">"){
//                        val layoutParams: ConstraintLayout.LayoutParams = rv_flow_list.layoutParams as ConstraintLayout.LayoutParams
//                        layoutParams.height = 0
//                        layoutParams.matchConstraintMaxHeight = height
//                        rv_flow_list.layoutParams = layoutParams
                        mAdapter.setList(datas)
                        isExpand = false
                    }else{
                        Toast.makeText(this, "*", Toast.LENGTH_SHORT).show()
                    }
//                    if (position == list.size - 2){
//
//                    }else if (position == list.size - 1){//收起
//
//                    }else{
//
//                    }
                }else{//展开
                    if (datas[position] == "+") {
                        //点击增加
                        Toast.makeText(this, "+", Toast.LENGTH_SHORT).show()
                    }else if (datas[position] == ">"){
                        //展开
//                        val layoutParams: ConstraintLayout.LayoutParams = rv_flow_list.layoutParams as ConstraintLayout.LayoutParams
//                        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
//                        rv_flow_list.layoutParams = layoutParams
                        mAdapter.setList(list)
                        isExpand = true
                    }else{
                        Toast.makeText(this, "*", Toast.LENGTH_SHORT).show()
                    }
//                    if (position == datas.size - 2){
//
//                    }else if (position == datas.size - 1){
//
//                    }else{
//                        Toast.makeText(this, "*", Toast.LENGTH_SHORT).show()
//                    }
                }


            }
        }

    }

    private fun getFlexboxLayoutManager(): FlexboxLayoutManager? {
        val manager = FlexboxLayoutManager(this)
        manager.flexWrap = FlexWrap.WRAP
        manager.flexDirection = FlexDirection.ROW
        manager.justifyContent = JustifyContent.FLEX_START
        manager.alignItems = AlignItems.FLEX_START
        return manager
    }
}