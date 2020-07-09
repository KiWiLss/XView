/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: DiffCallback
 * Author:   kiwilss
 * Date:     2020/7/8 23:12
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.main

import android.annotation.SuppressLint
import android.text.TextUtils
import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.kiwilss.xview.model.main.MainBean

/**
 *@FileName: DiffCallback
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/7/8
 * @desc   : {DESCRIPTION}
 */
class DiffCallback : DiffUtil.ItemCallback<MainBean>() {
    override fun areItemsTheSame(oldItem: MainBean, newItem: MainBean): Boolean {
        val equals = TextUtils.equals(oldItem.title, newItem.title)
        val b = oldItem.title == newItem.title
        Log.e("MMM", ": areItems--$equals" )
        Log.e("MMM", ": areItems---b--$b" )
        return equals
        //return oldItem.title == newItem.title
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: MainBean, newItem: MainBean): Boolean {
        val b = (TextUtils.equals(oldItem.title, newItem.title)
                && (oldItem.activity == newItem.activity))

        val classB = oldItem.activity?.equals(newItem.activity)
        Log.e("MMM", ": areContent--$b" )
        Log.e("MMM", ": areContent---class--$classB" )
        return b
    }
}