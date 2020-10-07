package com.etc.shopsys.service.impl;

import com.etc.shopsys.dao.GoodsEvaluateDao;
import com.etc.shopsys.dao.impl.GoodsEvaluateDaoImpl;
import com.etc.shopsys.domain.GoodsEvaluate;
import com.etc.shopsys.domain.Page;
import com.etc.shopsys.service.GoodsEvaluateService;

public class GoodsEvaluateServiceImpl implements GoodsEvaluateService {
    private GoodsEvaluateDao goodsEvaluateDao;

    public GoodsEvaluateServiceImpl() {
        this.goodsEvaluateDao =new GoodsEvaluateDaoImpl();
    }
    /*
     * 增：新增商品评价
     * @param goodsEvaluate
     * @return
     */
    @Override
    public String insertGoodsEvaluate(GoodsEvaluate goodsEvaluate) {
        return this.goodsEvaluateDao.insertGoodsEvaluate(goodsEvaluate)?"评价信息添加成功":"评价信息添加失败";
    }
    /*
     * 删:根据编号删除评价信息
     * @param odid gid
     * @return
     */
    @Override
    public String deleteGoodsEvaluateById(String odid, String gid) {
        return this.goodsEvaluateDao.deleteGoodsEvaluateById(odid,gid)?"评价信息删除成功":"评价信息删除失败";
    }
    /*
     * 改:根据编号修改评价信息
     * @param odid gid
     * @return
     */
    @Override
    public String updateGoodsEvaluateById(String odid, String gid, String evaluate) {
        return this.goodsEvaluateDao.updateGoodsEvaluateById(odid,gid,evaluate)?"评价信息修改成功":"评价信息修改失败";
    }
    /*
     * 查:根据商品编号查询商品类型
     * @param odid gid
     * @return
     */
    @Override
    public GoodsEvaluate findGoodsEvaluateById(String odid, String gid) {
        return this.goodsEvaluateDao.findGoodsEvaluateById(odid,gid);
    }
    /*
     *  查：查询所有商品评价
     * @param
     * @return
     */
    @Override
    public Page<GoodsEvaluate> findAllGoodsEvaluate(int currentPage, int sizePage) {
        return this.goodsEvaluateDao.findAllGoodsEvaluate(currentPage,sizePage);
    }
}
