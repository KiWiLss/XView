package com.kiwilss.xview.design.coordinator;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class CustomCoordinatorLayout extends CoordinatorLayout {
    private View mZoomView;
    private int mZoomViewWidth;
    private int mZoomViewHeight;

    private float firstPosition;//记录第一次按下的位置
    private boolean isScrolling;//是否正在缩放
    private boolean isScrollDown;//是否下滑

    private float mScrollRate = 0.6f;//缩放系数，缩放系数越大，变化的越大
    private float mReplyRate = 0.3f;//回调系数，越大，回调越慢
    private View mMoveView;
    private View mMoveView2;
    private int height,height2;

    public CustomCoordinatorLayout(@NonNull Context context) {
        super(context);
    }

    public CustomCoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomCoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setmZoomView(View mZoomView) {
        this.mZoomView = mZoomView;
    }

    public void setmMoveView(View mMoveView1,View mMoveView2) {
        this.mMoveView = mMoveView1;
        this.mMoveView2 = mMoveView2;
        height = mMoveView.getMeasuredHeight();
        height2 = mMoveView2.getMeasuredHeight();
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int[] location = new int[2];
        mZoomView.getLocationOnScreen(location);
        int y = location[1];


        if (mZoomViewWidth <= 0 || mZoomViewHeight <= 0) {
            mZoomViewWidth = mZoomView.getMeasuredWidth();
            mZoomViewHeight = mZoomView.getMeasuredHeight();
        }

        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                if(isScrollDown) break;
                //手指离开后恢复图片
                isScrolling = false;
                replyImage();
                break;
            case MotionEvent.ACTION_MOVE:
                if(y != 0) return super.dispatchTouchEvent(ev);
                isScrollDown = false;
                if (!isScrolling) {
                    if (getScrollY() == 0) {
                        firstPosition = ev.getY();// 滚动到顶部时记录位置，否则正常返回
                    } else {
                        break;
                    }
                }
                int distance = (int) ((ev.getY() - firstPosition) * mScrollRate); // 滚动距离乘以一个系数
                if (distance < 0) { // 当前位置比记录位置要小，正常返回
                    isScrollDown = true;
                    break;
                }
                // 处理放大
                isScrolling = true;
                setZoom(distance);

                return super.dispatchTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);

    }

    private void scrollDown(float zoom) {
        mMoveView2.setScrollY(-(int)(height2 * ((height2 + zoom) / height2)));
    }

    //回弹动画
    private void replyImage() {
        float distance = mZoomView.getMeasuredWidth() - mZoomViewWidth;
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(distance, 0f).setDuration((long) (distance * mReplyRate));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                setZoom((Float) animation.getAnimatedValue());
            }

        });
        valueAnimator.start();
        mMoveView.setScrollY(height);
        mMoveView2.setScrollY(height2);
    }

    public void setZoom(float zoom) {
        if (mZoomViewWidth <= 0 || mZoomViewHeight <= 0) {
            return;
        }
        ViewGroup.LayoutParams lp = mZoomView.getLayoutParams();
        lp.width = (int) (mZoomViewWidth * ((mZoomViewWidth + zoom) / mZoomViewWidth));
        lp.height = (int) (mZoomViewHeight * ((mZoomViewWidth + zoom) / mZoomViewWidth));
        ((MarginLayoutParams) lp).setMargins(-(lp.width - mZoomViewWidth) / 2, 0, 0, 0);
        mZoomView.setLayoutParams(lp);
        try {
            CollapsingToolbarLayout parent = (CollapsingToolbarLayout) (mMoveView.getParent());
            ViewGroup.LayoutParams layoutParams = parent.getLayoutParams();
            layoutParams.height = lp.height;
            parent.setLayoutParams(layoutParams);
        }catch (Exception e){

        }

    }
}