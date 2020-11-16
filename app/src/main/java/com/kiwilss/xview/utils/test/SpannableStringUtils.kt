package com.kiwilss.xview.utils.test

import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
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
        }
    }
}