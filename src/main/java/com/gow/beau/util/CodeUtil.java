package com.gow.beau.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by lzn on 2019/3/12.
 */
public class CodeUtil {

    public static String orderCode(Long customerId){
        if(null == customerId){
            return null;
        }
        return dateCode()+randomCode()+customerId;
    }

    public static String goodsCode(){
        return "G"+dateCode()+randomCode();
    }

    /**
     * lzn 2019/3/12 12:08
     * 日期拼接
     */
    private static String dateCode(){
        Calendar calendar = Calendar.getInstance();
        String year = calendar.get(Calendar.YEAR)+"";//得到年份
        String month = (calendar.get(Calendar.MONTH)+1)+"";//得到月份
        String date = calendar.get(Calendar.DATE)+"";//得到月份中今天的号数
        String hour = calendar.get(Calendar.HOUR_OF_DAY)+"";//得到一天中现在的时间，24小时制
        String minute = calendar.get(Calendar.MINUTE)+"";//得到分钟数
        String second = calendar.get(Calendar.SECOND)+"";//得到秒数
        String dateCode = year+month+date+hour+minute+second;
        return dateCode;
    }

    /**
     * lzn 2019/3/12 12:12
     * 随机数字
     */
    private static String randomCode(){
        String code = "";
        Random rand = new Random();
        //循环几次，取几个
        for(int i=0; i<4; i++) {
            //0 ~ 9 的随机数
            code += rand.nextInt(10);
        }
        return code;
    }
}
