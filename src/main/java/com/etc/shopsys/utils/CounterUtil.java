package com.etc.shopsys.utils;

/**
 * @ClassName CounterUtil
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/01 12:04
 * @Version 1.0
 **/
public class CounterUtil {
    /**
     * 获得指定位数，根据参数确定位数
     * @param prefix 前缀
     * @param length 位数
     * @param record 第几条记录
     * @return
     */
    public static String getCounterStr(String prefix, int length, int record) {
        return prefix + String.format("%0"+ length +"d", record);
    }
    /** 获得指定位数，默认4位*/
    public static String getCounterStr(String prefix, int record) {
        return prefix + String.format("%04d", record);
    }
}
