package com.etc.shopsys.dao.impl;

import com.etc.shopsys.dao.BaseDao;
import com.etc.shopsys.dao.OrderStateDao;
import com.etc.shopsys.domain.OrderState;
import com.etc.shopsys.domain.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderStateDaoImpl extends BaseDao<OrderState> implements OrderStateDao {
    @Override
    public boolean insertOsid(OrderState orderState) {
        String sql = "insert into orderstate values(?,?)";
        return super.executeUpdate(sql,orderState.getOsid(),orderState.getState());
    }

    @Override
    public boolean deleteOrderStateByOsid(int osid) {
        String sql = "delete from orderstate where osid = ?";
        return super.executeUpdate(sql,osid);
    }

    @Override
    public boolean updataOrderStateByOsid(int osid, String state) {
        String sql = "update orderstate set state = ? where osid = ?";
        return super.executeUpdate(sql,state,osid);
    }

    //根据状态编号查询订单状态
    @Override
    public Page<OrderState> findOrderStateByOsid(int osid, int currentPage, int sizePage) {
        String sql = "select * from orderstate where osid = ? limit ?,?";
        String countSql = "select count(osid) from orderstate where osid = ?";
        int start = (currentPage -1) * sizePage; // 分页起始位置
        List<OrderState> orderStates = super.executeQuery(sql,osid,start,sizePage);// 分页查询到的数据
        int totalCount = findCount(countSql,osid);// 查询总记录
        return new Page<OrderState>(currentPage,sizePage,totalCount,orderStates);
    }

    /**、
     * 查：查询所有状态记录
     * @return
     */
    @Override
    public List<OrderState> findAllOrderState() {
        String sql = "select * from orderstate";
        return super.executeQuery(sql);
    }

    /**
     * 查：根据订单状态查询记录
     * @param state
     * @return
     */
    @Override
    public OrderState findOSByState(String state) {
        String sql = "select * from orderstate where state=?";
        return super.executeQueryOne(sql,state);
    }

    /**
     * 查询：查询总记录数
     * @return
     */
    @Override
    public int findCount() {
        String sql = "select count(*) from orderstate";
        return super.findCount(sql);
    }

    /**
     * 查询：根据订单状态编号查询订单状态
     * @param osid
     * @return
     */
    @Override
    public OrderState findOSByOsid(int osid) {
        String sql = "select * from orderstate where osid=?";
        return super.executeQueryOne(sql, osid);
    }

    @Override
    protected OrderState getEntty(ResultSet rs)  {
        OrderState orderState = new OrderState();
        try {
            orderState.setOsid(rs.getInt("osid"));
            orderState.setState(rs.getString("state"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderState;
    }
}
