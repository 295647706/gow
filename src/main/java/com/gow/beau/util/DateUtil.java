package com.gow.beau.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Author lzn
 * @DATE 2019/8/30 9:39
 */
public class DateUtil {

    public static final String PATTERN_YEAR = "yyyy";
    public static final String PATTERN_YEAR_MONTH = "yyyy-MM";
    public static final String PATTERN_YEAR_MONTH_DAY = "yyyy-MM-dd";
    public static final String PATTERN_YEAR_MONTH_DAY_HOURS = "yyyy-MM-dd HH";
    public static final String PATTERN_YEAR_MONTH_DAY_HOURS_MINUTE = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_YEAR_MONTH_DAY_HOURS_MINUTE_SECONDS = "yyyy-MM-dd HH:mm:ss";

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
