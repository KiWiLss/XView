package com.kiwilss.xview.utils.date;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author : Lss kiwilss
 * @FileName: DateUtils
 * @e-mail : kiwilss@163.com
 * @time : 2020/7/21
 * @desc : {DESCRIPTION}
 */
public class TimeUtils {

    public static String PATTEN_YMD = "yyyy-MM-dd";
    public static String PATTEN_YMDHMS = "yyyy-MM-dd HH:mm:ss";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) {
        System.out.println("------------------");
        System.out.println(getNowLocalTime());
        System.out.println(getNowString());
        System.out.println(getNowDayOfYear());
    }

    /**
     * 获取当前时间相关
     */
    /**
     * 获取当前时间,只能在 26 及以上版本使用,格式 LocalDateTime
     *
     * @return 示例2020-07-20T16:38:44.216
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getNowLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前时间,只能在 26 及以上版本使用,格式 LocalDate
     *
     * @return 示例2020-07-20
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate getNowLocalDate() {
        return LocalDate.now();
    }

    /**
     * 获取当前时间,只能在 26 及以上版本使用,格式 LocalDate
     *
     * @return 22:48:23.534
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalTime getNowLocalTime() {
        return LocalTime.now();
    }

    /**
     * 获取当前时间 Date 类型
     *
     * @return
     */
    public static Date getNowDate() {
        return DateUtil.getNowDate();
    }

    /**
     * 获取当前时间字符串,年月日时分秒
     *
     * @return 2020-07-21 22:56:27
     */
    public static String getNowString() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime nowDateYMDHMS = LocalDateUtil.getNowDateYMDHMS();
            return LocalDateUtil.date2String(nowDateYMDHMS);
        } else {
            return DateUtil.getNowString();
        }
    }

    /**
     * 获取当前时间的时间戳,毫秒
     *
     * @return
     */
    public static long getNowMilli() {
        return DateUtil.getNowMills();
    }

    /**
     * 获取当前时间的时间戳,秒
     *
     * @return
     */
    public static long getNowSecond() {
        return getNowMilli() / 1000;
    }

    /**
     * 获取当前日期的年
     *
     * @return
     */
    public static int getNowYear() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return LocalDateUtil.getNowYear();
        } else {
            return DateUtil.getNowY2();
        }
    }

    /**
     * 获取当前日期的月
     *
     * @return 示例 7/ 12
     */
    public static int getNowMonth() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return LocalDateUtil.getNowMonth();
        } else {
            return DateUtil.getNowMonth();
        }
    }

    /**
     * 获取当前日期是该月的第几天
     *
     * @return
     */
    public static int getNowDay() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return LocalDateUtil.getNowDay();
        } else {
            return DateUtil.getNowDay();
        }
    }

    /**获取当前是几点,二十四小时制
     * @return
     */
    public static int getNowHour(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return LocalDateUtil.getNowHour();
        } else {
            return DateUtil.getNowHour();
        }
    }

    /**获取当前时间的分钟
     * @return
     */
    public static int getNowMinute(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return LocalDateUtil.getNowMinute();
        } else {
            return DateUtil.getNowMinute();
        }
    }
    /**获取当前时间的秒
     * @return
     */
    public static int getNowSecond2(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return LocalDateUtil.getNowSecond();
        } else {
            return DateUtil.getNowSecond();
        }
    }

    /**获取当前日期的星期,星期一返回1
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowWeek(){
        return LocalDateUtil.getNowWeek();
    }

    /**获取当前日期是该周的第几天,周日是第一天返回 1,周六最后一天返回 7
     * @return
     */
    public static int getNowWeek2(){
        return DateUtil.getNowWeek();
    }

    /**获取今天是今年的第几天
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowDayOfYear(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return LocalDateUtil.getNowDayOfYear();
        } else {
            return DateUtil.getNowDayOfYear();
        }
    }

    /**获取任意指定的时间
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getAnyLocalDateTime(int year, int month, int day, int hour, int minute, int second) {
        return LocalDateTime.of(year, month, day, hour, minute, second);
    }

    /**获取任意时间的年
     * @param localDateTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getYear(LocalDateTime localDateTime){
        return LocalDateUtil.getAppointYear(localDateTime);
    }

    /**获取任意时间的年
     * @param date
     * @return
     */
    public static int getYear(Date date){
        return DateUtil.getYear(date);
    }

    /**获取任意时间的年
     * @param time 默认时间格式PATTEN_YMDHMS
     * @return
     */
    public static int getYear(String time){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime localDateTime = LocalDateUtil.string2Date(time);
           return LocalDateUtil.getAppointYear(localDateTime);
        } else {
            return DateUtil.getYear(time);
        }
    }

    /**获取任意时间的年
     * @param time 2020-07-22
     * @param pattern 'yyyy-MM-dd
     * @return
     */
    public static int getYear(String time, String pattern){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime localDateTime = LocalDateUtil.string2Date(time,pattern);
            return LocalDateUtil.getAppointYear(localDateTime);
        } else {
            return DateUtil.getYear(time,pattern);
        }
    }

    /**
     获取任意时间的年
     * @param time 时间戳,毫秒
     * @return
     */
    public static int getYear(long time){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime localDateTime = LocalDateUtil.milli2LocalDateTime(time);
            return LocalDateUtil.getAppointYear(localDateTime);
        } else {
            return DateUtil.getYear(time);
        }
    }

    /**获取任意时间的月份
     * @param time  默认时间格式
     * @return
     */
    public static int getMonth(String time){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime localDateTime = LocalDateUtil.string2Date(time);
            return LocalDateUtil.getAppointMonth(localDateTime);
        } else {
            return DateUtil.getMonth(time);
        }
    }

    /**获取任意时间的月份,自定义时间格式
     * @param time
     * @param pattern
     * @return
     */
    public static int getMonth(String time, String pattern){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime localDateTime = LocalDateUtil.string2Date(time,pattern);
            return LocalDateUtil.getAppointMonth(localDateTime);
        } else {
            return DateUtil.getMonth(time,pattern);
        }
    }

    /**获取任意时间戳的年,毫秒
     * @param time
     * @return
     */
    public static int getMonth(long time){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime localDateTime = LocalDateUtil.milli2LocalDateTime(time);
            return LocalDateUtil.getAppointMonth(localDateTime);
        } else {
            return DateUtil.getMonth(time);
        }
    }



}
