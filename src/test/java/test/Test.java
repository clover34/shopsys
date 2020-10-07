package test;

import com.etc.shopsys.dao.OrderDetailsDao;
import com.etc.shopsys.dao.OrderStateDao;
import com.etc.shopsys.dao.OrdersDao;
import com.etc.shopsys.dao.TrolleyDao;
import com.etc.shopsys.dao.impl.OrderDetailsDaoImpl;
import com.etc.shopsys.dao.impl.OrderStateDaoImpl;
import com.etc.shopsys.dao.impl.OrdersDaoImpl;
import com.etc.shopsys.dao.impl.TrolleyDaoImpl;
import com.etc.shopsys.domain.*;
import com.etc.shopsys.utils.CounterUtil;
import com.etc.shopsys.utils.DBUtil;
import com.etc.shopsys.utils.DateUtil;

import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
         TrolleyDao trolleyDao=new TrolleyDaoImpl();
         boolean trolley=trolleyDao.deleteTrolleyById("1");
         System.out.println(trolley);
       /*boolean i=trolleyDao.insertTrolley(new Trolley("1","1",2));
        boolean i=trolleyDao.updateTrolleyById("1","1","3");
        Trolley trolley=trolleyDao.findTrolleyById("1");
        Page<Trolley> page=trolleyDao.findAllTrolley(1,1);
        List<Trolley> list=page.getData();
        for (Trolley trolley : list) {

        }*/

         /*OrderStateDao orderStateDao = new OrderStateDaoImpl();

       boolean osid = orderStateDao.insertOsid(new OrderState(234, 5));
        System.out.println(osid);*/

        /*boolean osid = orderStateDao.deleteOrderStateByOsid(234);
        System.out.println(osid);*/

        /*List<OrderState> allOrderState = orderStateDao.findAllOrderState();
        for (OrderState orderState : allOrderState) {
            System.out.println(orderState);
        }*/

        /*Page<OrderState> orderStateByOsid = orderStateDao.findOrderStateByOsid(789, 1, 1);
        System.out.println(orderStateByOsid);*/

        /*boolean b = orderStateDao.updataOrderStateByOsid(123, 3);
        System.out.println(b);*/

        /*OrdersDao ordersDao = new OrdersDaoImpl();
        boolean b = ordersDao.insertUidByOid(new Orders(DBUtil.getUUID(), CounterUtil.getCounterStr("oid",1), CounterUtil.getCounterStr("uid",1), 2.50, new Date(), 1));
        System.out.println(b);
        System.out.println(new Date());*/

        /*boolean b1 = ordersDao.deleteUidByOid("234");
        System.out.println(b1);*/

        /*List<Orders> allOrders = ordersDao.findAllOrders();
        for (Orders allOrder : allOrders) {
            System.out.println(allOrder);
        }
*/
        /*int allRecords = ordersDao.findAllRecords();
        System.out.println(allRecords);*/

        /*Orders ordersInfoByOid = ordersDao.findOrdersInfoByOid("123");
        System.out.println(ordersInfoByOid);*/

        /*Page<Orders> ordersInfoByOsid = ordersDao.findOrdersInfoByOsid(1, 1, 3);
        System.out.println(ordersInfoByOsid);*/

        /*Orders uid = ordersDao.findOrdersInfoByUid("uid0002");
        System.out.println(uid);*/

        /*boolean b = ordersDao.updataOsidByOid("123", 2);
        System.out.println(b);*/

        /*boolean b = ordersDao.updataTotalByOid("123", 100);
        System.out.println(b);*/

        /*boolean b = ordersDao.updataOsidByUid("uid0002", 5);
        System.out.println(b);*/

        /*boolean b = ordersDao.updataTotalByUid("uid0002", 5000);
        System.out.println(b);*/

        /*boolean b = ordersDao.updataUidByOid("oid0002", "u001");
        System.out.println(b);*/

       /* OrderDetailsDao dao = new OrderDetailsDaoImpl();

        boolean u = dao.deleteGidByOid("u0001");
        System.out.println(u);

        List<OrderDetails> allOrderDetails = dao.findAllOrderDetails();
        for (OrderDetails allOrderDetail : allOrderDetails) {
            System.out.println(allOrderDetail);
        }

        OrderDetails u = dao.findInfoByOid("u0002");
        System.out.println(u);*/

        /*boolean b = dao.insertGidByOid(new OrderDetails("u0002", "g0002", 5, 3, 15));
        System.out.println(b);

        boolean b = dao.updateGidByOid("u0002", "g0001");
        System.out.println(b);

        boolean g = dao.updategpriceByGid("g0001", 4.00000000);
        System.out.println(g);

        boolean u0002 = dao.updategpriceByOid("u0002", 3.00000000);
        System.out.println(u0002);

        boolean g0001 = dao.updateOdnumByGid("g0001", 4);


        boolean u0002 = dao.updateodnumByOid("u0002", 5);


        List<OrderDetails> allOrderDetails = dao.findAllOrderDetails();
        for (OrderDetails allOrderDetail : allOrderDetails) {
            System.out.println(allOrderDetail);
        }*/
        /*OrderDetails u00021 = dao.findOidByGid("u0002");
        System.out.println(u00021);
        OrderDetails u0002 = dao.findInfoByOid("u0002");
        System.out.println(u0002);
        String gid = u0002.getGid();
        System.out.println(gid);*/
    }

}
