package com.kiwilss.xview.utils.ktx

import android.content.Context
import android.content.Intent
import android.os.Bundle
import java.io.Serializable

/**
 *@FileName: IntentKtx
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/8
 * @desc   : {DESCRIPTION}
 */
object IntentKtx {


    inline fun <reified T>Context.startActivity2(vararg params: Pair<String, Any?>?){
       val bundle = Bundle()
        params.forEach {
            when (it?.second) {
                is String -> {
                    bundle.putString(it.first, it.second as String)
                }
                is Int -> {
                    bundle.putInt(it.first, it.second as Int)
                }
                is Long -> {
                    bundle.putLong(it.first, it.second as Long)
                }
                else -> {
                    bundle.putSerializable(it?.first, it?.second as Serializable?)
                }
            }
        }
        val intent = Intent(this,T::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }


}