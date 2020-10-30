package com.kiwilss.xview.utils;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import android.widget.TextView;

/**
 * textView指定行数的内容
 */
public class StringLengthsUtil {
    /**
     * 获取多行的内容
     */
    public static String getMultipleLines(TextView tvBrief, int maxLine) {
        String text = tvBrief.getText().toString();
        Layout layout = tvBrief.getLayout();
        String summary = "";
        int start = 0;
        int end;
        for (int i = 0; i < maxLine; i++) {
            end = layout.getLineEnd(i);
            summary = summary + text.substring(start, end);
            start = end;
        }
        return summary;
    }

    /**
     * 获取单行指定行数的内容
     */
    public static String getSingleLines(TextView tvBrief, int line) {
        String text = tvBrief.getText().toString();
        Layout layout = tvBrief.getLayout();
        int end = layout.getLineEnd(line);
        LogUtils.e(end);
        return text.substring(0, end); //指定行的内容
    }

    /**
     * 获取多行指定行数的内容
     *
     * @param tvBrief
     * @param startLines 开始行
     * @param endLines   结束行
     * @return
     */
    public static String getDesignationLines(TextView tvBrief, int startLines, int endLines) {
        if (startLines > endLines) {
            return "error:开始行数不可大于结束行数";
        } else if (startLines == endLines) {
            return "error:开始行数不可等于结束行数";
        }
        String text = tvBrief.getText().toString();
        Layout layout = tvBrief.getLayout();
        String summary = "";
        int start = 0;
        int end;
        for (int i = startLines; i < endLines; i++) {
            end = layout.getLineEnd(i);
            summary = summary + text.substring(start, end);
            start = end;
        }
        return summary;
    }


    /**
     * 设置textView结尾...后面显示的文字和颜色
     * @param context 上下文
     * @param textView textview
     * @param minLines 最少的行数
     * @param originText 原文本
     * @param endText 结尾文字
     * @param endColorID 结尾文字颜色id
     * @param isExpand 当前是否是展开状态
     */
    public void toggleEllipsize(final Context context,
                                final TextView textView,
                                final int minLines,
                                final String originText,
                                final String endText,
                                final int endColorID,
                                final boolean isExpand) {
        if (TextUtils.isEmpty(originText)) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver
                .OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (isExpand) {
                    textView.setText(originText);
                } else {
                    int paddingLeft = textView.getPaddingLeft();
                    int paddingRight = textView.getPaddingRight();
                    TextPaint paint = textView.getPaint();
                    float moreText = textView.getTextSize() * endText.length();
                    float availableTextWidth = (textView.getWidth() - paddingLeft - paddingRight) *
                            minLines - moreText;
                    CharSequence ellipsizeStr = TextUtils.ellipsize(originText, paint,
                            availableTextWidth, TextUtils.TruncateAt.END);
                    if (ellipsizeStr.length() < originText.length()) {
                        CharSequence temp = ellipsizeStr + endText;
                        SpannableStringBuilder ssb = new SpannableStringBuilder(temp);
                        ssb.setSpan(new ForegroundColorSpan(context.getResources().getColor
                                        (endColorID)),
                                temp.length() - endText.length(), temp.length(),    Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                        textView.setText(ssb);
                    } else {
                        textView.setText(originText);
                    }
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    textView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });
    }


    /**
     * 获取textview一行最大能显示几个字(需要在TextView测量完成之后)
     *
     * @param text     文本内容
     * @param paint     textview.getPaint()
     * @param maxWidth  textview.getWidth()/或者是指定的数值,如200dp
     * @return
     */
    public static int getLineMaxNumber(String text, TextPaint paint, float maxWidth) {
        if (null == text || "".equals(text)) {
            return 0;
        }
        //得到文本内容总体长度
        float textWidth = paint.measureText(text);
        // textWidth
        float width = textWidth / text.length();
        return (int) (maxWidth / width);
    }

    /**
     * 获取textview一行最大能显示几个字(需要在TextView测量完成之后)
     *
     * @param text     文本内容
     * @param paint    textview.getPaint()
     * @param maxWidth textview.getMaxWidth()/或者是指定的数值,如200dp
     */
    public static int getLineMaxNumber(String text, TextPaint paint, int maxWidth) {
        if (null == text || "".equals(text)) {
            return 0;
        }
        StaticLayout staticLayout = new StaticLayout(text, paint, maxWidth, Layout.Alignment.ALIGN_NORMAL
                , 1.0f, 0, false);
        //获取第一行最后显示的字符下标
        return staticLayout.getLineEnd(0);
    }




}
