/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: TextViewActivity
 * Author:   kiwilss
 * Date:     2020/7/19 17:09
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.xview.ui.view.textview

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.text.bold
import com.kiwilss.xview.R
import com.kiwilss.xview.utils.test.SpannableStringUtils
import kotlinx.android.synthetic.main.activity_textview.*


/**
 *@FileName: TextViewActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/7/19
 * @desc   : {DESCRIPTION}
 */
class TextViewActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textview)

        val src = "普通样式的文字测试富文本部分加粗"
        val target1 = "样式"
        val target2 = "测试"
        //使用方法一
        val ss1 = SpannableStringUtils.Builder(src,target1)
            .isBold(true).build()
        //使用方法二
        val ss11 = SpannableStringUtils.ssb(src)
        SpannableStringUtils.isBold(ss11,target2)
        tv_textview_test.text = ss11

        val src2 = "普通样式的文字测试富文本全部加粗"
        val ss2 = SpannableStringUtils.Builder(src2)
            .isBold(true).build()
        tv_textview_blod.text = ss2

        val src3 = "普通样式的文字测试富文本多种效果"
        val target3 = "普通样式的文字"
        val ss3 = SpannableStringUtils.Builder(src3,target3)
            .isBoldItalic(true)
            .foregroundColor(R.color.red)
            .build()
        tv_textview_blodItalic.text = ss3

        val src4 = "普通样式的文字测试富文本多个部分设置效果"
        val target4 = "样式的"
        val target44 = "测试富文本"
        //设置 target4 部分
        val ss4 = SpannableStringUtils.Builder(src4,target4)
            .foregroundColor(R.color.red)
            .build()
        //再设置 target44 部分
        SpannableStringUtils.foregroundColor(ss4,target44,R.color.blue_74D3FF)
        tv_textview_three.text = ss4

        val src5 = "普通样式的文字测试富文本部分文字可点击效果"
        val target5 = "可点击效果"
        val ss5 = SpannableStringUtils.Builder(src5,target5)
            //.foregroundColor(R.color.red)
            .clickSpan(object : ClickableSpan(){
                override fun onClick(widget: View) {
                    //设置点击处理
                    Toast.makeText(this@TextViewActivity, "hello", Toast.LENGTH_SHORT).show()
                }

            })
            .build()
        //设置点击需要先添加view.setMovementMethod(LinkMovementMethod.getInstance())
        tv_textview_4.movementMethod = LinkMovementMethod.getInstance()
        tv_textview_4.text = ss5
