package com.kiwilss.xview.ui.view.dialog.custom;

import com.kiwilss.xview.R;
import com.kiwilss.xview.ui.view.dialog.base.BaseDialogFragment;

/**
 * @author : Lss Administrator
 * @FileName: BaseDialogTest
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/11
 * @desc : {DESCRIPTION}
 */
public class BaseDialogTest extends BaseDialogFragment {

    @Override
    protected void initInterface() {
        setText(R.id.tv_pw_onetitle_title,"换个标题");
    }

    @Override
    protected int initLayoutId() {
        return R.layout.pw_center;
    }
}

