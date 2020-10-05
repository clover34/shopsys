package com.etc.shopsys.dao.impl;


import com.etc.shopsys.dao.BaseDao;
import com.etc.shopsys.dao.OrderDetailsDao;
import com.etc.shopsys.domain.OrderDetails;
import com.etc.shopsys.domain.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class OrderDetailsDaoImpl extends BaseDao<OrderDetails> implements OrderDetailsDao {

    // 增： 新增订单编号
    public boolean insertGidByOid(OrderDetails orderDetails) {
        String sql = "insert into orderdetails values(?,?,?,?,?)";
        return super.executeUpdate(sql,orderDetails.getOid(),orderDetails.getGid(),orderDetails.getOdnum(),
        orderDetails.getGprice(),orderDetails.getOdtotal());
    }
    // 删: 根据订单编号删除订单
    public boolean deleteGidByOid(String oid) {
        String sql = "delete from orderdetails where oid = ?";
        return super.executeUpdate(sql,oid);
    }
    //改: 根据订单编号修改商品编号
    public boolean updateGidByOid(String oid, String gid) {
        String sql = "update orderdetails set gid = ? where oid = ?";
        return super.executeUpdate(sql,gid,oid);
    }
    //改:  根据订单编号修改购买数量
    public boolean updateodnumByOid(String oid, int odnum) {
        String sql = "update orderdetails set odnum = ? where oid = ?";
        return super.executeUpdate(sql,odnum,oid);
    }
    //改: 根据订单编号修改商品单价
    public boolean updategpriceByOid(String oid, double gprice) {
        String sql = "update orderdetails set gprice = ? where oid = ?";
        return super.executeUpdate(sql,gprice,oid);
    }
    // 改: 根据商品编号修改购买数量
    public boolean updateOdnumByGid(String gid, int odnum) {
        String sql = "update orderdetails set odnum = ? where gid = ?";
        return super.executeUpdate(sql,odnum,gid);
    }
    // 改: 根据商品编号修改商品单价
    public boolean updategpriceByGid(String gid, double gprice) {
        String sql = "update orderdetails set gprice = ? where gid = ?";
        return super.executeUpdate(sql,gprice,gid);
    }
    /*// 查: 根据订单编号查询商品编号
    public OrderDetails findOidByGid(String oid) {
        String sql = "select gid from orderdetails where oid = ?";
        return super.executeQueryOne(sql,oid);
    }*/
    // 查:根据订单编号查询订单信息
    public OrderDetails findInfoByOid(String oid) {
        String sql = "select * from orderdetails where oid = ?";
        return super.executeQueryOne(sql,oid);
    }
    // 查: 查询全部订单
    public List<OrderDetails> findAllOrderDetails() {
        String sql = "select * from orderdetails";
        return super.executeQuery(sql);
    }


    protected OrderDetails getEntty(ResultSet rs){
        OrderDetails orderDetails = new OrderDetails();
        try {
            orderDetails.setOid(rs.getString("oid"));
            orderDetails.setGid(rs.getString("gid"));
            orderDetails.setOdnum(rs.getInt("odnum"));
            orderDetails.setGprice(rs.getDouble("gprice"));
            orderDetails.setOdtotal(rs.getDouble("odtotal"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderDetails;
    }
}
