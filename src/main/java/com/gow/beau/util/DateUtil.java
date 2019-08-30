package com.gow.beau.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Author lzn
 * @DATE 2019/8/30 9:39
 */
public class DateUtil {

    /**
     * date 转 string格式
     * */
    public static String dateToString(Date date){
        if(null == date){
            return "";
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
        }catch (Exception e){
            throw new RuntimeException("日期转换成String格式异常："+e.getMessage());
        }
    }

    /**
     * date 转 string格式
     * */
    public static String dateToString_HM(Date date){
        if(null == date){
            return "";
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            System.err.println(sdf.format(date));
            return sdf.format(date);
        }catch (Exception e){
            throw new RuntimeException("日期转换成String格式异常："+e.getMessage());
        }
    }

    /**
     * date 转 string格式
     * 带时间
     * */
    public static String dateToString2(Date date){
        if(null == date){
            return "";
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        }catch (Exception e){
            throw new RuntimeException("日期转换成String格式异常："+e.getMessage());
        }
    }

    /**
     * String 转 date
     * */
    public static Date stringToDate(String date){
        if(null == date || date.equals("")){
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(date);
        }catch (Exception e){
            throw new RuntimeException("日期转换成String格式异常："+e.getMessage());
        }
    }
    /**
     * String 转 date
     * 带时间
     * */
    public static Date stringToDate2(String date){
        if(null == date || date.equals("")){
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(date);
        }catch (Exception e){
            throw new RuntimeException("日期转换成String格式异常："+e.getMessage());
        }
    }

    /**
     * String 转 date
     * 带时间
     * */
    public static Date stringToDate3(String date){
        if(null == date || date.equals("")){
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return sdf.parse(date);
        }catch (Exception e){
            throw new RuntimeException("日期转换成String格式异常："+e.getMessage());
        }
    }


}
