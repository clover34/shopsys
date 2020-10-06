package com.etc.shopsys.service;

import com.etc.shopsys.domain.OrderDetails;

import java.util.List;

public interface OrderDetailsService {

    // 增： 新增订单编号
    String insertGidByOid(OrderDetails orderDetails);

    // 删: 根据订单编号删除订单
    String deleteGidByOid(String oid);

    //改: 根据订单编号修改商品编号
    String updateGidByOid(String oid, String gid);

    //改:  根据订单编号修改购买数量
    String updateodnumByOid(String oid, int odnum);

    //改: 根据订单编号修改商品单价
    String updategpriceByOid(String oid, double gprice);

    // 改: 根据商品编号修改购买数量
    String updateOdnumByGid(String gid, int odnum);

    // 改: 根据商品编号修改商品单价
    String updategpriceByGid(String gid, double gprice);

    // 查:根据订单编号查询订单信息
    OrderDetails findInfoByOid(String oid);

    // 查: 查询全部订单
    List<OrderDetails> findAllOrderDetails();
}
