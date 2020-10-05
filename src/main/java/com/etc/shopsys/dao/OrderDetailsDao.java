package com.etc.shopsys.dao;

import com.etc.shopsys.domain.OrderDetails;
import com.etc.shopsys.domain.Page;

import java.util.List;

public interface OrderDetailsDao {

    // 增： 新增订单编号
    boolean insertGidByOid(OrderDetails orderDetails);

    // 删: 根据订单编号删除订单
    boolean deleteGidByOid(String oid);

    //改: 根据订单编号修改商品编号
    boolean updateGidByOid(String oid, String gid);

    //改:  根据订单编号修改购买数量
    boolean updateodnumByOid(String oid, int odnum);

    //改: 根据订单编号修改商品单价
    boolean updategpriceByOid(String oid, double gprice);

    // 改: 根据商品编号修改购买数量
    boolean updateOdnumByGid(String gid, int odnum);

    // 改: 根据商品编号修改商品单价
    boolean updategpriceByGid(String gid, double gprice);

    /*// 查: 根据订单编号查询商品编号
    OrderDetails findOidByGid(String oid);*/

    // 查:根据订单编号查询订单信息
    OrderDetails findInfoByOid(String oid);

    // 查: 查询全部订单
    List<OrderDetails> findAllOrderDetails();

}
