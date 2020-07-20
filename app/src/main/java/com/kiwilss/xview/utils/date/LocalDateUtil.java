package com.kiwilss.xview.utils.date;

import android.annotation.SuppressLint;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author : Lss Administrator
 * @FileName: LocalDateUtil
 * @e-mail : kiwilss@163.com
 * @time : 2020/7/20
 * @desc : {LocalDateTime工具相关}
 */
public class LocalDateUtil {

    public static String PATTEN_YMD = "yyyy-MM-dd";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) {
        System.out.println("------------------LocalDateTime--------------");



//        long dayDiff = dayDiff("2020-07-16", "2020-07-20", PATTEN_YMD);
//        System.out.println(dayDiff);
//        System.out.println(getNowString());
//        System.out.println(string2String("2020-07-20 14:34:20"));
    }

    public static String string2String(String dateTime) {
        Date date = string2Date(dateTime, "yyyy-MM-dd HH:mm:ss");
        return date2String(date, "yyyy.MM.dd HH:mm:ss");
    }

    public static String date2String(Date date, String pattern) {
        return getDateParser(pattern).format(date);
    }

    public static Date string2Date(String time, String pattern) {
        try {
            return getDateParser(pattern).parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressLint("SimpleDateFormat")
    private static SimpleDateFormat getDateParser(String pattern) {
        return new SimpleDateFormat(pattern);
    }


    /**
     * 获取当前时间,返回格式2020-07-20
     *
     * @return
     */
    public static String getNowString() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(getNowMills());
    }

    /**
     * 获取当前时间的时间戳,毫秒
     *
     * @return
     */
    public static long getNowMills() {
        return System.currentTimeMillis();
    }

    public static long dayDiff(String startTimeStr, String endTimeStr, String format) {
//        if (TextUtils.isEmpty(startTimeStr) || TextUtils.isEmpty(endTimeStr)) {
//            return 0;
//        }
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formater = new SimpleDateFormat(format);
        long diff = 0L;
        try {
            long startTime = formater.parse(startTimeStr).getTime();
            long endTime = formater.parse(endTimeStr).getTime();
            diff = (endTime - startTime) / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diff;
    }

    /**
     * 获取今天日期 ,返回示例2020-07-20T16:38:44.216
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getNowDateYMDHMS() {
        return LocalDateTime.now();
    }

    /**
     * localdata 获取当前日期年月日,返回示例2020-07-20
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate getNowDateYMD() {
        return LocalDate.now();
    }

    /**
     * 获取今天日期的年份,返回示例2020
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowYear() {
        LocalDateTime nowDate = getNowDateYMDHMS();
        return nowDate.getYear();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowYear2() {
        return LocalDate.now().getYear();
    }

    /**
     * 获取当前日期的月份,返回示例 7
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowMonth() {
        LocalDateTime nowDate = getNowDateYMDHMS();
        return nowDate.getMonthValue();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowMonth2() {
        return LocalDate.now().getMonthValue();
    }

    /**
     * 返回今天日期是多少号,返回示例20
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowDay() {
        LocalDateTime nowDate = getNowDateYMDHMS();
        return nowDate.getDayOfMonth();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowDay2() {
        return LocalDate.now().getDayOfMonth();
    }

    /**
     * 获取现在日期的小时,返回示例16
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowHour() {
        LocalDateTime nowDate = getNowDateYMDHMS();
        return nowDate.getHour();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowHour2() {
        return LocalTime.now().getHour();
    }

    /**
     * 获取当前时间的分钟,示例38
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowMinute() {
        LocalDateTime nowDate = getNowDateYMDHMS();
        return nowDate.getMinute();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowMinute2() {
        return LocalTime.now().getMinute();
    }

    /**
     * 返回当前时间的秒,示例20
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowSecond() {
        LocalDateTime nowDate = getNowDateYMDHMS();
        return nowDate.getSecond();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowSecond2() {
        return LocalTime.now().getSecond();
    }

    /**
     * 获取当前日期的星期,星期一返回1
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowWeek2() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        return dayOfWeek.getValue();
    }

    /**
     * 获取今天是今年的第多少天,示例202
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowDayOfYear2() {
        return LocalDate.now().getDayOfYear();
    }

    /**
     * 获取当前日期的时分秒,示例16:38:44.216
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalTime getNowHMS() {
        return LocalTime.now();
    }


    /**
     * 获取指定日期相关,获取指定年月日时分秒的date
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getAppointDateYMDHMS(int year, int month, int day, int hour, int minute, int second) {
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute, second);
        return localDateTime;
    }

    /**
     * 获取指定年月日的date
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate getAppointDateYMD(int year, int month, int day) {
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalTime getAppointDateTime(int hour, int minute, int second) {
        return LocalTime.of(hour, minute, second);
    }

    /**
     * 获取指定时间的年份,返回示例2020
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAppointYear(LocalDateTime dateTime) {//
        return dateTime.getYear();
    }

    /**
     * 获取指定日期的月份,返回示例8
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAppointMonth(LocalDateTime dateTime) {//
        return dateTime.getMonthValue();
    }
    /**
     * 获取指定日期的天,返回示例8
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAppointDay(LocalDateTime dateTime){
        return dateTime.getDayOfMonth();
    }
    /**
     * 获取指定日期的星期,返回示例8
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAppointWeek(LocalDateTime dateTime){
        return dateTime.getDayOfWeek().getValue();
    }


}

