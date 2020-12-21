package com.kiwilss.xview.ui.picker

import android.view.View

import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_picker_all.*
import java.util.*

/**
 *@FileName: PickerAllActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/21
 * @desc   : {DESCRIPTION}
 */
class PickerAllActivity: BaseActivity(R.layout.activity_picker_all) {
    override fun initData() {

    }

    override fun initEvent() {
        btn_picker_all_date.setOnClickListener {
//            val timePicker = TimePickerBuilder(this,
//                OnTimeSelectListener { date, v ->
//                    LogUtils.e(date)
//                }).build()
//            timePicker.setTitleText("日期选择")
//            timePicker.show()
        }
    }

    override fun initInterface() {
    }
}