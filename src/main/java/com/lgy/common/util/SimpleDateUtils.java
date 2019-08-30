package com.lgy.common.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间处理工具类
 */
public class SimpleDateUtils {

    /**
     * 解决多线程时间生成BUG
     */
    public static ThreadLocal<SimpleDateFormat> SDF = new ThreadLocal<SimpleDateFormat>();

    public static final String PATTERN_DATE = "yyyy-MM-dd";

    public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";

    public static final String PATTERN_DATETIMES = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 获取前一天的时间
     *
     * @param value
     *            2017-06-10 00:00:00
     * @return 2017-06-09 00:00:00
     */
    @SuppressWarnings("deprecation")
    public static Date beginTimeOfTheDay(Date value) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, value.getDate() + 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取往一天的时间
     *
     * @param value
     *            2017-06-10 00:00:00
     * @return 2017-06-11 00:00:00
     */
    public static Date endTimeOfTheDay(Date value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(value.getTime());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 将时间设置为当天的开始的第0秒
     *
     * @param value
     *            2017-06-10 11:22:00
     * @return 2017-06-10 00:00:00
     */
    public static String beginTimeOfTheDay(String value) {

        if (value == null) {
            return null;
        }
        String newDate = toDate(toDate(value));
        if (newDate != null) {
            newDate += " 00:00:00";
        }

        return newDate;
    }

    /**
     * 将时间设置为当天的最后一秒
     *
     * @param value
     *            2017-06-10 11:22:00
     * @return 2017-06-10 23:59:59
     */
    public static String endTimeOfTheDay(String value) {

        if ((value = toDate(toDate(value))) != null) {
            value += " 23:59:59";
        }
        return value;
    }

    /**
     * 将日期对象转换为字符串 格式如：2011-01-01
     *
     * @param value
     *            Date
     * @return String 2011-01-01
     */
    public static String toDate(Date value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        String year = Integer.toString(calendar.get(Calendar.YEAR));
        String month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
        String date = Integer.toString(calendar.get(Calendar.DATE));
        year = StringUtils.leftPad(year, 4, "0");
        month = StringUtils.leftPad(month, 2, "0");
        date = StringUtils.leftPad(date, 2, "0");
        return new StringBuilder(32).append(year).append("-").append(month).append("-").append(date).toString();
    }

    /**
     * 将日期对象转换为字符串 格式如：2011-01-01 12:14:21
     *
     * @param value
     *            Date
     * @return String 2011-01-01 12:14:21
     */
    public static String toDateTime(Date value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        String year = Integer.toString(calendar.get(Calendar.YEAR));
        String month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
        String date = Integer.toString(calendar.get(Calendar.DATE));
        String hour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(calendar.get(Calendar.MINUTE));
        String second = Integer.toString(calendar.get(Calendar.SECOND));
        year = StringUtils.leftPad(year, 4, "0");
        month = StringUtils.leftPad(month, 2, "0");
        date = StringUtils.leftPad(date, 2, "0");
        hour = StringUtils.leftPad(hour, 2, "0");
        minute = StringUtils.leftPad(minute, 2, "0");
        second = StringUtils.leftPad(second, 2, "0");
        return new StringBuilder(32).append(year).append("-").append(month).append("-").append(date).append(" ")
                .append(hour).append(":").append(minute).append(":").append(second).toString();
    }


    /**
     * 将字符串转换为日期对象 格式如：2011-01-01
     *
     * @param value
     *            2011-01-01
     * @return Date
     */
    public static Date toDate(String value) {
        Date date = null;
        try {
            if (StringUtils.isNotBlank(value)) {
                initSimpleDateFormat();
                SDF.get().applyPattern(PATTERN_DATE);
                date = SDF.get().parse(value);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将字符串转换为日期对象 格式如：2011-01-01 12:14:21
     *
     * @param value
     *            2011-01-01 12:14:21
     * @return Date
     */
    public static Date toDateTime(String value) {
        Date date = null;
        try {
            if (StringUtils.isNotBlank(value)) {
                initSimpleDateFormat();
                SDF.get().applyPattern(PATTERN_DATETIME);
                date = SDF.get().parse(value);
            }
        } catch (ParseException e) {
        }
        return date;
    }


    /**
     * 根据传进来的格式（pattern）返回对应的String
     *
     * @param pattern
     *            时间格式
     * @param datetime
     *            2017-01-01 12:14:21
     * @return String
     */
    public static String convertDateToStirng(String pattern, String datetime) {
        if (StringUtils.isBlank(datetime)) {
            return null;
        }
        initSimpleDateFormat();
        String time = null;
        SDF.get().applyPattern(pattern);
        try {
            time = SDF.get().format(SDF.get().parse(datetime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 将时间字符串转成日期字符串
     *
     * @param datetime
     *            2017-01-01 12:14:21
     * @return yyyy-MM-dd
     */
    public static String convertDateToStirng(String datetime) {
        if (StringUtils.isBlank(datetime)) {
            return null;
        }
        initSimpleDateFormat();
        String time = null;
        SDF.get().applyPattern(PATTERN_DATE);
        try {
            time = SDF.get().format(SDF.get().parse(datetime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 获取本地服务器时间的往前一天的零点秒 例如:本地当前时间 2017-04-10 20:52:12 转换前天时间为:2017-04-11
     * 00:00:00 公式:前天时间-本地当前时间=秒
     *
     * @author wonderful
     * @return Long
     */
    public static long getBeforeDayConvertSecond() {
        Calendar curDate = Calendar.getInstance();
        Calendar tommorowDate = new GregorianCalendar(curDate.get(Calendar.YEAR), curDate.get(Calendar.MONTH),
                curDate.get(Calendar.DATE) + 1, 0, 0, 0);
        return (tommorowDate.getTimeInMillis() - curDate.getTimeInMillis()) / 1000L;
    }

    /**
     * 获取本地服务器时间的往前指定天的零点秒 例如:获取当前时间的后7天时间， 本地当前时间 2017-04-10 20:52:12
     * 转换前天时间为:2017-04-17 00:00:00 公式:前天时间-本地当前时间=秒
     *
     * @author wonderful
     * @return Long
     */
    public static Long getBeforeDayConvertSecond(int day) {
        Calendar curDate = Calendar.getInstance();
        Calendar tommorowDate = new GregorianCalendar(curDate.get(Calendar.YEAR), curDate.get(Calendar.MONTH),
                curDate.get(Calendar.DATE) + day, 0, 0, 0);
        return (tommorowDate.getTimeInMillis() - curDate.getTimeInMillis()) / 1000L;
    }

    /**
     * 初始化时间工具
     */
    public static void initSimpleDateFormat() {
        if (SDF.get() == null) {
            SimpleDateFormat sdf = new SimpleDateFormat();
            SDF.set(sdf);
        }
    }

    /**
     * 获取现在时间,string
     *
     * @return 返回时间字符串格式: yyyy-MM-dd HH:mm:ss.SSS
     */
    public static String getCurrentTimesToStirng() {
        return getCurrentDateToStirng(PATTERN_DATETIMES);
    }

    /**
     * 获取当前时间,String
     *
     * @return 返回时间字符串格式: yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentTimeToStirng() {
        return getCurrentDateToStirng(PATTERN_DATETIME);
    }

    /**
     * 获取现在日期
     *
     * @return 返回时间字符串格式: yyyy-MM-dd
     */
    public static String getCurrentDateToStirng() {
        return getCurrentDateToStirng(PATTERN_DATE);
    }

    /**
     * @param date 时间转换.
     * @return  yyyy-MM-dd'T'hh:mm:ss.SSS
     */
    public static String getTimeFormatString(Date date) {
        if(SDF.get() == null){
            initSimpleDateFormat();
        }

        SDF.get().applyPattern(PATTERN_DATETIMES);

        return SDF.get().format(date);
    }

    /**
     * 获取现在时间
     * yyyy-MM-dd
     * yyyy/MM/dd
     * yyyy-MM-dd HH:mm:ss.SSS
     *
     * @return 返回指定格式的时间
     */
    public static String getCurrentDateToStirng(String format) {
        if(SDF.get() == null){
            initSimpleDateFormat();
        }
        SDF.get().applyPattern(format);
        return SDF.get().format(new Date());
    }
}

