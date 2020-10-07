package com.etc.shopsys.dao;

import com.etc.shopsys.domain.OrderState;
import com.etc.shopsys.domain.Page;

import java.util.List;


public interface OrderStateDao {
    // 增： 新增状态编号
    boolean insertOsid(OrderState orderState);

    // 删： 根据状态编号删除订单状态信息
    boolean deleteOrderStateByOsid(int osid);

    // 改： 根据状态编号修改订单状态
    boolean updataOrderStateByOsid(int osid, String state);

    // 查： 根据状态编号查询订单状态
    Page<OrderState> findOrderStateByOsid(int osid,int currentPage, int sizePage);

    // 查： 根据状态状态查询订单状态
    Page<OrderState> findOrderStateByState(String state,int currentPage, int sizePage);

    // 查询所有订单状态
    List<OrderState> findAllOrderState();

    // 查：根据订单状态查询
    OrderState findOSByState(String state);

    // 查：获取总记录数
    int findCount();
}
