package com.etc.shopsys.dao.impl;

import com.etc.shopsys.dao.BaseDao;
import com.etc.shopsys.dao.TrolleyDao;
import com.etc.shopsys.domain.Page;
import com.etc.shopsys.domain.Trolley;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TrolleyDaoImpl extends BaseDao<Trolley> implements TrolleyDao {
    /*
     * 增：新增商品
     * @param goodsEvaluate
     * @return
     */
    @Override
    public boolean insertTrolley(Trolley trolley) {
        String sql="insert into trolley(uid,gid,trcount) values(?,?,?)";
        return super.executeUpdate(sql,trolley.getUid(),trolley.getGid(),trolley.getTrcount());
    }
    /*
     * 删:根据编号删除商品信息
     * @param odid gid
     * @return
     */
    @Override
    public boolean deleteTrolleyById(String gid) {
        String sql="delete from trolley where gid=?";
        return super.executeUpdate(sql,gid);
    }
    /*
     * 改:根据编号修改信息
     * @param odid gid
     * @return
     */
    @Override
    public boolean updateTrolleyById(String uid, String gid, int trcount) {
        String sql="update trolley set trcount=? where uid=? and gid=?";
        return super.executeUpdate(sql,trcount,uid,gid);
    }
    /*
     * 查:根据商品编号查询商品数量
     * @param odid gid
     * @return
     */
    @Override
    public Trolley findTrolleyById(String gid) {
        String sql="select * from trolley where gid=?";
        return super.executeQueryOne(sql,gid);
    }
    /*
     *  查：查询所有商品
     * @param
     * @return
     */
    @Override
    public Page<Trolley> findAllTrolley(int currentPage, int sizePage) {
        String sql = "select * from trolley limit ?,?";
        String countSql = "select count(*) from trolley";
        int start =  (currentPage-1) * sizePage;// 分页起始位置
        List<Trolley> emps = super.executeQuery(sql, start, sizePage);// 分页查询到的数据
        int totalCount = findCount(countSql);// 查询记录数
        return new Page<Trolley>(currentPage,sizePage,totalCount,emps);
    }

    @Override
    protected Trolley getEntty(ResultSet rs) throws SQLException {
        Trolley trolley=new Trolley();
        trolley.setGid(rs.getString("gid"));
        trolley.setUid(rs.getString("uid"));
        trolley.setTrcount(rs.getInt("trcount"));
        return trolley;
    }
}
