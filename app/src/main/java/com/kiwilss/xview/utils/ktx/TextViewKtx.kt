package com.kiwilss.xview.utils.ktx

import android.view.View
import android.widget.TextView

/**
 * @author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/26
 *  desc   : TextView扩展优化
 */
object TextViewKtx

/**
 *设置Text，简单判空
 */
fun TextView?.setText(value: CharSequence?) {
    this?.run {
        if (!value.isNullOrEmpty()) {
            text = value
        }
    }
}

/**
 *设置Text，简单判空，可以设置默认值
 */
fun TextView?.setText(value: CharSequence?, defaultValue: CharSequence? = null) {
    this?.run {
        if (!value.isNullOrEmpty()) {
            text = value
        } else {
            if (!defaultValue.isNullOrEmpty()) {
                text = defaultValue
            }
        }
    }
}

/**
 *判空，有数据显示，无数据隐藏
 */
fun TextView?.setTextVisibility(value: CharSequence?) {
    this?.run {
        if (!value.isNullOrEmpty()) {
            text = value
            visibility = View.VISIBLE
        } else {
            visibility = View.GONE
        }
    }
}
/**
 *判空，有数据设置选中，没有设置默认值
 */
fun TextView?.setTextSelect(value: CharSequence?, defaultValue: CharSequence? = null) {
    this?.run {
        if (value.isNullOrEmpty()) {
            isSelected = false
            if (!defaultValue.isNullOrEmpty()) {
                text = value
            }
        } else {
            text = value
            isSelected = true
        }
    }
}
/**
 *判空，有数据可以点击，没有不可点击，设置默认值
 */
fun TextView?.setTextEnable(value: CharSequence?, defaultValue: CharSequence? = null){
    this?.run {
        if (value.isNullOrEmpty()) {
            isEnabled = false
            if (!defaultValue.isNullOrEmpty()) {
                text = value
            }
        } else {
            text = value
            isEnabled = true
        }
    }
}








