package com.kiwilss.xview.utils.date;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

/**
 * @author : Lss kiwilss
 * @FileName: LocalTimeUtil
 * @e-mail : kiwilss@163.com
 * @time : 2020/7/26
 * @desc : {DESCRIPTION}
 */
public class LocalTimeUtil {
    public static String PATTEN_HMS = "HH:mm:ss";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) {

        System.out.println(getNowLocalTime());
        System.out.println(modifyLocalTime(getNowLocalTime(), 1, ChronoField.HOUR_OF_DAY));
        System.out.println(modifyLocalTime(getNowLocalTime(), 1, ChronoField.MINUTE_OF_HOUR));


    }

    /**
     * 获取当前日期的时分秒,示例16:38:44.216
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalTime getNowLocalTime() {
        return LocalTime.now();
    }

    /**
     * 获取当前时间 String
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getNowString() {
        return localTime2String(getNowLocalTime());
    }

    /**
     * 获取当前时间 String
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getNowString(String patten) {
        return localTime2String(getNowLocalTime(), patten);
    }

    /**
     * 获取当前时间的小时
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowHour() {
        return LocalTime.now().getHour();
    }

    /**
     * 获取当前时间的分钟
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowMinute() {
        return LocalTime.now().getMinute();
    }

    /**
     * 获取当前时间的秒
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowSecond() {
        return LocalTime.now().getSecond();
    }


    /**
     * 获取指定时分秒的 date,
     * 传值示例 4 , 4, 50
     * 返回示例04:04:50
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalTime getAnyLocalTime(int hour, int minute, int second) {
        return LocalTime.of(hour, minute, second);
    }

    /**
     * 获取任意时间的小时
     *
     * @param localTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAnyHour(LocalTime localTime) {
        return localTime.getHour();
    }

    /**
     * 获取任意时间的分钟
     *
     * @param localTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAnyMinute(LocalTime localTime) {
        return localTime.getMinute();
    }

    /**
     * 获取任意时间的秒
     *
     * @param localTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAnySecond(LocalTime localTime) {
        return localTime.getSecond();
    }

    /**
     * LocalTime ------>  String, 默认格式
     *
     * @param localTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String localTime2String(LocalTime localTime) {
        return localTime.format(DateTimeFormatter.ofPattern(PATTEN_HMS));
    }

    /**
     * LocalTime ------>  String
     *
     * @param localTime
     * @param patten
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String localTime2String(LocalTime localTime, String patten) {
        return localTime.format(DateTimeFormatter.ofPattern(patten));
    }

    /**
     * 增加时间,可以是时分秒
     *
     * @param localTime
     * @param unit
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalTime getPlus(LocalTime localTime, int num, TemporalUnit unit) {
        return localTime.plus(num, unit);
    }

    /**
     * 减少时间,可以是时分秒
     *
     * @param localTime
     * @param num
     * @param unit
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalTime getMinu(LocalTime localTime, int num, TemporalUnit unit) {
        return localTime.minus(num, unit);
    }

    /**
     * 修改时间为指定时间 12:00
     *
     * @param localTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalTime modifyLocalTime(LocalTime localTime) {
        return localTime.with(LocalTime.NOON);
    }

    /**
     * 修改为指定的时间,可以修改时分秒
     * 示例: getNowLocalTime(),1, ChronoField.HOUR_OF_DAY 当前时间22:29:09.180
     * 返回: 01:29:09.181
     * 将时间的小时改为了 1
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalTime modifyLocalTime(LocalTime localTime, int num, TemporalField field) {
        return localTime.with(field, num);
    }

    /**
     * 两个时间进行比较 大返回1，小就返回-1，一样就返回0
     *
     * @param localTimeOne
     * @param localTimeTwo
     * @return
     */
    public static int betweenTime(LocalTime localTimeOne, LocalTime localTimeTwo) {
        return localTimeOne.compareTo(localTimeTwo);
    }

    /**
     * 第一个时间是否在第二个时间前面
     *
     * @param localTimeOne
     * @param localTimeTwo
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isBefore(LocalTime localTimeOne, LocalTime localTimeTwo) {
        return localTimeOne.isBefore(localTimeTwo);
    }

    /**
     * 第一个时间是否在第二个时间后面
     *
     * @param localTimeOne
     * @param localTimeTwo
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isAfter(LocalTime localTimeOne, LocalTime localTimeTwo) {
        return localTimeOne.isAfter(localTimeTwo);
    }


}
