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
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.view.popup.easy.TestEasy
import com.kiwilss.xview.ui.view.popup.easy.TestMenu
import com.kiwilss.xview.ui.view.popup.easy.Xpopup
import com.kiwilss.xview.ui.view.popup.popup.*
import com.kiwilss.xview.ui.view.popup.smart.HorizontalPosition
import com.kiwilss.xview.ui.view.popup.smart.SmartPopupWindow
import com.kiwilss.xview.ui.view.popup.smart.VerticalPosition
import com.kiwilss.xview.utils.LogUtils
import com.kiwilss.xview.utils.Utils
import kotlinx.android.synthetic.main.activity_popup.*
import kotlinx.android.synthetic.main.pw_center.view.*

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
        //22
        btn_popup_center2.setOnClickListener {
           // testSimplePopup()
          testSimplePopup2()
        }
        btn_popup_menu2.setOnClickListener {
            showMenuPw2()
        }
        btn_popup_menu3.setOnClickListener {
//             EasyPopup.create()
//                .setContentView(this, R.layout.pw_menu)
//                 .setBackgroundDimEnable(true)
//               // .setAnimationStyle(R.style.RightPopAnim)
//                //是否允许点击PopupWindow之外的地方消失
//                .setFocusAndOutsideEnable(true)
//                .apply()
//                 .showAtAnchorView(btn_popup_menu3, YGravity.BELOW, XGravity.CENTER)

//            val pp = LSimplePw(this)
//            //pp.setPopupWidth(ViewGroup.LayoutParams.WRAP_CONTENT)
//            pp.showAtAnchorView(btn_popup_menu3, YGravity.BELOW, XGravity.CENTER)
            val contentView = layoutInflater.inflate(R.layout.pw_menu,null)
            val popup = SmartPopupWindow.Builder.build(this,contentView)
                .setOutsideTouchDismiss(false)
                .createPopupWindow()
            popup.showAtAnchorView(btn_popup_menu3, VerticalPosition.ABOVE, HorizontalPosition.CENTER)

        }
        btn_popup_center4.setOnClickListener {
//            EasyPopup.create().setWidth(ViewGroup.LayoutParams.MATCH_PARENT)
//                .setContentView(this,R.layout.pw_center)
//                .setBackgroundDimEnable(true)
//                .apply().showAtLocation(window.decorView,Gravity.CENTER,0,0)
            val contentView = layoutInflater.inflate(R.layout.pw_center,null)
            val popup = SmartPopupWindow.Builder.build(this,contentView)
                //.setOutsideTouchDismiss(false)
                .setSize(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
                .setAlpha(0.4f)
                .createPopupWindow()
            popup.showAtLocation(btn_popup_menu3,Gravity.CENTER,0,0)
        }
        btn_popup_center5.setOnClickListener {
            val contentView = layoutInflater.inflate(R.layout.pw_center,null)
            val popup = SmartPopupWindow(this)
            popup.contentView = contentView
            popup.width = ViewGroup.LayoutParams.MATCH_PARENT
            popup.height = ViewGroup.LayoutParams.WRAP_CONTENT
            popup.showAtLocation(btn_popup_center5,Gravity.CENTER,0,0)
        }

        btn_popup_center3.setOnClickListener {
            val pp = SimpleBasePopup(activity = this,simpleBasePopup = object :SimpleBasePopupListener(){
                override fun sure(simpleBasePopup: SimpleBasePopup) {
                    simpleBasePopup.dismiss()
                }

                override fun cancel(simpleBasePopup: SimpleBasePopup) {
                    super.cancel(simpleBasePopup)
                }
            })
            //pp.setIsClickDismiss(false)
            pp.showCenter()
        }
        btn_popup_center6.setOnClickListener {
            val pp = TestEasy(this)
            pp.showCenter()
        }
        btn_popup_center7.setOnClickListener {
            val menu = TestMenu(this)
            menu.showAtAnchorView(btn_popup_center7,VerticalPosition.ABOVE,HorizontalPosition.CENTER)
        }
        btn_popup_centerRight.setOnClickListener {
            val menu = TestMenu(this)
            menu.showAtAnchorView(btn_popup_centerRight,VerticalPosition.CENTER,HorizontalPosition.RIGHT)
        }
        btn_popup_center8.setOnClickListener {
            val menu = TestMenu(this)
            menu.showMenu(btn_popup_center8)
        }
        //xpopup自定义对话框
        btn_popup_xpopup.setOnClickListener {
            Xpopup(this,R.layout.pw_center)
                .setIsMask(true)
                .showCenter()
        }
    }

    private fun showMenuPw2() {
        val menu = SimpleMenu(this,object : PopupListener(){
            override fun cancel(simplePopup2: SimplePopup2?) {
                Toast.makeText(this@PopupActivity, "hello", Toast.LENGTH_SHORT).show()
            }
        })
//        menu.showAsDropDown(btn_popup_menu2)
        menu.showMenu(btn_popup_menu2)
    }

    private fun testSimplePopup2() {
        val simplePopup2 = SimplePopup2(this,object :PopupListener(){
            override fun cancel(simplePopup2: SimplePopup2?) {
                simplePopup2?.dismiss()
            }

            override fun sure(simplePopup2: SimplePopup2?) {
                super.sure(simplePopup2)
                simplePopup2?.dismiss()
            }
        })
        simplePopup2.setIsMask(true)
        simplePopup2.setIsClickDismiss(false)
        simplePopup2.showCenter(this)
    }

    private fun testSimplePopup() {
        val simple = SimplePopup(this,object : PopupClickListener{
            override fun cancel(simplePopup: SimplePopup) {
                simplePopup.dismiss()
            }

            override fun sure(simplePopup: SimplePopup) {
                simplePopup.dismiss()
            }
        })
        simple.showCenter(this)
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
//        val popup = PopupWindow()
//        popup.contentView = contentView
//        popup.width = ViewGroup.LayoutParams.MATCH_PARENT
//        popup.height = ViewGroup.LayoutParams.WRAP_CONTENT
        val popup = PopupWindow(contentView,
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)
        //对整个 popupwindow 设置背景
        //popup.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this,R.color.red)))
        contentView.tv_pw_onetitle_title.text = "居中显示提示"
//        popup.isOutsideTouchable = false
//        popup.isFocusable = false
//        popup.isTouchable = true
        popup.showAtLocation(window.decorView,gravity,0,0)

        popup.setOnDismissListener {
            Utils.backgroundAlpha(this,1f)
        }
    }
}