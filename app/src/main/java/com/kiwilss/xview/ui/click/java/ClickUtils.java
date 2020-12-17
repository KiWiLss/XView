package com.kiwilss.xview.ui.click.java;

import android.view.View;

/**
 * @author : Lss Administrator
 * @FileName: ClickUtils
 * @e-mail : kiwilss@163.com
 * @time : 2020/12/17
 * @desc : {点击限制,只能对一个控件使用,多个控件使用时会在1s内都无法点击}
 */
public class ClickUtils {
    private static final int MIN_DELAY_TIME = 1000;  // 两次点击间隔不能少于1000ms
    private static long lastClickTime;

    public static boolean clickEnable() {
        boolean flag = false;
        long currentClickTime = System.currentTimeMillis();
        if ((currentClickTime - lastClickTime) >= MIN_DELAY_TIME) {
            flag = true;
        }
        lastClickTime = currentClickTime;
        return flag;
    }


    public void test(View view){
        view.setOnClickListener(new ClickProxy(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }));
    }


}

