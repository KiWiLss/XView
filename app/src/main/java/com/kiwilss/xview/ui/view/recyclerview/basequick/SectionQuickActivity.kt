package com.kiwilss.xview.ui.view.recyclerview.basequick

import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.view.recyclerview.basequick.section.SectionBean
import com.kiwilss.xview.ui.view.recyclerview.basequick.section.SectionQuickAdapter
import kotlinx.android.synthetic.main.activity_section_quick.*

/**
 *@FileName: SectionQuickActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/9
 * @desc   : {DESCRIPTION}
 */
class SectionQuickActivity : BaseActivity(R.layout.activity_section_quick) {

    val mAdapter by lazy { SectionQuickAdapter() }

    override fun initData() {

    }

    override fun initEvent() {
    }

    override fun initInterface() {
        rv_section_quick_list?.run {
           // layoutManager = LinearLayoutManager(this@SectionQuickActivity)
            layoutManager = GridLayoutManager(this@SectionQuickActivity,3)
            adapter = mAdapter
        }

        val datas = arrayListOf<SectionBean>()
        var bean : SectionBean
        for (i in 0..19){
            if (i % 6 == 0){
                bean = SectionBean(true,null,"头布局数据$i")
            }else{
                bean = SectionBean(false,"正常布局数据$i",null)
            }
           datas.add(bean)
        }
        mAdapter.setList(datas)
        //点击事件
        mAdapter.setOnItemClickListener { adapter, view, position ->
            val bean = datas[position]
            if (bean.isHeader){
                Toast.makeText(this, "点了头布局--${bean.headerTitle}", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "点了正常布局--${bean.name}", Toast.LENGTH_SHORT).show()
            }

        }

    }
}