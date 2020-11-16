package com.kiwilss.xview.utils.test

import android.graphics.Typeface
import android.text.Layout
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.*
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import com.kiwilss.xview.utils.LogUtils

/**
 *@FileName: SpannableStringUtils
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/11/16
 * @desc   : {DESCRIPTION}
 */
class SpannableStringUtils private constructor() {

    class Builder(val src: String, val target: String? = null) {
        var ssb: SpannableStringBuilder = SpannableStringBuilder(src)
        private var start: Int = 0
        private var end: Int = 0

        init {
            LogUtils.e(ssb.length)
            start = getStart()
            end = getEnd()
        }
        private val flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE

        private var isBold: Boolean = false//加粗
        private var isItalic = false//倾斜
        private var isBoldItalic = false//加粗倾斜
        private var isUnderline = false//下划线
        private var isStrikethrough = false//删除线
        private var isSuperscript = false   //上标
        private var isSubscript = false     //下标
        @ColorInt
        private var foregroundColor = 0 //前景色
        @ColorInt
        private var backgroundColor = 0 //背景色
        @ColorInt
        private var quoteColor = 0//引用线颜色

        private var proportion = 0f //字体比例
        private var xProportion = 0f    //横向字体比例

        private var fontFamily: String? = null
        private var align: Layout.Alignment? = null

        //<p>需添加view.setMovementMethod(LinkMovementMethod.getInstance())</p>
        private var clickSpan: ClickableSpan? = null//点击事件
        private var url: String? = null//超链接

        private var textSize: Int = 0 //设置字体大小

        fun textSize(@DimenRes textSize: Int): Builder{
            this.textSize = ResUtils.getDimensionPixelSize(textSize)
            return this
        }

        fun clickSpan(clickSpan: ClickableSpan): Builder{
            this.clickSpan = clickSpan
            return this
        }
        fun url(url: String): Builder{
            this.url = url
            return this
        }

        fun align(align: Layout.Alignment):Builder{
            this.align = align
            return this
        }

        fun fontFamily(fontFamily: String):Builder{
            this.fontFamily = fontFamily
            return this
        }

        fun isSubscript(isSubscript: Boolean):Builder{
            this.isSubscript = isSubscript
            return this
        }
        fun isSuperscript(isSuperscript: Boolean):  Builder{
            this.isSuperscript = isSuperscript
            return this
        }

        fun xProportion(xProportion: Float):Builder{
            this.xProportion = xProportion
            return this
        }
        fun proportion(proportion: Float): Builder{
            this.proportion = proportion
            return this
        }

        private fun getStart(): Int {
            var start = 0
            if (src.isNullOrEmpty()) {
                return start
            }
            if (!target.isNullOrEmpty()) {
                start = src.indexOf(target)
            }
            if (start > ssb.length) {
                start = ssb.length
            }
            return start
        }

        private fun getEnd(): Int {
            var end = 0
            if (src.isEmpty()) {
                return end
            }
            end = if (!target.isNullOrEmpty()) {
                src.indexOf(target) + target.length
            }else{
                ssb.length
            }
            if (end > ssb.length) {
                end = ssb.length
            }
            return end
        }

        fun start(start: Int): Builder{
            this.start = start
            return this
        }

        fun end(end: Int): Builder{
            this.end = end
            return this
        }

        fun isBold(isBold: Boolean): Builder {
            this.isBold = isBold
            return this
        }

        fun isItalic(isItalic: Boolean): Builder {
            this.isItalic = isItalic
            return this
        }
        fun isBoldItalic(isBoldItalic: Boolean): Builder{
            this.isBoldItalic = isBoldItalic
            return this
        }
        fun isUnderline(isUnderline: Boolean): Builder{
            this.isUnderline = isUnderline
            return this
        }
        fun isStrikethrough(isStrikethrough: Boolean): Builder{
            this.isStrikethrough = isStrikethrough
            return this
        }
        fun foregroundColor(@ColorRes foregroundColor: Int): Builder{
            this.foregroundColor = ResUtils.getColor(foregroundColor)
            return this
        }
        fun backgroundColor(@ColorRes backgroundColor: Int): Builder{
            this.backgroundColor = ResUtils.getColor(backgroundColor)
            return this
        }
        fun quoteColor(@ColorRes quoteColor: Int): Builder{
            this.quoteColor = ResUtils.getColor(quoteColor)
            return this
        }

        fun build(): SpannableStringBuilder {
            //设置所有
            setSpan()
            return ssb
        }

        fun setSpan() {
            if (isBold) {
                ssb.setSpan(StyleSpan(Typeface.BOLD), start, end, flag)
            }
            if (isItalic) {
                ssb.setSpan(StyleSpan(Typeface.ITALIC), start, end, flag)
            }
            if (isBoldItalic){
                ssb.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, end, flag)
            }
            if (isUnderline){
                ssb.setSpan(UnderlineSpan(), start, end, flag)
            }
            if (isStrikethrough){
                ssb.setSpan(StrikethroughSpan(), start, end, flag)
            }
            if (foregroundColor != 0){
                ssb.setSpan(ForegroundColorSpan(foregroundColor), start, end, flag)
            }
            if (backgroundColor != 0){
                ssb.setSpan(BackgroundColorSpan(backgroundColor), start, end, flag)
            }
            if (quoteColor != 0){
                ssb.setSpan(QuoteSpan(quoteColor), start, end, flag)
            }
            if (xProportion != 0f){
                ssb.setSpan(ScaleXSpan(xProportion), start, end, flag)
            }
            if (proportion != 0f){
                ssb.setSpan(RelativeSizeSpan(proportion), start, end, flag)
            }
            if (isSuperscript) {
                ssb.setSpan(SuperscriptSpan(), start, end, flag)
            }
            if (isSubscript) {
                ssb.setSpan(SubscriptSpan(), start, end, flag)
            }
            if (fontFamily != null) {
                ssb.setSpan(TypefaceSpan(fontFamily), start, end, flag)
            }
            if (align != null) {
                ssb.setSpan(AlignmentSpan.Standard(align!!), start, end, flag)
            }
            if (clickSpan != null) {
                ssb.setSpan(clickSpan, start, end, flag)
            }
            if (url != null) {
                ssb.setSpan(URLSpan(url), start, end, flag)
            }
            if (textSize != 0){
                ssb.setSpan(AbsoluteSizeSpan(textSize),start,end,flag)
            }
        }
    }
}