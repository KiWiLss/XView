package com.kiwilss.xview.ui.view.popup.easy;

import android.app.Activity;

import org.jetbrains.annotations.NotNull;

/**
 * @author : Lss Administrator
 * @FileName: XpopupJ
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/10
 * @desc : {DESCRIPTION}
 */
public class XpopupJ extends EasyPopup {
    int layoutId;
    int animStyle;
    float backgroundAlpha;
    boolean isMask;
    boolean isCancelableOutSide;



    public XpopupJ(@NotNull Activity activity, int layout) {
        super(activity, layout);
    }

    @Override
    public void setInterface() {


    }
}

