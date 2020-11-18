package com.kiwilss.xview.ui.view.recyclerview.itemdecration;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/**
 * Description：RecyclerView的万能间距
 * Created by kang on 2018/3/9.
 */
public class CommonItemDecoration extends RecyclerView.ItemDecoration {
    private int horizontalSpace; // 每个item左右两侧的间距
    private int verticalSpace; // 每个item上下的间距
    private int leftMargin; // 整个RecyclerView的左间距
    private int topMargin; // 整个RecyclerView的顶部间距
    private int rightMargin; // 整个RecyclerView的右间距
    private int bottomMargin; // 整个RecyclerView的底部间距
 
    public CommonItemDecoration(int horizontalSpace, int verticalSpace) {
        this(horizontalSpace, verticalSpace, 0, 0, 0, 0);
    }
 
    public CommonItemDecoration(int horizontalSpace, int verticalSpace, int margin) {
        this(horizontalSpace, verticalSpace, margin, margin, margin, margin);
    }
 
    public CommonItemDecoration(int horizontalSpace, int verticalSpace, int leftMargin, int topMargin, int rightMargin, int bottomMargin) {
        this.horizontalSpace = horizontalSpace;
        this.verticalSpace = verticalSpace;
        this.leftMargin = leftMargin;
        this.topMargin = topMargin;
        this.rightMargin = rightMargin;
        this.bottomMargin = bottomMargin;
    }
 
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        // 得到当前Item在RecyclerView中的位置,从0开始
        int position = parent.getChildAdapterPosition(view);
        // 得到RecyclerView中Item的总个数
        int count = parent.getAdapter().getItemCount();
 
        if (parent.getLayoutManager() instanceof GridLayoutManager) { // 网格布局
            GridLayoutManager gridLayoutManager = (GridLayoutManager) parent.getLayoutManager();
            // 得到网格布局的列数
            int spanCount = gridLayoutManager.getSpanCount();
            // 判断该网格布局是水平还是垂直
            if (LinearLayoutManager.VERTICAL == gridLayoutManager.getOrientation()) { // 垂直
                if (spanCount == 1) { // 列数为1
                    verticalColumnOne(outRect, position, count);
                } else { // 列数大于1
                    verticalColumnMulti(outRect, position, count, spanCount);
                }
            } else if (LinearLayoutManager.HORIZONTAL == gridLayoutManager.getOrientation()) { // 水平
                if (spanCount == 1) { // 行数为1
                    horizontalColumnOne(outRect, position, count);
                } else { // 行数大于1
                    horizontalColumnMulti(outRect, position, count, spanCount);
                }
            }
        } else if (parent.getLayoutManager() instanceof LinearLayoutManager) { // 线性布局
            LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
            if (LinearLayoutManager.VERTICAL == layoutManager.getOrientation()) { // 垂直
                verticalColumnOne(outRect, position, count);
            } else if (LinearLayoutManager.HORIZONTAL == layoutManager.getOrientation()) { // 水平
                horizontalColumnOne(outRect, position, count);
            }
        } else if (parent.getLayoutManager() instanceof StaggeredGridLayoutManager) { // 流布局
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
    private void verticalColumnOne(Rect outRect, int position, int count) {
        if (position == 0) { // 位置为0时(即第一个Item)，不设置底部间距
            outRect.set(leftMargin, topMargin, rightMargin, 0);
        } else if (position == count - 1) { // 最后一个Item
            outRect.set(leftMargin, verticalSpace, rightMargin, bottomMargin);
        } else { // 中间的Item，不设置底部间距
            outRect.set(leftMargin, verticalSpace, rightMargin, 0);
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
    private void verticalColumnMulti(Rect outRect, int position, int count, int spanCount) {
        // 由于是网格布局，故每个item宽度是固定的，这里计算出每个item的左右边距之和
        int mEachSpace = (leftMargin + rightMargin + (spanCount - 1) * horizontalSpace) / spanCount;
        // 通过计算得出总行数
        int totalRow = count / spanCount + ((count % spanCount) == 0 ? 0 : 1);
        // 计算得出当前view所在的行
        int row = position / spanCount;
        int column = (position) % spanCount;
        int diff = ((mEachSpace - rightMargin) - leftMargin) / (spanCount - 1);
        int left = (column + 1 - 1) * diff + leftMargin;
        int right = mEachSpace - left;
        if (row == 0) {
            outRect.set(left,
                    topMargin,
                    right,
                    verticalSpace);
        } else if (row == totalRow - 1) {
            outRect.set(left,
                    0,
                    right,
                    bottomMargin);
        } else {
            outRect.set(left,
                    0,
                    right,
                    verticalSpace);
        }
    }
 
    /**
     * 列表水平且行数为1
     *
     * @param outRect  包括左上右下四个参数，分别控制view左上右下的margin
     * @param position 当前view所处位置
     * @param count    RecyclerView中Item的总个数
     */
    private void horizontalColumnOne(Rect outRect, int position, int count) {
        if (position == 0) { // 位置为0时(即第一个Item)
            outRect.set(leftMargin, topMargin, horizontalSpace / 2, bottomMargin);
        } else if (position == count - 1) { // 最后一个Item
            outRect.set(horizontalSpace / 2, topMargin, rightMargin, bottomMargin);
        } else { // 中间的Item
            outRect.set(horizontalSpace / 2, topMargin, horizontalSpace / 2, bottomMargin);
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
    private void horizontalColumnMulti(Rect outRect, int position, int count, int spanCount) {
        // 通过计算得出总列数
        int totalColumn = count / spanCount + ((count % spanCount) == 0 ? 0 : 1);
        // 计算得出当前view所在的列
        int column = position / spanCount;
        // 通过对position加1对spanCount取余得到row
        // 保证row等于1为第一行，等于0为最后一个，其它值为中间行
        int row = (position + 1) % spanCount;
        int mEachSpace = (topMargin + bottomMargin + (spanCount - 1) * verticalSpace) / spanCount;
        int diff = ((mEachSpace - bottomMargin) - topMargin) / (spanCount - 1);
        int top = (position % spanCount + 1  - 1) * diff + topMargin;
        int bottom = mEachSpace - top;
        if (row == 1) {
            outRect.set(column == 0 ? leftMargin : horizontalSpace / 2,
                    top,
                    column == totalColumn - 1 ? rightMargin : horizontalSpace / 2,
                    bottom);
        } else if (row == 0) {
            outRect.set(column == 0 ? leftMargin : horizontalSpace / 2,
                    top,
                    column == totalColumn - 1 ? rightMargin : horizontalSpace / 2,
                    bottom);
        } else {
            outRect.set(column == 0 ? leftMargin : horizontalSpace / 2,
                    top,
                    column == totalColumn - 1 ? rightMargin : horizontalSpace / 2,
                    bottom);
        }
    }
 
}