package com.etc.shopsys.dao;

import com.etc.shopsys.domain.Emp;
import com.etc.shopsys.domain.Page;

/**
 * @ClassName EmpDao
 * @Description TODO
 * @Author Administrator
 * @Date 20/09/30 15:45
 * @Version 1.0
 **/
public interface EmpDao {
    // 增：新增员工信息
    boolean insertEmp(Emp emp);
    // 删：根据编号删除员工信息，将是否删除字段修改成 0
    boolean deleteEmpById(String empid);
    // 改：根据编号修改员工信息
    boolean updateEmpById(Emp emp);
    // 查：根据编号查询员工信息
    Emp findEmpById(String empid);
    // 查：根据姓名查询员工信息
    Page<Emp> findAllEmp(int currentPage, int sizePage);
    // 模糊查询：根据姓名查询员工信息
    Page<Emp> findEmpLikeByName(String empname, int currentPage, int sizePage);
    // 查询：查询在职离职员工
    Page<Emp> findEmpIsDimission(int dimission, int currentPage, int sizePage);
    // 查询：根据职位编号查询员工信息
    Page<Emp> findEmpByEtid(int etid, int currentPage, int sizePage);
    // 查询：查询员工表总记录数
    int findEmpCount();

    // 登录：根据姓名和密码查询用户信息
    Emp findEmpByNameAndPwd(String empname, String password);
    // 登录：根据账号和密码查询用户信息
    Emp findEmpByAccountAndPwd(String account, String password);
    // 查询：根据账号查询员工信息
    Emp findEmpByAccount(String account);
}
