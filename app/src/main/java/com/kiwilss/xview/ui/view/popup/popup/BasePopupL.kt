/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: BasePopup
 * Author:   Administrator
 * Date:     2020/8/5 17:33
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.popup.popup

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.view.WindowManager
import android.widget.PopupWindow
import androidx.core.widget.PopupWindowCompat


/**
 *@FileName: BasePopup
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/5
 * @desc   : {DESCRIPTION}
 */
abstract class BasePopupL(val activity: Activity, layout: Int) : PopupWindow(activity) {

    //宽高
    private var mWidth = ViewGroup.LayoutParams.MATCH_PARENT
    private var mHeight = ViewGroup.LayoutParams.WRAP_CONTENT


    private var isMask = true //背景是否有阴影
    private var wm: WindowManager? = null


    init {
        initType()
        activity.run {
            contentView = layoutInflater.inflate(layout,null)
            wm = activity.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            //设置相对固定位置宽高
            width = ViewGroup.LayoutParams.MATCH_PARENT
            height = ViewGroup.LayoutParams.WRAP_CONTENT
            //设置内容
            setContent(contentView)
            //默认设置点击外部区域消失
            setIsClickDismiss(true)
        }
    }

    abstract fun setContent(contentView: View)

    fun setIsMask(isMask: Boolean) {
        this.isMask = isMask
    }

    fun setPopupWidth(width: Int) {
        mWidth = width
        setWidth(width)
    }

    fun setPopupHeight(height: Int) {
        mHeight = height
        setHeight(height)
    }
    /**
     * 设置是否点击外部区域消失
     *
     * @param isDismiss
     */
    fun setIsClickDismiss(isDismiss: Boolean) {
        if (isDismiss) {
            isOutsideTouchable = true
            isFocusable = true
            setBackgroundDrawable(ColorDrawable())
        } else {
            isOutsideTouchable = false
            isFocusable = false
            isTouchable = true
        }
    }

    /**
     * 作为对话框显示
     * 显示在界面的底部
     */
    fun showBottom() {
        showAtLocation(
            activity.window.decorView,
            Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL,
            0,
            0
        )
    }


    fun showCenter() {
        showAtLocation(
            activity.window.decorView,
            Gravity.CENTER or Gravity.CENTER_HORIZONTAL,
            0,
            0
        )
    }


    fun showTop() {
        showAtLocation(
            activity.window.decorView,
            Gravity.TOP or Gravity.CENTER_HORIZONTAL,
            0,
            0
        )
    }


    override fun showAtLocation(
        parent: View,
        gravity: Int,
        x: Int,
        y: Int
    ) {
        super.showAtLocation(parent, gravity, x, y)
        if (isMask) {
            updateDimAmount(0.5f)
        }
    }

    /**
     * 灵活菜单位置设置
     */
    fun showMenu(anchor: View){
        showAsDropDown(anchor,0,0,Gravity.NO_GRAVITY)
    }
    fun showMenu(anchor: View, xoff: Int, yoff: Int){
        showAsDropDown(anchor,xoff,yoff,Gravity.NO_GRAVITY)
    }
    fun showMenu(anchor: View, xoff: Int, yoff: Int,gravity: Int){
        showAsDropDown(anchor,xoff,yoff,gravity)
    }
    override fun showAsDropDown(
        anchor: View,
        xoff: Int,
        yoff: Int,
        gravity: Int
    ) {
        width = ViewGroup.LayoutParams.WRAP_CONTENT
        mWidth = width
        super.showAsDropDown(anchor, xoff, yoff,gravity)
        if (isMask) {
            updateDimAmount(0.5f)
        }
    }


    override fun dismiss() {
        super.dismiss()
    }

    private fun updateDimAmount(dimAmount: Float) {
        val decorView: View? = getDecorView()
        decorView?.let {
            val p = decorView.layoutParams as WindowManager.LayoutParams
            p.flags = p.flags or WindowManager.LayoutParams.FLAG_DIM_BEHIND
            p.dimAmount = dimAmount
            //modifyWindowLayoutParams(p)
            wm?.updateViewLayout(decorView, p)
        }
    }

     private fun getDecorView(): View? {
        var decorView: View? = null
        try {
            decorView = if (background == null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    contentView.parent as View
                } else {
                    contentView
                }
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    contentView.parent.parent as View
                } else {
                    contentView.parent as View
                }
            }
        } catch (ignore: Exception) {
        }
        return decorView
    }

    private fun setScreenMaskView(alpha: Float) {
        val attributes = activity.window.attributes
        attributes.alpha = alpha
        activity.window.attributes = attributes
    }

    @TargetApi(23)
    private fun initType() {
        //  解决华为手机在home建进入后台后，在进入应用，蒙层出现在popupWindow上层的bug。
        //  android4.0及以上版本都有这个hide方法，根据jvm原理，可以直接调用，选择android6.0版本进行编译即可。
        windowLayoutType = WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL
    }
}