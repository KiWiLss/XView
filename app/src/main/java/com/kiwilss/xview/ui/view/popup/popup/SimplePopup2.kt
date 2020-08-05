/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: SimplePopup
 * Author:   Administrator
 * Date:     2020/8/5 9:32
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.popup.popup

import android.app.Activity
import android.content.Context
import android.view.View
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.view.popup.BottomPushPopupWindow
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fg_test.view.*
import kotlinx.android.synthetic.main.pw_center.view.*

/**
 *@FileName: SimplePopup
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/5
 * @desc   : {DESCRIPTION}
 */
class SimplePopup2 (context: Activity, private val listener: PopupListener)
    : BottomPushPopupWindow<PopupListener>(context,listener){


    override fun generateCustomView(t: PopupListener?): View {
        val contentView = View.inflate(activity, R.layout.pw_center, null)
        contentView.tv_pw_onetitle_title.text = "简单提示"
        contentView.tv_pw_onetitle_cancel.setOnClickListener {
            listener.cancel(this)
        }
        contentView.tv_pw_onetitle_sure.setOnClickListener {
            listener.sure(this)
        }
        return contentView
    }
}

abstract class PopupListener{
    abstract fun cancel(simplePopup2: SimplePopup2?)
    open fun sure(simplePopup2: SimplePopup2?) {
     }
}