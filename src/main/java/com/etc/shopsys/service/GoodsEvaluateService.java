package com.etc.shopsys.service;

import com.etc.shopsys.domain.GoodsEvaluate;
import com.etc.shopsys.domain.Page;

public interface GoodsEvaluateService {
    //增：新增商品评价
    String insertGoodsEvaluate(GoodsEvaluate goodsEvaluate);
    //删:根据编号删除评价信息
    String deleteGoodsEvaluateById(String odid,String gid);
    //改:根据编号修改评价信息
    String updateGoodsEvaluateById(String odid,String gid,String evaluate);
    //查:根据商品编号查询商品类型
    GoodsEvaluate findGoodsEvaluateById(String odid,String gid);
    // 查：查询所有商品评价
    Page<GoodsEvaluate> findAllGoodsEvaluate(int currentPage, int sizePage);
}
