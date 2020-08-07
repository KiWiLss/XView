/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: SimpleBasePopup
 * Author:   Administrator
 * Date:     2020/8/5 17:44
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.popup.popup

import android.app.Activity
import android.view.View
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.pw_center.view.*

/**
 *@FileName: SimpleBasePopup
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/5
 * @desc   : {DESCRIPTION}
 */
class SimpleBasePopup(activity: Activity, layout: Int = R.layout.pw_center, private val simpleBasePopup: SimpleBasePopupListener? = null)
    : BasePopupL(activity,layout) {


    override fun setContent(contentView: View) {
        contentView.tv_pw_onetitle_title.text = "简单提示"
        contentView.tv_pw_onetitle_sure.setOnClickListener {
            simpleBasePopup?.sure(this)
        }
        contentView.tv_pw_onetitle_cancel.setOnClickListener {
            simpleBasePopup?.cancel(this)
        }

    }
}

abstract class SimpleBasePopupListener{
    abstract fun sure(simpleBasePopup: SimpleBasePopup)
    open fun cancel(simpleBasePopup: SimpleBasePopup){}
}