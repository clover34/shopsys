package com.etc.shopsys.dao.impl;

import com.etc.shopsys.dao.BaseDao;
import com.etc.shopsys.dao.EmpDao;
import com.etc.shopsys.dao.EmpTypeDao;
import com.etc.shopsys.domain.Emp;
import com.etc.shopsys.domain.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName EmpDaoImpl
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/01 21:28
 * @Version 1.0
 **/
public class EmpDaoImpl extends BaseDao<Emp> implements EmpDao {
    private EmpTypeDao empTypeDao = new EmpTypeDaoImpl();
    /**
     * 获取一个员工实体信息
     * @param rs
     * @return
     */
    @Override
    protected Emp getEntty(ResultSet rs) {
        Emp emp = new Emp();
        try {
            emp.setUUID(rs.getString("UUID"));
            emp.setEmpid(rs.getString("empid"));
            emp.setEmpname(rs.getString("empname"));
            emp.setEmpaccount(rs.getString("empaccount"));
            emp.setPassword(rs.getString("password"));
            emp.setDimission(rs.getInt("dimission"));
            emp.setEtid(empTypeDao.findEmpTypeById(rs.getString("etid")));
        } catch (SQLException e) {
            System.out.println("EmpDaoImpl获取一个员工实体对象异常");
            e.printStackTrace();
        }
        return emp;
    }

    /**
     * 增：新增一条员工记录
     * @param emp
     * @return
     */
    @Override
    public boolean insertEmp(Emp emp) {
        String sql = "insert into emp(UUID,empid,empname,empaccount,password,dimission,etid) values(?,?,?,?,?,?,?)";
        return super.executeUpdate(sql, emp.getUUID(),emp.getEmpid(),emp.getEmpname(),emp.getEmpaccount(),
                emp.getPassword(),emp.getDimission(),emp.getEtid().getEtid());
    }

    /**
     * 删除：根据编号删除员工信息：将 状态1改为0
     * @param empid
     * @return
     */
    @Override
    public boolean deleteEmpById(String empid) {
        String sql = "update emp set dimission=0 where empid=?";
        return super.executeUpdate(sql, empid);
    }

    /**
     * 修改：根据编号修改员工信息
     * @param emp
     * @return
     */
    @Override
    public boolean updateEmpById(Emp emp) {
        String sql = "update emp set empname=?,empaccount=?,password=?,dimission=?,etid=? where empid=?";
        return super.executeUpdate(emp.getEmpname(),emp.getEmpaccount(),emp.getPassword(),emp.getDimission(),
                emp.getEtid().getEtid(),emp.getEmpid());
    }

    /**
     * 查询：根据编号查询员工信息
     * @param empid
     * @return
     */
    @Override
    public Emp findEmpById(String empid) {
        String sql = "select * from emp where empid=?";
        return super.executeQueryOne(sql, empid);
    }

    /**
     * 查：查询所有员工信息,禁用
     * @return
     */
    @Override
    public Page<Emp> findAllEmp(int currentPage, int sizePage) {
        String sql = "select * from emp limit ?,?";
        int start =  (currentPage-1) * sizePage;// 分页起始位置
        List<Emp> emps = super.executeQuery(sql, start, sizePage);// 分页查询到的数据
        int totalCount = findCount(sql);
        return new Page<Emp>(currentPage,sizePage,totalCount,emps);
    }

    /**
     * 分页查询：查询多条记录
     * @param empname
     * @param currentPage
     * @param sizePage
     * @return
     */
    @Override
    public Page<Emp> findEmpLikeByName(String empname,int currentPage, int sizePage) {
        String sql = "select * from emp where empname like ? limit ?,?";
        String countSql = "select count(UUID) from emp where empname like ?";
        empname = "%"+empname+"%";// 模糊查询拼接
        int start =  (currentPage-1) * sizePage;// 分页起始位置
        List<Emp> emps = super.executeQuery(sql, empname, start, sizePage);// 分页查询到的数据
        int totalCount = findCount(countSql,empname);// 查询总记录数
        return new Page<Emp>(currentPage,sizePage,totalCount,emps);
    }

    /**
     * 查询：根据离职查询员工信息
     * @param dimission
     * @return
     */
    @Override
    public Page<Emp> findEmpIsDimission(int dimission,int currentPage, int sizePage) {
        String sql = "select * from emp where dimission=? limit ?,?";
        String countSql = "select count(UUID) from emp where dimission=?";
        int start =  (currentPage-1) * sizePage;// 分页起始位置
        List<Emp> emps = super.executeQuery(sql, dimission, start, sizePage);// 分页查询到的数据
        int totalCount = findCount(countSql,dimission);// 查询总记录数
        return new Page<Emp>(currentPage,sizePage,totalCount,emps);
    }

    /**
     * 查询：根据员工职位等级查询员工信息
     * @param etid
     * @param currentPage
     * @param sizePage
     * @return
     */
    @Override
    public Page<Emp> findEmpByEtid(int etid,int currentPage, int sizePage) {
        String sql = "select * from emp where etid=? limit ?,?";
        String countSql = "select count(UUID) from emp where etid=?";
        int start =  (currentPage-1) * sizePage;// 分页起始位置
        List<Emp> emps = super.executeQuery(sql, etid, start, sizePage);// 分页查询到的数据
        int totalCount = findCount(countSql,etid);// 查询总记录数
        return new Page<Emp>(currentPage,sizePage,totalCount,emps);
    }

    /**
     * 查询总记录数
     * @return
     */
    @Override
    public int findEmpCount() {
        String sql = "select count(UUID) from emp";
        return super.findCount(sql);
    }

    /**
     * 查询：根据用户名密码查询员工信息
     * @param empname
     * @param password
     * @return
     */
    @Override
    public Emp findEmpByNameAndPwd(String empname, String password) {
        String sql = "select * from emp where empname=? and password=?";
        return super.executeQueryOne(sql, empname, password);
    }

    /**
     * 查询：根据账号和密码查询员工信息
     * @param account
     * @param password
     * @return
     */
    @Override
    public Emp findEmpByAccountAndPwd(String account, String password) {
        String sql = "select * from emp where empaccount=? and password=?";
        return super.executeQueryOne(sql, account, password);
    }

    /**
     * 查询：根据账号查询员工信息
     * @param account
     * @return
     */
    @Override
    public Emp findEmpByAccount(String account) {
        String sql = "select * from emp where empaccount=?";
        return super.executeQueryOne(sql, account);
    }
}
