package com.kiwilss.xview.utils.date;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
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
        System.out.println(localDateTime2Date(getNowDateYMDHMS()));
        System.out.println(date2LocalDateTime(new Date()));
        System.out.println("------------------------------------------------");
        System.out.println(getPlusYear(getNowDateYMDHMS(), 2));
        System.out.println(getMinu(getNowDateYMDHMS(), 2, ChronoUnit.DAYS));
        System.out.println(betweenTwoTime(getNowDateYMDHMS(),
                getPlus(getNowDateYMDHMS(), 2, ChronoUnit.DAYS), ChronoUnit.DAYS));

        System.out.println(betweenTwoTime(getNowDateYMDHMS(),
                getPlus(getNowDateYMDHMS(), 2, ChronoUnit.YEARS), ChronoUnit.DAYS));
        System.out.println("------------------");
        System.out.println(date2Second(getNowDateYMDHMS()));
        System.out.println(date2Milli(getNowDateYMDHMS()));

        System.out.println(second2LocalDateTime(1595341319));
        System.out.println(milli2LocalDateTime(1595341319255L));

        System.out.println(isToday(getAppointDateYMDHMS(2020,7,21,3,4,5)));
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
    public static int getNowWeek() {
        return LocalDateTime.now().getDayOfWeek().getValue();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowWeek2() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        return dayOfWeek.getValue();
    }

    /**
     * 获取今天是今年的第多少天,示例202
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowDayOfYear() {
        return LocalDateTime.now().getDayOfYear();
    }

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
     * 获取指定日期相关
     * 获取指定年月日时分秒的date,传值示例 2020, 5, 4 , 4, 3, 9示例2020-05-04T04:03:09
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getAppointDateYMDHMS(int year, int month, int day, int hour, int minute, int second) {
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute, second);
        return localDateTime;
    }

    /**
     * 获取指定年月日的date,2020-10-04
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate getAppointDateYMD(int year, int month, int day) {
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate;
    }

    /**
     * 获取指定时分秒的 date,传值示例 4 , 4, 50 返回示例04:04:50
     */
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
    public static int getAppointDay(LocalDateTime dateTime) {
        return dateTime.getDayOfMonth();
    }

    /**
     * 获取指定日期的星期,返回示例8
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAppointWeek(LocalDateTime dateTime) {
        return dateTime.getDayOfWeek().getValue();
    }

    /**
     * 获取当前开始时间,零点,返回示例2020-07-20T00:00
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getNowStart() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
    }

    /**
     * 获取当前结束时间
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getNowEnd() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
    }

    /**
     * 获取指定时间的开始时间
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getAppointStart(LocalDate localDateTime) {
        return LocalDateTime.of(localDateTime, LocalTime.MIN);
    }

    /**
     * 获取指定时间的结束时间
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getAppointEnd(LocalDate localDate) {
        return LocalDateTime.of(localDate, LocalTime.MAX);
    }

    /**
     * 转化相关
     * LocalDateTime -> string ,默认格式,返回示例2020-07-20 21:44:09和传入的 pattern 有关
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String date2String(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(PATTEN_YMDHMS));
    }

    /**
     * LocalDateTime -> string ,指定格式,返回和传入的 pattern 有关
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String date2String(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * LocalDate -->  string ,返回默认格式
     * System.out.println(date2String(getNowDateYMD())),返回2020-07-20
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String date2String(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern(PATTEN_YMD));
    }

    /**
     * LocalDate -->  string,返回指定模式
     * System.out.println(date2String(getNowDateYMD(),"yyyy年MM月dd日"));
     * 返回示例:2020年07月20日
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String date2String(LocalDate localDate, String pattern) {
        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * string -->  localdate, string默认格式yyyy-MM-dd,传值2020-07-11返回示例2020-07-11
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate string2LocalDate(String date) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern(PATTEN_YMD);
        return LocalDate.parse(date, pattern);
    }

    /**
     * string -->  localdate, string指定格式
     * 传值2020/07/11,pattern = yyyy/MM/dd
     * 返回示例2020-07-11
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate string2Date(String date, String pattern) {
        DateTimeFormatter patterns = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(date, patterns);
    }

//    @RequiresApi(api = Build.VERSION_CODES.O)
//    public static LocalDate string2LocalDate(String date, String pattern) {
//        DateTimeFormatter patterns = DateTimeFormatter.ofPattern(pattern);
//        return LocalDate.parse(date, patterns);
//    }

    /**
     * string 类型时间 --> localdatetime  , 传入的值要和 pattern 匹配
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime string2Date(String date) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern(PATTEN_YMDHMS);
        return LocalDateTime.parse(date, pattern);
    }


    /**
     * date  --->  localdatetime
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime date2LocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * localdatetime  ------>     date
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Date localDateTime2Date(LocalDateTime date) {
        return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * date    ----->    milli   日期转毫秒
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Long date2Milli(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 时间戳秒--->LocalDateTime
     *返回示例 2020-07-21T22:21:59
     * @param
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime second2LocalDateTime(long second) {
        return LocalDateTime.ofEpochSecond(second, 0, ZoneOffset.ofHours(8));
    }

    /**
     * 时间戳毫秒--->LocalDateTime
     *返回示例 2020-07-21T22:21:59.255
     * @param milliseconds
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime milli2LocalDateTime(Long milliseconds) {
        return Instant.ofEpochMilli(milliseconds).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }


    /**
     * date    ----->    second   日期转秒
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Long date2Second(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * LocalDateTime  ---->  LocalDate
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate localDateTime2LocalDate(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate();
    }

    /**
     * LocalDateTime  ---->  LocalTime
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalTime localDateTime2LocalTime(LocalDateTime localDateTime) {
        return localDateTime.toLocalTime();
    }

    /**
     * LocalDate  + LocalTime ----->   LocalDateTime
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime localDate2LocalDateTime(LocalDate localDate, LocalTime localTime) {
        return localDate.atTime(localTime);
    }


    /**
     * 获取增加后的日期,可以是年,月,日
     * 例如,传入当前日期,获取2天后的日期(getNowDateYMDHMS(),2, ChronoUnit.DAYS)
     * 返回2020-07-23T09:22:26.816
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getPlus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    /**
     * 获取增加 number年后的日期
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getPlusYear(LocalDateTime localDateTime, long number) {
        return localDateTime.plusYears(number);
    }

    /**
     * 获取减少后的日期,可以是年,月,日
     * 例如,传入当前日期,获取2天前的日期(getNowDateYMDHMS(),2, ChronoUnit.DAYS)
     * 返回2020-07-19T18:01:48.033
     */
    //日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getMinu(LocalDateTime time, long number, TemporalUnit field) {
        return time.minus(number, field);
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     *
     * @param startTime
     * @param endTime
     * @param field     单位(年月日时分秒)
     * @return 可以获取日期差的年月日时分秒
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) return period.getYears();
        if (field == ChronoUnit.MONTHS) return period.getYears() * 12 + period.getMonths();
        return field.between(startTime, endTime);
    }

    /**
     * 返回两个日期的时间差,返回 Duration,可以通过它获取时间差的天,小时,分钟,秒等
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Duration betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime) {
        return Duration.between(startTime, endTime);
    }

    /**
     * 比较两个时间是否相同
     */
    public static boolean isSameDate(LocalDateTime startTime, LocalDateTime endTime) {
        return startTime.equals(endTime);
    }

    /**
     * startTime 是否在 endTime 之前
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isBefore(LocalDateTime startTime, LocalDateTime endTime) {
        return startTime.isBefore(endTime);
    }

    /**
     * startTime 是否在 endTime 之后
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isAfter(LocalDateTime startTime, LocalDateTime endTime) {
        return startTime.isAfter(endTime);
    }

    /**判断是否是今天
     * @param localDateTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isToday(LocalDateTime localDateTime){
        long days = betweenTwoTime(localDateTime, getNowDateYMDHMS(), ChronoUnit.DAYS);
        return days == 0;
    }






}

