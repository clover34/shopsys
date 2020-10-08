package com.etc.shopsys.dao.impl;

import com.etc.shopsys.dao.BaseDao;
import com.etc.shopsys.dao.OrdersDao;
import com.etc.shopsys.domain.OrderState;
import com.etc.shopsys.domain.Orders;
import com.etc.shopsys.domain.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class OrdersDaoImpl extends BaseDao<Orders>implements OrdersDao {

    // 增: 根据订单编号增加用户编号
    public boolean insertUidByOid(Orders orders) {
        String sql = "insert into Orders values(?,?,?,?,?,?)";
        return super.executeUpdate(sql,orders.getUUID(),orders.getOid(),orders.getUid(),orders.getTotal(),
                orders.getCreatedate(),orders.getOsid());
    }
    // 删: 根据订单编号删除订单
    public boolean deleteUidByOid(String oid) {
        String sql = "delete from orders where oid = ?";
        return super.executeUpdate(sql, oid);
    }



    // 改: 根据订单编号修改用户编号
    public boolean updataUidByOid(String oid, String uid) {
        String sql = "update orders set uid = ? where oid = ?";
        return super.executeUpdate(sql,uid,oid);
    }
    //改: 根据订单编号修改订单总价
    public boolean updataTotalByOid(String oid, double total) {
        String sql = "update orders set total = ? where oid = ?";
        return super.executeUpdate(sql,total,oid);
    }
    //改: 根据订单编号修改订单创建时间
    /*public boolean updataCreateDateByOid(String oid, Date createdate) {
        String sql = "update orders set createdate = ? where oid = ?";
        return super.executeUpdate(sql,oid,createdate);
    }*/
    //改: 根据订单编号修改状态编号
    public boolean updataOsidByOid(String oid, int osid) {
        String sql = "update orders set osid = ? where oid = ?";
        return super.executeUpdate(sql,osid,oid);
    }
    //改: 根据用户编号修改订单总价
    public boolean updataTotalByUid(String uid, double total) {
        String sql = "update orders set total = ? where uid = ?";
        return super.executeUpdate(sql,total,uid);
    }
    //改: 根据用户编号修改订单时间创建时间
    /*public boolean updataCreateDateByUid(int uid, Date createdate) {
        String sql = "update orders set createdate = ? where uid = ?";
        return super.executeUpdate(sql,uid,createdate);
    }*/
    //改:根据用户编号修改状态编号
    public boolean updataOsidByUid(String uid, int osid) {
        String sql = "update orders set osid = ? where uid = ?";
        return super.executeUpdate(sql,osid,uid);
    }
    //查: 查询全部订单
    public List<Orders> findAllOrders() {
        String sql = "select * from orders";
        return super.executeQuery(sql);
    }

    @Override
    public int findAllRecords() {
        String sql = "select count(UUID) from orders";
        return super.findCount(sql);
    }

    //查: 根据订单编号查询订单信息
    public Orders findOrdersInfoByOid(String oid) {
        String sql = "select * from orders where oid = ?";
        return super.executeQueryOne(sql,oid);
    }
    //查:根据用户编号查询订单信息(查询单个)
    public Page<Orders> findOrdersInfoByUid(String uid,int currentPage,int sizePage) {
        String sql = "select * from orders where uid = ?";
        String countSql = "select count(uid) from orders where uid = ?";
        int start = (currentPage-1) *sizePage;// 分页起始位置
        List<Orders> ordersList = super.executeQuery(sql,uid,start,sizePage);// 分页查询到的数据
        int totalCount = findCount(countSql,uid);// 查询总记录
        return new Page<Orders>(currentPage,sizePage,totalCount,ordersList);

    }
    //查: 根据底单创建时间插查询订单信息
    public Orders findOrdersInfoByCreateDate(Date createdate) {
        String sql = "select * from orders where createdate = ?";
        return super.executeQueryOne(sql,createdate);
    }

    @Override
    public Orders findOrdersInfoByUUID(String uuid) {
        String sql = "select * from orders where UUID = ?";
        return super.executeQueryOne(sql,uuid);
    }


    //查: 根据状态编号查询订单信息
    public Page<Orders> findOrdersInfoByOsid(int osid,int currentPage,int sizePage) {
        String sql = "select * from orders where osid = ? limit ?,?";
        String countSql = "select count(osid) from orders where osid = ?";
        int start = (currentPage-1) *sizePage;// 分页起始位置
        List<Orders> ordersList = super.executeQuery(sql,osid,start,sizePage);// 分页查询到的数据
        int totalCount = findCount(countSql,osid);// 查询总记录
        return new Page<Orders>(currentPage,sizePage,totalCount,ordersList);

    }

    protected Orders getEntty(ResultSet rs) {
        Orders orders = new Orders();
        try {
            orders.setUUID(rs.getString("UUID"));// 写UUID
            orders.setOid(rs.getString("oid"));
            orders.setUid(rs.getString ("uid"));
            orders.setTotal(rs.getDouble("total"));
            orders.setCreatedate(rs.getDate("createdate"));
            orders.setOsid(rs.getInt("osid"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orders;
    }
}
