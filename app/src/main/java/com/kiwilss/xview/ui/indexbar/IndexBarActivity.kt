package com.kiwilss.xview.ui.indexbar

import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_indexbar.*

/**
 *@FileName: IndexBarActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/8
 * @desc   : {自定义indexbar,新增设置数据源,可以很方便管理提示TextView,
 * 数据源少时,只能动态调整整个indexbar的高度才能达到字母紧凑和居住的效果,
 * 适用于数据源比较完整的情况}
 */
class IndexBarActivity : BaseActivity(R.layout.activity_indexbar) {
    private val data = arrayOf(
        "A",
        "B",
        "C",
        "D",
        "E",
        "F",
        "G",
        "H",
        "I",
        "J",
        "K",
        "L",
        "M",
        "N",
        "O",
        "X",
        "Y",
        "Z",
        "#"
    )
    override fun initData() {
    }

    override fun initEvent() {
        sb_indexbar_one.setOnIndexChangedListener { index, position ->
            LogUtils.e("index = $index, position = $position")
        }
        sb_indexbar_one.setDatas(data.toList())
        sb_indexbar_one?.run {
            //setTextSize(R.dimen.m12)
            setNormalColor(R.color.red)
            setSelectColor(R.color.colorAccent)
            setOverlayTextView(tv_indexbar_hint)
        }
        //索引变化监听
        sb_indexbar_one.setOnIndexChangedListener { index, position ->

        }
    }

    override fun initInterface() {
    }
}