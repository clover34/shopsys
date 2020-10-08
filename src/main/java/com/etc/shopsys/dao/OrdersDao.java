package com.etc.shopsys.dao;

import com.etc.shopsys.domain.Orders;
import com.etc.shopsys.domain.Page;

import java.util.Date;
import java.util.List;

public interface OrdersDao {

    // 增: 新增订单
    boolean insertUidByOid(Orders orders);



    // 删: 根据订单编号删除用户编号
    boolean deleteUidByOid(String oid);

    // 改: 根据订单编号修改用户编号
    boolean updataUidByOid(String oid, String uid);

    //改: 根据订单编号修改订单总价
    boolean updataTotalByOid(String oid, double total);

    //改: 根据订单编号修改订单创建时间
    /*boolean updataCreateDateByOid(String oid, Date createdate);*/

    //改: 根据订单编号修改状态编号
    boolean updataOsidByOid(String oid, int osid);

    //改: 根据用户编号修改订单总价
    boolean updataTotalByUid(String uid, double total);

    //改: 根据用户编号修改订单时间创建时间
    /*boolean updataCreateDateByUid(int uid, Date createdate);*/

    //改:根据用户编号修改状态编号
    boolean updataOsidByUid(String uid, int osid);

    //查: 查询全部订单
    List<Orders> findAllOrders();

    //查: 查询总记录条数
    int findAllRecords();

    //查: 根据订单编号查询订单信息
    Orders findOrdersInfoByOid(String oid);

    //查:根据用户编号查询订单信息
    Page<Orders> findOrdersInfoByUid(String uid,int currentPage,int sizePage);

    //查: 根据订单创建时间插查询订单信息
    Orders findOrdersInfoByCreateDate(Date createdate);

    //查:根据UUID查询
    Orders findOrdersInfoByUUID(String uuid);

    //查: 根据状态编号查询订单信息
    Page<Orders> findOrdersInfoByOsid(int osid,int currentPage,int sizePage);

}
