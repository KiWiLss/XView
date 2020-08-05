/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: SimpleMenu
 * Author:   Administrator
 * Date:     2020/8/5 16:13
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.popup.popup

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.view.popup.BottomPushPopupWindow
import kotlinx.android.synthetic.main.pw_menu.view.*

/**
 *@FileName: SimpleMenu
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/5
 * @desc   : {DESCRIPTION}
 */
class SimpleMenu(context: Activity, private val listener: PopupListener):
    BottomPushPopupWindow<PopupListener>(context,listener) {
    override fun generateCustomView(t: PopupListener?): View {
        val contentView = View.inflate(activity, R.layout.pw_menu, null)
        contentView.tv_pw_onetitle_cancel.setOnClickListener {
            listener.cancel(null)
        }
        contentView.tv_pw_onetitle_sure.setOnClickListener {
            listener.sure(null)
        }
        return contentView
    }
}