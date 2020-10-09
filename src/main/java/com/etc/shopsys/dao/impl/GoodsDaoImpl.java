package com.etc.shopsys.dao.impl;

import com.etc.shopsys.dao.BaseDao;
import com.etc.shopsys.dao.GoodsDao;
import com.etc.shopsys.dao.GoodsTypleDao;
import com.etc.shopsys.domain.Goods;
import com.etc.shopsys.domain.Page;
import com.etc.shopsys.service.GoodsTypeService;
import com.etc.shopsys.utils.CounterUtil;
import com.etc.shopsys.utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GoodsDaoImpl extends BaseDao<Goods> implements GoodsDao {
    /**
     * 增:新增商品信息
     * @param goods
     * @return
     */
    @Override
    public boolean insertGoods(Goods goods) {
        String sql="insert into goods(UUID,gid,gname,gcount,gprice,gtid,isdelete,gdepict,gimg) values(?,?,?,?,?,?,?,?,?)";
        return super.executeUpdate(sql,goods.getUUID(), goods.getGid()
                , goods.getGname(),goods.getGcount(),goods.getGprice(),goods.getGtid().getGtid()
                ,goods.getIsdelete(),goods.getGdepict(), goods.getGimg());
    }
    /*
     * 删：根据编号删除商品信息，将是否删除字段改为0
     * @param gid
     * @return
     */
    @Override
    public boolean deleteGoodsById(String gid) {
        String sql="update goods set isdelete=0 where gid=?";
        return super.executeUpdate(sql,gid);
    }
    /*
     * 改:根据编号修改商品信息..
     * @param gid
     * @return
     */
    @Override
    public boolean updateGoodsById(Goods goods) {
        String sql="update goods set  gname=?,gcount=?,gprice=?,gtid=?,isdelete=?,gdepict=?,gimg=? where gid=? and UUID=?";
        return super.executeUpdate(sql,goods.getGname(),goods.getGcount(),goods.getGprice()
        ,goods.getGtid().getGtid(),goods.getIsdelete(),goods.getGdepict(),goods.getGimg(),goods.getGid(),goods.getUUID());
    }
    /*
     * 查:根据编号查询商品信息
     * @param gid
     * @return
     */
    @Override
    public Goods findGoodsById(String gid) {
        String sql="select * from goods where gid=?";
        return super.executeQueryOne(sql,gid);
    }
    /*
     * 查:根据名称查询商品信息
     * @param gid
     * @return
     */
    @Override
    public Goods findGoodsByName(String gname) {
        String sql="select * from goods where gname=?";
        return super.executeQueryOne(sql,gname);
    }

    /*
     * 查:查询所有商品信息
     * @param g
     * @return
     */
    @Override
    public Page<Goods> findAllGoods(int currentPage, int sizePage) {
        String sql="select * from goods limit ?,?";
        String countSql="select count(*) from goods";
        int start =  (currentPage-1) * sizePage;// 分页起始位置
        List<Goods> goods= super.executeQuery(sql, start, sizePage);// 分页查询到的数据
        int totalCount = findCount(countSql);
        return new Page<Goods>(currentPage,sizePage,totalCount,goods);
    }
    /*
     * 模糊查询:根据商品名称查询商品信息
     * @param g
     * @return
     */
    @Override
    public Page<Goods> findGoodsLikeByGname(String gname,int currentPage, int sizePage) {
        String sql = "select * from goods where gname like ? limit ?,?";
        String countSql = "select count(UUID) from goods where gname like ?";
        gname = "%"+gname+"%";// 模糊查询拼接
        int start =  (currentPage-1) * sizePage;// 分页起始位置
        List<Goods> goods = super.executeQuery(sql, gname, start, sizePage);// 分页查询到的数据
        int totalCount = findCount(countSql,gname);// 查询总记录数
        return new Page<Goods>(currentPage,sizePage,totalCount,goods);
    }
    /*
     * 查:根据商品类型查询商品信息
     * @param g
     * @return
     */
    @Override
    public Page<Goods> findGoodsById(int gtid,int currentPage, int sizePage) {
        String sql = "select * from goods where gtid=? limit ?,?";
        String countSql = "select count(UUID) from goods where gtid=?";
        int start =  (currentPage-1) * sizePage;// 分页起始位置
        List<Goods> goods = super.executeQuery(sql, gtid, start, sizePage);// 分页查询到的数据
        int totalCount = findCount(countSql,gtid);// 查询总记录数
        return new Page<Goods>(currentPage,sizePage,totalCount,goods);
    }
    /*
     * 查：查询存在删除商品信息
     * @param g
     * @return
     */
    @Override
    public Page<Goods> findGoodsIsDelete(int isdelete, int currentPage, int sizePage) {
        String sql = "select * from goods where isdelete=? limit ?,?";
        String countSql = "select count(UUID) from goods where isdelete=?";
        int start =  (currentPage-1) * sizePage;// 分页起始位置
        List<Goods> goods = super.executeQuery(sql, isdelete, start, sizePage);// 分页查询到的数据
        int totalCount = findCount(countSql,isdelete);// 查询总记录数
        return new Page<Goods>(currentPage,sizePage,totalCount,goods);
    }
    /*
     * 查：查询商品表总记录数
     * @param g
     * @return
     */
    @Override
    public int findGoodsCount() {
        String sql = "select count(UUID) from goods";
        return super.findCount(sql);
    }

    /*
     * 获取商品信息
     * @param rs
     * @return
     */
    @Override
    protected Goods getEntty(ResultSet rs) {
        GoodsTypleDao goodsTypleDao = new GoodsTypleDaoImpl();
        Goods goods=new Goods();
        try {
            goods.setUUID(rs.getString("UUID"));
            goods.setGid(rs.getString("gid"));
            goods.setGname(rs.getString("gname"));
            goods.setGcount(rs.getInt("gcount"));
            goods.setGprice(rs.getDouble("gprice"));
            goods.setGtid(goodsTypleDao.findGoodsTypeById(rs.getString("gtid")));
            goods.setIsdelete(rs.getInt("isdelete"));
            goods.setGdepict(rs.getString("gdepict"));
            goods.setGimg(rs.getString("gimg"));
        } catch (SQLException e) {
            System.out.println("获取商品信息异常");
            e.printStackTrace();
        }
        return goods;
    }
}
