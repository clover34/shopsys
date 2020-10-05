package com.etc.shopsys.utils;

/**
 * @ClassName VerifyUtil
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/05 18:30
 * @Version 1.0
 **/
public class VerifyUtil {
    /**
     * 正则表达式验证手机号格式
     * @param phone
     * @return
     */
    public static boolean verifyPhone(String phone){
        String regex = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        return phone.matches(regex);
    }

    /**
     * 正则表达式验证邮箱格式
     * @param email
     * @return
     */
    public static boolean verifyEmail(String email){
        String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return email.matches(regex);
    }
}
