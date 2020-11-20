package com.kiwilss.xview.utils.test

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.StaggeredGridLayoutManager

/**
 * Description：RecyclerView的万能间距
 * Created by kang on 2018/3/9.
 */
class IntervalItemDecoration2 (
    // 每个item左右两侧的间距
    private val horizontalSpace: Int,
    // 每个item上下的间距
    private val verticalSpace: Int,
    // 整个RecyclerView的左间距
    private val leftMargin: Int = 0,
    // 整个RecyclerView的顶部间距
    private val topMargin: Int = 0,
    // 整个RecyclerView的右间距
    private val rightMargin: Int = 0,
    // 整个RecyclerView的底部间距
    private val bottomMargin: Int = 0
) : ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        // 得到当前Item在RecyclerView中的位置,从0开始
        val position = parent.getChildAdapterPosition(view)
        // 得到RecyclerView中Item的总个数
        val count = parent.adapter!!.itemCount
        if (parent.layoutManager is GridLayoutManager) { // 网格布局
            val gridLayoutManager =
                parent.layoutManager as GridLayoutManager?
            // 得到网格布局的列数
            val spanCount = gridLayoutManager!!.spanCount
            // 判断该网格布局是水平还是垂直
            if (LinearLayoutManager.VERTICAL == gridLayoutManager.orientation) { // 垂直
                if (spanCount == 1) { // 列数为1
                    verticalColumnOne(outRect, position, count)
                } else { // 列数大于1
                    verticalColumnMulti(outRect, position, count, spanCount)
                }
            } else if (LinearLayoutManager.HORIZONTAL == gridLayoutManager.orientation) { // 水平
                if (spanCount == 1) { // 行数为1
                    horizontalColumnOne(outRect, position, count)
                } else { // 行数大于1
                    horizontalColumnMulti(outRect, position, count, spanCount)
                }
            }
        } else if (parent.layoutManager is LinearLayoutManager) { // 线性布局
            val layoutManager =
                parent.layoutManager as LinearLayoutManager?
            if (LinearLayoutManager.VERTICAL == layoutManager!!.orientation) { // 垂直
                verticalColumnOne(outRect, position, count)
            } else if (LinearLayoutManager.HORIZONTAL == layoutManager.orientation) { // 水平
                horizontalColumnOne(outRect, position, count)
            }
        } else if (parent.layoutManager is StaggeredGridLayoutManager) { // 流布局
            //TODO 瀑布流布局相关
        }
    }

    /**
     * 列表垂直且列数为1
     *
     * @param outRect  包括左上右下四个参数，分别控制view左上右下的margin
     * @param position 当前view所处位置
     * @param count    RecyclerView中Item的总个数
     */
    private fun verticalColumnOne(
        outRect: Rect,
        position: Int,
        count: Int
    ) {
        if (position == 0) { // 位置为0时(即第一个Item)，不设置底部间距
            outRect[leftMargin, topMargin, rightMargin] = 0
        } else if (position == count - 1) { // 最后一个Item
            outRect[leftMargin, verticalSpace, rightMargin] = bottomMargin
        } else { // 中间的Item，不设置底部间距
            outRect[leftMargin, verticalSpace, rightMargin] = 0
        }
    }

    /**
     * 列表垂直且列数大于1
     *
     * @param outRect   包括左上右下四个参数，分别控制view左上右下的margin
     * @param position  当前view所处位置
     * @param count     RecyclerView中Item的总个数
     * @param spanCount 布局的列数
     */
    private fun verticalColumnMulti(
        outRect: Rect,
        position: Int,
        count: Int,
        spanCount: Int
    ) {
        // 由于是网格布局，故每个item宽度是固定的，这里计算出每个item的左右边距之和
        val mEachSpace =
            (leftMargin + rightMargin + (spanCount - 1) * horizontalSpace) / spanCount
        // 通过计算得出总行数
        val totalRow = count / spanCount + if (count % spanCount == 0) 0 else 1
        // 计算得出当前view所在的行
        val row = position / spanCount
        val column = position % spanCount
        val diff = (mEachSpace - rightMargin - leftMargin) / (spanCount - 1)
        val left = (column + 1 - 1) * diff + leftMargin
        val right = mEachSpace - left
        if (row == 0) {
            outRect[left, topMargin, right] = verticalSpace
        } else if (row == totalRow - 1) {
            outRect[left, 0, right] = bottomMargin
        } else {
            outRect[left, 0, right] = verticalSpace
        }
    }

    /**
     * 列表水平且行数为1
     *
     * @param outRect  包括左上右下四个参数，分别控制view左上右下的margin
     * @param position 当前view所处位置
     * @param count    RecyclerView中Item的总个数
     */
    private fun horizontalColumnOne(
        outRect: Rect,
        position: Int,
        count: Int
    ) {
        if (position == 0) { // 位置为0时(即第一个Item)
            outRect[leftMargin, topMargin, horizontalSpace / 2] = bottomMargin
        } else if (position == count - 1) { // 最后一个Item
            outRect[horizontalSpace / 2, topMargin, rightMargin] = bottomMargin
        } else { // 中间的Item
            outRect[horizontalSpace / 2, topMargin, horizontalSpace / 2] = bottomMargin
        }
    }

    /**
     * 列表水平且行数大于1
     *
     * @param outRect   包括左上右下四个参数，分别控制view左上右下的margin
     * @param position  当前view所处位置
     * @param count     RecyclerView中Item的总个数
     * @param spanCount 布局的行数
     */
    private fun horizontalColumnMulti(
        outRect: Rect,
        position: Int,
        count: Int,
        spanCount: Int
    ) {
        // 通过计算得出总列数
        val totalColumn = count / spanCount + if (count % spanCount == 0) 0 else 1
        // 计算得出当前view所在的列
        val column = position / spanCount
        // 通过对position加1对spanCount取余得到row
        // 保证row等于1为第一行，等于0为最后一个，其它值为中间行
        val row = (position + 1) % spanCount
        val mEachSpace =
            (topMargin + bottomMargin + (spanCount - 1) * verticalSpace) / spanCount
        val diff = (mEachSpace - bottomMargin - topMargin) / (spanCount - 1)
        val top = (position % spanCount + 1 - 1) * diff + topMargin
        val bottom = mEachSpace - top
        if (row == 1) {
            outRect[if (column == 0) leftMargin else horizontalSpace / 2, top, if (column == totalColumn - 1) rightMargin else horizontalSpace / 2] =
                bottom
        } else if (row == 0) {
            outRect[if (column == 0) leftMargin else horizontalSpace / 2, top, if (column == totalColumn - 1) rightMargin else horizontalSpace / 2] =
                bottom
        } else {
            outRect[if (column == 0) leftMargin else horizontalSpace / 2, top, if (column == totalColumn - 1) rightMargin else horizontalSpace / 2] =
                bottom
        }
    }

}