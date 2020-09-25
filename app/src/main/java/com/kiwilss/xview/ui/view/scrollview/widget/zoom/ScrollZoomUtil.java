package com.kiwilss.xview.ui.view.scrollview.widget.zoom;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.kiwilss.xview.utils.LogUtils;

/**
 * Description:滚动缩放的工具类
 * Created by 禽兽先生
 * Created on 2018/10/22
 */
public class ScrollZoomUtil {
    //控件原始高
    private static int sZoomViewOriginWidth = 0;
    //控件原始宽
    private static int sZoomViewOriginHeight = 0;
    //被监听的可滚动控件按下时的纵坐标
    private static float sLastY = 0;
    //是否开始缩放的标志位
    private static boolean sStartZoom = false;
    // 回弹时间系数，系数越小，回弹越快
    private static float mReplyRatio = 0.5f;

    // 滑动放大系数，系数越大，滑动时放大程度越大
    public static float mScaleRatio = 0.4f;

    // 最大的放大倍数
    public static float mScaleTimes = 2f;


 
    public static void scrollZoom(final View scrollView, final View zoomView) {
        zoomView.post(new Runnable() {
            @Override
            public void run() {
                //记录控件原始宽高
                sZoomViewOriginWidth = zoomView.getMeasuredWidth();
                sZoomViewOriginHeight = zoomView.getMeasuredHeight();
            }
        });
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //当被监听的可滚动控件已经滚动到顶部时才可以进行缩放，置标志位为 true，记录下按下的纵坐标
                        if (scrollView.getScrollY() == 0) {
                            sStartZoom = true;
                            sLastY = event.getY();
                            return true;
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (sStartZoom) {
                            //计算滑动的距离
                            float distanceY = event.getY() - sLastY;
                            if (distanceY > 0) {
                                //当滑动距离大于 0 时表示下拉操作，对需要缩放的控件进行放大操作
                                zoom(zoomView, distanceY);
                            } else {
                                //当滑动距离小于 0 时表示上拉操作，判断需要缩放的控件的当前宽高，如果比原始宽高大则先缩放至原始宽高
                                if (zoomView.getMeasuredWidth() > sZoomViewOriginWidth) {
                                    zoom(zoomView, distanceY);
                                } else {
                                    //需要缩放的控件的当前宽高与原始宽高相等时再进行上拉，则进行正常的滚动操作
                                    break;
                                }
                            }
                            return true;
                        }
                    case MotionEvent.ACTION_UP:
                        //手指抬起后恢复原始状态
                        sLastY = 0;
                        sStartZoom = false;
                        restore(zoomView);
                        break;
                }
                return false;
            }
        });
    }
 
    /**
     * Description:缩放
     * Date:2018/10/22
     */
    private static void zoom(View zoomView, float distanceY) {
        if (sZoomViewOriginWidth <= 0 || sZoomViewOriginHeight <= 0) {
            return;
        }
        //控制缩放比例
        float scaleTimes = (float) ((sZoomViewOriginWidth + distanceY) / (sZoomViewOriginWidth * 1.0));
//  如超过最大放大倍数，直接返回
        if (scaleTimes > mScaleTimes) return;

        ViewGroup.LayoutParams layoutParams = zoomView.getLayoutParams();
        //控件高为原始高度加上滑动距离乘以一个系数（与滑动距离 1:1 的话变化太大）
        LogUtils.e(distanceY);
        layoutParams.height = (int) (sZoomViewOriginHeight + distanceY * 0.4);
        //控件宽等比例变化
        layoutParams.width = (int) ((sZoomViewOriginWidth * (sZoomViewOriginHeight + distanceY * 0.4)) / sZoomViewOriginHeight);
        //  设置控件水平居中
        ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(-(layoutParams.width - sZoomViewOriginWidth) / 2, 0, 0, 0);
        zoomView.setLayoutParams(layoutParams);
    }
 
    /**
     * Description:恢复成初始状态
     * Date:2018/10/22
     */
    private static void restore(final View zoomView) {

        final float distance = zoomView.getMeasuredWidth() - sZoomViewOriginWidth;
        // 设置动画
        ValueAnimator anim = ObjectAnimator.ofFloat(distance, 0.0F).setDuration((long) (distance * mReplyRatio));
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                zoom(zoomView,(Float) animation.getAnimatedValue());
            }
        });
        anim.start();

//        //利用属性动画恢复成原始宽高，使其有一个过渡效果
//        ValueAnimator widthValueAnimator = ObjectAnimator.ofInt(zoomView.getMeasuredWidth(), sZoomViewOriginWidth);
//        ValueAnimator heightValueAnimator = ObjectAnimator.ofInt(zoomView.getMeasuredHeight(), sZoomViewOriginHeight);
//        widthValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                ViewGroup.LayoutParams layoutParams = zoomView.getLayoutParams();
//                layoutParams.width = (int) animation.getAnimatedValue();
//                zoomView.setLayoutParams(layoutParams);
//            }
//        });
//        heightValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                ViewGroup.LayoutParams layoutParams = zoomView.getLayoutParams();
//                layoutParams.height = (int) animation.getAnimatedValue();
//                zoomView.setLayoutParams(layoutParams);
//            }
//        });
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.play(widthValueAnimator).with(heightValueAnimator);
//        //这个动画时长是每个动画持续的时长而不是总时长
//        animatorSet.setDuration(300);
//        animatorSet.start();
    }
}