package UtilTest;

import com.etc.shopsys.utils.VerifyUtil;
import org.junit.Test;

/**
 * @ClassName VerifyUtilTest
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/05 18:34
 * @Version 1.0
 **/
public class VerifyUtilTest {
    @Test
    public void test(){
        String phone = "17608994857";
        String Phone01 = "1760899485711";
        String Phone02 = "11111111111";
        String Phone03 = "111111111";
        System.out.println("========================手机号校验========================");
        System.out.println(VerifyUtil.verifyPhone(phone));
        System.out.println(VerifyUtil.verifyPhone(Phone01));
        System.out.println(VerifyUtil.verifyPhone(Phone02));
        System.out.println(VerifyUtil.verifyPhone(Phone03));
        System.out.println("========================邮箱校验========================");
        String email = "1448562378@qq.com";
        String email01 = "1448562378@qq.c";
        String email02 = "1448562378@q.com";
        String email03 = "1448562378qq.com";
        System.out.println(VerifyUtil.verifyEmail(email));
        System.out.println(VerifyUtil.verifyEmail(email01));
        System.out.println(VerifyUtil.verifyEmail(email02));
        System.out.println(VerifyUtil.verifyEmail(email03));
    }
}
