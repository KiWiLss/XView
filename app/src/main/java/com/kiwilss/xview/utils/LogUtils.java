package com.kiwilss.xview.utils;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : Lss Administrator
 * @FileName: LogUtils
 * @e-mail : kiwilss@163.com
 * @time : 2020/7/1
 * @desc : {DESCRIPTION}
 */
public class LogUtils {

    public static void main(String[] args) {
        System.out.println(getStringDate());
    }

    public static String getStringDate() {
        String currentTimeString = "2020-07-06 15:36:45";
        long time = string2Millis(currentTimeString, "yyyy-MM-dd HH:mm:ss");
        Date currentTime = new Date();
        currentTime.setTime(time);
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    public static Long string2Millis(String dateStr, String formatStr) {
        try {
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
            return simpleDateFormat.parse(dateStr).getTime();
        } catch (Exception e) {
            return 0L;
        }
    }

    public static final String TAG = "MMM";
    public static boolean isLog = true;


    public static void e(String content){
       e(content,TAG,"");
    }
    public static void e(Object content){
        e(content,TAG,"");
    }
    public static void e(Object content,String middle){
        e(content,TAG,middle);
    }
    public static void e(String content,String middle){
        e(content,TAG,middle);
    }
    public static void e(String content,String tag,String middle){
        if (isLog)
        Log.e(tag, middle + " ---- e: " + content );
    }
    public static void e(Object content,String tag,String middle){
        e(content == null ? "null" : content.toString(),tag,middle);
    }
}
