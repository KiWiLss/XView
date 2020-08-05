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
class SimplePopup (context: Context, private val popupClickListener: PopupClickListener)
    : BottomPushPopupWindow<PopupClickListener>(context,popupClickListener){
    override fun generateCustomView(t: PopupClickListener?): View {
        val contentView = View.inflate(context, R.layout.pw_center, null)
        contentView.tv_pw_onetitle_title.text = "简单提示"
        contentView.tv_pw_onetitle_cancel.setOnClickListener {
            popupClickListener.cancel(this)
        }
        contentView.tv_pw_onetitle_sure.setOnClickListener {
            popupClickListener.sure(this)
        }
        return contentView
    }
}

interface PopupClickListener{
    fun cancel(simplePopup: SimplePopup)
    fun sure(simplePopup: SimplePopup)
}