/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: SimpleDialog
 * Author:   kiwilss
 * Date:     2020/8/3 20:54
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.mddialog.dialog

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.dialog_bottom_simple.*

/**
 *@FileName: SimpleDialog
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/3
 * @desc   : {DESCRIPTION}
 */
class SimpleDialog(context: Context): BottomSheetDialog(context) {

    init {
        setContentView(R.layout.dialog_bottom_simple_fillet)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //布局内容动态设置
        tv_dialog_bottom_simple_title.text = "第一个标签"
    }


}