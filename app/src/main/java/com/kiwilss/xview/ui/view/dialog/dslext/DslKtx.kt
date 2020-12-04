package com.kiwilss.xview.ui.view.dialog.dslext

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.xview.ui.view.dialog.base.XDialog

/**
 *@FileName: DslKtx
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/4
 * @desc   : {DESCRIPTION}
 */


inline fun AppCompatActivity.showXDialog(layoutId:  Int, action: XDialog.() -> Unit): XDialog{
    val xDialog = XDialog.Builder(this,layoutId)
        .build()
        xDialog.apply(action).show()
    return xDialog
}

