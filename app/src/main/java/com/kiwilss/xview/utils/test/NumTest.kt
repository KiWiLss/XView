package com.kiwilss.xview.utils.test

import java.math.BigDecimal
import java.text.DecimalFormat

/**
 * @author : Lss Administrator
 * @FileName: NumTest
 * @e-mail : kiwilss@163.com
 * @time : 2020/11/16
 * @desc : {DESCRIPTION}
 */
object NumTest{

    const val five = "#.00000"
    const val four = "#.0000"
    const val two = "#.00"

    /**
     * stirng -> double
     * 整数默认会有一位小数,90 -->  90.0
     * 有小数有多少位显示多少位, 90.023 --> 90.023
     * 90.00会保留一位 --->  90.0
    */
    fun string2Double(string: String?): Double?{
        if (string.isNullOrEmpty()) {
            return null
        }
        return string.toDouble()
    }

    fun getDoubleFormat(pattern: String): DecimalFormat{
        return DecimalFormat(pattern)
    }

    /**
     * 默认保留2位,会四舍五入
     * string: 传入的数字
     * pattern: 转成double类型格式
    */
    fun string2String(string: String?,pattern: String = two): String?{
        if (string.isNullOrEmpty()) {
            return null
        }
        val dd = string2Double(string)
        val doubleFormat = getDoubleFormat(pattern)
        return doubleFormat.format(dd)
    }
    /**
     * 默认保留2位,会四舍五入
     * dd: 传入的数字
     * pattern: 转成double类型格式
     */
    fun double2String(dd: Double?, pattern: String = two): String?{
        if (dd == null){
            return null
        }
        val doubleFormat = getDoubleFormat(pattern)
        return doubleFormat.format(dd)
    }


    /**
     * double --> string 保留dig位,不四舍五入
     * d: 数据源
     * dig: 保留小数点后几位
    */
    fun double2String(d: Double?, dig: Int): String?{
        if (d == null) {
            return null
        }
        val doubleFormat = getDoubleFormat(five)
        val result = doubleFormat.format(d)
        val index = result.indexOf(".")
         return result.subSequence(0, index + dig + 1).toString()
    }
    /**
     * string --> string 保留dig位,不四舍五入
     * d: 数据源
     * dig: 保留小数点后几位
     */
    fun string2String(string: String?, dig: Int): String?{
        if (string.isNullOrEmpty()) {
            return null
        }
        val dd = string2Double(string)
        return double2String(dd,dig)
    }




}

fun main() {

    println(NumTest.string2String("90"))
    println(NumTest.string2String("90.0"))
    println(NumTest.string2String("90.027"))
    println(NumTest.string2String("90.4567"))
    println("-------------------------")
//    println(NumTest.string2String("90"))
    //保留两位小数第三位如果大于4会进一位（四舍五入）

    //保留两位小数第三位如果大于4会进一位（四舍五入）
    val f: Double = 6.2569874
    var i = 7
    println(i.toDouble())
    println(NumTest.double2String(i.toDouble(), 3))
    println(NumTest.double2String(f, 2))
    println("-----------------------")
    println(NumTest.string2String("9",3))
    println(NumTest.string2String("2",2))
    println("------------")
    println(NumTest.double2String(3.2))
    println(NumTest.double2String(3.289))
    println(NumTest.double2String(3.4567))



}