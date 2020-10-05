package UtilTest;

import com.etc.shopsys.utils.CounterUtil;
import org.junit.Test;

/**
 * @ClassName CounterUtilTest
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/01 12:27
 * @Version 1.0
 **/
public class CounterUtilTest {
    @Test
    public void test(){
        System.out.println("默认4位" + CounterUtil.getCounterStr("goods", 101));
        System.out.println("5位" + CounterUtil.getCounterStr("user", 5, 111));
    }
}
