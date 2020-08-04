/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: PopupActivity
 * Author:   kiwilss
 * Date:     2020/8/3 23:23
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.popup

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.xview.R
import com.kiwilss.xview.utils.Utils
import kotlinx.android.synthetic.main.activity_popup.*

/**
 *@FileName: PopupActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/3
 * @desc   : {DESCRIPTION}
 */
class PopupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)
        btn_popup_center.setOnClickListener {
            showCenterPw(Gravity.CENTER)
        }
        btn_popup_bottom.setOnClickListener {
            showCenterPw(Gravity.BOTTOM)
        }
        btn_popup_menu.setOnClickListener {
            showMenuPw()
        }
    }

    private fun showMenuPw() {
        val contentView = layoutInflater.inflate(R.layout.pw_menu, null)
        val popup = PopupWindow(contentView,
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)
        //对整个 popupwindow 设置背景
        //popup.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this,R.color.red)))

        popup.showAsDropDown(btn_popup_menu)
    }

    private fun showCenterPw(gravity: Int) {
        //设置整个屏幕阴影
        Utils.backgroundAlpha(this,0.5f)
        //没有背景色,点击外部可以消失
        val contentView = layoutInflater.inflate(R.layout.pw_center, null)
        val popup = PopupWindow(contentView,
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)
        //对整个 popupwindow 设置背景
        //popup.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this,R.color.red)))

        popup.showAtLocation(window.decorView,gravity,0,0)

        popup.setOnDismissListener {
            Utils.backgroundAlpha(this,1f)
        }
    }
}