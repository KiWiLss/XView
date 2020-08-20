package com.kiwilss.xview.ui.startforresulthelp.help

import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentActivity

class ActivityHelper private constructor(activity: FragmentActivity) {
    private val TAG = "ActivityLauncher"
    private var mContext: Context? = null
    private var mRouterFragment: RouterFragment? = null


    init {
        mContext = activity
        mRouterFragment = getRouterFragment(activity)
    }
    
    companion object{
        //private const val TAG = "ActivityLauncher"
        fun init(activity: FragmentActivity): ActivityHelper {
            return ActivityHelper(activity)
        }
    }


    private fun getRouterFragment(activity: FragmentActivity): RouterFragment? {
        var routerFragment: RouterFragment? = findRouterFragment(activity)
            if (routerFragment == null){
                //创建 fragment,加入当前 activity
                routerFragment = RouterFragment.newInstance()
                val sfm = activity.supportFragmentManager
                sfm.beginTransaction().add(routerFragment!!,TAG).commitAllowingStateLoss()
                sfm.executePendingTransactions()
        }
        return routerFragment
    }

    private fun findRouterFragment(activity: FragmentActivity): RouterFragment? {
        //通过 tag 获取 fragment
        return activity.supportFragmentManager.findFragmentByTag(TAG) as RouterFragment?
    }

    //跳转方法
     fun startActivityForResult(
        clazz: Class<*>,
        callback: ActivityHelper.Callback
    ) {
        val intent = Intent(mContext, clazz)
        startActivityForResult(intent, callback)
    }

    fun startActivityForResult(intent: Intent, callback: Callback){
        mRouterFragment?.run {
            startActivityForResult(intent, callback)
        }
    }

    interface Callback{
            fun onActivityResult(resultCode: Int, data: Intent?)
    }
}