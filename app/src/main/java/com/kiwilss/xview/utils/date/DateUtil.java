package com.kiwilss.xview.utils.date;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author kiwilss
 */
public class DateUtil {

    //毫秒
    public static final int MSEC = 1;
    //秒
    public static final int SEC = 1000;
    //分
    public static final int MIN = 60000;
    //时
    public static final int HOUR = 3600000;
    //天
    public static final int DAY = 86400000;
    /**
     * 默认格式
     */
    private static final DateFormat DEFAULT_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 日期时间 格式yyyy-MM-dd HH:mm:ss
     */
    public static String PATTEN_YMDSFM = "yyyy-MM-dd HH:mm:ss";

    public static String PATTEN_YMDSF = "yyyy-MM-dd HH:mm";
    public static String PATTEN_YMDS = "yyyy-MM-dd HH";
    /**
     * 日期格式yyyy-MM-dd
     */
    public static String PATTEN_YMD = "yyyy-MM-dd";
    /**
     * 日期格式yyyy年MM月dd日
     */
    public static String PATTEN_YMD_CN = "yyyy年MM月dd日";

    /**
     * 日期格式 时分秒
     */
    public static final String PATTEN_HFM = "HH:mm:ss";
    /**
     * 日期格式 时
     */
    public static final String PATTEN_H = "HH";
    /**
     * 日期格式 分
     */
    public static final String PATTEN_M = "mm";

    private static final String[] CHINESE_ZODIAC =
            {"猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊"};
    private static final String[] ZODIAC = {
            "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座",
            "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "魔羯座"
    };
    private static final int[] ZODIAC_FLAGS = {20, 19, 21, 21, 21, 22, 23, 23, 23, 24, 23, 22};

    /**
     * 默认的日期间隔符
     */
    public static String       DEFAULT_SEPERATOR     = "-";
    /**
     * 日期验证复杂正则
     */
    public static String       DATE_REG              = "([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-9])))";

    /**
     * 日期验证简单正则
     */
    private static String      DATE_REG_SIMPLE       = "^\\d{4}-\\d{2}-\\d{2}$";
    /**
     * 大于等于
     */
    public static final String COMPARE_TYPE_GTE      = "GTE";
    /**
     * 大于
     */
    public static final String COMPARE_TYPE_GT       = "GT";


    public static void main(String[] args) {
        System.out.println("------------------------");
        System.out.println(getNowMonth());

//        System.out.println(date2String(setMonths(getNowDate(),5)));
//        System.out.println(addMonth("2019-05-22",PATTEN_YMD,5));
//
//        System.out.println(getBeforeDate(PATTEN_YMD));
//        System.out.println(getTomorrowDate(PATTEN_YMD));
//
//        System.out.println(addYears(getNowDate(),3));
//
//        System.out.println(isTomorrow("2019-05-22 23:34:16"));
//        System.out.println(isTomorrow("2019-05-23 23:34:16"));
//
//        System.out.println(isSameDay("2019-05-22 23:34:16","2019-05-22 11:34:16"));
//        System.out.println(isSameDay("2019-05-22","2019-06-22",PATTEN_YMD));
//        System.out.println(isSameDay(1558022400000L,1558101600000L));
//
//        System.out.println(millis2String(1558022400000L));
//        System.out.println(millis2String(1558022400000L,PATTEN_YMD));
//
//        System.out.println(string2Millis("2019-05-22 23:34:16"));
//        System.out.println(string2Millis("2019-05-22",PATTEN_YMD));
//
//        System.out.println("------------------------------------");
//        System.out.println(getYear("2019-05-22 23:34:16"));
//        System.out.println(getYear("2019-05-22",PATTEN_YMD));
//
//        System.out.println(getMonth("2019-05-22 23:34:16"));
//        System.out.println(getMonth("2019-05-22", PATTEN_YMD));
//
//        System.out.println(getDay("2019-05-22 23:34:16"));
//        System.out.println(getHour("2019-05-22 23:34:16"));
//        System.out.println(getMinute("2019-05-22 23:34:16"));
//        System.out.println(getSecond("2019-05-22 23:34:16"));
//
//        System.out.println("------------------------------------");
//        System.out.println(between("2019-05-22 23:34:16","2019-05-21 23:34:16","2019-05-24 23:34:16"));
//        System.out.println(between("2019-05-22","2019-05-21","2019-05-24",PATTEN_YMD));
//
//        System.out.println(computerDuration(120000));
//
//        System.out.println(getUserDate(PATTEN_YMD));
//        System.out.println(getUserDate(PATTEN_YMDSFM));
//        System.out.println(getUserDate(PATTEN_YMDSF));
//        System.out.println(getUserDate(PATTEN_H));
//
//
//        System.out.println(getPreTime("2019-05-22 23:34:16", "20"));
//
//        System.out.println(getNextDay("2019-05-22 23:34:16", "2"));
//        System.out.println(getNextDay("2019-05-22 23:34:16", "12"));
//
//        System.out.println(getEndDateOfMonth("2019-05-22 23:34:16"));
//        System.out.println(getEndDateOfMonth("2019-05-22"));
//        System.out.println(getEDate("2019-05-22"));
//
//        System.out.println(isSameWeekDates("2019-05-22 23:34:16", "2019-05-23 23:34:16"));
//        System.out.println(isSameWeekDates("2019-05-22 23:34:16", "2019-05-28 23:34:16"));
//        System.out.println(isSameWeekDates("2019-05-22", PATTEN_YMD, "2019-05-28", PATTEN_YMD));
//
//        System.out.println(getSeqWeek("2019-01-10 23:34:16"));
//
//        System.out.println(getWeekFormDate("2019-05-17 23:34:16", 2));
//        System.out.println(getWeekFormDate("2019-05-17", PATTEN_YMD, 2));
//        System.out.println(getWeekFormDate("2019-05-17", PATTEN_YMD, 2, PATTEN_YMD));
//
//        System.out.println(getUSWeek(getNowDate()));
//        //获取星期几
//        System.out.println(getChineseWeek(getNowDate()));
//        //获取星期几,没有时分秒,时间和后面的格式要对应
//        System.out.println(getChineseWeek("2019-05-17", PATTEN_YMD));
//        //与当前时间的时间差
//        System.out.println(getTimeSpanByNow("2019-05-18 23:34:16", HOUR));//---->24
//        System.out.println(getTimeSpanByNow("2019-05-18 23:34:16", DAY));//---->1(超过 24 小时算 1 天)
//        System.out.println(getTimeSpanByNow("2019-05-18", PATTEN_YMD, DAY));//----->1
//
//        //比较两个时间差
//        System.out.println("fit time span-->" + getFitTimeSpan("2019-05-17 18:34:16", "2019-05-10 18:35:16", 5));
//        System.out.println(getFitTimeSpan("2019-05-17 18:34:16", "2019-05-10 18:35:16", DEFAULT_FORMAT, 1));
//
//        System.out.println(getTimeSpan("2019-05-17 18:34:16", "2019-05-10 18:35:16", DAY));
//        System.out.println(getTimeSpan("2019-05-17", "2019-05-10", PATTEN_YMD, DAY));
//
//        //millis-11位,秒;13 位,毫秒-->string
//        //string--->millis     结果--->1558089256000
//        System.out.println(string2Millis("2019-05-17 18:34:16"));
//        //没有时分秒,后面的类型要对应,结果--->  1558022400000(相当于2019-05-17 00:00:00)
//        System.out.println(string2Millis("2019-05-17", PATTEN_YMD));
//
//        //string ----> date
//        System.out.println(string2Date("2019-05-17 18:34:16"));
//        //转换后默认时分秒是00:00:00
//        System.out.println(string2Date("2019-05-17 18:34:16", PATTEN_YMD));
//        System.out.println(string2Date("2019-05-17", PATTEN_YMD));
//
//        //date ---> string  年月日时分秒
//        System.out.println(date2String(new Date()));
//        //date ---> string  年月日
//        System.out.println(date2String(new Date(), PATTEN_YMD));
//
//        //获取当前的时间
//        System.out.println("当前日期--->" + getNowString());
//        System.out.println(getNowString(PATTEN_YMD));
//        System.out.println(getNowString(PATTEN_YMD_CN));
//
//        //获取当前的时分秒
//        System.out.println(getNowString(PATTEN_HFM));
//        //获取档期的小时
//        System.out.println(getNowString(PATTEN_H));
//        //获取当前分钟
//        System.out.println(getNowString(PATTEN_M));
//
//        //获取当前年,月,日,星期,小时,分钟,秒
//        System.out.println(getNowY() + "年---" + getNowMonth() + "月--" + getNowDay() + "日--周" + getNowWeek() + "---"
//                + getNowHour() + "时--" + getNowMinute() + "分---" + getNowSecond() + "秒");
//
//        System.out.println(getLastDaysOfMonth(2019, 5));
    }


