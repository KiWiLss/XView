package com.kiwilss.xview.utils.keyboard;

import android.content.res.Resources;

import com.kiwilss.xview.utils.Utils;

class UtilsBridge {



    public static int getStatusBarHeight() {
        Resources resources = Utils.INSTANCE.getContext().getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }

    public static int getNavBarHeight() {
        Resources res = Utils.INSTANCE.getContext().getResources();
        int resourceId = res.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId != 0) {
            return res.getDimensionPixelSize(resourceId);
        } else {
            return 0;
        }
    }
}