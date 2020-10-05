package com.etc.shopsys.dao.impl;

import com.etc.shopsys.dao.BaseDao;
import com.etc.shopsys.dao.GoodsTypleDao;
import com.etc.shopsys.domain.GoodsTyple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GoodsTypleDaoImpl extends BaseDao<GoodsTyple> implements GoodsTypleDao {
    /*
     * 增：新增类型
     * @param goodsTyple
     * @return
     */
    @Override
    public boolean insertGoodsType(GoodsTyple goodsTyple) {
        String sql="insert into goodstype(gtid,gtname) values(?,?)";
        return super.executeUpdate(sql,goodsTyple.getGtid(),goodsTyple.getGtname());
    }
    /*
     * 删：根据编号删除商品类型
     * @param goodsTyple
     * @return
     */
    @Override
    public boolean deleteGoodsTypeById(String gtid) {
        String sql="delete from goodstype where gtid=?";
        return super.executeUpdate(sql,gtid);
    }
    /*
     * 改：根据编号修改商品类型
     * @param goodsTyple
     * @return
     */
    @Override
    public boolean updateGoodsTypeById(String gtid,String gtname) {
        String sql="update goodstype set gtname=? where gtid=?";
        return super.executeUpdate(sql,gtname,gtid);
    }
    /*
     * 查：根据编号查询商品类型
     * @param goodsTyple
     * @return
     */
    @Override
    public GoodsTyple findGoodsTypeById(String gtid) {
        String sql="select * from goodstype where gtid=?";
        return super.executeQueryOne(sql,gtid);
    }
    /*
     * 查：根据商品名称查询商品类型
     * @param goodsTyple
     * @return
     */
    @Override
    public GoodsTyple findGoodsTypeBygtname(String gtname) {
        String sql = "select * from goodstype where gtname=?";
        return super.executeQueryOne(sql, gtname);
    }

    /*
     * 查：查询所有商品类型
     * @param goodsTyple
     * @return
     */
    @Override
    public List<GoodsTyple> findAllGoodsType() {
        String sql="select * from goodstype";
        return super.executeQuery(sql);
    }
    /*
     * 查询：查询商品表总记录数
     * @param goodsTyple
     * @return
     */
    @Override
    public int findGoodsCount() {
        String sql = "select count(gtid) from goodstype";
        return super.findCount(sql);
    }

    /*
     * 获取商品类别信息
     * @param rs
     * @return
     */
    @Override
    protected GoodsTyple getEntty(ResultSet rs) {
        GoodsTyple gt=new GoodsTyple();
        try {
            gt.setGtid(rs.getString("gtid"));
            gt.setGtname(rs.getString("gtname"));
        } catch (SQLException e) {
            System.out.println("获取商品类别信息异常");
            e.printStackTrace();
        }
        return gt;
    }
}
