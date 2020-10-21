package com.kiwilss.xview.utils.test

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.kiwilss.App
import com.kiwilss.xview.utils.Utils


/**
 *@FileName: ResUtils
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/10/17
 * @desc   : {资源相关工具类}
 */
object ResUtils {

     private fun getContext() : Context = App.mContext!!
    /**
     * 获取resources对象
    */
    fun getResources() = getContext().resources
    /**
     * 获取资源Color值
     */
    fun getColor(@ColorRes resId: Int) = ContextCompat.getColor(getContext(),resId)

    /**
     * 获取资源String值
    */
    fun getString(@StringRes resId: Int) = getContext().resources.getString(resId)

    /**
     * 获取资源Drawable值
    */
    fun getDrawable(@DrawableRes resId: Int) =  ContextCompat.getDrawable(getContext(),resId)

    /**
     * 获取Drawable的数组
     *
     * @param context
     * @param resId
     * @return
     */
    fun getDrawableArray(
        context: Context?,
        @ArrayRes resId: Int
    ): Array<Drawable?>? {
        val ta = getResources().obtainTypedArray(resId)
        val icons = arrayOfNulls<Drawable>(ta.length())
        for (i in 0 until ta.length()) {
            val id = ta.getResourceId(i, 0)
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(context!!, id)
            }
        }
        ta.recycle()
        return icons
    }

    /**
     * 获取资源精确的dimens值
    */
    fun getDimens(@DimenRes resId: Int) = getContext().resources.getDimension(resId)

    //返回的是【去余取整】的值
    fun getDimensionPixelOffset(@DimenRes resId: Int) = getContext().resources.getDimensionPixelOffset(resId)
    //返回的是【4舍5入】的值
    fun getDimensionPixelSize(@DimenRes resId: Int) = getContext().resources.getDimensionPixelSize(resId)
    /**
     * 获取ColorStateList值
    */
    fun getColors(@ColorRes resId: Int) = ContextCompat.getColorStateList(getContext(),resId)

    /**
     * 获取字符串的数组
     *
     * @param resId
     * @return
     */
    fun getStringArray(@ArrayRes resId: Int): Array<String?>? {
        return getResources().getStringArray(resId)
    }


    /**
     * 获取Drawable属性（兼容VectorDrawable）
     *
     * @param context
     * @param typedArray
     * @param index
     * @return
     */
    fun getDrawableAttrRes(
        context: Context?,
        typedArray: TypedArray,
        @StyleableRes index: Int
    ): Drawable? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return typedArray.getDrawable(index)
        } else {
            val resourceId = typedArray.getResourceId(index, -1)
            if (resourceId != -1) {
                return AppCompatResources.getDrawable(context!!, resourceId)
            }
        }
        return null
    }

    /**
     * 获取数字的数组
     *
     * @param resId
     * @return
     */
    fun getIntArray(@ArrayRes resId: Int): IntArray? {
        return getResources().getIntArray(resId)
    }

    /**
     * 获取动画
     *
     * @param resId
     * @return
     */
    fun getAnim(@AnimRes resId: Int): Animation? {
        return AnimationUtils.loadAnimation(
            getContext(),
            resId
        )
    }

    /**
     * Check if layout direction is RTL
     *
     * @return `true` if the layout direction is right-to-left
     */
    fun isRtl(): Boolean {
        return getResources().configuration.layoutDirection == View.LAYOUT_DIRECTION_RTL
    }



}

//fun Any.color(@ColorRes colorRes: Int)  = ResUtils.getColor(colorRes)