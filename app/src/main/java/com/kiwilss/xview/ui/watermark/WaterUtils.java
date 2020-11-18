package com.kiwilss.xview.ui.watermark;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * @author : Lss Administrator
 * @FileName: WaterUtils
 * @e-mail : kiwilss@163.com
 * @time : 2020/11/18
 * @desc : {DESCRIPTION}
 */
public class WaterUtils {
    /**
     * 绘制已经测量过的View
     */
    public static Bitmap drawMeasureView(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }

    /**
     * 先测量和布局，再生成Bitmap
     */
    public static Bitmap getBitmap(View view, Activity context) {

        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metric);
        int screenWidth= metric.widthPixels; // 屏幕宽度（像素）
        int screenHeight = metric.heightPixels; // 屏幕高度（像素）

        // 测量
        int widthSpec = View.MeasureSpec.makeMeasureSpec(screenWidth, View.MeasureSpec.AT_MOST);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(screenHeight, View.MeasureSpec.AT_MOST);
        view.measure(widthSpec, heightSpec);
        // 布局
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        view.layout(0, 0, measuredWidth, measuredHeight);
        // 绘制
        int width = view.getWidth();
        int height = view.getHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }
}

