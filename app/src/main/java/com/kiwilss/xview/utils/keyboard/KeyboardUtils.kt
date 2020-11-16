package com.kiwilss.xview.utils.keyboard

import android.R
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Rect
import android.os.*
import android.util.Log
import android.view.*
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import com.kiwilss.xview.utils.KeyboardUtils2
import com.kiwilss.xview.utils.Utils
import com.kiwilss.xview.utils.Utils.getApp

/**
 *@FileName: KeyboardUtils
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/11/15
 * @desc   : {DESCRIPTION}
 */
object KeyboardUtils {
    private var millis: Long = 0
    private var sDecorViewDelta = 0
    private const val TAG_ON_GLOBAL_LAYOUT_LISTENER = -8

    //显示软键盘相关
    /**
     * Show the soft input.
     */
    fun showSoftInput() {
        val imm = Utils.getContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager ?: return
        imm.toggleSoftInput(
            InputMethodManager.SHOW_FORCED,
            InputMethodManager.HIDE_IMPLICIT_ONLY
        )
    }

    /**
     * Show the soft input.
     */
    fun showSoftInput(activity: Activity) {
        if (!KbUtils.isSoftInputVisible(activity)) {
            KbUtils.toggleSoftInput()
        }
    }

    /**
     * Show the soft input.
     *
     * @param view The view.
     */
    fun showSoftInput(view: View) {
        showSoftInput(view, 0)
    }

    /**
     * Show the soft input.
     *
     * @param view  The view.
     * @param flags Provides additional operating flags.  Currently may be
     * 0 or have the [InputMethodManager.SHOW_IMPLICIT] bit set.
     */
    fun showSoftInput(view: View, flags: Int) {
        val imm =
            Utils.getContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager ?: return
        view.isFocusable = true
        view.isFocusableInTouchMode = true
        view.requestFocus()
        imm.showSoftInput(view, flags, object : ResultReceiver(Handler()) {
            override fun onReceiveResult(resultCode: Int, resultData: Bundle) {
                if (resultCode == InputMethodManager.RESULT_UNCHANGED_HIDDEN
                    || resultCode == InputMethodManager.RESULT_HIDDEN
                ) {
                    KbUtils.toggleSoftInput()
                }
            }
        })
        imm.toggleSoftInput(
            InputMethodManager.SHOW_FORCED,
            InputMethodManager.HIDE_IMPLICIT_ONLY
        )
    }


    /**
     * Toggle the soft input display or not.即使已经显示了键盘,调用以后会先隐藏键盘再显示
     */
    fun toggleSoftInput() {
        val imm =
            getApp()
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                ?: return
        imm.toggleSoftInput(0, 0)
    }

    /**
     * Hide the soft input.
     *
     * @param activity The activity.
     */
    fun hideSoftInputByToggle(activity: Activity?) {
        val nowMillis = SystemClock.elapsedRealtime()
        val delta = nowMillis - millis
        if (Math.abs(delta) > 500 && KbUtils.isSoftInputVisible(activity!!)) {
            KbUtils.toggleSoftInput()
        }
        millis = nowMillis
    }


    /**
     * Hide the soft input.
     *
     * @param activity The activity.
     */
    fun hideSoftInput(activity: Activity) {
        hideSoftInput(activity.window)
    }

    /**
     * Hide the soft input.
     *
     * @param window The window.
     */
    fun hideSoftInput(window: Window) {
        var view = window.currentFocus
        if (view == null) {
            val decorView = window.decorView
            val focusView =
                decorView.findViewWithTag<View>("keyboardTagView")
            if (focusView == null) {
                view = EditText(window.context)
                view.setTag("keyboardTagView")
                (decorView as ViewGroup).addView(view, 0, 0)
            } else {
                view = focusView
            }
            view.requestFocus()
        }
        hideSoftInput(view)
    }

