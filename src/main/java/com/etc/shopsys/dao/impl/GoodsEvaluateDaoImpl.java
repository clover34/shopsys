package com.etc.shopsys.dao.impl;

import com.etc.shopsys.dao.BaseDao;
import com.etc.shopsys.dao.GoodsEvaluateDao;
import com.etc.shopsys.domain.GoodsEvaluate;
import com.etc.shopsys.domain.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GoodsEvaluateDaoImpl extends BaseDao<GoodsEvaluate> implements GoodsEvaluateDao {
    /*
    * 增：新增商品评价
    * @param goodsEvaluate
    * @return
    */
    @Override
    public boolean insertGoodsEvaluate(GoodsEvaluate goodsEvaluate) {
        String sql="insert into goodsevaluate(odid,gid,evaluate) values(?,?,?)";
        return super.executeUpdate(sql,goodsEvaluate.getOdid(),goodsEvaluate.getGid()
        ,goodsEvaluate.getEvaluate());
    }
    /*
     * 删:根据编号删除评价信息
     * @param odid gid
     * @return
     */
    @Override
    public boolean deleteGoodsEvaluateById(String odid, String gid) {
        String sql="delete from goodsevaluate where odid=? and gid=?";
        return super.executeUpdate(sql,odid,gid);
    }
    /*
     * 改:根据编号修改评价信息
     * @param odid gid
     * @return
     */
    @Override
    public boolean updateGoodsEvaluateById(String odid, String gid,String evaluate) {
        String sql="update goodsevaluate set evaluate=? where odid=? and gid=?";
        return super.executeUpdate(sql,evaluate,odid,gid);
    }
    /*
     * 查:根据商品编号查询商品类型
     * @param odid gid
     * @return
     */
    @Override
    public GoodsEvaluate findGoodsEvaluateById(String odid, String gid) {
        String sql="select * from goodsevaluate where odid=? and gid=?";
        return super.executeQueryOne(sql,odid,gid);
    }
    /*
     *  查：查询所有商品评价
     * @param
     * @return
     */
    @Override
    public Page<GoodsEvaluate> findAllGoodsEvaluate(int currentPage, int sizePage) {
        String sql = "select * from goodsevaluate limit ?,?";
        String countSql = "select count(*) from goodsevaluate";
        int start =  (currentPage-1) * sizePage;// 分页起始位置
        List<GoodsEvaluate> emps = super.executeQuery(sql, start, sizePage);// 分页查询到的数据
        int totalCount = findCount(countSql);// 查询记录数
        return new Page<GoodsEvaluate>(currentPage,sizePage,totalCount,emps);
    }
    /*
     * 获取商品评价信息
     * @param rs
     * @return
     */
    @Override
    protected GoodsEvaluate getEntty(ResultSet rs) {
        GoodsEvaluate ge=new GoodsEvaluate();
        try {
            ge.setOdid(rs.getString("odid"));
            ge.setGid(rs.getString("gid"));
            ge.setEvaluate(rs.getString("evaluate"));
        } catch (SQLException e) {
            System.out.println("获取商品评价信息异常");
            e.printStackTrace();
        }
        return ge;
    }
}
