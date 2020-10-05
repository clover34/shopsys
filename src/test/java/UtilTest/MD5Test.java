package UtilTest;

import com.etc.shopsys.utils.DateUtil;
import com.etc.shopsys.utils.EncryptUtil;
import org.junit.Test;

import java.util.Date;

/**
 * @ClassName MD5Test
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/05 13:43
 * @Version 1.0
 **/
public class MD5Test {
    @Test
    public void test(){
        String pwd = EncryptUtil.md52String("admin");
        System.out.println(EncryptUtil.string2MD5(pwd));
    }
}