    /**
     * Hide the soft input.
     *
     * @param view The view.
     */
    fun hideSoftInput(view: View) {
        val imm =
            Utils.getContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                ?: return
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


    /**
     * Return whether soft input is visible.
     *
     * @param activity The activity.
     * @return `true`: yes<br></br>`false`: no
     */
    fun isSoftInputVisible(activity: Activity): Boolean {
        return getDecorViewInvisibleHeight(activity.window) > 0
    }


    private fun getDecorViewInvisibleHeight(window: Window): Int {
        val decorView = window.decorView
        val outRect = Rect()
        decorView.getWindowVisibleDisplayFrame(outRect)
        val delta = Math.abs(decorView.bottom - outRect.bottom)
        if (delta <= UtilsBridge.getNavBarHeight() + UtilsBridge.getStatusBarHeight()) {
            sDecorViewDelta = delta
            return 0
        }
        return delta - sDecorViewDelta
    }

    /**
     * Register soft input changed listener.
     *
     * @param activity The activity.
     * @param listener The soft input changed listener.
     */
    fun registerSoftInputChangedListener(
        activity: Activity,
        listener: OnSoftInputChangedListener
    ) {
        registerSoftInputChangedListener(activity.window, listener)
    }

    /**
     * Register soft input changed listener.
     *
     * @param window   The window.
     * @param listener The soft input changed listener.
     */
    fun registerSoftInputChangedListener(
        window: Window,
        listener: OnSoftInputChangedListener
    ) {
        val flags = window.attributes.flags
        if (flags and WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS != 0) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
        val contentView = window.findViewById<FrameLayout>(R.id.content)
        val decorViewInvisibleHeightPre =
            intArrayOf(getDecorViewInvisibleHeight(window))
        val onGlobalLayoutListener = OnGlobalLayoutListener {
            val height = getDecorViewInvisibleHeight(window)
            if (decorViewInvisibleHeightPre[0] != height) {
                listener.onSoftInputChanged(height)
                decorViewInvisibleHeightPre[0] = height
            }
        }
        contentView.viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener)
        contentView.setTag(TAG_ON_GLOBAL_LAYOUT_LISTENER, onGlobalLayoutListener)
    }

