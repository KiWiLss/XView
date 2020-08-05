package com.kiwilss.xview.ui.view.popup;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * 从下方弹出的PopupWindow,仿iphone效果，增加半透明蒙层。
 * <p>
 * 实现原理：<br>
 * 在弹出自定义的PopupWindow时，增加一个半透明蒙层view到窗口，并置于PopupWindow下方。
 * </p>
 * <p>
 * 使用方法：<br>
 * 继承BottomPushPopupWindow，编写generateCustomView添加自定义的view，调用show方法显示。
 * </p>
 *
 * @author y
 */
public abstract class BottomPushPopupWindow<T> extends PopupWindow {

    protected Activity activity;
    private boolean isMask = true;//背景是否有阴影
//    private WindowManager wm;
//    private View maskView;

    //@SuppressWarnings("deprecation")
    public BottomPushPopupWindow(Activity activity, T t) {
        super(activity);
        this.activity = activity;
        //wm  =  (WindowManager)  context.getSystemService(Context.WINDOW_SERVICE);
        initType();
        setContentView(generateCustomView(t));
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //默认设置点击外部区域消失
        setIsClickDismiss(true);
        //setBackgroundDrawable(context.getResources().getDrawable(android.R.color.transparent));
    }

    protected abstract View generateCustomView(T t);

    @TargetApi(23)
    private void initType() {
        //  解决华为手机在home建进入后台后，在进入应用，蒙层出现在popupWindow上层的bug。
        //  android4.0及以上版本都有这个hide方法，根据jvm原理，可以直接调用，选择android6.0版本进行编译即可。
        setWindowLayoutType(WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL);
    }


    public void setIsMask(boolean isMask) {
        this.isMask = isMask;
    }

    public void setPopupWidth(int width) {
        setWidth(width);
    }

    public void setPopupHeight(int height) {
        setHeight(height);
    }

    /**
     * 设置是否点击外部区域消失
     *
     * @param isDismiss
     */
    public void setIsClickDismiss(boolean isDismiss) {
        if (isDismiss) {
            setOutsideTouchable(true);
            setFocusable(true);
            setBackgroundDrawable(new ColorDrawable());
        } else {
            setOutsideTouchable(false);
            setFocusable(false);
            setTouchable(true);
        }
    }

    /**
     * 作为对话框显示
     * 显示在界面的底部
     */
    public void showBottom() {
        if (activity != null) {
            showAtLocation(activity.getWindow().getDecorView(), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        }
    }

    public void showBottom(Activity activity) {
        if (activity != null) {
            showAtLocation(activity.getWindow().getDecorView(), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        }
    }

    public void showCenter() {
        if (activity != null) {
            showAtLocation(activity.getWindow().getDecorView(), Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
        }
    }

    public void showCenter(Activity activity) {
        if (activity != null) {
            showAtLocation(activity.getWindow().getDecorView(), Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
        }
    }

    public void showTop() {
        if (activity != null) {
            showAtLocation(activity.getWindow().getDecorView(), Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
        }
    }

    public void showTop(Activity activity) {
        if (activity != null) {
            showAtLocation(activity.getWindow().getDecorView(), Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
        }
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        if (isMask) {
            setScreenMaskView(0.5f);
        }
        super.showAtLocation(parent, gravity, x, y);
    }

    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        if (isMask) {
            setScreenMaskView(0.5f);
        }
        super.showAsDropDown(anchor, xoff, yoff);
    }

    public void showAsDropDown(View anchor) {
        showAsDropDown(anchor, 0, 0);
    }

    @Override
    public void dismiss() {
        if (isMask) {
            setScreenMaskView(1f);
        }
        super.dismiss();
    }


    public void setScreenMaskView(float alpha) {
        if (activity != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.alpha = alpha;
            activity.getWindow().setAttributes(attributes);
        }
    }


//    private  void  addMaskView(IBinder token)  {
//        WindowManager.LayoutParams  p  =  new  WindowManager.LayoutParams();
//        p.width  =  WindowManager.LayoutParams.MATCH_PARENT;
//        p.height  =  WindowManager.LayoutParams.MATCH_PARENT;
//        p.format  =  PixelFormat.TRANSLUCENT;
//        p.type  =  WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
//        p.token  =  token;
//        p.windowAnimations = android.R.style.Animation_Toast;
//        maskView = new View(context);
//        maskView.setBackgroundColor(0x7f000000);
//        //  maskView.setFitsSystemWindows(false);
//        // 华为手机在home建进入后台后，在进入应用，蒙层出现在popupWindow上层，导致界面卡死，
//        // 这里新增加按bug返回。
//        // initType方法已经解决该问题，但是还是留着这个按back返回功能，防止其他手机出现华为手机类似问题。
//        maskView.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if (keyCode == KeyEvent.KEYCODE_BACK) {
//                    removeMaskView();
//                    return true;
//                }
//                return false;
//            }
//        });
//        wm.addView(maskView, p);
//    }

//    private void removeMaskView() {
//        if (maskView != null) {
//            wm.removeViewImmediate(maskView);
//            maskView = null;
//        }
//    }
}