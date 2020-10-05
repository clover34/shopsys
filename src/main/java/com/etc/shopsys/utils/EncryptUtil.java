package com.etc.shopsys.utils;

/**
 * @ClassName EncryptUtil
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/05 13:30
 * @Version 1.0
 **/
public class EncryptUtil {
    /**
     * @param str
     *      要加密的字符串
     * @return
     */
    public static String string2MD5(String str){
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] ^= 10;//对字节加密
        }
        return new String(bytes);
    }

    /**
     * @param str
     * @return
     */
    public static String md52String(String str){
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] ^= 10;//对字节加密
        }
        return new String(bytes);
    }
}
