package com.kiwilss.xview.ui.view.dialog.custom;

import android.view.Gravity;
import android.view.ViewGroup;

import com.kiwilss.xview.R;
import com.kiwilss.xview.ui.view.dialog.base.BaseDialogFragment;

/**
 * @author : Lss Administrator
 * @FileName: BaseDialogTest
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/11
 * @desc : {DESCRIPTION}
 */
public class BaseDialogTest2 extends BaseDialogFragment {

    @Override
    protected void initInterface() {
        setText(R.id.tv_pw_onetitle_title,"设置参数");

        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setGravity(Gravity.BOTTOM);

    }

    @Override
    protected int initLayoutId() {
        return R.layout.pw_center;
    }
}

