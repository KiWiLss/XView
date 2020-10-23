package com.kiwilss.xview.utils;

import android.text.Layout;
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
}
