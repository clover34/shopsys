package com.etc.shopsys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/05 14:08
 * @Version 1.0
 **/
public class DateUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * Date 转换 String
     * @param date
     * @return
     */
    public static String date2String(Date date){
        return sdf.format(date);
    }

    /**
     * String 转 date
     * @param date
     * @return
     */
    public static Date string2Date(String date){
        try {
            return sdf.parse(date );
        } catch (ParseException e) {
            System.out.println("string转date异常");
            e.printStackTrace();
        }
        return null;
    }
}
