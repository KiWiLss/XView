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
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.time.temporal.WeekFields;
import java.util.Date;

/**
 * @author : Lss kiwilss
 * @FileName: LocalDateTimeUtil
 * @e-mail : kiwilss@163.com
 * @time : 2020/7/25
 * @desc : {DESCRIPTION}
 */
public class LocalDateTimeUtil {

    public static String PATTEN_YMD = "yyyy-MM-dd";
    public static String PATTEN_YMDHMS = "yyyy-MM-dd HH:mm:ss";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) {
        System.out.println("--------------------");
        LocalDateTime oneTime = getAnyLocalDateTime(2020, 6, 30, 2, 2, 2);
        LocalDateTime twoTime = getAnyLocalDateTime(2020, 7, 2, 2, 2, 2);

        System.out.println(getPlusYear(getNowLocalDateTime(),-1));
    }

    /**
     * ------------------------------获取当前时间相关-----------------------
     */
    /**
     * 获取今天日期 ,返回示例2020-07-20T16:38:44.216
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getNowLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前时间 string 类型,默认时间格式
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getNowString() {
        return localDateTime2String(getNowLocalDateTime());
    }

    /**
     * 获取当前时间,返回自定义格式
     *
     * @param patten
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getNowString(String patten) {
        return localDateTime2String(getNowLocalDateTime(), patten);
    }

    /**
     * 获取当前时间,毫秒
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static long getNowMilli() {
        return localDateTime2Milli(getNowLocalDateTime());
    }

    /**
     * 获取今天日期的年份,返回示例2020
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowYear() {
        LocalDateTime nowDate = getNowLocalDateTime();
        return nowDate.getYear();
    }

    /**
     * 获取当前日期的月份,返回示例 7
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowMonth() {
        LocalDateTime nowDate = getNowLocalDateTime();
        return nowDate.getMonthValue();
    }

    /**
     * 返回今天日期是多少号,返回示例20
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowDay() {
        LocalDateTime nowDate = getNowLocalDateTime();
        return nowDate.getDayOfMonth();
    }

    /**
     * 获取现在日期的小时,返回示例16
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowHour() {
        LocalDateTime nowDate = getNowLocalDateTime();
        return nowDate.getHour();
    }

    /**
     * 获取当前时间的分钟,示例38
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowMinute() {
        LocalDateTime nowDate = getNowLocalDateTime();
        return nowDate.getMinute();
    }

    /**
     * 返回当前时间的秒,示例20
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowSecond() {
        LocalDateTime nowDate = getNowLocalDateTime();
        return nowDate.getSecond();
    }

    /**
     * 获取当前日期的星期,星期一返回1
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowWeek() {
        return LocalDateTime.now().getDayOfWeek().getValue();
    }

    /**
     * 获取今天是今年的第几周
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowWeekOfYear() {
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1);
        return getNowLocalDateTime().get(weekFields.weekOfYear());
    }

    /**
     * 获取今天是本月的第几周
     * 今天是 2020-07-25  返回 4
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowWeekOfMonth() {
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1);
        return getNowLocalDateTime().get(weekFields.weekOfMonth());
    }


    /**
     * 获取今天是今年的第多少天,示例202
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getNowDayOfYear() {
        return LocalDateTime.now().getDayOfYear();
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
     * ------------------------------获取any时间相关-----------------------
     */
    /**
     * 获取指定日期相关
     * 获取指定年月日时分秒的date,
     * 传值示例 2020, 5, 4 , 4, 3, 9
     * 返回示例2020-05-04T04:03:09
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getAnyLocalDateTime(int year, int month, int day, int hour, int minute, int second) {
        return LocalDateTime.of(year, month, day, hour, minute, second);
    }

    /**
     * 获取指定时间的 string 类型,默认格式
     *
     * @param localDateTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getAnyString(LocalDateTime localDateTime) {
        return localDateTime2String(localDateTime);
    }

    /**
     * 获取指定时间的 string 类型,自定义格式
     *
     * @param localDateTime
     * @param patten
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getAnyString(LocalDateTime localDateTime, String patten) {
        return localDateTime2String(localDateTime, patten);
    }

    /**
     * 获取指定时间的 毫秒
     *
     * @param localDateTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static long getAnyMilli(LocalDateTime localDateTime) {
        return localDateTime2Milli(localDateTime);
    }

    /**
     * 获取指定时间的年份,返回示例2020
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAnyYear(LocalDateTime dateTime) {
        return dateTime.getYear();
    }

    /**
     * 获取指定日期的月份,返回示例8
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAnyMonth(LocalDateTime dateTime) {
        return dateTime.getMonthValue();
    }

    /**
     * 获取指定日期的天,返回示例8
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAnyDay(LocalDateTime dateTime) {
        return dateTime.getDayOfMonth();
    }

    /**
     * 获取指定日期的星期,返回示例周日返回 7
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAnyWeek(LocalDateTime dateTime) {
        return dateTime.getDayOfWeek().getValue();
    }

    /**
     * 获取任意时间在本月的第几周
     *
     * @param localDateTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int getAnyWeekOfMonth(LocalDateTime localDateTime) {
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1);
        return localDateTime.get(weekFields.weekOfMonth());
    }

    /**
     * 获取指定时间的开始时间
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getAnyStart(LocalDate localDateTime) {
        return LocalDateTime.of(localDateTime, LocalTime.MIN);
    }

    /**
     * 获取指定时间的结束时间
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getAnyEnd(LocalDate localDate) {
        return LocalDateTime.of(localDate, LocalTime.MAX);
    }

    /**
     * 获取任意时间,月份的第一天的时间
     *
     * @param localDateTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getFirstDayOfMonth(LocalDateTime localDateTime) {
        return localDateTime.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获取任意时间,月份的最后一天的时间
     *
     * @param localDateTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getLastDayOfMonth(LocalDateTime localDateTime) {
        return localDateTime.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 获取任意时间,下个月第一天的时间
     *
     * @param localDateTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getFirstDayOfNextMonth(LocalDateTime localDateTime) {
        return localDateTime.with(TemporalAdjusters.firstDayOfNextMonth());
    }

    /**
     * 获取任意时间,下年第一天的时间
     *
     * @param localDateTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getFirstDayOfNextYear(LocalDateTime localDateTime) {
        return localDateTime.with(TemporalAdjusters.firstDayOfNextYear());
    }

    /**
     * 获取任意时间,年份的第一天的时间
     *
     * @param localDateTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getFirstDayOfYear(LocalDateTime localDateTime) {
        return localDateTime.with(TemporalAdjusters.firstDayOfYear());
    }

    /**
     * 获取任意时间,年份的最后一天的时间
     *
     * @param localDateTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getLastDayOfYear(LocalDateTime localDateTime) {
        return localDateTime.with(TemporalAdjusters.lastDayOfYear());
    }

    /**
     * ------------------------------转换相关-----------------------
     */
    /**
     * LocalDateTime -> string ,默认格式,
     * 返回示例2020-07-20 21:44:09和传入的 pattern 有关
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String localDateTime2String(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(PATTEN_YMDHMS));
    }

    /**
     * LocalDateTime -> string ,指定格式,
     * 传值:  LocalDateTime   ,    yyyy年MM月dd日 HH:mm:ss
     * 返回和传入的 pattern 有关,  2020年07月24日 15:27:44
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String localDateTime2String(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * LocalDateTime    ----->    milli   日期转毫秒
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Long localDateTime2Milli(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * LocalDateTime    ----->    second   日期转秒
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Long localDateTime2Second(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * LocalDateTime  ---->  LocalDate
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate localDateTime2LocalDate(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate localDateTime2LocalDate2(LocalDateTime localDateTime) {
        return LocalDate.from(localDateTime);
    }

    /**
     * LocalDateTime  ---->  LocalTime
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalTime localDateTime2LocalTime(LocalDateTime localDateTime) {
        return localDateTime.toLocalTime();
    }

    /**
     * localdatetime  ------>     date
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Date localDateTime2Date(LocalDateTime date) {
        return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * string 类型时间 --> localdatetime  , 默认时间格式
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime string2LocalDateTime(String date) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern(PATTEN_YMDHMS);
        return LocalDateTime.parse(date, pattern);
    }

    /**
     * string 类型时间 --> localdatetime
     *
     * @param date    2020/07/22 14:23:34
     * @param pattern yyyy/MM/dd HH:mm:ss
     * @return 2020-07-22T14:23:34
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime string2LocalDateTime(String date, String pattern) {
        DateTimeFormatter pattern2 = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(date, pattern2);
    }

    /**
     * date  --->  localdatetime
     * Date :  Fri Jul 24 16:41:21 CST 2020
     * LocalDateTime :  2020-07-24T16:40:12.706
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime date2LocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 时间戳秒--->LocalDateTime
     * 返回示例 2020-07-21T22:21:59
     *
     * @param
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime second2LocalDateTime(long second) {
        return LocalDateTime.ofEpochSecond(second, 0, ZoneOffset.ofHours(8));
    }

    /**
     * 时间戳毫秒--->LocalDateTime
     * 返回示例 2020-07-21T22:21:59.255
     *
     * @param milliseconds
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime milli2LocalDateTime(Long milliseconds) {
        return Instant.ofEpochMilli(milliseconds).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }

    /**
     * LocalDate  + LocalTime ----->   LocalDateTime
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime localDate2LocalDateTime(LocalDate localDate, LocalTime localTime) {
        return localDate.atTime(localTime);
    }
    /**
     * ------------------------------时间计算相关-----------------------
     */
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
     * 获取增加 number月后的日期
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getPlusMonth(LocalDateTime localDateTime, long number) {
        return localDateTime.plusMonths(number);
    }

    /**
     * 获取增加 number天后的日期
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getPlusDay(LocalDateTime localDateTime, long number) {
        return localDateTime.plusDays(number);
    }

    /**
     * 获取减少后的日期,可以是年,月,日,时,分,秒
     * 例如,传入当前日期,获取2天前的日期(getNowDateYMDHMS(),2, ChronoUnit.DAYS)
     * 返回2020-07-19T18:01:48.033
     */
    //日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getMinu(LocalDateTime time, long number, TemporalUnit field) {
        return time.minus(number, field);
    }

    /**
     * 获取减少 number年后的日期
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getMinuYear(LocalDateTime time, long number) {
        return time.minusYears(number);
    }

    /**
     * 获取减少 number月后的日期
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getMinuMonth(LocalDateTime time, long number) {
        return time.minusMonths(number);
    }

    /**
     * 获取减少 number天后的日期
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDateTime getMinuDay(LocalDateTime time, long number) {
        return time.minusDays(number);
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     * 后面的日期大,返回正数,否则返回负数
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
     * ------------------------------判断相关-----------------------
     */
    /**
     * 比较两个时间是否相同
     */
    public static boolean isSameLocalDateTime(LocalDateTime startTime, LocalDateTime endTime) {
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

    /**
     * 判断是否是今天
     *
     * @param localDateTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isToday(LocalDateTime localDateTime) {
        long days = betweenTwoTime(localDateTime, getNowLocalDateTime(), ChronoUnit.DAYS);
        return days == 0;
    }

    /**
     * 是否是昨天
     *
     * @param localDateTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isYesterday(LocalDateTime localDateTime) {
        long days = betweenTwoTime(getNowLocalDateTime(), localDateTime, ChronoUnit.DAYS);
        return days == -1;
    }

    /**
     * 是否是明天
     *
     * @param localDateTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isTomorrow(LocalDateTime localDateTime) {
        long days = betweenTwoTime(getNowLocalDateTime(), localDateTime, ChronoUnit.DAYS);
        return days == 1;
    }

    /**
     * 是否是闰年
     *
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isLeapYear(LocalDateTime localDateTime) {
        return isLeapYear(localDateTime.getYear());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isLeapYear(String time) {
        LocalDateTime localDateTime = string2LocalDateTime(time);
        return isLeapYear(localDateTime);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isLeapYear(String time, String patten) {
        LocalDateTime localDateTime = string2LocalDateTime(time, patten);
        return isLeapYear(localDateTime);
    }

    /**
     * 是否是同一年
     *
     * @param localDateTimeOne
     * @param localDateTimeTwo
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isSameYear(LocalDateTime localDateTimeOne, LocalDateTime localDateTimeTwo) {
        return getAnyYear(localDateTimeOne) == getAnyYear(localDateTimeTwo);
    }

    /**
     * 是否是同一月
     *
     * @param localDateTimeOne
     * @param localDateTimeTwo
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isSameMonth(LocalDateTime localDateTimeOne, LocalDateTime localDateTimeTwo) {
        boolean sameYear = isSameYear(localDateTimeOne, localDateTimeTwo);
        if (sameYear) {
            return getAnyMonth(localDateTimeOne) == getAnyMonth(localDateTimeTwo);
        } else {
            return false;
        }
    }

    /**
     * 是否在同一天
     *
     * @param localDateTimeOne
     * @param localDateTimeTwo
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean isSameDay(LocalDateTime localDateTimeOne, LocalDateTime localDateTimeTwo) {
        boolean sameLocalDateTime = isSameLocalDateTime(localDateTimeOne, localDateTimeTwo);
        if (sameLocalDateTime) {
            return true;
        } else {
            Duration duration = betweenTwoTime(localDateTimeOne, localDateTimeTwo);
            long days = duration.toDays();
            return days == 0;
        }
    }

    /**
     * 以second为主进行判断
     * 以first为开始时间，second为结束时间
     * 判断两个时间是否在同一个周内。
     *
     * @param first
     * @param second
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Boolean isSameWeek(LocalDateTime first, LocalDateTime second) {
//        两个时间差不超过7天,
        Period period = Period.between(first.toLocalDate(), second.toLocalDate());
        int years = period.getYears();
        if (years > 0) {
            return false;
        }
        int months = period.getMonths();
        if (months > 0) {
            return false;
        }
        int days = period.getDays();
        if (days == 0) {
//          表明是同一天
            return true;
        }
        if (days > 7 || days < -7) {
//            两个时间差 超出了7天
            return false;
        }
        int firstDayOfWeek = first.getDayOfWeek().getValue();
        int secondDayOfWeek = second.getDayOfWeek().getValue();
        if (secondDayOfWeek == 1) {
            if (oneDay(firstDayOfWeek, secondDayOfWeek, days)) {
                return true;
            } else {
                return false;
            }
        }
        if (secondDayOfWeek == 7) {
            if (sevenDay(firstDayOfWeek, secondDayOfWeek, days)) {
                return true;
            } else {
                return false;
            }
        }
        if (otherDay(firstDayOfWeek, secondDayOfWeek, days)) {
            return true;
        } else {
            return false;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Boolean isSameWeek(LocalDate first, LocalDate second) {
//        两个时间差不超过7天,
        Period period = Period.between(first, second);
        int years = period.getYears();
        if (years > 0) {
            return false;
        }
        int months = period.getMonths();
        if (months > 0) {
            return false;
        }
        int days = period.getDays();
        if (days == 0) {
//          表明是同一天
            return true;
        }
        if (days > 7 || days < -7) {
//            两个时间差 超出了7天
            return false;
        }
        int firstDayOfWeek = first.getDayOfWeek().getValue();
        int secondDayOfWeek = second.getDayOfWeek().getValue();
        if (secondDayOfWeek == 1) {
            if (oneDay(firstDayOfWeek, secondDayOfWeek, days)) {
                return true;
            } else {
                return false;
            }
        }
        if (secondDayOfWeek == 7) {
            if (sevenDay(firstDayOfWeek, secondDayOfWeek, days)) {
                return true;
            } else {
                return false;
            }
        }
        if (otherDay(firstDayOfWeek, secondDayOfWeek, days)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * secondDayOfWeek 是所在星期的第一天
     * 星期的第一天 数据处理
     *
     * @return
     */
    private static Boolean oneDay(int firstDayOfWeek, int secondDayOfWeek, int days) {
        if (days > 0) {
//            表明 first 比second 小 不在同一周
            return false;
        } else {
//            表明 first 比second 大
            if (secondDayOfWeek - days == firstDayOfWeek) {
                return true;
            }
        }
        return false;
    }

    /**
     * 星期的第7天的时候处理数据
     *
     * @return
     */
    private static Boolean sevenDay(int firstDayOfWeek, int secondDayOfWeek, int days) {
//        second 是周日
        if (firstDayOfWeek + days == secondDayOfWeek) {
            return true;
        }
        return false;
    }

    /**
     * 其他天的数据处理
     *
     * @return
     */
    private static Boolean otherDay(int firstDayOfWeek, int secondDayOfWeek, int days) {
        if (days < 0) {
//              表明 first 比 second 大
            if ((secondDayOfWeek - days) == firstDayOfWeek) {
//                    两者是 一周内
                return true;
            }
        } else {
//          表明 first 比 second 小
            if (firstDayOfWeek + days == secondDayOfWeek) {
                //                    两者是 一周内
                return true;
            }
        }
        return false;
    }

}
