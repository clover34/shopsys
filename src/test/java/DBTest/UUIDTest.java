package DBTest;

import com.etc.shopsys.utils.DBUtil;
import org.junit.Test;

/**
 * @ClassName UUIDTest
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/01 21:33
 * @Version 1.0
 **/
public class UUIDTest {
    @Test
    public void test(){
        System.out.println(DBUtil.getUUID());
    }
}
