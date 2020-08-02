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

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kiwilss.xview.R
import com.kiwilss.xview.utils.LogUtils
import kotlin.math.ceil

/**
 *@FileName: ItemDivider
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/1
 * @desc   : {DESCRIPTION}
 */
class ItemDivider(
    private val firstTop: Boolean = false, private val lastBottom: Boolean = false,
    private val left: Boolean = false, private val right: Boolean = false,
    private val dividerWidth: Int = 2, val color: Int = Color.parseColor("#f2f2f2")
                    ): RecyclerView.ItemDecoration() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var paint: Paint? = null

    init {
        //初始化paint
        if (paint == null) {
            paint = Paint(Paint.ANTI_ALIAS_FLAG)
            paint!!.style = Paint.Style.FILL
            paint!!.color = color
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
        if (layoutManager is LinearLayoutManager) {//线性
            LogUtils.e("线性-->")
            val orientation = (layoutManager as LinearLayoutManager).orientation
            if (orientation == LinearLayoutManager.VERTICAL) {
                //垂直方向用的较多,特殊处理第一个Item顶部是否绘制分割线,最后一个Item底部是否绘制分割线
                //中间的Item全都绘制在底部
                if (parent.getChildLayoutPosition(view) == 0) {
                    if (firstTop){
                        outRect.top = dividerWidth
                    }
                    LogUtils.e(firstTop,"firstTop")
                    outRect.bottom = dividerWidth
                }else if (parent.getChildLayoutPosition(view) + 1 == parent.adapter?.itemCount){
                    if (lastBottom){
                        outRect.bottom = dividerWidth
                    }
                }else{
                    LogUtils.e("bottom--->linear")
                    // 水平分割线将绘制在item底部
                    outRect.bottom = dividerWidth
                }
            } else if (orientation == LinearLayoutManager.HORIZONTAL) {
                //水平方向,top代表第一个item左侧是否绘制,bottom代表最后一个item右边是否绘制
                if (parent.getChildLayoutPosition(view) == 0) {
                    if (firstTop){
                        outRect.left = dividerWidth
                    }
                }else if (parent.getChildLayoutPosition(view) + 1 == parent.adapter?.itemCount){
                    if (lastBottom){
                        outRect.right = dividerWidth
                    }
                }else{
                    // 垂直分割线将绘制在item右侧
                    outRect.right = dividerWidth
                }
            }
            if (layoutManager is GridLayoutManager){//网格
                //处理一下特殊情况,firstTop第一行是否绘制,lastBottom最后一行是否绘制,left左侧是否绘制,right右侧是否绘制(默认全都不绘制)
                val childLayoutPosition = parent.getChildLayoutPosition(view)
                val childCount = (layoutManager as GridLayoutManager).childCount
                val spanCount = (layoutManager as GridLayoutManager).spanCount
                val lp = view.layoutParams as GridLayoutManager.LayoutParams
                LogUtils.e("$childLayoutPosition + ---------spancount= == $spanCount---------count=$childCount")
                if (orientation == LinearLayoutManager.VERTICAL){
                    //如果只有一行时,特殊情况处理
                    if (childCount <= spanCount){
                        if (firstTop){
                            outRect.top = dividerWidth
                        }
                        if (lastBottom){
                            outRect.bottom = dividerWidth
                        }
                        if (left && lp.spanIndex == 0){//第一个的左边绘制
                            outRect.left = dividerWidth
                        }
                        if (right && lp.spanIndex == spanCount - 1){//最后一个右边绘制
                            outRect.right = dividerWidth
                        }
                        //中间的全都绘制左边
                        if ( lp.spanIndex > 0) {
                            // 如果列表是垂直方向,则最左边的一列略过
                            outRect.left = dividerWidth
                        }
                    }


                }else if (orientation == LinearLayoutManager.HORIZONTAL && lp.spanIndex > 0) {
                    // 如果列表是水平方向,则最上边的一列略过
                    outRect.top = dividerWidth
                }


            }
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
//        val layoutManager = parent.layoutManager
//        var spanCount = 0
//        if (layoutManager is GridLayoutManager) {
//            spanCount = layoutManager.spanCount
//        }
//        val childCount = parent.childCount
//        var count = childCount % spanCount
//        if (count == 0) {
//            count = spanCount
//        }
        // 这个值是为了补偿横竖方向上分割线交叉处间隙
        // 这个值是为了补偿横竖方向上分割线交叉处间隙
        val offSet = ceil(dividerWidth * 1f / 2.toDouble()).toInt()
        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val params =
                child.layoutParams as RecyclerView.LayoutParams
            val left1 = child.right + params.rightMargin
            val right1: Int = left1 + dividerWidth
            val top1 = child.top - offSet - params.topMargin
            val bottom1 = child.bottom + offSet + params.bottomMargin
            //绘制分割线(绘制竖直方向的矩形)
            c.drawRect(
                left1.toFloat(), top1.toFloat(), right1.toFloat(), bottom1.toFloat(),
                paint!!
            )
            val left2 = child.left - offSet - params.leftMargin
            val right2 = child.right + offSet + params.rightMargin
            val top2 = child.bottom + params.bottomMargin
            val bottom2: Int = top2 + dividerWidth
            //绘制分割线(绘制水平方向的矩形)
            c.drawRect(left2.toFloat(), top2.toFloat(), right2.toFloat(), bottom2.toFloat(),
                paint!!
            )
            //判断最后一行不画
//            if (i < parent.childCount - count) {
//                c.drawRect(
//                    left2.toFloat(),
//                    top2.toFloat(),
//                    right2.toFloat(),
//                    bottom2.toFloat(),
//                    paint!!
//                )
//            }
        }
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    }
}