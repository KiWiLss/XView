package com.kiwilss.xview.design.appbar;

import com.google.android.material.appbar.AppBarLayout;

public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {
  
    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }
  
    private State mCurrentState = State.IDLE;
  
    @Override
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (i == 0) {
            if (mCurrentState != State.EXPANDED) {
                onStateChanged(appBarLayout, State.EXPANDED,i);
            }
            mCurrentState = State.EXPANDED;
        } else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
            if (mCurrentState != State.COLLAPSED) {
                onStateChanged(appBarLayout, State.COLLAPSED,i);
            }
            mCurrentState = State.COLLAPSED;
        } else {
            if (mCurrentState != State.IDLE) {
                onStateChanged(appBarLayout, State.IDLE,i);
            }
            mCurrentState = State.IDLE;
        }
        onStateChangedAny(appBarLayout,i);
    }
  
    public abstract void onStateChanged(AppBarLayout appBarLayout, State state,int i);

    /**
     * 任意滚动位置都可以监听
     * @param appBarLayout
     * @param i
     */
    public void onStateChangedAny(AppBarLayout appBarLayout, int i){

    }
}