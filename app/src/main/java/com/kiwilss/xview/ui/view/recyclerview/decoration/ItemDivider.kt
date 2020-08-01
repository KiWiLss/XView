/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: ItemDivider
 * Author:   Administrator
 * Date:     2020/8/1 16:02
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.recyclerview.decoration

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kiwilss.xview.R

/**
 *@FileName: ItemDivider
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/1
 * @desc   : {DESCRIPTION}
 */
class ItemDivider(val top: Boolean = false,val bottom: Boolean,val width: Int, val color: Int = R.color.black_e6e6e6): RecyclerView.ItemDecoration() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var paint: Paint? = null

    init {
        //初始化paint
        if (paint == null) {
            paint = Paint(Paint.ANTI_ALIAS_FLAG)
            paint!!.style = Paint.Style.FILL
        }
    }
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if (layoutManager == null) {
            layoutManager = parent.layoutManager
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    }
}