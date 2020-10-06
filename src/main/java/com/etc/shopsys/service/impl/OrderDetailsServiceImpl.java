package com.etc.shopsys.service.impl;

import com.etc.shopsys.dao.OrderDetailsDao;
import com.etc.shopsys.dao.impl.OrderDetailsDaoImpl;
import com.etc.shopsys.domain.OrderDetails;
import com.etc.shopsys.service.OrderDetailsService;
import com.etc.shopsys.utils.CounterUtil;

import java.util.List;

public class OrderDetailsServiceImpl implements OrderDetailsService {

    private OrderDetailsDao orderDetailsDao = new OrderDetailsDaoImpl();


    @Override
    public String insertGidByOid(OrderDetails orderDetails) {
        orderDetails.setOid(CounterUtil.getCounterStr("oid",orderDetailsDao.findAll()+1));
        if(orderDetailsDao.findInfoByOid(orderDetails.getOid())==null){
            return orderDetailsDao.insertGidByOid(orderDetails)?"添加成功":"添加失败";
        }else{
            return "该订单编号已存在，添加失败";
        }

    }

    @Override
    public String deleteGidByOid(String oid) {
        return orderDetailsDao.deleteGidByOid(oid)?"删除成功":"删除失败";

    }

    @Override
    public String updateGidByOid(String oid, String gid) {
        return orderDetailsDao.updateGidByOid(oid,gid)?"修改成功":"修改失败";

    }

    @Override
    public String updateodnumByOid(String oid, int odnum) {
        return orderDetailsDao.updateodnumByOid(oid,odnum)?"修改成功":"修改失败";

    }

    @Override
    public String updategpriceByOid(String oid, double gprice) {
        return orderDetailsDao.updategpriceByOid(oid,gprice)?"修改成功":"修改失败";

    }

    @Override
    public String updateOdnumByGid(String gid, int odnum) {
        return orderDetailsDao.updateOdnumByGid(gid,odnum)?"修改成功":"修改失败";

    }

    @Override
    public String updategpriceByGid(String gid, double gprice) {
        return orderDetailsDao.updategpriceByGid(gid,gprice)?"修改成功":"修改失败";

    }

    @Override
    public OrderDetails findInfoByOid(String oid) {
        OrderDetails oid1 = orderDetailsDao.findInfoByOid(oid);
        return oid1;

    }

    @Override
    public List<OrderDetails> findAllOrderDetails() {
        List<OrderDetails> details = orderDetailsDao.findAllOrderDetails();
        return details;
    }
}
