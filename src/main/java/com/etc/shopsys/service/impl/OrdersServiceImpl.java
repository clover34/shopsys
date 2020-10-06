package com.etc.shopsys.service.impl;

import com.etc.shopsys.dao.OrdersDao;
import com.etc.shopsys.dao.impl.OrdersDaoImpl;
import com.etc.shopsys.domain.Orders;
import com.etc.shopsys.domain.Page;
import com.etc.shopsys.service.OrdersService;
import com.etc.shopsys.utils.CounterUtil;

import java.util.Date;
import java.util.List;

public class OrdersServiceImpl implements OrdersService {

    private OrdersDao ordersDao = new OrdersDaoImpl();

    @Override
    public String insertUidByOid(Orders orders) {
        orders.setOid(CounterUtil.getCounterStr("oid",ordersDao.findAllRecords()+1));
        if(ordersDao.findOrdersInfoByOid(orders.getOid())==null){
            return ordersDao.insertUidByOid(orders)?"添加成功":"添加失败";
        }else{
            return "该订单编号已存在，添加失败";
        }

    }

    @Override
    public String deleteUidByOid(String oid) {
        return ordersDao.deleteUidByOid(oid)?"删除成功":"删除失败";

    }

    @Override
    public String updataUidByOid(String oid, String uid) {
        return ordersDao.updataUidByOid(oid,uid)?"修改成功":"修改失败";

    }

    @Override
    public String updataTotalByOid(String oid, double total) {
        return ordersDao.updataTotalByOid(oid,total)?"修改成功":"修改失败";

    }

    @Override
    public String updataOsidByOid(String oid, int osid) {
        return ordersDao.updataOsidByOid(oid,osid)?"修改成功":"修改失败";

    }

    @Override
    public String updataTotalByUid(String uid, double total) {
        return ordersDao.updataTotalByUid(uid,total)?"修改成功":"修改失败";

    }

    @Override
    public String updataOsidByUid(String uid, int osid) {
        return ordersDao.updataOsidByUid(uid,osid)?"修改成功":"修改失败";

    }

    @Override
    public List<Orders> findAllOrders() {
        List<Orders> orders = ordersDao.findAllOrders();
        return orders;
    }

    @Override
    public Orders findOrdersInfoByOid(String oid) {
        Orders oid1 = ordersDao.findOrdersInfoByOid(oid);
        return oid1;
    }

    @Override
    public Orders findOrdersInfoByUid(String uid) {
        Orders uid1 = ordersDao.findOrdersInfoByUid(uid);
        return uid1;
    }

    @Override
    public Orders findOrdersInfoByCreateDate(Date createdate) {
        Orders date = ordersDao.findOrdersInfoByCreateDate(createdate);
        return date;
    }

    @Override
    public Orders findOrdersInfoByUUID(String uuid) {
        Orders uuid1 = ordersDao.findOrdersInfoByUUID(uuid);
        return uuid1;
    }

    @Override
    public Page<Orders> findOrdersInfoByOsid(int osid, int currentPage, int sizePage) {
        Page<Orders> osid1 = ordersDao.findOrdersInfoByOsid(osid, currentPage, sizePage);
        return osid1;
    }
}
