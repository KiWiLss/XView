package com.kiwilss.xview.design.behavior.fab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kiwilss.xview.utils.anim.AnimatorUtil;

/**
 * @author : Lss Administrator
 * @FileName: ScaleUpShowBehavior
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/17
 * @desc : {FloatingActionButton上滑缩小隐藏,上滑放大显示,使用于返回顶部等}
 */
public class ScaleUpShowBehavior extends FloatingActionButton.Behavior {

    public ScaleUpShowBehavior(Context context, AttributeSet attrs) {
        super();
    }

    private boolean isAnimatingOut = false;
    private boolean isShow = true;

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                                       @NonNull FloatingActionButton child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL ||
                super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
        //return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, @NonNull int[] consumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed);
//        if (dyConsumed > 0 && dyUnconsumed == 0) {
//            System.out.println("上滑中。。。");
//        }
//        if (dyConsumed == 0 && dyUnconsumed > 0) {
//            System.out.println("到边界了还在上滑。。。");
//        }
//        if (dyConsumed < 0 && dyUnconsumed == 0) {
//            System.out.println("下滑中。。。");
//        }
//        if (dyConsumed == 0 && dyUnconsumed < 0) {
//            System.out.println("到边界了，还在下滑。。。");
//        }
        // 手指上滑，隐藏FAB
        // 手指上滑，隐藏FAB
        if ((dyConsumed > 0 || dyUnconsumed > 0) && !isAnimatingOut && isShow) {
            AnimatorUtil.INSTANCE.scaleHide(child, viewPropertyAnimatorListenerHide);
        } else if (dyConsumed < 0 || dyUnconsumed < 0 && !isAnimatingOut && !isShow) {
            // 手指下滑，显示FAB
            AnimatorUtil.INSTANCE.scaleShow(child,viewPropertyAnimatorListener);
        }
    }



    ViewPropertyAnimatorListener viewPropertyAnimatorListener = new ViewPropertyAnimatorListener() {

        @Override
        public void onAnimationStart(View view) {
            //view.setVisibility(View.VISIBLE);
            isAnimatingOut = true;
        }

        @Override
        public void onAnimationEnd(View view) {
            isAnimatingOut = false;
        }

        @Override
        public void onAnimationCancel(View arg0) {
            isAnimatingOut = false;
        }
    };

    ViewPropertyAnimatorListener viewPropertyAnimatorListenerHide = new ViewPropertyAnimatorListener() {

        @Override
        public void onAnimationStart(View view) {
            isAnimatingOut = true;
        }

        @Override
        public void onAnimationEnd(View view) {
            isAnimatingOut = false;
            //view.setVisibility(View.GONE);
        }

        @Override
        public void onAnimationCancel(View arg0) {
            isAnimatingOut = false;
        }
    };
}

