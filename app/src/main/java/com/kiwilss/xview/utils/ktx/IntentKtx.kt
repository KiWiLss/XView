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
        val intent = Intent(this,T::class.java)
        params.forEach {
            when (it?.second) {
                is String -> {
                    intent.putExtra(it.first, it.second as String)
                }
                is Int -> {
                    intent.putExtra(it.first, it.second as Int)
                }
                is Long -> {
                    intent.putExtra(it.first, it.second as Long)
                }
                else -> {
                    intent.putExtra(it?.first, it?.second as Serializable?)
                }
            }
        }
        startActivity(intent)
    }


}