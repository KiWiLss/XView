package com.kiwilss.xview.utils;

import android.util.Log;

/**
 * @author : Lss Administrator
 * @FileName: LogUtils
 * @e-mail : kiwilss@163.com
 * @time : 2020/7/1
 * @desc : {DESCRIPTION}
 */
public class LogUtils {

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