//
//        val ssb1 = com.kiwilss.xview.utils.test.SpannableStringUtils.Builder(src, target1)
//            .foregroundColor(R.color.red)
//            .build()
//      com.kiwilss.xview.utils.test.SpannableStringUtils.foregroundColor(ssb1,target2,R.color.blue_74D3FF)
//      com.kiwilss.xview.utils.test.SpannableStringUtils.foregroundColor(ssb1,0,1,R.color.yellow_FF9B52)
//
//        tv_textview_test.text = ssb1
//
//        val build = com.kiwilss.xview.utils.test.
//        SpannableStringUtils
//            .Builder("普通样式的文字测试全部文字改变","改变")
//            .isBold(true)
////            .isStrikethrough(true)
////            .isUnderline(true)
//            .textSize(R.dimen.m15)
//            .foregroundColor(R.color.red)
////            .isSubscript(true)
////            .clickSpan(object : ClickableSpan(){
////                override fun onClick(widget: View) {
////                    LogUtils.e("span")
////                    Toast.makeText(this@TextViewActivity, "hello", Toast.LENGTH_SHORT).show()
////                }
////
////            })
//            .url("https://www.baidu.com")
//            .build()
//        build.setSpan(BackgroundColorSpan(
//            ContextCompat.getColor(this,R.color.yellow_FF9B52)), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//        tv_textview_blod.movementMethod = LinkMovementMethod.getInstance()
//        tv_textview_blod.text = build
//
////        val create1 = SpannableStringUtils.getBuilder("普通样式的文字,加粗")
////            .setBold()
////            .create()
////        tv_textview_blod.text = create1
//
//        val create2 = SpannableStringUtils.getBuilder("普通样式的文字,加粗倾斜")
//            .setBoldItalic()
//            .create()
//        tv_textview_blodItalic.text = create2
//
//        val create3 = SpannableStringUtils.getBuilder("普通样式的文字,下划线")
//            .setUnderline()
//            .create()
//        tv_textview_three.text = create3
//
//        val create4 = SpannableStringUtils.getBuilder("普通样式的文字,设置标识")
//            .setFlag(SPAN_INCLUSIVE_EXCLUSIVE)
//            .create()
//        tv_textview_4.text = create4
//
//        val create5 = SpannableStringUtils.getBuilder("普通样式的文字,设置foregroundcolor")
//            .setForegroundColor(ContextCompat.getColor(this,R.color.red))
//            .create()
//        tv_textview_5.text = create5
//
//        val create6 = SpannableStringUtils.getBuilder("普通样式的文字,设置backgroundcolor")
//            .setBackgroundColor(ContextCompat.getColor(this,R.color.red))
//            .create()
//        tv_textview_6.text = create6
//
//        val create7 = SpannableStringUtils.getBuilder("普通样式的文字,设置引用线颜色")
//            .setQuoteColor(ContextCompat.getColor(this,R.color.red))
//            .create()
//        tv_textview_7.text = create7
//
//        val create8 = SpannableStringUtils.getBuilder("普通样式的文字,设置列表标记")
//            .setBullet(20,ContextCompat.getColor(this,R.color.red))
//            .create()
//        tv_textview_8.text = create8
//
//        val create9 = SpannableStringUtils.getBuilder("普通样式的文字,设置字体比例")
//            .setProportion(2f)
//            .create()
//        tv_textview_9.text = create9
//
//        val create10 = SpannableStringUtils.getBuilder("普通样式的文字,设置字体横向比例")
//            .setXProportion(2f)
//            .create()
//        tv_textview_10.text = create10
//
//        val create11 = SpannableStringUtils.getBuilder("普通样式的文字,设置删除线")
//            .setStrikethrough()
//            .create()
//        tv_textview_11.text = create11
//
//        val create12 = SpannableStringUtils.getBuilder("普通样式的文字,设置上标")
//            .setSuperscript()
//            .create()
//        tv_textview_12.text = create12
//
//        val create13 = SpannableStringUtils.getBuilder("普通样式的文字,设置下标")
//            .setSuperscript()
//            .create()
//        tv_textview_13.text = create13
//
//        //设置了图片以后就没有文字了
//        val create14 = SpannableStringUtils.getBuilder("普通样式的文字,设置图片")
//            .setResourceId(R.mipmap.ic_launcher)
//            .create()
//        //tv_textview_14.text = create14
//
//        //没什么效果,可能用法不对
//        tv_textview_15.movementMethod = LinkMovementMethod.getInstance()
//        val create15 = SpannableStringUtils.getBuilder("普通样式的文字,设置点击")
//            .setClickSpan(object :ClickableSpan(){
//                override fun onClick(widget: View) {
//                    Toast.makeText(this@TextViewActivity, "hello", Toast.LENGTH_SHORT).show()
//                }
//            })
//            .create()
//        tv_textview_15.text = create15
//
//        val create16 = SpannableStringUtils.getBuilder("普通样式的文字,设置超链接普通样式的文字,设置超链接")
//            .setForegroundColor(ContextCompat.getColor(this,R.color.red))
//            .setLeadingMargin(2,0)
//            .setUrl("https://www.baidu.com")
//            .create()
//        tv_textview_16.movementMethod = LinkMovementMethod.getInstance()
//        tv_textview_16.text = create16
//        tv_textview_16.setTextColor(ContextCompat.getColor(this,R.color.red))
////        tv_textview_16.setOnClickListener {
////            Toast.makeText(this@TextViewActivity, "hello", Toast.LENGTH_SHORT).show()
////        }

    }
}