package com.etc.shopsys.dao;

import com.etc.shopsys.domain.GoodsTyple;

import java.util.List;

public interface GoodsTypleDao {
//增：新增商品类型
boolean insertGoodsType(GoodsTyple goodsTyple);
//删：根据商品编号删除商品类型
boolean deleteGoodsTypeById(String gtid);
//改：根据商品编号修改商品类型
boolean updateGoodsTypeById(String gtid, String gtname);
//查：根据商品编号查询商品类型
GoodsTyple findGoodsTypeById(String gtid);
//查：根据商品名称查询商品类型
GoodsTyple findGoodsTypeBygtname(String gtname);
// 查：查询所有商品类型
List<GoodsTyple> findAllGoodsType();
// 查询：查询商品表总记录数
int findGoodsCount();
}
