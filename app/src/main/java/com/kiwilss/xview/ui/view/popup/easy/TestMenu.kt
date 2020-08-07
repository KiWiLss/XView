/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: TestMenu
 * Author:   Administrator
 * Date:     2020/8/7 17:46
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.popup.easy

import android.app.Activity
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.pw_center.view.*

/**
 *@FileName: TestMenu
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/7
 * @desc   : {DESCRIPTION}
 */
class TestMenu(activity: Activity,layoutId: Int = R.layout.pw_menu): EasyPopup(activity,layoutId) {
    override fun setInterface() {
        contentView.tv_pw_onetitle_title.text = "菜单样式"
    }
}