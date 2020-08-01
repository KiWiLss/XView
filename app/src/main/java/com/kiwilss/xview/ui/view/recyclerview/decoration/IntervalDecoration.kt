/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: IntervalDecoration
 * Author:   Administrator
 * Date:     2020/8/1 15:24
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.recyclerview.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 *@FileName: IntervalDecoration
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/1
 * @desc   : { 一般不管是哪个item,左右间距通常都是一样的,
 * 不排除有特殊的情况,这里按照常见的情况来处理}
 */
class IntervalDecoration(
    private val top: Int = 0, private val bottom: Int = 0, private val left: Int = 0, private val right: Int = 0
    , private val firstTop: Int = 0, private val firstBottom: Int = bottom, private val firstLeft: Int = left, private val firstRight: Int = right,
    private val lastTop: Int = top, private val lastBottom: Int = 0, private val lastLeft: Int = left, private val lastRight: Int = right)
    : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        //如果是第一个item
        if (parent.getChildLayoutPosition(view) == 0) {
            //设置四个方向的间距
            outRect.top = firstTop
            outRect.bottom = firstBottom
            outRect.left = firstLeft
            outRect.right = firstRight
        }else if (parent.getChildLayoutPosition(view) + 1 == parent.adapter?.itemCount){
            //最后一个item
            outRect.top = lastTop
            outRect.bottom = lastBottom
            outRect.left = lastLeft
            outRect.right =lastRight
        }else{
            //中间的item
            outRect.top = top
            outRect.bottom = bottom
            outRect.left = left
            outRect.right = right
        }
    }
}