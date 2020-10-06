package com.etc.shopsys.service;

import com.etc.shopsys.domain.OrderState;
import com.etc.shopsys.domain.Page;

import java.util.List;

public interface OrderStateService {

    // 增： 新增状态编号
    String insertOsid(OrderState orderState);

    // 删： 根据状态编号删除订单状态信息
    String deleteOrderStateByOsid(int osid);

    // 改： 根据状态编号修改订单状态
    String updataOrderStateByOsid(int osid, String state);

    // 查： 根据状态编号查询订单状态
    Page<OrderState> findOrderStateByOsid(int osid, int currentPage, int sizePage);

    // 查询所有订单状态
    List<OrderState> findAllOrderState();
}
