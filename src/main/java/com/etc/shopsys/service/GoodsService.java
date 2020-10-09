package com.etc.shopsys.service;

import com.etc.shopsys.domain.Goods;
import com.etc.shopsys.domain.Page;

public interface GoodsService {
    //增:新增商品信息
    String insertGoods(Goods goods);
    //删：根据编号删除商品信息，将是否删除字段改为0
    String deleteGoodsById(String gid);
    //改:根据编号修改商品信息
    String updateGoodsById(Goods goods);
    //查:根据编号查询商品信息
    Goods findGoodsById(String gid);
    //查:根据名称查询商品信息
    Goods findGoodsByGname(String gname);
    //查:查询所有商品信息
    Page<Goods> findAllGoods(int currentPage, int sizePage);
    //模糊查询:根据商品名称查询商品信息
    Page<Goods> findGoodsLikeByGname(String gname, int currentPage, int sizePage);
    //查:根据商品类型查询商品信息
    Page<Goods> findGoodsById(int gtid, int currentPage, int sizePage);
    // 查：查询存在删除商品信息
    Page<Goods> findGoodsIsDelete(int isdelete, int currentPage, int sizePage);
    // 查：查询商品表总记录数
    int findGoodsCount();
}
