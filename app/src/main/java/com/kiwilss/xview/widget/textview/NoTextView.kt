package com.kiwilss.xview.widget.textview

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatTextView
import kotlin.math.abs
import kotlin.math.ceil

/**
 *@FileName: NoTextView
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/7
 * @desc   : {DESCRIPTION}
 */
class NoTextView @JvmOverloads constructor(context: Context,
                 attrs: AttributeSet? = null,
                 defStyleAttr: Int = 0) : AppCompatTextView(context,attrs, defStyleAttr) {

        init {
            val textSize = textSize
            val paint = Paint()
            paint.textSize = textSize
            val fontMetricsInt = paint.fontMetricsInt
            setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)
            val top =
                ceil(abs((fontMetricsInt.top - fontMetricsInt.ascent) / 2.0)).toInt()
            setPadding(
                0, -(abs(fontMetricsInt.top - fontMetricsInt.ascent) + top)
                , 0,
                fontMetricsInt.top - fontMetricsInt.ascent
            )
        }
}