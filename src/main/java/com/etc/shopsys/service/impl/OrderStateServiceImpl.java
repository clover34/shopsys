package com.etc.shopsys.service.impl;

import com.etc.shopsys.dao.OrderStateDao;
import com.etc.shopsys.dao.impl.OrderStateDaoImpl;
import com.etc.shopsys.domain.OrderState;
import com.etc.shopsys.domain.Page;
import com.etc.shopsys.service.OrderStateService;
import com.etc.shopsys.utils.CounterUtil;

import java.util.List;

public class OrderStateServiceImpl implements OrderStateService {

    private OrderStateDao orderStateDao = new OrderStateDaoImpl();

    /**
     * 新增状态编号
     * @param orderState
     * @return
     */
    @Override
    public String insertOsid(OrderState orderState) {
        orderState.setOsid(orderStateDao.findCount()+1);
        if (orderStateDao.findOSByState(orderState.getState()) == null) {
            // 当状态信息不存在
            return orderStateDao.insertOsid(orderState) ? "添加成功" : "添加失败";
        } else {
            // 状态信息已存在
            return "订单状态已存在,添加失败";
        }
    }

    /**
     * 根据状态编号删除订单状态信息
     * @param osid
     * @return
     */
    @Override
    public String deleteOrderStateByOsid(int osid) {
        return orderStateDao.deleteOrderStateByOsid(osid)?"删除成功":"删除失败";
    }

    /**
     * 根据状态编号修改订单状态
     * @param osid
     * @param state
     * @return
     */
    @Override
    public String updataOrderStateByOsid(int osid, String state) {
        return orderStateDao.updataOrderStateByOsid(osid, state)?"修改成功":"修改失败";

    }

    /**
     * 根据状态编号查询订单状态
     * @param osid
     * @param currentPage
     * @param sizePage
     * @return
     */
    @Override
    public Page<OrderState> findOrderStateByOsid(int osid, int currentPage, int sizePage) {
        Page<OrderState> orderStateByOsid = orderStateDao.findOrderStateByOsid(osid, currentPage, sizePage);
        return orderStateByOsid;
    }

    @Override
    public Page<OrderState> findOrderStateByState(String state, int currentPage, int sizePage) {
        Page<OrderState> orderStateByState = orderStateDao.findOrderStateByState(state, currentPage, sizePage);
        return orderStateByState;
    }

    /**
     * 查询所有订单状态
     * @return
     */
    @Override
    public List<OrderState> findAllOrderState() {
        List<OrderState> all = orderStateDao.findAllOrderState();
        return all;
    }
}
