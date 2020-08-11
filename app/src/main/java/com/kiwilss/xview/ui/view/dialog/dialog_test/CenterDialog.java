package com.kiwilss.xview.ui.view.dialog.dialog_test;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.kiwilss.xview.R;
import com.kiwilss.xview.ui.view.dialog.base.LDialog;

/**
 * @author : Lss Administrator
 * @FileName: CenterDialog
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/11
 * @desc : {DESCRIPTION}
 */
public class CenterDialog extends LDialog {

    public CenterDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void initInterface(Bundle savedInstanceState) {

                setWidth(ViewGroup.LayoutParams.MATCH_PARENT)//设置宽度
                .setHeight(ViewGroup.LayoutParams.WRAP_CONTENT)//设置高度
                .setGravity(Gravity.BOTTOM)//设置显示位置
                        //.setImageRes()//设置图标
                        //.setAnimationStyle()//设置动画
                .setText(R.id.tv_pw_onetitle_title,"测试LDialog")//设置控件文字
                .setOnClick(R.id.tv_pw_onetitle_cancel, new View.OnClickListener() {//设置点击
                    @Override
                    public void onClick(View view) {
                        dismiss();
                    }
                });
               // getView() 获取控件

    }

    @Override
    protected int initContentView() {
        return R.layout.pw_center;
    }
}

