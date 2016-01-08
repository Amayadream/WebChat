package com.amayadream.webchat.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * NAME   :  List/com.amayadream.list.util
 * Author :  Amayadream
 * Date   :  2015.11.26 17:33
 * TODO   :  日期时间工具
 */
public class DateUtil {
    private static final String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    private static final String month = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1);
    private static final String day = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
    private static final String hour_24 = String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
    private static final String hour_12 = String.valueOf(Calendar.getInstance().get(Calendar.HOUR));
    private static final String minute = String.valueOf(Calendar.getInstance().get(Calendar.MINUTE));
    private static final String second = String.valueOf(Calendar.getInstance().get(Calendar.SECOND));

    /**
     * 按照yyyy-MM-dd获取日期,缺位补足(例如:2015-01-21)
     * @return 日期
     */
    public String getDateFull(){
        return year + "-" + (Integer.parseInt(month) < 10 ? ("0" + month) : month) + "-" + (Integer.parseInt(day) < 10 ? ("0" + day) : day);
    }

    /**
     * 按照yyyy-MM-dd获取日期,不补足缺位(例如:2015-1-21)
     * @return 日期
     */
    public String getDateNotFull(){
        return year + "-" + month + "-" + day;
    }

    /**
     * 按照yyyy-MM-dd HH:mm:ss,12小时制(例如:2015-01-21 PM 6:30:30)
     * @return 日期时间 12小时制
     */
    public String getDateTime12(){
        return year + "-" + (Integer.parseInt(month) < 10 ? ("0" + month) : month) + "-" + (Integer.parseInt(day) < 10 ? ("0" + day) : day) + " "
                + (Integer.parseInt(hour_12) < 10 ? ("PM " + hour_12) : ("AM " + hour_12)) + ":" + (Integer.parseInt(minute) < 10 ? ("0" + minute) : minute) + ":"
                + (Integer.parseInt(second) < 10 ? ("0" + second) : second);
    }

    /**
     * 按照yyyy-MM-dd HH:mm:ss,24小时制(例如:2015-01-21 18:30:30)
     * @return 日期时间 24小时制
     */
    public String getDateTime24(){
        return year + "-" + (Integer.parseInt(month) < 10 ? ("0" + month) : month) + "-" + (Integer.parseInt(day) < 10 ? ("0" + day) : day) + " "
                + (Integer.parseInt(hour_24) < 10 ? ("0" + hour_24) : hour_24) + ":" + (Integer.parseInt(minute) < 10 ? ("0" + minute) : minute) + ":"
                + (Integer.parseInt(second) < 10 ? ("0" + second) : second);
    }

//    public static String getDateTime_24(){
//        Date date = new Date();
//        SimpleDateFormat timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = timeStamp.format(date);
//        return time;
//    }

    /**
     * 获取当前时间的时间戳
     * @return Unix时间戳
     */
    public Long getStamp(){
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 将Unix时间戳转换为日期时间
     * @param timeStamp Unix时间戳
     * @return 日期时间(yyyy-MM-dd HH:mm:ss)
     */
    public String StampToDateTime(long timeStamp){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timeStamp * 1000));
    }

    /**
     * 计算年龄
     * @param year 出生年份
     * @return 年龄
     */
    public int getAge(int year){
        return Integer.parseInt(getYear()) - year;
    }

    /**
     * 获取 年
     * @return 年
     */
    public String getYear() {
        return year;
    }

    /**
     * 获取 月(已修正)
     * @return 月
     */
    public String getMonth() {
        return month;
    }

    /**
     * 获取 日
     * @return 日
     */
    public String getDay() {
        return day;
    }

    /**
     * 获取24小时制 时
     * @return 时(24小时制)
     */
    public String getHour_24() {
        return hour_24;
    }

    /**
     * 获取12小时制 时
     * @return 时(12小时制)
     */
    public String getHour_12() {
        return hour_12;
    }

    /**
     * 获取 分
     * @return 分
     */
    public String getMinute() {
        return minute;
    }

    /**
     * 获取 秒
     * @return 秒
     */
    public String getSecond() {
        return second;
    }
}
