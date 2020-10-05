package com.etc.shopsys.service.impl;

import com.etc.shopsys.dao.GoodsDao;
import com.etc.shopsys.dao.impl.GoodsDaoImpl;
import com.etc.shopsys.domain.Goods;
import com.etc.shopsys.domain.Page;
import com.etc.shopsys.service.GoodsService;
import com.etc.shopsys.utils.CounterUtil;
import com.etc.shopsys.utils.DBUtil;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao;
    public GoodsServiceImpl() {
        this.goodsDao =new GoodsDaoImpl();
    }
    /**
     * 增:新增商品信息
     * @param goods
     * @return
     */
    @Override
    public String insertGoods(Goods goods) {
        goods.setUUID(DBUtil.getUUID());//获取UUID
        goods.setGid(CounterUtil.getCounterStr("goods",this.goodsDao.findGoodsCount()));//获取商品编号
        goods.setIsdelete(1);//获取商品是否删除默认值1.否0.是
        /*if (){

        }*/
        return null;
    }
    /*
     * 删：根据编号删除商品信息，将是否删除字段改为0
     * @param gid
     * @return
     */
    @Override
    public String deleteGoodsById(String gid) {
        return null;
    }
    /*
     * 改:根据编号修改商品信息
     * @param gid
     * @return
     */
    @Override
    public String updateGoodsById(Goods goods) {
        return null;
    }
    /*
     * 查:根据编号查询商品信息
     * @param gid
     * @return
     */
    @Override
    public Goods findGoodsById(String gid) {
        return null;
    }
    /*
     * 查:查询所有商品信息
     * @param gid
     * @return
     */
    @Override
    public Page<Goods> findAllGoods(int currentPage, int sizePage) {
        return null;
    }
    /*
     * 模糊查询:根据商品名称查询商品信息
     * @param g
     * @return
     */
    @Override
    public Page<Goods> findGoodsLikeByGname(String gname, int currentPage, int sizePage) {
        return null;
    }
    /*
     * 查:根据商品类型查询商品信息
     * @param g
     * @return
     */
    @Override
    public Page<Goods> findGoodsById(int gtid, int currentPage, int sizePage) {
        return null;
    }
    /*
     * 查:根据商品是否删除查询商品信息
     * @param g
     * @return
     */
    @Override
    public Page<Goods> findGoodsIsDelete(int isdelete, int currentPage, int sizePage) {
        return null;
    }
    /*
     * 查：查询商品表总记录数
     * @param gid
     * @return
     */
    @Override
    public int findGoodsCount() {
        return 0;
    }
}
