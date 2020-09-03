package com.kiwilss.xview.utils

import java.math.BigDecimal
import java.text.DecimalFormat
import kotlin.math.roundToInt

/**
 *@FileName: MathUtils
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/3
 * @desc   : {https://blog.csdn.net/hcwbr123/article/details/77895914}
 */



fun double2String(value: Double): String?{
    val df = DecimalFormat("#0.00")
    return df.format(value)
}

fun double2String2(value: Double): String? {//会四舍五入
    val df = DecimalFormat("#####0.00")
    return df.format(value)
}

fun double2String3(value: Double): String?{
    return String.format("%.2f",value)
}
//BigDecimal.ROUND_HALF_UP四舍五入
//BigDecimal.ROUND_DOWN向下取
//BigDecimal.ROUND_UP向上取
fun double2String4(value: Double): String?{
   val bigDecimal = BigDecimal(value)
    return bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).toDouble().toString()
}



fun main() {
    val d = 2.34567
    val dd = 2.342456
    println(double2String2(d))//--> 2.35
    println(double2String2(dd))//--->2.34

    println(double2String(d))
    println(double2String(dd))

    println(double2String3(d))
    println("--------------------")
    println(double2String4(d))
    println(double2String4(dd))



}