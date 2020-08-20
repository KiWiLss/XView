package com.kiwilss.xview.ui.startforresulthelp.help

import android.content.Intent
import android.os.Bundle
import android.util.SparseArray
import androidx.fragment.app.Fragment
import java.util.*

class RouterFragment : Fragment() {

    private val mCallbacks: SparseArray<ActivityHelper.Callback> =
        SparseArray<ActivityHelper.Callback>()

    private val mCodeGenerator: Random = Random()

    companion object{
        fun newInstance(): RouterFragment? {
            return RouterFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //防止重复创建
        retainInstance = true
    }

    fun  startActivityForResult(intent: Intent, callback: ActivityHelper.Callback){
        val requestCode = makeRequestCode()
        mCallbacks.put(requestCode,callback)
        startActivityForResult(intent,requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //处理返回的结果
        val callback = mCallbacks[requestCode]
        mCallbacks.remove(requestCode)
        callback?.run {
            onActivityResult(resultCode,data)
        }
    }
    /**
     * 随机生成唯一的requestCode，最多尝试10次
     * @return
     */
    private fun makeRequestCode(): Int {
        var requestCode: Int
        var tryCount = 0
        do {
            requestCode = mCodeGenerator.nextInt(0x0000FFFF)
            tryCount++
        } while (mCallbacks.indexOfKey(requestCode) >= 0 && tryCount < 10)
        return requestCode
    }
}