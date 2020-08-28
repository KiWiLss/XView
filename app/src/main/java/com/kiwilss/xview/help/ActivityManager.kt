package com.kiwilss.xview.help

import android.app.Activity
import com.kiwilss.xview.utils.LogUtils
import java.lang.Exception
import java.lang.ref.WeakReference
import java.util.*
import kotlin.system.exitProcess

/**
 *@FileName: ActivityHelp
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/28
 * @desc   : {DESCRIPTION}
 */
class ActivityManager private constructor() {

    //private val mActivityList = LinkedList<Activity>()
    private val mActivityStack: Stack<WeakReference<Activity>> = Stack()

    private object ActivityHelpSingle {
        val activityHelp = ActivityManager()
    }

    companion object {
        val instance = ActivityHelpSingle.activityHelp
    }

    /**
     * 添加Activity到栈
     */
    fun addActivity(activity: Activity?) {
        activity?.let {
            mActivityStack.add(WeakReference(activity))
        }
    }

    /**
     * 检查弱引用是否释放，若释放，则从栈中清理掉该元素
     */
    fun checkWeakReference() {
        val iterator = mActivityStack.iterator()
        // 使用迭代器进行安全删除
        while (iterator.hasNext()) {
            val next: WeakReference<Activity> = iterator.next()
            val activity: Activity? = next.get()
            if (activity == null) {
                iterator.remove()
            }
        }
    }

    /**
     *获取当前Activity（栈中最后一个压入的）
     */
    fun getCurrentActivity(): Activity? {
        checkWeakReference()
        if (mActivityStack.isNotEmpty()) {
            return mActivityStack.lastElement().get()
        }
        return null
    }

    /**
     *关闭当前Activity（栈中最后一个压入的）
     */
    fun finishCurrentActivity() {
        val currentActivity = getCurrentActivity()
        currentActivity?.run {
            if (!isFinishing){
                finish()
            }
        }
    }

    /**
     * 关闭指定的Activity
     */
    fun finishActivity(activity: Activity?) {
        activity?.let {
            // 使用迭代器进行安全删除
            val iterator = mActivityStack.iterator()
            while (iterator.hasNext()) {
                val weakReference = iterator.next()
                val temp = weakReference.get()
                if (temp == null) {
                    iterator.remove()
                    continue
                }
                if (temp == it) {
                    iterator.remove()
                }
            }
            if (!it.isFinishing){
                it.finish()
            }
        }
    }

    /**
     * 关闭指定的Activity
     */
    fun finishActivity(clazz: Class<*>?) {
        clazz?.run {
            // 使用迭代器进行安全删除
            val iterator = mActivityStack.iterator()
            while (iterator.hasNext()) {
                val weakReference = iterator.next()
                val temp = weakReference.get()
                if (temp == null) {
                    iterator.remove()
                    continue
                }
                if (temp.javaClass == this) {
                    iterator.remove()
                    if (temp.isFinishing){
                        temp.finish()
                    }
                }
            }
        }
    }

    /**
     *关闭所有activity
     */
    fun finishAll() {
        for (weak in mActivityStack) {
            val activity = weak.get()
            activity?.run {
                if (!isFinishing){
                    finish()
                }
            }
        }
        mActivityStack.clear()
    }

    /**
     * 退出应用程序
     */
    fun exitApp() {
        try {
            finishAll()
            // 退出JVM,释放所占内存资源,0表示正常退出
            //exitProcess(0)
            // 从系统中kill掉应用程序
            //android.os.Process.killProcess(android.os.Process.myPid())
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    /**
     * 只移除,不做关闭操作
    */
    fun removeActivity(activity: Activity?) {
        activity?.let {
            val iterator = mActivityStack.iterator()
            while (iterator.hasNext()) {
                val weakReference = iterator.next()
                val temp = weakReference.get()
                if (temp == null){
                    iterator.remove()
                    continue
                }
                if (temp == activity){
                    iterator.remove()
                }
            }
        }
    }

    fun getList(){
        LogUtils.e(mActivityStack.size)
    }

}