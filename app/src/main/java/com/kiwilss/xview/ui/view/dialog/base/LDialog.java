package com.kiwilss.xview.ui.view.dialog.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

/**
 * @author : Lss Administrator
 * @FileName: LDialog
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/11
 * @desc : {DESCRIPTION}
 */
public abstract class LDialog extends Dialog {
    private final SparseArray<View> views;
    public Context mContext;

    private int mWidth = ViewGroup.LayoutParams.MATCH_PARENT;
    private int mHeight = ViewGroup.LayoutParams.WRAP_CONTENT;
    private int mGravity = Gravity.CENTER;
    private int mAnimationStyle = 0;//默认没有动画效果
    public LDialog(@NonNull Context context) {
        this(context, 0);
    }

    public LDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        views = new SparseArray<View>();
        mContext = context;

    }

    public LDialog setWidth(int width){
        this.mWidth = width;
        return this;
    }
    public LDialog setHeight(int height){
        this.mHeight = height;
        return this;
    }
    public LDialog setGravity(int gravity){
        mGravity = gravity;
        return this;
    }
    public LDialog setAnimationStyle(int animationStyle){
        this.mAnimationStyle = animationStyle;
        return this;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局
        setContentView(initContentView());
        initInterface(savedInstanceState);
        //设置宽高
        Window window = getWindow();
        if (window != null){
            if (mAnimationStyle != 0){
                window.setWindowAnimations(mAnimationStyle);
            }
            window.setBackgroundDrawable(new ColorDrawable((Color.parseColor("#00000000"))));
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = mWidth;
            lp.height = mHeight;
            lp.gravity = mGravity;
            window.setAttributes(lp);
        }
    }

    /**初始设置界面
     * @param savedInstanceState
     */
    protected abstract void initInterface(Bundle savedInstanceState);

    /**
     * 获取布局
     */
    protected abstract int initContentView();

    public LDialog setText(int viewId, String text) {
        if (!TextUtils.isEmpty(text)) {
            TextView tv = getView(viewId);
            tv.setText(text);
        }
        return this;
    }

    public LDialog setOnClick(int viewId, View.OnClickListener listener) {
        getView(viewId).setOnClickListener(listener);
        return this;
    }

    public LDialog setImageRes(@IdRes int viewId, @DrawableRes int res) {
        ImageView view = getView(viewId);
        if (view != null) {
            view.setImageResource(res);
        }
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T getView(@IdRes int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }
}

