package com.kiwilss.xview.design.behavior.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import com.kiwilss.xview.utils.LogUtils;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * @author stefan 邮箱：648701906@qq.com
 *         <p></p>
 * @describe 在app中，这个类用于头像的行为 具体使用在Strings.xml中的引用
 */
public class CircleImageInUsercBehavior extends CoordinatorLayout.Behavior<CircleImageView> {

    private final String TAG_TOOLBAR = "toolbar";

    private float mStartAvatarY;

    private float mStartAvatarX;

    private int mAvatarMaxHeight;

    private int mToolBarHeight;

    private float mStartDependencyY;

    public CircleImageInUsercBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, CircleImageView child, View dependency) {
        return dependency instanceof DisInterceptNestedScrollView;
    }


    //当dependency变化的时候调用
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, CircleImageView child, View dependency) {
        //初始化一些基础参数
        init(parent, child, dependency);
        //计算比例
        if (child.getY() <= 0) return false;

        float percent = (float) ((child.getY() - mToolBarHeight) / (mStartAvatarY - mToolBarHeight));

        if (percent < 0) {
            percent = 0;
        }

        if (this.percent == percent || percent > 1) return true;
        this.percent = percent;
        //LogUtils.e(percent,"----percent--->");
        LogUtils.e(child.getY() + "-------------" + mStartAvatarY + "-------toolbar---" + mToolBarHeight + "percent--" + percent + "---" + dependency.getHeight());
       //设置头像的大小
        ViewCompat.setScaleX(child, percent);
        ViewCompat.setScaleY(child, percent);
        return false;
    }

    /**
     * 初始化数据
     * @param parent
     * @param child
     * @param dependency
     */
    private void init(CoordinatorLayout parent, CircleImageView child, View dependency) {
        if (mStartAvatarY == 0) {
            mStartAvatarY = child.getY();
        }
        if (mStartDependencyY == 0) {
            mStartDependencyY = dependency.getY();
        }
        if (mStartAvatarX == 0) {
            mStartAvatarX = child.getX();
        }

        if (mAvatarMaxHeight == 0) {
            mAvatarMaxHeight = child.getHeight();
        }
        if (mToolBarHeight == 0) {
            Toolbar toolbar = (Toolbar) parent.findViewWithTag(TAG_TOOLBAR);
            mToolBarHeight = toolbar.getHeight();
        }
    }

    float percent = 0;
}
