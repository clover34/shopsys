package com.etc.shopsys.service.impl;

import com.etc.shopsys.dao.GoodsDao;
import com.etc.shopsys.dao.TrolleyDao;
import com.etc.shopsys.dao.impl.GoodsDaoImpl;
import com.etc.shopsys.dao.impl.TrolleyDaoImpl;
import com.etc.shopsys.domain.Goods;
import com.etc.shopsys.domain.Trolley;
import com.etc.shopsys.service.TrolleyService;

import java.util.List;

public class TrolleyServiceImpl implements TrolleyService {
    private TrolleyDao dao;
    private GoodsDao goodsDao;

    public TrolleyServiceImpl() {
        this.dao =new TrolleyDaoImpl();
        this.goodsDao = new GoodsDaoImpl();
    }

    @Override
    public String insertTrolley(Trolley trolley) {
        Goods goods=this.goodsDao.findGoodsById(trolley.getGid());
        if (goods.getGcount()==0){
            return "商品库存不足，添加失败";
        }
        trolley.setTrcount(1);//商品数量默认为1
        return this.dao.insertTrolley(trolley)?"添加到购物车成功":"添加到购物车失败";
    }

    @Override
    public String deleteTrolleyById(String gid) {
        return this.dao.deleteTrolleyById(gid)?"购物车信息删除成功":"购物车信息删除失败";
    }

    @Override
    public String updateTrolleyById(String uid, String gid, int trcount) {
        Trolley trolley=new Trolley();
        Goods goods=this.goodsDao.findGoodsById(trolley.getGid());
        if (trcount>goods.getGcount()){
            return "商品库存不足，添加失败";
        }
        return this.dao.updateTrolleyById(uid,gid,trcount)?"购物车信息修改成功":"购物车信息修改失败";
    }

    @Override
    public Trolley findTrolleyById(String gid) {
        return this.dao.findTrolleyById(gid);
    }

    @Override
    public List<Trolley> findAllTrolley() {
        return this.dao.findAllTrolley();
    }
}