    /**
     * Unregister soft input changed listener.
     *
     * @param window The window.
     */
    fun unregisterSoftInputChangedListener(window: Window) {
        val contentView =
            window.findViewById<View>(R.id.content) ?: return
        val tag = contentView.getTag(TAG_ON_GLOBAL_LAYOUT_LISTENER)
        if (tag is OnGlobalLayoutListener) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                contentView.viewTreeObserver
                    .removeOnGlobalLayoutListener(tag)
            }
        }
    }

    /**
     * Fix the bug of 5497 in Android.
     *
     * Don't set adjustResize
     *
     * @param activity The activity.
     */
    fun fixAndroidBug5497(activity: Activity) {
        fixAndroidBug5497(activity.window)
    }

    /**
     * Fix the bug of 5497 in Android.
     *
     * It will clean the adjustResize
     *
     * @param window The window.
     */
    fun fixAndroidBug5497(window: Window) {
        val softInputMode = window.attributes.softInputMode
        window.setSoftInputMode(softInputMode and WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE.inv())
        val contentView = window.findViewById<FrameLayout>(R.id.content)
        val contentViewChild = contentView.getChildAt(0)
        val paddingBottom = contentViewChild.paddingBottom
        val contentViewInvisibleHeightPre5497 =
            intArrayOf(getContentViewInvisibleHeight(window))
        contentView.viewTreeObserver
            .addOnGlobalLayoutListener {
                val height = getContentViewInvisibleHeight(window)
                if (contentViewInvisibleHeightPre5497[0] != height) {
                    contentViewChild.setPadding(
                        contentViewChild.paddingLeft,
                        contentViewChild.paddingTop,
                        contentViewChild.paddingRight,
                        paddingBottom + getDecorViewInvisibleHeight(window)
                    )
                    contentViewInvisibleHeightPre5497[0] = height
                }
            }
    }

    private fun getContentViewInvisibleHeight(window: Window): Int {
        val contentView =
            window.findViewById<View>(R.id.content) ?: return 0
        val outRect = Rect()
        contentView.getWindowVisibleDisplayFrame(outRect)
        Log.d(
            "KeyboardUtils", "getContentViewInvisibleHeight: "
                    + (contentView.bottom - outRect.bottom)
        )
        val delta = Math.abs(contentView.bottom - outRect.bottom)
        return if (delta <= UtilsBridge.getStatusBarHeight() + UtilsBridge.getNavBarHeight()) {
            0
        } else delta
    }

    /**
     * Fix the leaks of soft input.
     *
     * @param activity The activity.
     */
    fun fixSoftInputLeaks(activity: Activity) {
        fixSoftInputLeaks(activity.window)
    }

    /**
     * Fix the leaks of soft input.
     *
     * @param window The window.
     */
    fun fixSoftInputLeaks(window: Window) {
        val imm =
            getApp()
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                ?: return
        val leakViews =
            arrayOf("mLastSrvView", "mCurRootView", "mServedView", "mNextServedView")
        for (leakView in leakViews) {
            try {
                val leakViewField =
                    InputMethodManager::class.java.getDeclaredField(
                        leakView
                    )
                if (!leakViewField.isAccessible) {
                    leakViewField.isAccessible = true
                }
                val obj = leakViewField[imm] as? View ?: continue
                if (obj.rootView === window.decorView.rootView) {
                    leakViewField[imm] = null
                }
            } catch (ignore: Throwable) { /**/
            }
        }
    }

    // interface
    ///////////////////////////////////////////////////////////////////////////
    interface OnSoftInputChangedListener {
        fun onSoftInputChanged(height: Int)
    }

    /**
     * 软键盘以覆盖当前界面的形式出现
     *
     * @param activity
     */
    fun setSoftInputAdjustNothing(activity: Activity) {
        activity.window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING
                    or WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
        )
    }

    /**
     * 软键盘以顶起当前界面的形式出现, 注意这种方式会使得当前布局的高度发生变化，触发当前布局onSizeChanged方法回调，这里前后高度差就是软键盘的高度了
     *
     * @param activity
     */
    fun setSoftInputAdjustResize(activity: Activity) {
        activity.window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                    or WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
        )
    }

    /**
     * 软键盘以上推当前界面的形式出现, 注意这种方式不会改变布局的高度
     *
     * @param activity
     */
    fun setSoftInputAdjustPan(activity: Activity) {
        activity.window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN
                    or WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
        )
    }

    /**
     * 禁用物理返回键
     *
     *
     * 使用方法：
     *
     * 需重写 onKeyDown
     *
     * @param keyCode
     * @return
     * @Override public boolean onKeyDown(int keyCode, KeyEvent event) {
     * return KeyboardUtils.onDisableBackKeyDown(keyCode) && super.onKeyDown(keyCode, event) ;
     * }
     */
    fun onDisableBackKeyDown(keyCode: Int): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_BACK -> return false
            KeyEvent.KEYCODE_HOME -> return false
            else -> {
            }
        }
        return true
    }


    /**
     * 点击屏幕空白区域隐藏软键盘
     *
     * 根据 EditText 所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
     *
     * 需重写 dispatchTouchEvent
     *
     * @param ev
     * @param activity 窗口
     * @return
     */
    fun dispatchTouchEvent(ev: MotionEvent?, activity: Activity) {
        if (ev == null) return
        if (ev.action == MotionEvent.ACTION_DOWN) {
            val v = activity.currentFocus
            if (isShouldHideKeyboard(v, ev)) {
                KeyboardUtils2.hideSoftInput(v)
            }
        }
    }

    /**
     * 点击屏幕空白区域隐藏软键盘
     *
     * 根据 EditText 所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
     *
     * 需重写 dispatchTouchEvent
     *
     * @param ev
     * @param dialog 窗口
     * @return
     */
    fun dispatchTouchEvent(ev: MotionEvent?, dialog: Dialog) {
        if (ev == null) return
        if (ev.action == MotionEvent.ACTION_DOWN) {
            val v = dialog.currentFocus
            if (isShouldHideKeyboard(v, ev)) {
                KeyboardUtils2.hideSoftInput(v)
            }
        }
    }

    /**
     * 点击屏幕空白区域隐藏软键盘
     *
     * 根据 EditText 所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
     *
     * 需重写 dispatchTouchEvent
     *
     * @param ev
     * @param focusView 聚焦的view
     * @return
     */
    fun dispatchTouchEvent(ev: MotionEvent?, focusView: View?) {
        if (ev == null) return
        if (ev.action == MotionEvent.ACTION_DOWN) {
            if (isShouldHideKeyboard(focusView, ev)) {
                KeyboardUtils2.hideSoftInput(focusView)
            }
        }
    }

    /**
     * 点击屏幕空白区域隐藏软键盘
     *
     * 根据 EditText 所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
     *
     * 需重写 dispatchTouchEvent
     *
     * @param ev
     * @param window 窗口
     * @return
     */
    fun dispatchTouchEvent(ev: MotionEvent?, window: Window) {
        if (ev == null) return
        if (ev.action == MotionEvent.ACTION_DOWN) {
            val v = window.currentFocus
            if (isShouldHideKeyboard(v, ev)) {
                KeyboardUtils2.hideSoftInput(v)
            }
        }
    }

    /**
     * 根据 EditText 所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
     *
     * @param v
     * @param event
     * @return
     */
    private fun isShouldHideKeyboard(v: View?, event: MotionEvent): Boolean {
        if (v != null && v is EditText) {
            val l = intArrayOf(0, 0)
            v.getLocationInWindow(l)
            val left = l[0]
            val top = l[1]
            val bottom = top + v.getHeight()
            val right = left + v.getWidth()
            return !(event.x > left && event.x < right && event.y > top && event.y < bottom)
        }
        return false
    }


}