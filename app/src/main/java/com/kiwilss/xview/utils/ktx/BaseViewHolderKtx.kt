package com.kiwilss.xview.utils.ktx

import androidx.annotation.IdRes
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * @author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/26
 *  desc   :BaseViewHolder使用扩展
 */



fun BaseViewHolder.setTextValue(@IdRes viewId: Int, value: CharSequence?): BaseViewHolder{
    value?.run {
        setText(viewId, value)
    }
    return this
}

fun BaseViewHolder.setTextValue(@IdRes viewId: Int, value: CharSequence?, defaultValue: CharSequence? = null): BaseViewHolder{
    value?.run {
        setText(viewId, value)
    }
    defaultValue?.run {
        setText(viewId, defaultValue)
    }
    return this
}