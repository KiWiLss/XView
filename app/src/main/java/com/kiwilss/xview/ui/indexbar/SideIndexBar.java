package com.kiwilss.xview.ui.indexbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.kiwilss.xview.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 索引条
 *
 * @author xuexiang
 * @since 2018/12/29 上午11:57
 */
public class SideIndexBar extends View {
    private  String[] DEFAULT_INDEX_ITEMS = {"定位", "热门", "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

    private int mDefaultTextColor = Color.parseColor("#333333");
    private int mDefaultTextSize = 40;

    private List<String> mIndexItems;

    private Context mContext;
    /**
     * 每个index的高度
     */
    private float mItemHeight;
    private int mTextSize;
    private int mTextColor;
    private int mTextTouchedColor;
    private int mCurrentIndex = -1;

    private Paint mPaint;
    private Paint mTouchedPaint;

    private int mWidth;
    private int mHeight;
    /**
     * 居中绘制，文字绘制起点和控件顶部的间隔
     */
    private float mTopMargin;

    private TextView mOverlayTextView;
    private OnIndexTouchedChangedListener mOnIndexChangedListener;

    private int navigationBarHeight;

    public void setNavigationBarHeight(int height) {
        this.navigationBarHeight = height;
    }

    public SideIndexBar(Context context) {
        this(context, null);
    }

    public SideIndexBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SideIndexBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init(context,attrs);
    }

    private void init(Context context,AttributeSet attrs) {
        mIndexItems = new ArrayList<>();
        mIndexItems.addAll(Arrays.asList(DEFAULT_INDEX_ITEMS));


        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SideIndexBar);
        mTextSize = typedArray.getDimensionPixelSize(R.styleable.SideIndexBar_cpIndexBarTextSize,mDefaultTextSize);
        mTextColor = typedArray.getColor(R.styleable.SideIndexBar_cpIndexBarNormalTextColor, mDefaultTextColor);
        mTextTouchedColor = typedArray.getColor(R.styleable.SideIndexBar_cpIndexBarSelectedTextColor, mDefaultTextColor);

        typedArray.recycle();

//        TypedValue typedValue = new TypedValue();
//        context.getTheme().resolveAttribute(R.attr.cpIndexBarTextSize, typedValue, true);
//        mTextSize = context.getResources().getDimensionPixelSize(typedValue.resourceId);
//
//        context.getTheme().resolveAttribute(R.attr.cpIndexBarNormalTextColor, typedValue, true);
//        mTextColor = context.getResources().getColor(typedValue.resourceId);
//
//        context.getTheme().resolveAttribute(R.attr.cpIndexBarSelectedTextColor, typedValue, true);
//        mTextTouchedColor = context.getResources().getColor(typedValue.resourceId);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(mTextSize);
        mPaint.setColor(mTextColor);

        mTouchedPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTouchedPaint.setTextSize(mTextSize);
        mTouchedPaint.setColor(mTextTouchedColor);
    }

    public void setTextSize(@DimenRes int dimension){
        if (dimension != 0 && mPaint != null && mTouchedPaint != null && mContext != null){
            int dimen = mContext.getResources().getDimensionPixelSize(dimension);
            mPaint.setTextSize(dimen);
            mTouchedPaint.setTextSize(dimen);
            invalidate();
        }
    }
    public void setNormalColor(@ColorRes int color){
        if (color != 0 && mPaint != null && mContext != null){
            mPaint.setColor(ContextCompat.getColor(mContext,color));
            invalidate();
        }
    }

    public void  setSelectColor(@ColorRes int color){
        if (color != 0 && mTouchedPaint != null && mContext != null){
            mTouchedPaint.setColor(ContextCompat.getColor(mContext,color));
            invalidate();
        }
    }

    public void setDatas(List<String> datas){
        if (datas != null && !datas.isEmpty() && mIndexItems != null){
            mIndexItems.clear();
            mIndexItems.addAll(datas);
            invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String index;
        for (int i = 0; i < mIndexItems.size(); i++) {
            index = mIndexItems.get(i);
            Paint.FontMetrics fm = mPaint.getFontMetrics();
            canvas.drawText(index,
                    (mWidth - mPaint.measureText(index)) / 2,
                    mItemHeight / 2 + (fm.bottom - fm.top) / 2 - fm.bottom + mItemHeight * i + mTopMargin,
                    i == mCurrentIndex ? mTouchedPaint : mPaint);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getWidth();
        if (Math.abs(h - oldh) == navigationBarHeight) {
            //底部导航栏隐藏或显示
            mHeight = h;
        } else {
            //避免软键盘弹出时挤压
            mHeight = Math.max(getHeight(), oldh);
        }
        mItemHeight = mHeight / mIndexItems.size();
        mTopMargin = (mHeight - mItemHeight * mIndexItems.size()) / 2;
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        performClick();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                float y = event.getY();
                int indexSize = mIndexItems.size();
                int touchedIndex = (int) (y / mItemHeight);
                if (touchedIndex < 0) {
                    touchedIndex = 0;
                } else if (touchedIndex >= indexSize) {
                    touchedIndex = indexSize - 1;
                }
                if (mOnIndexChangedListener != null && touchedIndex >= 0 && touchedIndex < indexSize) {
                    if (touchedIndex != mCurrentIndex) {
                        mCurrentIndex = touchedIndex;
                        if (mOverlayTextView != null) {
                            mOverlayTextView.setVisibility(VISIBLE);
                            mOverlayTextView.setText(mIndexItems.get(touchedIndex));
                        }
                        mOnIndexChangedListener.onIndexChanged(mIndexItems.get(touchedIndex), touchedIndex);
                        invalidate();
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mCurrentIndex = -1;
                if (mOverlayTextView != null) {
                    mOverlayTextView.setVisibility(GONE);
                }
                invalidate();
                break;
            default:
                break;
        }
        return true;
    }

    public SideIndexBar setOverlayTextView(TextView overlay) {
        this.mOverlayTextView = overlay;
        return this;
    }

    public SideIndexBar setOnIndexChangedListener(OnIndexTouchedChangedListener listener) {
        this.mOnIndexChangedListener = listener;
        return this;
    }

    /**
     * 索引变化监听
     */
    public interface OnIndexTouchedChangedListener {
        /**
         * 索引发生变化
         *
         * @param index    字母序号
         * @param position
         */
        void onIndexChanged(String index, int position);
    }
}
