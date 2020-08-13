/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: ScreenUtils
 * Author:   kiwilss
 * Date:     2020/8/9 09:35
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.utils

import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow

/**
 *@FileName: ScreenUtils
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/9
 * @desc   : {DESCRIPTION}
 */
object ScreenUtils {

    /**
     * 设置添加屏幕的背景透明度
     * @param bgAlpha
     */
    fun setScreenAlpha(context: Activity, bgAlpha: Float) {
        val lp: WindowManager.LayoutParams = context.window.attributes
        lp.alpha = bgAlpha //0.0-1.0
        context.window.attributes = lp
    }

     fun setScreenAlpha(context: Context, pp: PopupWindow,dimAmount: Float) {
        val decorView: View? = getDecorView(pp)
        decorView?.let {
            val p = decorView.layoutParams as WindowManager.LayoutParams
            p.flags = p.flags or WindowManager.LayoutParams.FLAG_DIM_BEHIND
            p.dimAmount = dimAmount
            //modifyWindowLayoutParams(p)
            (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager)
                .updateViewLayout(decorView, p)
        }
    }

    private fun getDecorView(pp: PopupWindow): View? {
        var decorView: View? = null
        try {
            decorView = if (pp.background == null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    pp.contentView.parent as View
                } else {
                    pp.contentView
                }
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    pp.contentView.parent.parent as View
                } else {
                    pp.contentView.parent as View
                }
            }
        } catch (ignore: Exception) {
        }
        return decorView
    }

}