/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: UiModelTest
 * Author:   kiwilss
 * Date:     2020/7/5 21:12
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui

import java.sql.SQLOutput

/**
 *@FileName: UiModelTest
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/7/5
 * @desc   : {DESCRIPTION}
 */
class UiModelTest {
    //testb


}

fun main() {

    //for  迭代器
    val numbers = listOf("one", "two", "three", "four")
    val iterator = numbers.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }


    println("--------------------------")
    for (index in numbers.indices) {
        println("index = $index , value = ${numbers[index]}")
    }
    println("--------------------------")
    for (item in numbers) {
        println(item)
    }
    for ((index,element) in numbers.withIndex()){
        println("index=$index --- element=$element")
    }
    println("--------------------------")
    numbers.forEach {
        println(it)
    }
    println("--------------------------")
    numbers.filter {
        it.contains("two")//符合条件的保留
    }.forEach {
     println(it)
    }



}