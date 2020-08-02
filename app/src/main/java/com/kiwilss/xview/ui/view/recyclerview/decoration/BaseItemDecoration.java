package com.kiwilss.xview.ui.view.recyclerview.decoration;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * author : NYB
 * created on : 2020/6/9 11:43
 * description ：
 */
public class BaseItemDecoration extends RecyclerView.ItemDecoration {

    private int divider;//上下item之间 相距的距离
    private int dividerHorizontal;//左右item之间 相距的距离
    private int marginTop;//第一个距离上面的距离
    private int marginBottom;//最后一个距离下面的距离
    private int lineCount;//一行多少个
    private int marginHorizontal;//距离两边的距离

    public BaseItemDecoration(int divider, int lineCount) {
        this.divider = divider;
        this.lineCount = lineCount;
        this.dividerHorizontal = divider;//默认不设置和上下的一致
    }

    public void setDividerHorizontal(int dividerHorizontal) {
        this.dividerHorizontal = dividerHorizontal;
    }

    public void setMarginHorizontal(int marginHorizontal) {
        this.marginHorizontal = marginHorizontal;
    }

    public void setMarginTop(int marginTop) {
        this.marginTop = marginTop;
    }

    public void setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getAdapter() != null && lineCount != 0) {
            int itemCount = parent.getAdapter().getItemCount();
            int position = parent.getChildLayoutPosition(view) + 1;
            int lineNum = itemCount % lineCount == 0 ? itemCount / lineCount : itemCount / lineCount + 1;
            int positionLineNum = position % lineCount == 0 ? position / lineCount : position / lineCount + 1;
            if (positionLineNum == 1) {
                outRect.top = marginTop;
            }
            if (lineNum == positionLineNum) {
                outRect.bottom = marginBottom;
            } else {
                outRect.bottom = divider;
            }
        } else {
            outRect.bottom = marginBottom;
        }
        if (lineCount != 0) {
            if (lineCount == 1) {
                outRect.left = marginHorizontal;
                outRect.right = marginHorizontal;
            } else if (parent.getChildLayoutPosition(view) % lineCount == 0) {
                // left
                outRect.left = marginHorizontal;
                outRect.right = dividerHorizontal / 2;
            } else if (parent.getChildLayoutPosition(view) % lineCount == (lineCount - 1)) {
                outRect.left = dividerHorizontal / 2;
                outRect.right = marginHorizontal;
            } else {
                outRect.left = dividerHorizontal / 2;
                outRect.right = dividerHorizontal / 2;
            }
        }
    }
}
