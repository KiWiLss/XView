/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: TestEasy
 * Author:   Administrator
 * Date:     2020/8/7 17:12
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.popup.easy

import android.annotation.SuppressLint
import android.app.Activity
import android.view.ViewGroup
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.pw_center.view.*

/**
 *@FileName: TestEasy
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/7
 * @desc   : {DESCRIPTION}
 */
class TestEasy(activity: Activity,layoutId: Int = R.layout.pw_center): EasyPopup(activity,layoutId) {
    @SuppressLint("SetTextI18n")
    override fun setInterface() {
        //这里可以重新设置popupwindow的一些属性
        width = ViewGroup.LayoutParams.WRAP_CONTENT
        height = ViewGroup.LayoutParams.WRAP_CONTENT
        setIsMask(false)
        setIsTouchOutsideDimiss(false)
        //获取到对话框控件,设置内容或是点击等
        contentView.tv_pw_onetitle_title.text = "EasyPopup Test"
    }
}