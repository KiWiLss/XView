package com.kiwilss.xview.ui.view.dialog.base;

import android.app.Dialog;
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
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.kiwilss.xview.R;

/**
 * @author : Lss Administrator
 * @FileName: BaseDialogFragment
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/11
 * @desc : {DESCRIPTION}
 */
public abstract class BaseDialogFragment extends DialogFragment {
    private SparseArray<View> views;

    public View mContentView;
    private int mWidth = WindowManager.LayoutParams.MATCH_PARENT;
    private int mHeight = WindowManager.LayoutParams.WRAP_CONTENT;
    private int mGravity = Gravity.CENTER;
    private int mAnimationStyle = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        views = new SparseArray<>();
        if (mContentView == null) {
            mContentView = inflater.inflate(initLayoutId(), container, false);
        }
        return mContentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initInterface();

    }

    public void setWidth(int width) {
        this.mWidth = width;
    }

    public void setHeight(int height) {
        this.mHeight = height;
    }

    public void setGravity(int gravity) {
        this.mGravity = gravity;
    }

    public void setmAnimationStyle(int animationStyle) {
        this.mAnimationStyle = animationStyle;
    }

    @Override
    public void onStart() {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setBackgroundDrawableResource(R.color.transparent);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = mWidth;
        attributes.height = mHeight;
        attributes.gravity = mGravity;
        attributes.windowAnimations = mAnimationStyle;
        window.setAttributes(attributes);
        super.onStart();
    }

    protected abstract void initInterface();

    protected abstract int initLayoutId();

    public void setText(int viewId, String text) {
        if (!TextUtils.isEmpty(text)) {
            TextView tv = getView(viewId);
            if (tv != null) {
                tv.setText(text);
            }
        }
    }

    public void setOnClick(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        if (view != null) {
            view.setOnClickListener(listener);
        }
    }

    public void setImageRes(@IdRes int viewId, @DrawableRes int res) {
        ImageView view = getView(viewId);
        if (view != null) {
            view.setImageResource(res);
        }
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


}

