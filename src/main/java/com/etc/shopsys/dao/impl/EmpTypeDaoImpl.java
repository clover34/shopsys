package com.etc.shopsys.dao.impl;

import com.etc.shopsys.dao.BaseDao;
import com.etc.shopsys.dao.EmpTypeDao;
import com.etc.shopsys.domain.EmpType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName EmpTypeDaoImpl
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/02 12:22
 * @Version 1.0
 **/
public class EmpTypeDaoImpl extends BaseDao<EmpType> implements EmpTypeDao {
    /**
     * 获取一个员工等级对象
     * @param rs
     * @return
     */
    @Override
    protected EmpType getEntty(ResultSet rs) {
        EmpType et = new EmpType();
        try {
            et.setEtid(rs.getString("etid"));
            et.setEtname(rs.getString("etname"));
        } catch (SQLException e) {
            System.out.println("获取一个实体信息异常");
            e.printStackTrace();
        }
        return et;
    }

    /**
     * 增：新增一个员工等级记录
     * @param empType
     * @return
     */
    @Override
    public boolean insertEmpType(EmpType empType) {
        String sql = "insert into emptype(etid,etname) values(?,?)";
        return super.executeUpdate(sql, empType.getEtid(), empType.getEtname());
    }

    /**
     * 删除：根据编号删除员工等级信息
     * @param etid
     * @return
     */
    @Override
    public boolean deleteEmpTypeById(String etid) {
        String sql = "delete from emptype where etid=?";
        return super.executeUpdate(sql, etid);
    }

    /**
     * 修改：根据编号修改等级信息
     * @param empType
     * @return
     */
    @Override
    public boolean updateEmpTypeById(EmpType empType) {
        String sql = "update emptype set etname=? where etid=?";
        return super.executeUpdate(sql, empType.getEtname(), empType.getEtid());
    }

    /**
     * 查询：根据编号查询员工等级信息
     * @param etid
     * @return
     */
    @Override
    public EmpType findEmpTypeById(String etid) {
        String sql = "select * from emptype where etid=?";
        return super.executeQueryOne(sql, etid);
    }

    /**
     * 查询：查询所有类型信息
     * @return
     */
    @Override
    public List<EmpType> findAllEmpType() {
        String sql = "select * from emptype";
        return super.executeQuery(sql);
    }

    /**
     * 查询：查询员工等级表记录数
     * @return
     */
    @Override
    public int findEmpTypeCount() {
        String sql = "select count(etid) from emptype";
        return super.findCount(sql);
    }

    /**
     * 查询：根据姓名查询员工等级信息
     * @param etname
     * @return
     */
    @Override
    public EmpType findEmpTypeByEtName(String etname) {
        String sql = "select * from emptype where etname=?";
        return super.executeQueryOne(sql, etname);
    }
}
