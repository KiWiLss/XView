/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: FgDialog
 * Author:   Administrator
 * Date:     2020/8/10 17:40
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.dialog.custom

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.kiwilss.xview.R
import com.kiwilss.xview.utils.LogUtils


/**
 *@FileName: FgDialog
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/10
 * @desc   : {DESCRIPTION}
 */
class FgDialog : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        LogUtils.e("onCreate")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        LogUtils.e("onCreateView")
        return inflater.inflate(R.layout.pw_center, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtils.e("onViewCreated")


    }

    override fun onStart() {
        dialog?.window?.run {
            setBackgroundDrawableResource(R.color.transparent)
            val attributes = attributes
            attributes.width = WindowManager.LayoutParams.MATCH_PARENT
            attributes.height = WindowManager.LayoutParams.WRAP_CONTENT
            attributes.gravity = Gravity.BOTTOM
            setAttributes(attributes)
        }
        super.onStart()
        LogUtils.e("onStart")

    }


}