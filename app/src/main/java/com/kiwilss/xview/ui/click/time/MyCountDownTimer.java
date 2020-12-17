package com.kiwilss.xview.ui.click.time;

import android.os.CountDownTimer;

import com.kiwilss.xview.utils.LogUtils;

/**
 * @author : Lss Administrator
 * @FileName: MyCountDownTimer
 * @e-mail : kiwilss@163.com
 * @time : 2020/12/17
 * @desc : {DESCRIPTION}
 */
public class MyCountDownTimer extends CountDownTimer {

    private long mCurrentTime;
    private boolean isPaused;
    private boolean isReStart;


    private long mTotalTime;
    private long mCountDownTime;
    public MyCountDownTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        mTotalTime = millisInFuture;
        mCountDownTime = countDownInterval;
    }

    @Override
    public void onTick(long l) {
        LogUtils.e(l / mCountDownTime + "------------" + mTotalTime);
        mCurrentTime = l/mCountDownTime;
    }

    @Override
    public void onFinish() {
        LogUtils.e("onFinish"+ mCurrentTime);
    }

    public void onRestart(){
        isReStart = true;
        onTick(mCurrentTime);
        LogUtils.e("restart"+ mCurrentTime);
    }

    public void onPause(){
        LogUtils.e("pause" + mCurrentTime);
        isPaused = true;
        cancel();
    }

}

