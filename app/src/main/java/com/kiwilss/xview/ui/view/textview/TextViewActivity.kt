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

import android.graphics.BlurMaskFilter
import android.os.Bundle
import android.text.Spanned.SPAN_INCLUSIVE_EXCLUSIVE
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.kiwilss.xview.R
import com.kiwilss.xview.utils.view.SpannableStringUtils
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
//        val create = SpannableStringUtils.getBuilder("测试一下")
//            .setBlur(10f,BlurMaskFilter.Blur.NORMAL).create()
//        tv_textview_test.text = create
        val create1 = SpannableStringUtils.getBuilder("普通样式的文字,加粗")
            .setBold()
            .create()
        tv_textview_blod.text = create1

        val create2 = SpannableStringUtils.getBuilder("普通样式的文字,加粗倾斜")
            .setBoldItalic()
            .create()
        tv_textview_blodItalic.text = create2

        val create3 = SpannableStringUtils.getBuilder("普通样式的文字,下划线")
            .setUnderline()
            .create()
        tv_textview_three.text = create3

        val create4 = SpannableStringUtils.getBuilder("普通样式的文字,设置标识")
            .setFlag(SPAN_INCLUSIVE_EXCLUSIVE)
            .create()
        tv_textview_4.text = create4

        val create5 = SpannableStringUtils.getBuilder("普通样式的文字,设置foregroundcolor")
            .setForegroundColor(ContextCompat.getColor(this,R.color.red))
            .create()
        tv_textview_5.text = create5

        val create6 = SpannableStringUtils.getBuilder("普通样式的文字,设置backgroundcolor")
            .setBackgroundColor(ContextCompat.getColor(this,R.color.red))
            .create()
        tv_textview_6.text = create6

        val create7 = SpannableStringUtils.getBuilder("普通样式的文字,设置引用线颜色")
            .setQuoteColor(ContextCompat.getColor(this,R.color.red))
            .create()
        tv_textview_7.text = create7

        val create8 = SpannableStringUtils.getBuilder("普通样式的文字,设置列表标记")
            .setBullet(20,ContextCompat.getColor(this,R.color.red))
            .create()
        tv_textview_8.text = create8

        val create9 = SpannableStringUtils.getBuilder("普通样式的文字,设置字体比例")
            .setProportion(2f)
            .create()
        tv_textview_9.text = create9

        val create10 = SpannableStringUtils.getBuilder("普通样式的文字,设置字体横向比例")
            .setXProportion(2f)
            .create()
        tv_textview_10.text = create10

        val create11 = SpannableStringUtils.getBuilder("普通样式的文字,设置删除线")
            .setStrikethrough()
            .create()
        tv_textview_11.text = create11

        val create12 = SpannableStringUtils.getBuilder("普通样式的文字,设置上标")
            .setSuperscript()
            .create()
        tv_textview_12.text = create12

        val create13 = SpannableStringUtils.getBuilder("普通样式的文字,设置下标")
            .setSuperscript()
            .create()
        tv_textview_13.text = create13

        //设置了图片以后就没有文字了
        val create14 = SpannableStringUtils.getBuilder("普通样式的文字,设置图片")
            .setResourceId(R.mipmap.ic_launcher)
            .create()
        //tv_textview_14.text = create14

        //没什么效果,可能用法不对
        tv_textview_15.movementMethod = LinkMovementMethod.getInstance()
        val create15 = SpannableStringUtils.getBuilder("普通样式的文字,设置点击")
            .setClickSpan(object :ClickableSpan(){
                override fun onClick(widget: View) {
                    Toast.makeText(this@TextViewActivity, "hello", Toast.LENGTH_SHORT).show()
                }
            })
            .create()
        tv_textview_15.text = create15

        val create16 = SpannableStringUtils.getBuilder("普通样式的文字,设置超链接")
            .setForegroundColor(ContextCompat.getColor(this,R.color.red))
            .setUrl("https://www.baidu.com")
            .create()
        tv_textview_16.movementMethod = LinkMovementMethod.getInstance()
        tv_textview_16.text = create16
        tv_textview_16.setTextColor(ContextCompat.getColor(this,R.color.red))
//        tv_textview_16.setOnClickListener {
//            Toast.makeText(this@TextViewActivity, "hello", Toast.LENGTH_SHORT).show()
//        }

    }
}