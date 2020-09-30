package DBTest;

import com.etc.shopsys.utils.DBUtil;
import org.junit.Test;

/**
 * @ClassName ConnectionDBTest
 * @Description TODO
 * @Author Administrator
 * @Date 20/09/30 13:46
 * @Version 1.0
 **/
public class ConnectionDBTest {
    @Test
    public void test(){
        System.out.println(DBUtil.getConnection());
    }
}
