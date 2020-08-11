package com.kiwilss.xview.ui.view.dialog.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.LayoutInflater;
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
 * @FileName: XDialog
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/11
 * @desc : {DESCRIPTION}
 */
public class XDialog extends Dialog {
    private final SparseArray<View> views = new SparseArray<>();
    private int mWidth ;
    private int mHeight;
    private int mGravity;
    private int mAnimationStyle;//默认没有动画效果
    private Context mContext;
    private int layoutResId;
    private View mContentView;
    public XDialog(@NonNull Context context,Builder builder) {
        super(context);
        mWidth = builder.width;
        mHeight = builder.height;
        mGravity = builder.gravity;
        mAnimationStyle = builder.animationStyle;
        mContext = builder.context;
        this.layoutResId = builder.layoutResId;
        mContentView = LayoutInflater.from(mContext).inflate(layoutResId, null);
        setContentView(mContentView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initInterface(savedInstanceState);
        //setContentView(layoutResId);
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

    public XDialog setText(int viewId, String text) {
        if (!TextUtils.isEmpty(text)) {
            TextView tv = getView(viewId);
            if (tv != null) {
                tv.setText(text);
            }
        }
        return this;
    }

    public XDialog setOnClick(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        if (view != null) {
            view.setOnClickListener(listener);
        }
        return this;
    }

    public XDialog setImageRes(@IdRes int viewId, @DrawableRes int res) {
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
            view = mContentView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    public static final class Builder {

        private int width = ViewGroup.LayoutParams.MATCH_PARENT;
        private int height  = ViewGroup.LayoutParams.WRAP_CONTENT;
        private int gravity  = Gravity.CENTER;
        private int animationStyle  = 0;
        private Context context;
        private int layoutResId;

        public Builder(Context context,int layoutResId) {
            this.context = context;
            this.layoutResId = layoutResId;
        }
//        public Builder layoutResId(int layoutResId){
//            this.layoutResId = layoutResId;
//            return this;
//        }
        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder gravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        public Builder animationStyle(int animationStyle) {
            this.animationStyle = animationStyle;
            return this;
        }

        public XDialog build() {
            return new XDialog(context,this);
        }
    }
}

