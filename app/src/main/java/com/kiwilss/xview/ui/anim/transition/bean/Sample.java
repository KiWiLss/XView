package com.kiwilss.xview.ui.anim.transition.bean;

import android.annotation.SuppressLint;
import android.widget.ImageView;

import androidx.annotation.ColorRes;
import androidx.core.graphics.drawable.DrawableCompat;

import java.io.Serializable;

public class Sample implements Serializable {

    final int color;
    private final String name;

    public Sample(@ColorRes int color, String name) {
        this.color = color;
        this.name = name;
    }

    @SuppressLint("ResourceAsColor")
    public static void setColorTint(ImageView view, @ColorRes int color) {
        DrawableCompat.setTint(view.getDrawable(), color);
        //view.setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }


}