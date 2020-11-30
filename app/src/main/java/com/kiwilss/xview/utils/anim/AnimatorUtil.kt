package com.kiwilss.xview.utils.anim


import android.view.View
import android.view.animation.AccelerateInterpolator
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator

/**
 * Created by chenxz on 2018/5/13.
 */
object AnimatorUtil {


    const val ALPHA = "alpha"
    const val SCALE_X = "scaleX"
    const val SCALE_Y = "scaleY"
    const val ROTATION = "rotation"
    const val ROTATION_X = "rotationX"
    const val ROTATION_Y = "rotationY"
    const val TRANSLATION_X = "translationX"
    const val TRANSLATION_Y = "translationY"




    private val FAST_OUT_SLOW_IN_INTERPOLATOR: LinearOutSlowInInterpolator by lazy {
        LinearOutSlowInInterpolator()
    }

    private val LINER_INTERPOLATOR: AccelerateInterpolator by lazy {
        AccelerateInterpolator()
    }

    /**
     * 显示View
     * @param view View
     * @param listener ViewPropertyAnimatorListener
     */
    fun scaleShow(view: View, listener: ViewPropertyAnimatorListener) {
        //view.visibility = View.VISIBLE
        ViewCompat.animate(view)
                .scaleX(1.0f)
                .scaleY(1.0f)
                .alpha(1.0f)
                .setDuration(200)
                .setListener(listener)
                .setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR)
                .start()
    }

    /**
     * 隐藏View
     * @param view View
     * @param listener ViewPropertyAnimatorListener
     */
    fun scaleHide(view: View, listener: ViewPropertyAnimatorListener) {
        ViewCompat.animate(view)
                .scaleX(0.0f)
                .scaleY(0.0f)
                .alpha(0.0f)
                .setDuration(500)
                .setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR)
                .setListener(listener)
                .start()
    }

    /**
     * 显示view
     *
     * @param view View
     * @param listener ViewPropertyAnimatorListener
     */
    fun translateShow(view: View, listener: ViewPropertyAnimatorListener) {
        view.visibility = View.VISIBLE
        ViewCompat.animate(view)
                .translationY(0f)
                .setDuration(400)
                .setListener(listener)
                .setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR)
                .start()
    }

    /**
     * 隐藏view
     *
     * @param view View
     * @param listener ViewPropertyAnimatorListener
     */
    fun translateHide(view: View, listener: ViewPropertyAnimatorListener) {
        view.visibility = View.VISIBLE
        ViewCompat.animate(view)
                .translationY(350f)
                .setDuration(400)
                .setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR)
                .setListener(listener)
                .start()
    }

}