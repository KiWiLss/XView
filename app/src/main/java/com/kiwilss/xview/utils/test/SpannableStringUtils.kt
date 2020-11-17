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

    //针对多个部分调用设置使用呢
    companion object {
        private const val flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE

        private fun getStart(ssb: SpannableStringBuilder, target: String?): Int {
            if (target.isNullOrEmpty()) {
                return 0
            }
            return ssb.indexOf(target)
        }

        private fun getEnd(ssb: SpannableStringBuilder, target: String?): Int {
            if (target.isNullOrEmpty()) {
                return 0
            }
            val pos = ssb.indexOf(target)
            var end = pos + target.length
            if (end > ssb.length) {
                end = ssb.length
            }
            return end
        }

        private fun getPosStart(ssb: SpannableStringBuilder, start: Int): Int {
            var posStart = start
            if (start < 0) {
                posStart = 0
            } else if (start > ssb.length) {
                posStart = ssb.length
            }
            return posStart
        }

        private fun getPosEnd(ssb: SpannableStringBuilder, end: Int): Int {
            var posEnd = end
            if (end > ssb.length) {
                posEnd = ssb.length
            }
            return posEnd
        }

        fun isBold(ssb: SpannableStringBuilder, target: String?): SpannableStringBuilder {
            if (!target.isNullOrEmpty()) {
                ssb.setSpan(
                    StyleSpan(Typeface.BOLD),
                    getStart(ssb, target),
                    getEnd(ssb, target),
                    flag
                )
            }
            return ssb
        }

        fun isBold(ssb: SpannableStringBuilder, start: Int, end: Int): SpannableStringBuilder {
            ssb.setSpan(
                StyleSpan(Typeface.BOLD),
                getPosStart(ssb, start),
                getPosEnd(ssb, end),
                flag
            )
            return ssb
        }

        fun isItalic(ssb: SpannableStringBuilder, target: String?): SpannableStringBuilder {
            if (!target.isNullOrEmpty()) {
                ssb.setSpan(
                    StyleSpan(Typeface.ITALIC),
                    getStart(ssb, target),
                    getEnd(ssb, target),
                    flag
                )
            }
            return ssb
        }

        fun isItalic(ssb: SpannableStringBuilder, start: Int, end: Int): SpannableStringBuilder {
            ssb.setSpan(
                StyleSpan(Typeface.ITALIC),
                getPosStart(ssb, start),
                getPosEnd(ssb, end),
                flag
            )
            return ssb
        }

        fun isBoldItalic(ssb: SpannableStringBuilder, target: String?): SpannableStringBuilder {
            if (!target.isNullOrEmpty()) {
                ssb.setSpan(
                    StyleSpan(Typeface.BOLD_ITALIC),
                    getStart(ssb, target),
                    getEnd(ssb, target),
                    flag
                )
            }
            return ssb
        }

        fun isBoldItalic(
            ssb: SpannableStringBuilder,
            start: Int,
            end: Int
        ): SpannableStringBuilder {
            ssb.setSpan(
                StyleSpan(Typeface.BOLD_ITALIC),
                getPosStart(ssb, start),
                getPosEnd(ssb, end),
                flag
            )
            return ssb
        }

        fun isUnderline(ssb: SpannableStringBuilder, target: String?): SpannableStringBuilder {
            if (!target.isNullOrEmpty()) {
                ssb.setSpan(UnderlineSpan(), getStart(ssb, target), getEnd(ssb, target), flag)
            }
            return ssb
        }

        fun isUnderline(ssb: SpannableStringBuilder, start: Int, end: Int): SpannableStringBuilder {
            ssb.setSpan(UnderlineSpan(), getPosStart(ssb, start), getPosEnd(ssb, end), flag)
            return ssb
        }

        fun isStrikethrough(ssb: SpannableStringBuilder, target: String?): SpannableStringBuilder {
            if (!target.isNullOrEmpty()) {
                ssb.setSpan(StrikethroughSpan(), getStart(ssb, target), getEnd(ssb, target), flag)
            }
            return ssb
        }

        fun isStrikethrough(
            ssb: SpannableStringBuilder,
            start: Int,
            end: Int
        ): SpannableStringBuilder {
            ssb.setSpan(StrikethroughSpan(), getPosStart(ssb, start), getPosEnd(ssb, end), flag)
            return ssb
        }

        fun foregroundColor(
            ssb: SpannableStringBuilder,
            target: String?,
            @ColorRes froegroundColorRes: Int
        ): SpannableStringBuilder {
            if (!target.isNullOrEmpty()) {
                ssb.setSpan(
                    ForegroundColorSpan(ResUtils.getColor(froegroundColorRes)),
                    getStart(ssb, target),
                    getEnd(ssb, target),
                    flag
                )
            }
            return ssb
        }

        fun foregroundColor(
            ssb: SpannableStringBuilder,
            start: Int,
            end: Int,
            @ColorRes froegroundColorRes: Int
        ): SpannableStringBuilder {
            ssb.setSpan(
                ForegroundColorSpan(ResUtils.getColor(froegroundColorRes)),
                getPosStart(ssb, start),
                getPosEnd(ssb, end),
                flag
            )
            return ssb
        }

        fun backgroundColor(
            ssb: SpannableStringBuilder,
            target: String?,
            @ColorRes backgroundColor: Int
        ): SpannableStringBuilder {
            if (!target.isNullOrEmpty()) {
                ssb.setSpan(
                    BackgroundColorSpan(ResUtils.getColor(backgroundColor)),
                    getStart(ssb, target),
                    getEnd(ssb, target),
                    flag
                )
            }
            return ssb
        }

        fun backgroundColor(
            ssb: SpannableStringBuilder,
            start: Int,
            end: Int,
            @ColorRes backgroundColor: Int
        ): SpannableStringBuilder {
            ssb.setSpan(
                BackgroundColorSpan(ResUtils.getColor(backgroundColor)),
                getPosStart(ssb, start),
                getPosEnd(ssb, end),
                flag
            )
            return ssb
        }

        fun textSize(
            ssb: SpannableStringBuilder,
            target: String?,
            @DimenRes textSize: Int
        ): SpannableStringBuilder {
            if (!target.isNullOrEmpty()) {
                ssb.setSpan(
                    AbsoluteSizeSpan(ResUtils.getDimensionPixelSize(textSize)),
                    getStart(ssb, target),
                    getEnd(ssb, target),
                    flag
                )
            }
            return ssb
        }

        fun textSize(
            ssb: SpannableStringBuilder,
            start: Int,
            end: Int,
            @DimenRes textSize: Int
        ): SpannableStringBuilder {
            ssb.setSpan(
                AbsoluteSizeSpan(ResUtils.getDimensionPixelSize(textSize)),
                getPosStart(ssb, start),
                getPosEnd(ssb, end),
                flag
            )
            return ssb
        }

        fun clickSpan(
            ssb: SpannableStringBuilder,
            target: String?,
            clickSpan: ClickableSpan
        ): SpannableStringBuilder {
            if (!target.isNullOrEmpty()) {
                ssb.setSpan(clickSpan, getStart(ssb, target), getEnd(ssb, target), flag)
            }
            return ssb
        }

        fun clickSpan(
            ssb: SpannableStringBuilder,
            start: Int,
            end: Int,
            clickSpan: ClickableSpan
        ): SpannableStringBuilder {
            ssb.setSpan(clickSpan, getPosStart(ssb, start), getPosEnd(ssb, end), flag)
            return ssb
        }

        fun url(
            ssb: SpannableStringBuilder,
            target: String?,
            url: String?
        ): SpannableStringBuilder {
            if (!target.isNullOrEmpty() && !url.isNullOrEmpty()) {
                ssb.setSpan(URLSpan(url), getStart(ssb, target), getEnd(ssb, target), flag)
            }
            return ssb
        }

        fun url(
            ssb: SpannableStringBuilder,
            start: Int,
            end: Int,
            url: String?
        ): SpannableStringBuilder {
            if (!url.isNullOrEmpty()) {
                ssb.setSpan(URLSpan(url), getPosStart(ssb, start), getPosEnd(ssb, end), flag)
            }
            return ssb
        }

        fun ssb(src: String?): SpannableStringBuilder {
            if (src.isNullOrEmpty()) {
                return SpannableStringBuilder()
            }
            return SpannableStringBuilder(src)
        }


    }

    //针对单个部分使用
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

        fun textSize(@DimenRes textSize: Int): Builder {
            this.textSize = ResUtils.getDimensionPixelSize(textSize)
            return this
        }

        fun clickSpan(clickSpan: ClickableSpan): Builder {
            this.clickSpan = clickSpan
            return this
        }

        fun url(url: String): Builder {
            this.url = url
            return this
        }

        fun align(align: Layout.Alignment): Builder {
            this.align = align
            return this
        }

        fun fontFamily(fontFamily: String): Builder {
            this.fontFamily = fontFamily
            return this
        }

        fun isSubscript(isSubscript: Boolean): Builder {
            this.isSubscript = isSubscript
            return this
        }

        fun isSuperscript(isSuperscript: Boolean): Builder {
            this.isSuperscript = isSuperscript
            return this
        }

        fun xProportion(xProportion: Float): Builder {
            this.xProportion = xProportion
            return this
        }

        fun proportion(proportion: Float): Builder {
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
            } else {
                ssb.length
            }
            if (end > ssb.length) {
                end = ssb.length
            }
            return end
        }

        fun start(start: Int): Builder {
            this.start = start
            return this
        }

        fun end(end: Int): Builder {
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

        fun isBoldItalic(isBoldItalic: Boolean): Builder {
            this.isBoldItalic = isBoldItalic
            return this
        }

        fun isUnderline(isUnderline: Boolean): Builder {
            this.isUnderline = isUnderline
            return this
        }

        fun isStrikethrough(isStrikethrough: Boolean): Builder {
            this.isStrikethrough = isStrikethrough
            return this
        }

        fun foregroundColor(@ColorRes foregroundColor: Int): Builder {
            this.foregroundColor = ResUtils.getColor(foregroundColor)
            return this
        }

        fun backgroundColor(@ColorRes backgroundColor: Int): Builder {
            this.backgroundColor = ResUtils.getColor(backgroundColor)
            return this
        }

        fun quoteColor(@ColorRes quoteColor: Int): Builder {
            this.quoteColor = ResUtils.getColor(quoteColor)
            return this
        }

        fun build(): SpannableStringBuilder {
            //设置所有
            setSpan()
            return ssb
        }

        fun setSpan() {
            //处理start,end 防止越界
            if (start < 0) {
                start = 0
            } else if (start > ssb.length) {
                start = ssb.length
            }
            if (end < 0) {
                end = 0
            } else if (end > ssb.length) {
                end = ssb.length
            }
            if (isBold) {
                ssb.setSpan(StyleSpan(Typeface.BOLD), start, end, flag)
            }
            if (isItalic) {
                ssb.setSpan(StyleSpan(Typeface.ITALIC), start, end, flag)
            }
            if (isBoldItalic) {
                ssb.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, end, flag)
            }
            if (isUnderline) {
                ssb.setSpan(UnderlineSpan(), start, end, flag)
            }
            if (isStrikethrough) {
                ssb.setSpan(StrikethroughSpan(), start, end, flag)
            }
            if (foregroundColor != 0) {
                ssb.setSpan(ForegroundColorSpan(foregroundColor), start, end, flag)
            }
            if (backgroundColor != 0) {
                ssb.setSpan(BackgroundColorSpan(backgroundColor), start, end, flag)
            }
            if (quoteColor != 0) {
                ssb.setSpan(QuoteSpan(quoteColor), start, end, flag)
            }
            if (xProportion != 0f) {
                ssb.setSpan(ScaleXSpan(xProportion), start, end, flag)
            }
            if (proportion != 0f) {
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
            if (textSize != 0) {
                ssb.setSpan(AbsoluteSizeSpan(textSize), start, end, flag)
            }
        }
    }
}