    /**
     * 获得明日0点0分0秒的时间戳
     *
     * @author xuxiaowen
     * @date 2019/03/29
     * @return
     */
    public static int getTomorrowMorning() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() / 1000);

    }

    /**
     * 获得明日23点59分59秒的时间戳
     *
     * @return
     */
    public static int getTomorrowEnding() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() / 1000);
    }

    /**
     *
     * 获取当天的最晚时间23:59:59
     *
     * @author zsl-2017年4月28日
     *
     * @param date
     *            日期
     * @param //pattern
     *            格式
     * @return
     */
    public static Date getLatestTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     *
     * 获取当天的最早时间00:00:00
     *
     * @author zsl-2017年4月28日
     *
     * @param date
     *            日期
     * @param //pattern
     *            格式
     * @return
     */
    public static Date getFirstTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        return calendar.getTime();
    }

    /**
     *
     * @author:nicholas
     * @date:2018年1月6日下午4:33:43
     * @desc:上周一
     * @param date
     * @return
     */
    public static Date geLastWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday(date));
        cal.add(Calendar.DATE, -7);
        return cal.getTime();
    }

    /**
     *
     * @author:nicholas
     * @date:2018年1月6日下午4:33:43
     * @desc:本周一
     * @param date
     * @return
     */
    public static Date getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    /**
     * 本周一凌晨
     *
     * @author zsl-2019年4月8日
     * @return
     */
    public static Date getThisWeekMonday0(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    /**
     * 计算两个日期之间间隔天数
     *
     * @author xuxiaowen
     * @date 2018/8/30
     * @param startTime
     * @param endTime
     * @return
     * @throws
     */
    public static int daysBetween(Date startTime, Date endTime) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(startTime);
            long time1 = cal.getTimeInMillis();
            cal.setTime(endTime);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            return Integer.parseInt(String.valueOf(between_days));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 计算两个日期之间间隔天数
     *
     * @author xuxiaowen
     * @date 2018/8/30
     *
     * @param startTimeStr
     * @param endTimeStr
     * @param format
     * @return
     */
    public static long dayDiff(String startTimeStr, String endTimeStr, String format) {
        SimpleDateFormat formater = new SimpleDateFormat(format);
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
     * 返回日时分秒
     *
     * @author:nicholas
     * @date:2018年9月29日上午11:02:02
     * @desc:
     * @param second
     * @return
     */
    public static String secondToTime(long second) {//时间戳是秒
        long days = second / 86400;// 转换天数
        second = second % 86400;// 剩余秒数
        long hours = second / 3600;// 转换小时数
        second = second % 3600;// 剩余秒数
        long minutes = second / 60;// 转换分钟
        second = second % 60;// 剩余秒数
        if (0 < days) {
            return days + " " + hours + ":" + minutes + ":" + second;
        } else {
            return hours + ":" + minutes + ":" + second;
        }
    }



    /**
     *
     * @author:nicholas
     * @date:2018年1月6日下午4:33:43
     * @desc:下周一
     * @param date
     * @return
     */
    public static Date getNextWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday(date));
        cal.add(Calendar.DATE, 7);
        return cal.getTime();
    }

    /**
     *
     * @author:nicholas
     * @date:2018年1月8日下午3:18:57
     * @desc:获取本月第一天
     * @return
     */
    public static Date getThisMonthFirstDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // 获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        String first = format.format(c.getTime());

        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date firstDay = null;
        try {
            first = first + " 00:00:00";
            firstDay = format.parse(first);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return firstDay;
    }

    /**
     * 获取本月最后一天
     *
     * @author zsl-2019年4月2日
     * @return
     */
    public static Date getThisMonthLastDay() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // 获取当前月最后一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        String first = format.format(c.getTime());

        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date firstDay = null;
        try {
            first = first + " 23:59:59";
            firstDay = format.parse(first);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return firstDay;
    }


    /**???
     * 获取当前日期最后时间-到秒结束
     *
     * @author xuxiaowen
     * @date 2018/8/17
     *
     * @param date
     * @return
     */
    public static Date initEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date initializeEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static Date initializeEndSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 日期比较， 后面日期比前面的日期大
     *
     * @param dateFrom
     *            开始日期
     * @param dateEnd
     *            结束日期
     * @return boolean 比较结果
     */
    public static boolean checkDateFromTo(String dateFrom, String dateEnd) {
        if (checkDateCompare(dateFrom, dateEnd, COMPARE_TYPE_GTE)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断前后日期对比。 如果后面的日期大于前面的日期， 返回true。 否则返回false。
     *
     * @param dateFromStr
     *            开始日期
     * @param dateEndStr
     *            结束日期
     * @return boolean 比较结果
     */
    private static boolean checkDateCompare(String dateFromStr, String dateEndStr, String compareType) {
        if (!checkIsActiveDate(dateFromStr) || !checkIsActiveDate(dateEndStr)) {
            return false;
        } else {
            Date dateFrom = string2Date(dateFromStr, PATTEN_YMD);
            Date dateEnd = string2Date(dateEndStr, PATTEN_YMD);

            if (COMPARE_TYPE_GT.equals(compareType)) {
                // 大于
                if (dateFrom.before(dateEnd)) {
                    return true;
                }
            } else if (COMPARE_TYPE_GTE.equals(compareType)) {
                // 大于等于
                if (!dateEnd.before(dateFrom)) {
                    return true;
                }
            } else if (COMPARE_TYPE_GTE.equals(compareType)) {
                // 不等于
                if (!isEqual(dateFromStr, dateEndStr)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 比较两个日期大小
     *
     * @param startDate
     *            开始日期
     * @param endDate
     *            结束日期
     * @return 开始日期早于结束日期，返回true。否则返回false。相等，返回false
     */
    public static boolean dateCompare(Date startDate, Date endDate) {
        if (startDate.before(endDate)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否是有效日期
     *
     * @param date
     *            判断日期
     * @return 是否有效日期
     */
    public static boolean checkIsActiveDate(String date) {
        // 先验证基本格式是否正确
        if (!matches(date, DATE_REG_SIMPLE)) {
            return false;
        }
        // 验证复杂格式是否正确
        if (isNotEmpty(date) && date.contains(DEFAULT_SEPERATOR)) {
            String dateNoSeprator = date.replaceAll(DEFAULT_SEPERATOR, "");
            return matches(dateNoSeprator, DATE_REG);
        }
        return false;
    }


    /**
     * 判断两个String 是否相等， 如果都是null 也表示相等
     *
     * @param s1
     * @param s2
     * @return boolean
     */
    public static boolean isEqual(String s1, String s2) {
        if (s1 == null) {
            s1 = "";
        }
        if (s2 == null) {
            s2 = "";
        }
        return (s1.equals(s2));
    }

    /**
     * 判断是否不为空，不空返回true
     *
     * @param str
     * @return boolean
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
    /**
     * 正则表达式匹配<br>
     *
     * @param value
     * @param regexp
     * @return boolean
     */
    public static boolean matches(String value, String regexp) {
        if (isEmpty(value) || isEmpty(regexp)) {
            return false;
        } else {
            return value.matches(regexp);
        }
    }
    /**
     * 判断是否为空
     *
     * @param str
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        if ("".equals(nvl(str))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 处理String null 如果是null 返回空字符串，否则返回trim后的String
     *
     * @param value
     * @return String
     */
    public static String nvl(String value) {
        if (value == null) {
            return "";
        } else {
            return value.trim();
        }
    }
    /**
     * 返回某月的第一天
     *
     * @param year
     *            年
     * @param month
     *            月
     * @return 某月的第一天
     */
    public static Date getFirstDayOfMonth(String year, String month) {
        // 验证空
        if (isEmpty(year) || isEmpty(month)) {
            return null;
        }
        // 验证年
        if (!matches(year, "\\d{4}")) {
            return null;
        }
        // 验证月
        int monthValue = Integer.parseInt(month);
        if (monthValue > 12 || monthValue < 1) {
            return null;
        }
        // 改成 yyyy-MM-dd格式
        StringBuilder sb = new StringBuilder();
        sb.append(year);
        sb.append(DEFAULT_SEPERATOR);
        sb.append(month);
        sb.append(DEFAULT_SEPERATOR);
        sb.append("01");
        return string2Date(sb.toString(), PATTEN_YMD);
    }

    /**
     * 返回某月的最后一天
     *
     * @param year
     *            年
     * @param month
     *            月
     * @return 某月的最后一天
     */
    public static Date getLastDayOfMonth(String year, String month) {
        // 验证空
        if (isEmpty(year) || isEmpty(month)) {
            return null;
        }
        // 验证年
        if (!matches(year, "\\d{4}")) {
            return null;
        }
        // 验证月
        int monthValue = Integer.parseInt(month);
        if (monthValue > 12 || monthValue < 1) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        cal.set(Calendar.MONTH, monthValue - 1);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 获取当前时间的上一个月的年月
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String getBeforeMonth(Date date, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        return date2String(cal.getTime(), pattern);
    }

    /**
     * 获取当前日期前30天的日期
     *
     * @param fm
     *            日期格式
     * @return 当前日期前三十天的日期
     * @throws //SystemException
     *             转换异常，抛出系统异常
     */
    public static String thirtyDaysBeforeNow(String fm) {
        String result;
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_MONTH, -30);
        Format format = new SimpleDateFormat(fm);
        result = format.format(date.getTime());
        return result;
    }

    /**
     * 获取指定日期的前30天的日期
     *
     * @param startDate
     *            指定日期
     * @param fm
     *            格式
     * @return 指定日期前30天的日期
     * @throws //SystemException
     *             转换异常，抛出系统异常
     */
    public static String thirtyDaysBeforeSpecifiedDate(Date startDate, String fm) {
        String result;
        Calendar date = Calendar.getInstance();
        date.setTime(startDate);
        date.add(Calendar.DAY_OF_MONTH, -30);
        Format format = new SimpleDateFormat(fm);
        result = format.format(date.getTime());
        return result;
    }

    /**
     * 获取前一天日期
     * @para
     * @return 前一天 日期
     * @throws //SystemException
     *             转换异常，抛出系统异常
     */
    public static String getBeforeDate(String patten) {
        String result;
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_MONTH, -1);
        Format format = new SimpleDateFormat(patten);
        result = format.format(date.getTime());
        return result;
    }

    /**获取明天的日期
     * @param patten
     * @return
     */
    public static String getTomorrowDate(String patten){
        String result;
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_MONTH, 1);
        Format format = new SimpleDateFormat(patten);
        result = format.format(date.getTime());
        return result;
    }

    /**
     * 对date对象的年份字段设置value值，返回一个新的date对象，原date不变
     *
     * @param date  需要设置的date
     * @param value 需要设置的年份
     * @return 设置年份字段后返回的新的Date对象
     */
    private static Date setYears( Date date, int value) {
        return set(date, Calendar.YEAR, value);
    }

    /**
     * 对date对象的月字段设置value值，返回一个新的date对象，原date不变
     *
     * @param date  需要设置的date
     * @param value 需要设置的月
     * @return 设置月字段后返回的新的Date对象
     */
    private static Date setMonths(Date date, int value) {
        return set(date, Calendar.MONTH, value);
    }

    /**
     * 对date对象的天字段设置value值，返回一个新的date对象，原date不变
     *
     * @param date  需要设置的date
     * @param value 需要设置的天
     * @return 设置天字段后返回的新的Date对象
     */
    private static Date setDays( Date date, int value) {
        return set(date, Calendar.DAY_OF_MONTH, value);
    }

    /**
     * 对date对象的小时字段设置value值，返回一个新的date对象，原date不变
     *
     * @param date  需要设置的date
     * @param value 需要设置的小时
     * @return 设置小时字段后返回的新的Date对象
     */
    private static Date setHours( Date date, int value) {
        return set(date, Calendar.HOUR_OF_DAY, value);
    }

    /**
     * 对date对象的分钟字段设置value值，返回一个新的date对象，原date不变
     *
     * @param date  需要设置的date
     * @param value 需要设置的分钟
     * @return 设置分钟字段后返回的新的Date对象
     */
    private static Date setMinutes( Date date, int value) {
        return set(date, Calendar.MINUTE, value);
    }

    /**
     * 对date对象的秒字段设置value值，返回一个新的date对象，原date不变
     *
     * @param date  需要设置的date
     * @param value 需要设置的秒值
     * @return 设置秒字段后返回的新的Date对象
     */
    private static Date setSeconds( Date date, int value) {
        return set(date, Calendar.SECOND, value);
    }

    /**
     * 对date对象的毫秒值字段设置value值，返回一个新的date对象，原date不变
     *
     * @param date  需要设置的date
     * @param value 需要设置的毫秒值
     * @return 设置毫秒值字段后返回的新的Date对象
     */
    private static Date setMilliseconds( Date date, int value) {
        return set(date, Calendar.MILLISECOND, value);
    }

    /**
     * 对date对象的calendarField字段设置value值，返回一个新的date对象，原date不变
     *
     * @param date          需要设置的date
     * @param calendarField Calendar字段
     * @param value         calendarField字段需要设置的值
     * @return 设置calendarField字段后返回的新的Date对象
     */
    private static Date set(Date date, int calendarField, int value) {
        if (null == date) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.set(calendarField, value);
        return calendar.getTime();
    }
    private static String set2(Date date, int calendarField, int value) {
        return date2String(set(date,calendarField,value));
    }


    /**
     * 在date时间基础上增加amount年,原date不变
     *
     * @param date   需要增加amount年的date时间
     * @param amount 增加amount年
     * @return 增加amount年后的date时间
     */
    public static Date addYears(Date date, int amount) {
        return add(date, amount);
    }

    public static String addYears(String time, int amount){//默认时间格式
        Date date = addYears(string2Date(time), amount);
        return date2String(date);
    }
    public static String addYears(String time, String patten, int amount){//自定义时间格式
        Date date = addYears(string2Date(time,patten), amount);
        return date2String(date);
    }
        /**
     * 增加date，返回一个新的date对象，原date不变
     *
     * @param date          需要增加的date
     * @param amount        增加的总数，可以是负的
     * @return 增加后的新的date对象
     */
    private static Date add(Date date, int amount) {
        if (null == date) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, amount);
        return calendar.getTime();
    }

    /**
     * 日期加月
     *
     * @param date
     *            日期
     * @param spans
     *            增加数量
     * @return 加月后的日期
     */
    public static Date addMonth(Date date, int spans) {
        return addDate(date, Calendar.MONTH, spans);
    }

    public static String addMonth(String time,int spans){//默认时间格式
        return date2String(addMonth(string2Date(time),spans));
    }
    public static String addMonth(String time, String patten, int spans){//自定义样式,返回样式相同
        return date2String(addMonth(string2Date(time,patten),spans),patten);
    }

    /**
     * 日期加天
     *
     * @param date
     *            日期
     * @param spans
     *            增加数量
     * @return 加天后的日期
     */
    public static Date addDay(Date date, int spans) {
        return addDate(date, Calendar.DAY_OF_MONTH, spans);
    }

    public static String addDay(String time, int spans){//默认时间格式
        return date2String(addDay(string2Date(time),spans));
    }
    public static String addDay(String time, String patten, int spans){//自定义格式
        return date2String(addDay(string2Date(time, patten),spans), patten);
    }

    /**
     * 日期加小时
     *
     * @param date
     *            日期
     * @param spans
     *            增加数量
     * @return 加小时后的日期
     */
    public static Date addHour(Date date, int spans) {
        return addDate(date, Calendar.HOUR_OF_DAY, spans);
    }

    public static String addHour(String time, int spans){//默认格式
        return date2String(addHour(string2Date(time),spans));
    }

    public static String addHour(String time, String patten, int spans){//自定义格式
        return date2String(addHour(string2Date(time,patten),spans),patten);
    }

    /**
     * 日期加分钟
     *
     * @param date
     *            日期
     * @param spans
     *            增加数量
     * @return 加分钟后的日期
     */
    public static Date addMinute(Date date, int spans) {
        return addDate(date, Calendar.MINUTE, spans);
    }

    public static String addMinute(String time, int spans){//默认格式
        return date2String(addMinute(string2Date(time),spans));
    }

    public static String addMinute(String time, String patten, int spans){//自定义格式
        return date2String(addMinute(string2Date(time,patten),spans),patten);
    }

    /**
     * 日期加秒
     *
     * @param date
     *            日期
     * @param spans
     *            增加数量
     * @return 加秒后的日期
     */
    public static Date addSecond(Date date, int spans) {
        return addDate(date, Calendar.SECOND, spans);
    }
    /**
     * 日期加法计算
     *
     * @param date
     *            日期
     * @param type
     *            增加类型
     * @param spans
     *            增加数量
     * @return 加法计算后的日期
     */
    public static Date addDate(Date date, int type, int spans) {
        Calendar inputCalendar = Calendar.getInstance();
        inputCalendar.setTime(date);
        inputCalendar.add(type, spans);
        return inputCalendar.getTime();
    }
    /**
     * 判断一个时间是不是明天
     * @param date 需要判断的时间
     * @return true明天，false不是
     */
    public static boolean isTomorrow(Date date) {
        Calendar calendar1 = getCalendar();
        calendar1.setTime(date);

        Calendar calendar2 = getCalendar();
        calendar2.add(Calendar.DAY_OF_MONTH, 1);
        return isSameDay(calendar1, calendar2);
    }

    public static boolean isTomorrow(String time){
        return isTomorrow(string2Date(time));
    }
    public static boolean isTomorrow(String time, String patten){
        return isTomorrow(string2Date(time,patten));
    }
    public static boolean isTomorrow(long time){
        return isTomorrow(millis2Date(time));
    }

    /**获取 Calendar
     * @return
     */
    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    /**获取任意时间的年
     * @param time
     * @return
     */
    public static int getYear(String time){//默认时间格式
        return getYear(string2Date(time));
    }
    //其他时间格式
    public static int getYear(String time, String patten){
        return getYear(string2Date(time,patten));
    }
    public static int getYear(long time){
        return getYear(millis2Date(time));
    }

    public static int getYear(Date date){
        Calendar calendar = getCalendar();
         calendar.setTime(date);
         return calendar.get(Calendar.YEAR) ;
    }

    /**获取任意时间月份
     * @param
     * @return
     */
    public static int getMonth(String time){//默认时间格式
        return getMonth(string2Date(time));
    }

    public static int getMonth(String time, String patten){//任意时间格式
        return getMonth(string2Date(time,patten));
    }
    public static int getMonth(long time){
        return getMonth(millis2Date(time));
    }

    public static int getMonth(Date date){
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**获取任意时间的天
     * @param time
     * @return
     */
    public static int getDay(String time){//默认时间格式
        return getDay(string2Date(time));
    }
    public static int getDay(String time, String patten){//自定义时间格式
        return getDay(string2Date(time,patten));
    }
    public static int getDay(long time){//默认年月日时分秒
        return getDay(millis2Date(time));
    }

    public static int getDay(Date date){
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**获取任意时间的小时,12 小时制
     * @param date
     * @return
     */
    public static int getHour(Date date){
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR);
    }

    /**获取任意时间的小时,24 小时制
     * @param date
     * @return
     */
    public static int getHour2(Date date){
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**获取时间的小时,默认时间格式,默认是获取 24 小时制
     * @param time
     * @return
     */
    public static int getHour(String time){
      return getHour(time,true);
    }

    /**获取时间的小时,默认时间格式
     * @param time
     * @param is24
     * @return
     */
    public static int getHour(String time, boolean is24){
      return getHour(time,PATTEN_YMDSFM,is24);
    }

    /**获取时间的小时,自定义时间格式,至少要到小时
     * @param time
     * @param patten
     * @param is24
     * @return
     */
    public static int getHour(String time, String patten, boolean is24){
        Date date = string2Date(time,patten);
        if (is24){
            return getHour2(date);
        }else {
            return getHour(date);
        }
    }

    public static int getHour(long time,boolean is24){
        if (is24){
            return getHour2(millis2Date(time));
        }else {
            return getHour(millis2Date(time));
        }
    }

    /**获取日期的分钟
     * @param date
     * @return
     */
    public static int getMinute(Date date){
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**获取时间的分钟,默认时间格式
     * @param time
     * @return
     */
    public static int getMinute(String time){
        return getMinute(string2Date(time));
    }

    public static int getMinute(long time){
        return getMinute(millis2Date(time));
    }

    /**获取日期的秒
     * @param date
     * @return
     */
    public static int getSecond(Date date){
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }
    public static int getSecond(String time){
        return getSecond(string2Date(time));
    }
    public static int getSecond(long time){
        return getSecond(millis2Date(time));
    }

    /**
     * 检查两个Calendar对象是否是同一天，忽略时间
     *
     * @param calendar1 first Calendar
     * @param calendar2 second Calendar
     * @return true：同一天，false不是同一天
     */
    public static boolean isSameDay( Calendar calendar1,  Calendar calendar2) {
        if (null == calendar1 || null == calendar2) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return calendar1.get(Calendar.ERA) == calendar2.get(Calendar.ERA) &&
                calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) &&
                calendar1.get(Calendar.DAY_OF_YEAR) == calendar2.get(Calendar.DAY_OF_YEAR);
    }

        /**
     * 检查两个Date对象是否是同一天
     *
     * @param date1 first Date
     * @param date2 second Date
     * @return true：同一天，false不是同一天
     */
    public static boolean isSameDay(Date date1, Date date2) {
        if (null == date1 || null == date2) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar1 = getCalendar();
        calendar1.setTime(date1);

        Calendar calendar2 = getCalendar();
        calendar2.setTime(date2);

        return isSameDay(calendar1, calendar2);
    }

    public static boolean isSameDay(String time1, String time2){//默认时间格式
        return isSameDay(string2Date(time1),string2Date(time2));
    }

    public static boolean isSameDay(String time1, String time2, String patten){//自定义时间格式
        return isSameDay(string2Date(time1,patten),string2Date(time2,patten));
    }

    public static boolean isSameDay(long time1,long time2){
        return isSameDay(millis2Date(time1),millis2Date(time2));
    }


    /**
     * 判断srcDate时间是否在startDate和endDate之间
     *
     * @param srcDate   需要判断的时间
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return true：srcDate时间在startDate和endDate之间，false：srcDate时间不在startDate和endDate之间
     */
    public static boolean between(Date srcDate,  Date startDate, Date endDate) {
        if (startDate.after(srcDate)) {
            return false;
        } else if (endDate.before(srcDate)) {
            return false;
        }
        return true;
    }

    public static boolean between(String srcDate,  String startDate, String endDate) {//三个时间,都是默认时间格式
        Date src = string2Date(srcDate);
        Date start = string2Date(startDate);
        Date end = string2Date(endDate);
        if (start.after(src)) {
            return false;
        } else if (end.before(src)) {
            return false;
        }
        return true;
    }

    public static boolean between(String srcDate,  String startDate, String endDate,String patten) {//三个时间时间格式要一样
        Date src = string2Date(srcDate,patten);
        Date start = string2Date(startDate,patten);
        Date end = string2Date(endDate,patten);
        if (start.after(src)) {
            return false;
        } else if (end.before(src)) {
            return false;
        }
        return true;
    }

        /**
     * 将Calendar对象转换为Date对象
     *
     * @param calendar 需要转换的Calendar对象
     * @return 转换后的Date对象
     */
    public static Date calendar2Date(Calendar calendar) {
        return calendar.getTime();
    }

    /**
     * //     * 将Date对象转换为Calendar对象
     * //     *
     * //     * @param date     需要转换的Date对象
     * //     * @param timeZone 时区
     * //     * @return 转换后的Calendar对象
     * //
     */
    public static Calendar date2Calendar(Date date, TimeZone timeZone) {
        Calendar calendar;
        if (null == timeZone) {
            calendar = Calendar.getInstance();
        } else {
            calendar = Calendar.getInstance(timeZone);
        }
        calendar.setTime(date);
        return calendar;
    }

    public static Calendar date2Calendar(Date date) {
        return date2Calendar(date, null);
    }


    /**
     * 计算时长
     *
     * @param duration 时长毫秒值
     * @return 时长
     */
    public static String computerDuration(long duration) {
        if (0 > duration) {
            return "0";
        }
        duration /= 1000;
        long day = duration / (24 * 60 * 60);
        long hour = duration / (60 * 60) % 24;
        long minute = duration / 60 % 60;
        long second = duration % 60;
        StringBuilder sb = new StringBuilder();
        if (day >= 1) {
            sb.append(day).append("天");
        }
        if (hour >= 1) {
            sb.append(hour).append("小时");
        }
        if (minute >= 1) {
            sb.append(minute).append("分钟");
        }
//        if (second >= 1) {
//            sb.append(second).append("秒");
//        }
        if (sb.length() <= 0) {
            sb.append("0分钟");
        }
        return sb.toString();
    }





    /**
     * 根据用户传入的时间表示格式，
     * 返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
     *
     * @param //yyyyMMddhhmmss
     * @return
     */

    public static String getUserDate(String patten) {//当前时间
        return getUserDate(getNowDate(), patten);
    }

    public static String getUserDate(Date time, String patten) {//任意时间
        SimpleDateFormat formatter = new SimpleDateFormat(patten);
        String dateString = formatter.format(time);
        return dateString;
    }

    public static String getUserDate(String time, String patten) {//任意时间,时间格式
        SimpleDateFormat formatter = new SimpleDateFormat(patten);
        return formatter.format(string2Date(time));
    }

    public static String getUserDate(long time, String patten) {//任意时间,时间格式
        SimpleDateFormat format = getDateParser(patten);
        return format.format(millis2Date(time));
    }

    /**
     * 时间前推或后推分钟,其中JJ表示分钟.
     */
    public static String getPreTime(String time, String jj) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mydate1 = "";
        try {
            Date date1 = format.parse(time);
            long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
            date1.setTime(Time * 1000);
            mydate1 = format.format(date1);
        } catch (Exception e) {

        }
        return mydate1;
    }

    public static String getPreTime(String time, int jj) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mydate1 = "";
        try {
            Date date1 = format.parse(time);
            long Time = (date1.getTime() / 1000) + jj * 60;
            date1.setTime(Time * 1000);
            mydate1 = format.format(date1);
        } catch (Exception e) {

        }
        return mydate1;
    }

    public static String getPreTime(Date time, int jj) {
        return getPreTime(date2String(time), jj);
    }

    public static String getPreTime(long time, int jj) {
        return getPreTime(millis2String(time), jj);
    }

    /**
     * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
     */
    public static String getNextDay(String nowdate, String delay) {//默认时间格式
        return getNextDay(nowdate, PATTEN_YMDSFM, delay);
    }

    public static String getNextDay(String nowdate, int delay) {//yyyy-MM-dd时间格式
        return getNextDay(nowdate, PATTEN_YMD, delay);
    }

    public static String getNextDay(Date date, int delay) {
        return getNextDay(date2String(date), PATTEN_YMDSFM, delay);
    }

    public static String getNextDay(long date, int delay) {
        return getNextDay(millis2String(date), PATTEN_YMDSFM, delay);
    }

    public static String getNextDay(String nowdate, String patten, String delay) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String mdate = "";
            Date d = string2Date(nowdate, patten);
            assert d != null;
            long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
            d.setTime(myTime * 1000);
            mdate = format.format(d);
            return mdate;
        } catch (Exception e) {
            return "";
        }
    }

    public static String getNextDay(String nowdate, String patten, int delay) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String mdate = "";
            Date d = string2Date(nowdate, patten);
            assert d != null;
            long myTime = (d.getTime() / 1000) + delay * 24 * 60 * 60;
            d.setTime(myTime * 1000);
            mdate = format.format(d);
            return mdate;
        } catch (Exception e) {
            return "";
        }
    }


    /**
     * 获取一个月的最后一天
     *
     * @param dat
     * @return
     */
    public static String getEndDateOfMonth(String dat) {// yyyy-MM-dd
        String str = dat.substring(0, 8);
        String month = dat.substring(5, 7);
        int mon = Integer.parseInt(month);
        if (mon == 1 || mon == 3 || mon == 5
                || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
            str += "31";
        } else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
            str += "30";
        } else {
            if (isLeapYear(dat)) {
                str += "29";
            } else {
                str += "28";
            }
        }
        return str;
    }

    public static String getEndDateOfMonth(Date dat) {
        return getEndDateOfMonth(date2String(dat));
    }

    public static String getEndDateOfMonth(long dat) {
        return getEndDateOfMonth(millis2String(dat));
    }

    /**
     * 返回美国时间格式 26 Apr 2006
     *
     * @param str
     * @return
     */
    public static String getEDate(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(str, pos);
        String j = strtodate.toString();
        String[] k = j.split(" ");
        return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
    }


    /**
     * 判断二个时间是否在同一个周
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameWeekDates(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        if (0 == subYear) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) ==
                    cal2.get(Calendar.WEEK_OF_YEAR)) {
                return true;
            }
        } else if (1 == subYear && 11 ==
                cal2.get(Calendar.MONTH)) {
            // 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
            if (cal1.get(Calendar.WEEK_OF_YEAR) ==
                    cal2.get(Calendar.WEEK_OF_YEAR)) {
                return true;
            }
        } else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) ==
                    cal2.get(Calendar.WEEK_OF_YEAR)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSameWeekDates(String date1, String date2) {
        return isSameWeekDates(string2Date(date1), string2Date(date2));
    }

    /**
     * 判断二个时间是否在同一个周,两个时间类型可自定义
     */
    public static boolean isSameWeekDates(String date1, String patten1, String date2, String patten2) {
        return isSameWeekDates(string2Date(date1, patten1), string2Date(date2, patten2));
    }

    /**
     * 判断二个时间是否在同一个周,两个时间类型一样
     */
    public static boolean isSameWeekDates(String date1, String date2, String patten) {
        return isSameWeekDates(string2Date(date1, patten), string2Date(date2, patten));
    }

    /**
     * 判断二个时间是否在同一个周
     */
    public static boolean isSameWeekDates(long date1, long date2) {
        return isSameWeekDates(millis2Date(date1), millis2Date(date2));
    }

    /**
     * 根据日期,获得是本年第几周
     *
     * @return
     */
    public static int getSeqWeek(String time) {
        return getSeqWeek(time, PATTEN_YMDSFM);
    }

    public static int getSeqWeek() {//当前时间
        return getSeqWeek(getNowString(), PATTEN_YMDSFM);
    }

    public static int getSeqWeek(Date date) {
        return getSeqWeek(date2String(date), PATTEN_YMDSFM);
    }

    public static int getSeqWeek(long millis) {
        return getSeqWeek(millis2String(millis), PATTEN_YMDSFM);
    }

    public static int getSeqWeek(String time, String patten) {
        Calendar calendar = Calendar.getInstance();
        Date date = string2Date(time, patten);
        assert date != null;
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号
     *
     * @param sdate 默认时间格式,返回的也是默认格式
     * @param num
     * @return
     */
    public static String getWeekFormDate(String sdate, int num) {
        return getWeekFormDate(sdate, PATTEN_YMDSFM, num, PATTEN_YMDSFM);
    }

    public static String getWeekFormDate(String sdate, String patten, int num) {
        return getWeekFormDate(sdate, patten, num, PATTEN_YMDSFM);
    }

    public static String getWeekFormDate(Date sdate, int num) {
        return getWeekFormDate(date2String(sdate), PATTEN_YMDSFM, num, PATTEN_YMDSFM);
    }

    public static String getWeekFormDate(long sdate, int num) {
        return getWeekFormDate(millis2String(sdate), PATTEN_YMDSFM, num, PATTEN_YMDSFM);
    }

    public static String getWeekFormDate(String sdate, String patten, int num, String valuePatten) {
        Date dd = string2Date(sdate, patten);
        Calendar c = Calendar.getInstance();
        assert dd != null;
        c.setTime(dd);
        switch (num) {
            case 1:
// 返回星期一所在的日期
                c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                break;
            case 2:
// 返回星期二所在的日期
                c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                break;
            case 3:
// 返回星期三所在的日期
                c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                break;
            case 4:
// 返回星期四所在的日期
                c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                break;
            case 5:
// 返回星期五所在的日期
                c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                break;
            case 6:
// 返回星期六所在的日期
                c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                break;
            case 0:
// 返回星期日所在的日期
                c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                break;
            default:
        }
        return new SimpleDateFormat(valuePatten).format(c.getTime());
    }


    /**
     * 获取星座
     *
     * @param time
     * @return
     */
    public static String getZodiac(final String time) {
        return getZodiac(string2Date(time, DEFAULT_FORMAT));
    }

    public static String getZodiac(final String time, final DateFormat format) {
        return getZodiac(string2Date(time, format));
    }

    public static String getZodiac(final String time, final String patten) {
        return getZodiac(string2Date(time, patten));
    }

    public static String getZodiac(final Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return getZodiac(month, day);
    }

    public static String getZodiac(final long millis) {
        return getZodiac(millis2Date(millis));
    }

    public static String getZodiac(final int month, final int day) {
        return ZODIAC[day >= ZODIAC_FLAGS[month - 1]
                ? month - 1
                : (month + 10) % 12];
    }

    /**
     * 获取生肖
     *
     * @param time
     * @return
     */
    public static String getChineseZodiac(final String time) {
        return getChineseZodiac(string2Date(time, DEFAULT_FORMAT));
    }

    public static String getChineseZodiac(final String time, final String patten) {
        return getChineseZodiac(string2Date(time, patten));
    }

    public static String getChineseZodiac(final String time, final DateFormat format) {
        return getChineseZodiac(string2Date(time, format));
    }

    public static String getChineseZodiac(final Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return CHINESE_ZODIAC[cal.get(Calendar.YEAR) % 12];
    }

    public static String getChineseZodiac(final int year) {
        return CHINESE_ZODIAC[year % 12];
    }

    /**
     * 获取英语的星期
     *
     * @param time
     * @return
     */
    public static String getUSWeek(final String time) {
        return getUSWeek(string2Date(time, DEFAULT_FORMAT));
    }

    public static String getUSWeek(final String time, String patten) {
        return getUSWeek(string2Date(time, getDateParser(patten)));
    }

    public static String getUSWeek(final String time, final DateFormat format) {
        return getUSWeek(string2Date(time, format));
    }

    public static String getUSWeek(final Date date) {
        return new SimpleDateFormat("EEEE", Locale.US).format(date);
    }

    public static String getUSWeek(final long millis) {
        return getUSWeek(new Date(millis));
    }


    /**
     * 获取星期几
     *
     * @param time
     * @return
     */
    public static String getChineseWeek(final String time) {
        return getChineseWeek(string2Date(time, DEFAULT_FORMAT));
    }

    public static String getChineseWeek(final String time, String patten) {
        return getChineseWeek(string2Date(time, getDateParser(patten)));
    }

    public static String getChineseWeek(final Date date) {
        return new SimpleDateFormat("E", Locale.CHINA).format(date);
    }

    public static String getChineseWeek(final long millis) {
        return getChineseWeek(new Date(millis));
    }

    /**
     * 获取友好型与当前时间的差
     *
     * @param time The formatted time string.
     * @return the friendly time span by now
     * <ul>
     * <li>如果小于 1 秒钟内，显示刚刚</li>
     * <li>如果在 1 分钟内，显示 XXX秒前</li>
     * <li>如果在 1 小时内，显示 XXX分钟前</li>
     * <li>如果在 1 小时外的今天内，显示今天15:32</li>
     * <li>如果是昨天的，显示昨天15:32</li>
     * <li>其余显示，2016-10-15</li>
     * <li>时间不合法的情况全部日期和时间信息，如星期六 十月 27 14:21:20 CST 2007</li>
     * </ul>
     */
    public static String getFriendlyTimeSpanByNow(final String time) {
        return getFriendlyTimeSpanByNow(time, DEFAULT_FORMAT);
    }

    public static String getFriendlyTimeSpanByNow(final String time,
                                                  final String patten) {
        return getFriendlyTimeSpanByNow(string2Millis(time, patten));
    }

    public static String getFriendlyTimeSpanByNow(final String time,
                                                  final DateFormat format) {
        return getFriendlyTimeSpanByNow(string2Millis(time, format));
    }

    public static String getFriendlyTimeSpanByNow(final Date date) {
        return getFriendlyTimeSpanByNow(date.getTime());
    }

    /**
     * Return the friendly time span by now.
     *
     * @param millis The milliseconds.
     * @return the friendly time span by now
     * <ul>
     * <li>如果小于 1 秒钟内，显示刚刚</li>
     * <li>如果在 1 分钟内，显示 XXX秒前</li>
     * <li>如果在 1 小时内，显示 XXX分钟前</li>
     * <li>如果在 1 小时外的今天内，显示今天15:32</li>
     * <li>如果是昨天的，显示昨天15:32</li>
     * <li>其余显示，2016-10-15</li>
     * <li>时间不合法的情况全部日期和时间信息，如星期六 十月 27 14:21:20 CST 2007</li>
     * </ul>
     */
    public static String getFriendlyTimeSpanByNow(final long millis) {
        long now = System.currentTimeMillis();
        long span = now - millis;
        if (span < 0)
        // U can read http://www.apihome.cn/api/java/Formatter.html to understand it.
        {
            return String.format("%tc", millis);
        }
        if (span < 1000) {
            return "刚刚";
        } else if (span < MIN) {
            return String.format(Locale.getDefault(), "%d秒前", span / SEC);
        } else if (span < HOUR) {
            return String.format(Locale.getDefault(), "%d分钟前", span / MIN);
        }
        // 获取当天 00:00
        long wee = getWeeOfToday();
        if (millis >= wee) {
            return String.format("今天%tR", millis);
        } else if (millis >= wee - DAY) {
            return String.format("昨天%tR", millis);
        } else {
            return String.format("%tF", millis);
        }
    }

    /**
     * 获取合适型与当前时间的差
     *
     * @param time
     * @param precision <li>precision = 0，返回 null</li>
     *                  *                  <li>precision = 1，返回天</li>
     *                  *                  <li>precision = 2，返回天和小时</li>
     *                  *                  <li>precision = 3，返回天、小时和分钟</li>
     *                  *                  <li>precision = 4，返回天、小时、分钟和秒</li>
     *                  *                  <li>precision &gt;= 5，返回天、小时、分钟、秒和毫秒
     * @return
     */
    public static String getFitTimeSpanByNow(final String time, final int precision) {
        return getFitTimeSpan(time, getNowString(), DEFAULT_FORMAT, precision);
    }

    public static String getFitTimeSpanByNow(final String time,
                                             final DateFormat format,
                                             final int precision) {
        return getFitTimeSpan(time, getNowString(format), format, precision);
    }

    public static String getFitTimeSpanByNow(final String time,
                                             final String patten,
                                             final int precision) {
        SimpleDateFormat format = getDateParser(patten);
        return getFitTimeSpan(time, getNowString(format), format, precision);
    }

    public static String getFitTimeSpanByNow(final Date date, final int precision) {
        return getFitTimeSpan(date, getNowDate(), precision);
    }

    public static String getFitTimeSpanByNow(final long millis, final int precision) {
        return getFitTimeSpan(millis, System.currentTimeMillis(), precision);
    }

    /**
     * 获取时间和当前时间的时间差,时间格式默认(更精确)
     *
     * @param time
     * @param unit
     * @return
     */
    public static long getTimeSpanByNow(final String time, final int unit) {
        return getTimeSpan(time, getNowString(), unit);
    }

    /**
     * (有时分秒更精确)
     *
     * @param time
     * @param patten
     * @param unit
     * @return
     */
    public static long getTimeSpanByNow(final String time,
                                        final String patten,
                                        final int unit) {
        SimpleDateFormat format = getDateParser(patten);
        return getTimeSpan(time, getNowString(format), format, unit);
    }


    /**比较两个时间,返回想要的值
     * @param time1
     * @param time2
     * @param precision<li>precision = 0，返回 null</li>
     *      *                  <li>precision = 1，返回天</li>
     *      *                  <li>precision = 2，返回天和小时</li>
     *      *                  <li>precision = 3，返回天、小时和分钟</li>
     *      *                  <li>precision = 4，返回天、小时、分钟和秒</li>
     *      *                  <li>precision &gt;= 5，返回天、小时、分钟、秒和毫秒</li>
     * @return
     */
    /**
     * 默认时间格式
     */
    public static String getFitTimeSpan(final String time1, final String time2, final int precision) {
        long delta = string2Millis(time1, DEFAULT_FORMAT) - string2Millis(time2, DEFAULT_FORMAT);
        return millis2FitTimeSpan(delta, precision);
    }

    public static String getFitTimeSpan(final String time1, final String time2, String patten, final int precision) {
        SimpleDateFormat format = getDateParser(patten);
        long delta = string2Millis(time1, format) - string2Millis(time2, format);
        return millis2FitTimeSpan(delta, precision);
    }

    public static String getFitTimeSpan(final String time1, final String time2, DateFormat format, final int precision) {
        long delta = string2Millis(time1, format) - string2Millis(time2, format);
        return millis2FitTimeSpan(delta, precision);
    }

    public static String getFitTimeSpan(final Date date1, final Date date2, final int precision) {
        return millis2FitTimeSpan(date2Millis(date1) - date2Millis(date2), precision);
    }

    /**
     * 13 位时间戳
     *
     * @param millis1
     * @param millis2
     * @param precision
     * @return
     */
    public static String getFitTimeSpan(final long millis1,
                                        final long millis2,
                                        final int precision) {
        return millis2FitTimeSpan(millis1 - millis2, precision);
    }

    private static String millis2FitTimeSpan(long millis, int precision) {
        if (precision <= 0) {
            return null;
        }
        precision = Math.min(precision, 5);
        String[] units = {"天", "小时", "分钟", "秒", "毫秒"};
        if (millis == 0) {
            return 0 + units[precision - 1];
        }
        StringBuilder sb = new StringBuilder();
        if (millis < 0) {
            sb.append("-");
            millis = -millis;
        }
        int[] unitLen = {86400000, 3600000, 60000, 1000, 1};
        for (int i = 0; i < precision; i++) {
            if (millis >= unitLen[i]) {
                long mode = millis / unitLen[i];
                millis -= mode * unitLen[i];
                sb.append(mode).append(units[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 比较两个时间的时间差
     *
     * @param time1
     * @param time2
     * @param unit
     * @return
     */
    public static long getTimeSpan(String time1, String time2, int unit) {
        return getTimeSpan(time1, time2, DEFAULT_FORMAT, unit);
    }

    public static long getTimeSpan(String time1, String time2, String patten, int unit) {
        return getTimeSpan(time1, time2, getDateParser(patten), unit);
    }

    public static long getTimeSpan(Date date1, Date date2, int unit) {
        return millis2TimeSpan(date2Millis(date1) - date2Millis(date2), unit);
    }

    public static long getTimeSpan(long millis1, long millis2, int unit) {
        return millis2TimeSpan(millis1 - millis2, unit);
    }

    public static long getTimeSpan(String time1, String time2, DateFormat format, int unit) {
        return millis2TimeSpan(string2Millis(time1, format) - string2Millis(time2, format), unit);
    }

    private static long millis2TimeSpan(long millis, int unit) {
        return millis / unit;
    }

    /**
     * 判断是否是今天
     *
     * @param time
     * @return
     */
    public static boolean isToday(String time) {
        return isToday(string2Millis(time, DEFAULT_FORMAT));
    }

    public static boolean isToday(final long millis) {
        long wee = getWeeOfToday();
        return millis >= wee && millis < wee + DAY;
    }

    private static long getWeeOfToday() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    public static boolean isToday(Date date) {
        return isToday(date.getTime());
    }

    /**
     * 获取SimpleDateFormat
     *
     * @param pattern
     * @return
     */
    private static SimpleDateFormat getDateParser(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    public static long string2Millis(String time) {
        return string2Millis(time, DEFAULT_FORMAT);
    }

    public static long string2Millis(String time, String patten) {
        try {
            return getDateParser(patten).parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static long string2Millis(String time, DateFormat format) {
        try {
            return format.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 时间戳转外 String 类型日期
     *
     * @param millis
     * @return
     */
    public static String millis2String(long millis) {
        return millis2String(millis, DEFAULT_FORMAT);
    }

    public static String millis2String(long millis, DateFormat format) {
        return format.format(new Date(millis));
    }

    public static String millis2String(long millis, String pattern) {
        return millis2String(millis, getDateParser(pattern));
    }

    /**
     * string类型时间转为 date 类型
     *
     * @param time
     * @return
     */
    public static Date string2Date(String time) {
        return string2Date(time, DEFAULT_FORMAT);
    }

    public static Date string2Date(String time, String pattern) {
        try {
            return getDateParser(pattern).parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date string2Date(String time, DateFormat format) {
        try {
            return format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * date 转成 string
     *
     * @param date
     * @return
     */
    public static String date2String(Date date) {
        return date2String(date, DEFAULT_FORMAT);
    }

    public static String date2String(Date date, DateFormat format) {
        return format.format(date);
    }

    /**
     * 返回自定义String类型时间
     */
    public static String date2String(Date date, String pattern) {
        return getDateParser(pattern).format(date);
    }

    /**
     * 时间戳毫秒转成 Date
     *
     * @param millis
     * @return
     */
    public static Date millis2Date(long millis) {
        return new Date(millis);
    }

    /**
     * date 转时间戳
     *
     * @param date
     * @return
     */
    public static long date2Millis(Date date) {
        return date.getTime();
    }

    /**
     * 根据传入的年份和月份，获取上一个月有多少天
     *
     * @param year
     * @param month
     * @return
     */
    public static int getLastDaysOfMonth(int year, int month) {
        int lastDaysOfMonth = 0;
        if (month == 1) {
            lastDaysOfMonth = getDaysOfMonth(year - 1, 12);
        } else {
            lastDaysOfMonth = getDaysOfMonth(year, month - 1);
        }
        return lastDaysOfMonth;
    }


    /**
     * 判断是否为闰年
     *
     * @param
     * @return
     */
    public static boolean isLeapYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        return isLeapYear(year);
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static boolean isLeapYear(long millis) {
        return isLeapYear(millis2Date(millis));
    }

    /**
     * 判断是否润年,默认格式
     */
    public static boolean isLeapYear(String time) {
        Date date = string2Date(time);
        return isLeapYear(date);
    }

    /**
     * 判断是否润年,自定义格式
     */
    public static boolean isLeapYear(String time, String patten) {
        Date date = string2Date(time, patten);
        return isLeapYear(date);
    }


    /**
     * 根据传入的年份和月份，判断当前月有多少天
     *
     * @param year
     * @param month
     * @return
     */
    public static int getDaysOfMonth(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
        }
        return -1;
    }


    /**
     * 获取当前年份
     *
     * @return
     */
    public static String getNowY() {
        return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    }

    public static int getNowY2() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * 获取当前月份
     *
     * @return
     */
    public static int getNowMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    /**
     * 获取当前日期是该月的第几天
     *
     * @return
     */
    public static int getNowDay() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前日期是该周的第几天,周日是第一天返回 1,周六最后一天返回 7
     *
     * @return
     */
    public static int getNowWeek() {
        return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
    }

    /**获取当前日期是当月的第几周,7月27号,返回 5
     * @return
     */
    public static int getNowWeekOfMonth(){
        return Calendar.getInstance().get(Calendar.WEEK_OF_MONTH);
    }

    /**获取当前日期是当年的第几周
     * @return
     */
    public static int getNowWeekOfYear(){
        return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取当前时间 Date 类型
     *
     * @return
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 获取当前是几点,二十四小时制
     */
    public static int getNowHour() {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取当前是几分
     *
     * @return
     */
    public static int getNowMinute() {
        return Calendar.getInstance().get(Calendar.MINUTE);
    }

    /**
     * 获取当前秒
     *
     * @return
     */
    public static int getNowSecond() {
        return Calendar.getInstance().get(Calendar.SECOND);
    }


    /**
     * 获取当前时间字符串,年月日时分秒
     *
     * @return
     */
    public static String getNowString() {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTEN_YMDSFM);
//        return simpleDateFormat.format(getNowMills());
        return DEFAULT_FORMAT.format(getNowMills());
    }

    /**
     * 获取当前时间字符串,自定义返回类型
     *
     * @return
     */
    public static String getNowString(String pattern) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
////        return simpleDateFormat.format(getNowMills());
        return getDateParser(pattern).format(getNowMills());
    }

    public static String getNowString(DateFormat dateFormat) {
        return dateFormat.format(getNowMills());
    }

    /**
     * 获取当前时间的时间戳,毫秒
     *
     * @return
     */
    public static long getNowMills() {
        return System.currentTimeMillis();
    }

    /**获取今天是今年的第几天
     * @return
     */
    public static int getNowDayOfYear(){
        int nowSecond = getNowSecond();
        return nowSecond/(24 * 60 * 60);
    }

}
