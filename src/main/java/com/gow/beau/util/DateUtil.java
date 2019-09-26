package com.gow.beau.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Author lzn
 * @DATE 2019/8/30 9:39
 */
public class DateUtil {

    //日期转换格式
    public static final String PATTERN_YEAR = "yyyy";
    public static final String PATTERN_YEAR_MONTH = "yyyy-MM";
    public static final String PATTERN_YEAR_MONTH_DAY = "yyyy-MM-dd";
    public static final String PATTERN_YEAR_MONTH_DAY_HOURS = "yyyy-MM-dd HH";
    public static final String PATTERN_YEAR_MONTH_DAY_HOURS_MINUTE = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_YEAR_MONTH_DAY_HOURS_MINUTE_SECONDS = "yyyy-MM-dd HH:mm:ss";
    //日期时间段
    public static final String CALENDAR_YEAR = "year";
    public static final String CALENDAR_MONTH = "month";
    public static final String CALENDAR_DAY = "day";
    public static final String CALENDAR_HOURS = "hours";
    public static final String CALENDAR_MINUTE = "minute";
    public static final String CALENDAR_SECONDS = "seconds";

    /**
     * 当前系统 - 时间相加减
     * */
    public static Date getTimeAddOrSubtract(String calendarValue , int number){
        Calendar calendar = Calendar.getInstance();
        switch (calendarValue){
            case CALENDAR_YEAR :
                calendar.add(Calendar.YEAR,number);
            case CALENDAR_MONTH :
                calendar.add(Calendar.YEAR,number);
            case CALENDAR_DAY :
                calendar.add(Calendar.DAY_OF_WEEK,number);
            case CALENDAR_HOURS :
                calendar.add(Calendar.HOUR,number);
            case CALENDAR_MINUTE :
                calendar.add(Calendar.MINUTE,number);
            case CALENDAR_SECONDS :
                calendar.add(Calendar.SECOND,number);
        }
        return calendar.getTime();
    }

    /**
     * date 转 string格式
     * */
    public static String dateToString(Date date,String pattern){
        if(null == date){
            return "";
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format(date);
        }catch (Exception e){
            throw new RuntimeException("日期转换成String格式异常："+e.getMessage());
        }
    }

    /**
     * String 转 date
     * */
    public static Date stringToDate(String date,String pattern){
        if(null == date || date.equals("")){
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(date);
        }catch (Exception e){
            throw new RuntimeException("日期转换成String格式异常："+e.getMessage());
        }
    }




}
