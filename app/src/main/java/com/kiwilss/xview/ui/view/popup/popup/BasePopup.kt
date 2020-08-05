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
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.PopupWindow

/**
 *@FileName: BasePopup
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/5
 * @desc   : {DESCRIPTION}
 */
abstract class BasePopup(val activity: Activity, layout: Int) : PopupWindow(activity) {

    private var isMask = true //背景是否有阴影

    init {
        initType()
        activity.run {
            contentView = layoutInflater.inflate(layout,null)
            //设置内容
            setContent(contentView)
            width = ViewGroup.LayoutParams.MATCH_PARENT
            height = ViewGroup.LayoutParams.WRAP_CONTENT
            //默认设置点击外部区域消失
            setIsClickDismiss(true)
        }
    }

    abstract fun setContent(contentView: View)

    fun setIsMask(isMask: Boolean) {
        this.isMask = isMask
    }

    fun setPopupWidth(width: Int) {
        setWidth(width)
    }

    fun setPopupHeight(height: Int) {
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

    fun showBottom(activity: Activity?) {
        if (activity != null) {
            showAtLocation(
                activity.window.decorView,
                Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL,
                0,
                0
            )
        }
    }

    fun showCenter() {
        showAtLocation(
            activity.window.decorView,
            Gravity.CENTER or Gravity.CENTER_HORIZONTAL,
            0,
            0
        )
    }

    fun showCenter(activity: Activity?) {
        if (activity != null) {
            showAtLocation(
                activity.window.decorView,
                Gravity.CENTER or Gravity.CENTER_HORIZONTAL,
                0,
                0
            )
        }
    }

    fun showTop() {
        showAtLocation(
            activity.window.decorView,
            Gravity.TOP or Gravity.CENTER_HORIZONTAL,
            0,
            0
        )
    }

    fun showTop(activity: Activity?) {
        if (activity != null) {
            showAtLocation(
                activity.window.decorView,
                Gravity.TOP or Gravity.CENTER_HORIZONTAL,
                0,
                0
            )
        }
    }

    override fun showAtLocation(
        parent: View,
        gravity: Int,
        x: Int,
        y: Int
    ) {
        if (isMask) {
            setScreenMaskView(0.5f)
        }
        super.showAtLocation(parent, gravity, x, y)
    }

    override fun showAsDropDown(
        anchor: View,
        xoff: Int,
        yoff: Int
    ) {
        width = ViewGroup.LayoutParams.WRAP_CONTENT
        if (isMask) {
            setScreenMaskView(0.5f)
        }
        super.showAsDropDown(anchor, xoff, yoff)
    }

    override fun showAsDropDown(anchor: View) {
        showAsDropDown(anchor, 0, 0)
    }

    override fun dismiss() {
        if (isMask) {
            setScreenMaskView(1f)
        }
        super.dismiss()
    }

    private fun setScreenMaskView(alpha: Float) {
        if (activity != null) {
            val attributes = activity!!.window.attributes
            attributes.alpha = alpha
            activity!!.window.attributes = attributes
        }
    }

    @TargetApi(23)
    private fun initType() {
        //  解决华为手机在home建进入后台后，在进入应用，蒙层出现在popupWindow上层的bug。
        //  android4.0及以上版本都有这个hide方法，根据jvm原理，可以直接调用，选择android6.0版本进行编译即可。
        windowLayoutType = WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL
    }
}