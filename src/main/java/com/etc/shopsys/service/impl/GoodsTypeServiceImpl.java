package com.etc.shopsys.service.impl;

import com.etc.shopsys.dao.GoodsTypleDao;
import com.etc.shopsys.dao.impl.GoodsTypleDaoImpl;
import com.etc.shopsys.domain.GoodsTyple;
import com.etc.shopsys.service.GoodsTypeService;
import com.etc.shopsys.utils.CounterUtil;

import java.awt.font.TextHitInfo;
import java.util.List;

public class GoodsTypeServiceImpl implements GoodsTypeService {
    private GoodsTypleDao goodsTypleDao;

    public GoodsTypeServiceImpl() {
        this.goodsTypleDao =new GoodsTypleDaoImpl();
    }
    /*
     * 增：新增类型
     * @param goodsTyple
     * @return
     */
    @Override
    public String insertGoodsType(GoodsTyple goodsTyple) {
        GoodsTyple goodsTyple1 = this.goodsTypleDao.findGoodsTypeById(goodsTyple.getGtid());
        if (goodsTyple1 == null) {
            goodsTyple.setGtid(CounterUtil.getCounterStr("goodstype",this.goodsTypleDao.findGoodsCount()));
            return this.goodsTypleDao.insertGoodsType(goodsTyple)?"添加成功":"添加失败";
        } else {
            return "添加失败，类型已存在";
        }
    }
    @Override
    public String deleteGoodsTypeById(String gtid) {
        return this.goodsTypleDao.deleteGoodsTypeById(gtid)?"删除成功":"删除失败";
    }

    @Override
    public String updateGoodsTypeById(String gtid, String gtname) {
        return this.goodsTypleDao.updateGoodsTypeById(gtid,gtname)?"修改成功":"修改失败";
    }

    @Override
    public GoodsTyple findGoodsTypeById(String gtid) {
        return this.goodsTypleDao.findGoodsTypeById(gtid);
    }

    @Override
    public GoodsTyple findGoodsTypeBygtname(String gtname) {
        return this.goodsTypleDao.findGoodsTypeBygtname(gtname);
    }

    @Override
    public List<GoodsTyple> findAllGoodsType() {
        return this.goodsTypleDao.findAllGoodsType();
    }

    @Override
    public int findGoodsCount() {
        return this.goodsTypleDao.findGoodsCount();
    }
}
