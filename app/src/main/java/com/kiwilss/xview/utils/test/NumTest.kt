package com.kiwilss.xview.utils.test

import com.kiwilss.xview.utils.test.NumTest.string2Bean
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.NumberFormat

/**
 * @author : Lss Administrator
 * @FileName: NumTest
 * @e-mail : kiwilss@163.com
 * @time : 2020/11/16
 * @desc : {DESCRIPTION}
 */
object NumTest {

    const val five = "#0.00000"
    const val four = "#0.0000"
    const val two = "#0.00"

    /**
     * stirng -> double
     * 整数默认会有一位小数,90 -->  90.0
     * 有小数有多少位显示多少位, 90.023 --> 90.023
     * 90.00会保留一位 --->  90.0
     */
    fun string2Double(string: String?): Double? {
        if (string.isNullOrEmpty()) {
            return null
        }
        return string.toDouble()
    }

    fun getDoubleFormat(pattern: String): DecimalFormat {
        return DecimalFormat(pattern)
    }

    /**
     * 默认保留2位,会四舍五入
     * string: 传入的数字
     * pattern: 转成double类型格式
     */
    fun string2StringRound(string: String?, pattern: String = two): String {
        if (string.isNullOrEmpty()) {
            return ""
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
    fun double2StringRound(dd: Double?, pattern: String = two): String {
        if (dd == null) {
            return ""
        }
        val doubleFormat = getDoubleFormat(pattern)
        return doubleFormat.format(dd)
    }


    /**
     * double --> string 保留dig位,不四舍五入
     * d: 数据源
     * dig: 保留小数点后几位
     */
    fun double2String(d: Double?, dig: Int = 2): String {
        if (d == null) {
            return ""
        }
        val doubleFormat = getDoubleFormat(five)
        val result = doubleFormat.format(d)

        var index = result.indexOf(".")
        if (index > result.length) {
            index = result.length
        }
        var end = index + dig + 1
        if (end > result.length) {
            end = result.length
        }
        return result.subSequence(0, end).toString()
    }

    /**
     * string --> string 保留dig位,不四舍五入
     * d: 数据源
     * dig: 保留小数点后几位
     */
    fun string2String(string: String?, dig: Int = 2): String {
        if (string.isNullOrEmpty()) {
            return ""
        }
        val dd = string2Double(string)
        return double2String(dd, dig)
    }

    /**
     * doulble  ---->  string
     * .0 会去除掉
    */
    fun doubleWipeZero(double: Double?): String{
        if (double == null){
            return ""
        }
        val decimalFormat =
            DecimalFormat("###################.###########")
        return decimalFormat.format(double)
    }

    fun string2Bean(string: String?): String {
        if (string.isNullOrEmpty()) {
            return ""
        }
        val num = string.toDouble()
        return if (num < 100) {
            (num * 100).toInt().toString()
        } else {
            val bean = num * 100
            val d = bean / 10000
            doubleWipeZero(d) + "万"
        }
    }

    fun convertRate2Decimal(rate: Double?): String? {
        if (rate == null) {
            return null
        }
        val nf: NumberFormat = NumberFormat.getPercentInstance()
        nf.maximumFractionDigits = 2 // 设置保留小数位
        nf.roundingMode = RoundingMode.HALF_UP // 设置舍入模式
        return nf.format(rate)
    }

}

fun main() {
    println(NumTest.doubleWipeZero(1.02))
    println(NumTest.doubleWipeZero(1.00))
    println(NumTest.doubleWipeZero(1.0))
    println("-----------------------")
    println(NumTest.string2String("1"))
    println(NumTest.string2String("1.0"))
    println(NumTest.string2String("1.00"))
    println(NumTest.string2String("0.00"))
    println(NumTest.string2String("0.0"))
    println(NumTest.string2String("0.003"))
    println("-----------------------")
    println(NumTest.string2StringRound("1"))
    println(NumTest.string2StringRound("1.04"))
    println(NumTest.string2StringRound("1.006"))
    println(NumTest.string2StringRound("0.00"))
    println(NumTest.string2StringRound("0.0"))
    println(NumTest.string2StringRound("0.003"))
    println(NumTest.string2StringRound("0.006"))


}