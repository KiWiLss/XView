package com.kiwilss.xview.ui.view.recyclerview.basequick.mutil

import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_muilt_quick.*

/**
 *@FileName: MuiltQuickActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/9
 * @desc   : {DESCRIPTION}
 */
class MuiltQuickActivity : BaseActivity(R.layout.activity_muilt_quick) {

    val mAdapter by lazy { MultiQuickAdapter() }

    override fun initData() {
    }

    override fun initEvent() {
        srl_muilt_quick_refresh.setOnRefreshListener {
            srl_muilt_quick_refresh.isRefreshing = false
        }

    }

    override fun initInterface() {

        rv_muilt_quick_list?.run {
            layoutManager = GridLayoutManager(this@MuiltQuickActivity,2)
            adapter = mAdapter
        }

        val datas = arrayListOf<MuiltBean>()

        //对多布局进行处理,可以控制每个布局是线性还是网格
        mAdapter.setGridSpanSizeLookup { gridLayoutManager, viewType, position ->
             datas[position].spanSize
        }

        mAdapter.setOnItemClickListener { adapter, view, position ->
            val bean = datas[position]
            when (bean.itemType) {
                MuiltBean.TEXT -> {
                    Toast.makeText(this, "this is TEXT ${bean.first}", Toast.LENGTH_SHORT).show()
                }
                MuiltBean.IMG -> {
                    Toast.makeText(this, "this is IMG ${bean.first}", Toast.LENGTH_SHORT).show()
                }
                MuiltBean.Span -> {
                    Toast.makeText(this, "this is span ${bean.second}", Toast.LENGTH_SHORT).show()
                }
                else -> {
                }
            }
        }

        var bean : MuiltBean
        for (i in 0..5){
            bean = MuiltBean("first $i","second $i",MuiltBean.TEXT,2)
            datas.add(bean)
        }
        for (i in 0..5){
            bean = MuiltBean("first $i","second $i",MuiltBean.IMG,2)
            datas.add(bean)
        }
        for (i in 0..9){
            bean = MuiltBean("first $i","second $i",MuiltBean.Span,1)
            datas.add(bean)
        }
        for (i in 0..5){
            bean = MuiltBean("first $i","second $i",MuiltBean.TEXT,2)
            datas.add(bean)
        }
        mAdapter.setList(datas)
    }
}