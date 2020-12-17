package com.kiwilss.xview.ui.click.java;

import android.view.View;

/**
 * @author : Lss Administrator
 * @FileName: CustomClickListener
 * @e-mail : kiwilss@163.com
 * @time : 2020/12/17
 * @desc : {https://segmentfault.com/a/1190000016442998}
 */
public abstract class CustomClickListener implements View.OnClickListener {
    private long mLastTime;
    private long mTimeInterval = 1000L;

    public CustomClickListener() {
    }

    public CustomClickListener(long mTimeInterval) {
        this.mTimeInterval = mTimeInterval;
    }

    @Override
    public void onClick(View view) {
        long nowTime = System.currentTimeMillis();
        if (nowTime - mLastTime > mTimeInterval) {
            //单次点击
            onSingleClick(view);
            mLastTime = nowTime;
        } else {
            //快速点击
            onFastClick(view);
        }
    }

    protected abstract void onSingleClick(View view);

    protected void onFastClick(View view) {

    }
}
