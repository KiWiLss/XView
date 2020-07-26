package com.kiwilss.xview.utils.date;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
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
    public static String PATTEN_YMDHMS = "yyyy-MM-dd HH:mm:ss";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) {
        System.out.println("------------------LocalDateTime--------------");
        long day = betweenTwoTime(getAnyLocalDate(2020, 7, 24)
                , getAnyLocalDate(2020, 7, 20), ChronoUnit.DAYS);

        long milli = localDate2Milli(getNowLocalDate());
        System.out.println(milli);
        System.out.println(milli2LocalDate(milli));
    }

    /**
     * localdata 获取当前日期年月日,返回示例2020-07-20
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate getNowLocalDate() {
        return LocalDate.now();
    }

    /**
     * 获取当前日期,string 类型
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getNowString() {
        return localDate2String(getNowLocalDate());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getNowString(String patten) {
        return localDate2String(getNowLocalDate(), patten);
    }

    /**
     * 获取当前时间的年
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowYear() {
        return LocalDate.now().getYear();
    }

    /**
     * 获取当前时间的月
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowMonth() {
        return LocalDate.now().getMonthValue();
    }

    /**
     * 获取当前时间的号
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowDay() {
        return LocalDate.now().getDayOfMonth();
    }


    /**
     * 获取当前日期的星期,星期一返回1
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowWeek() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        return dayOfWeek.getValue();
    }

    /**
     * 获取今天是今年的第几周
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowWeekOfYear() {
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1);
        return getNowLocalDate().get(weekFields.weekOfYear());
    }

    /**
     * 获取今天是本月的第几周
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowWeekOfMonth() {
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1);
        return getNowLocalDate().get(weekFields.weekOfMonth());
    }

    /**
     * 获取今天是今年的第多少天,示例202
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowDayOfYear() {
        return LocalDate.now().getDayOfYear();
    }

    /**
     * 获取今天是几号,等同于 getNowDay
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowDayOfMonth() {
        return LocalDate.now().getDayOfMonth();
    }

    /**
     * 获取指定年月日的LocalDate
     * 传值示例 2020, 10,4
     * 返回示例2020-10-04
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate getAnyLocalDate(int year, int month, int day) {
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate;
    }

    /**
     * 获取指定时间的 string 类型,默认格式
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getAnyString(int year, int month, int day) {
        LocalDate localDate = getAnyLocalDate(year, month, day);
        return localDate2String(localDate);
    }

    /**
     * 获取指定时间的 string 类型,自定义格式
     *
     * @param year
     * @param month
     * @param day
     * @param patten
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getAnyString(int year, int month, int day, String patten) {
        LocalDate localDate = getAnyLocalDate(year, month, day);
        return localDate2String(localDate, patten);
    }

    /**
     * 获取指定时间的年份,返回示例2020
     *
     * @param localDate
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAnyYear(LocalDate localDate) {
        return localDate.getYear();
    }

    /**
     * 获取指定日期的月份,返回示例8
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAnyMonth(LocalDate localDate) {
        return localDate.getMonthValue();
    }

    /**
     * 获取指定日期的天
     *
     * @param localDate
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAnyDay(LocalDate localDate) {
        return localDate.getDayOfMonth();
    }


    /**
     * 获取指定日期的星期,周一返回 1
     *
     * @param localDate
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAnyWeek(LocalDate localDate) {
        return localDate.getDayOfWeek().getValue();
    }

    /**获取任意时间在月份的第几周
     * @param localDate
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAnyWeekOfMonth(LocalDate localDate){
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1);
        return localDate.get(weekFields.weekOfMonth());
    }

    /**获取任意时间在年份的第几周
     * @param localDate
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAnyWeekOfYear(LocalDate localDate){
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1);
        return localDate.get(weekFields.weekOfYear());
    }
    /**
     * LocalDate -->  string ,返回默认格式
     * System.out.println(date2String(getNowDateYMD())),返回2020-07-20
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String localDate2String(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern(PATTEN_YMD));
    }

    /**
     * LocalDate -->  string,返回指定模式
     * System.out.println(date2String(getNowDateYMD(),"yyyy年MM月dd日"));
     * 返回示例:2020年07月20日
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String localDate2String(LocalDate localDate, String pattern) {
        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * LocalDate  + LocalTime ----->   LocalDateTime
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime localDate2LocalDateTime(LocalDate localDate, LocalTime localTime) {
        return localDate.atTime(localTime);
    }

    /**
     * string -->  localdate, string默认格式yyyy-MM-dd,
     * 传值2020-07-11
     * 返回示例2020-07-11
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate string2LocalDate(String date) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern(PATTEN_YMD);
        return LocalDate.parse(date, pattern);
    }

    /**
     * string -->  localdate, string指定格式(必须保证前面的时间和后面的格式一致)
     * 传值2020/07/11,pattern = yyyy/MM/dd    返回示例2020-07-11
     * 传值示例: 2020/07/25 12:23:45  yyyy/MM/dd HH:mm:ss 返回示例:2020-07-25
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate string2LocalDate(String date, String pattern) {
        DateTimeFormatter patterns = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(date, patterns);
    }

    /**LocalDate转时间戳
     * @param localDate
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static long localDate2Milli(LocalDate localDate){
        return localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
    }

    /**时间戳转 LocalDate
     * @param time
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate milli2LocalDate(long time){
       return Instant.ofEpochMilli(time).atZone(ZoneOffset.ofHours(8)).toLocalDate();
    }

    /**LocalDate  ----->  Date
     * @param localDate
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Date localDate2Date(LocalDate localDate){
        return Date.from(localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());
    }

    /**Date  ------>  LocalDate
     * @param date
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate date2LocalDate(Date date){
        return date.toInstant().atZone(ZoneOffset.ofHours(8)).toLocalDate();
    }

    /**
     * 比较两个日期的差,可以是年,月,日
     *
     * @param startTime
     * @param endTime
     * @param field
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static long betweenTwoTime(LocalDate startTime, LocalDate endTime, ChronoUnit field) {
        Period period = Period.between(startTime, endTime);
        if (field == ChronoUnit.YEARS) return period.getYears();
        if (field == ChronoUnit.MONTHS) return period.getYears() * 12 + period.getMonths();
        return field.between(startTime, endTime);
    }


    /**
     * 判断是否是今天
     *
     * @param localDate
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isToday(LocalDate localDate) {
        long days = betweenTwoTime(localDate, getNowLocalDate(), ChronoUnit.DAYS);
        return days == 0;
    }

    /**
     * 判断是否是今天,不完整(年月日)
     *
     * @param time
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isToday(String time) {
        return isToday(string2LocalDate(time));
    }

    /**判断是否是昨天
     * @param localDate
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isYesterday(LocalDate localDate) {
        long days = betweenTwoTime(getNowLocalDate(), localDate, ChronoUnit.DAYS);
        return days == -1;
    }

    /**判断是否是明天
     * @param localDate
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isTomorrow(LocalDate localDate) {
        long days = betweenTwoTime(getNowLocalDate(), localDate, ChronoUnit.DAYS);
        return days == 1;
    }

    /**判断是否是同一年
     * @param localDateOne
     * @param localDateTwo
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isSameYear(LocalDate localDateOne, LocalDate localDateTwo) {
        return getAnyYear(localDateOne) == getAnyYear(localDateTwo);
    }

    /**判断是否是同一月
     * @param localDateOne
     * @param localDateTwo
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isSameMonth(LocalDate localDateOne, LocalDate localDateTwo) {
        boolean sameYear = isSameYear(localDateOne, localDateTwo);
        if (sameYear) {
            return getAnyMonth(localDateOne) == getAnyMonth(localDateTwo);
        } else {
            return false;
        }
    }

    /**判断是否是同一天
     * @param localDateOne
     * @param localDateTwo
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isSameDay(LocalDate localDateOne, LocalDate localDateTwo) {
        long days = betweenTwoTime(localDateOne, localDateTwo, ChronoUnit.DAYS);
        return days == 0;
    }

    //同一周



}

