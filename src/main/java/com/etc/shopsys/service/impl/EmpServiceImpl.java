package com.etc.shopsys.service.impl;

import com.etc.shopsys.dao.EmpDao;
import com.etc.shopsys.dao.impl.EmpDaoImpl;
import com.etc.shopsys.domain.Emp;
import com.etc.shopsys.domain.Page;
import com.etc.shopsys.service.EmpService;
import com.etc.shopsys.utils.CounterUtil;
import com.etc.shopsys.utils.DBUtil;

/**
 * @ClassName EmpServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/05 14:42
 * @Version 1.0
 **/
public class EmpServiceImpl implements EmpService {
    private EmpDao empDao = new EmpDaoImpl();
    /**
     * 新增：新增员工信息
     * @param emp
     * @return
     */
    @Override
    public String insertEmp(Emp emp) {
        emp.setUUID(DBUtil.getUUID());// 获取 UUID
        emp.setEmpid(CounterUtil.getCounterStr("emp", empDao.findEmpCount()));// 员工编号自动生成
        emp.setDimission(1);// 默认在职 1：在职 0：离职
        // 查询员工账号是否存在
        if (empDao.findEmpByAccount(emp.getEmpaccount()) == null) {
            return empDao.insertEmp(emp) ? "员工添加成功" : "员工添加失败";
        } else {
            return "账号已存在";
        }
    }

    /**
     * 删除：根据编号删除员工信息
     * @param empid
     * @return
     */
    @Override
    public String deleteEmpById(String empid) {
        // 判断员工是否存在
        if (empDao.findEmpById(empid) != null) {
            return empDao.deleteEmpById(empid) ? "修改成功" : "修改失败";
        } else {
            return "员工不存在";
        }
    }

    /**
     * 修改：根据编号修改员工信息
     * @param emp
     * @return
     */
    @Override
    public String updateEmpById(Emp emp) {
        // 查询员工是否存在
        if (empDao.findEmpById(emp.getEmpid()) != null) {
            return empDao.updateEmpById(emp) ? "修改成功" : "修改失败";
        } else {
            return "员工不存在";
        }
    }

    /**
     * 查询：根据编号查询员工信息
     * @param empid
     * @return
     */
    @Override
    public Emp findEmpById(String empid) {
        return empDao.findEmpById(empid);
    }

    /**
     * 查询：查询所有员工信息
     * @param currentPage
     * @param sizePage
     * @return
     */
    @Override
    public Page<Emp> findAllEmp(int currentPage, int sizePage) {
        return empDao.findAllEmp(currentPage, sizePage);
    }

    /**
     * 模糊查询：根据姓名查询员工信息
     * @param empname
     * @param currentPage
     * @param sizePage
     * @return
     */
    @Override
    public Page<Emp> findEmpLikeByName(String empname, int currentPage, int sizePage) {
        return empDao.findEmpLikeByName(empname, currentPage, sizePage);
    }

    /**
     * 查询：根据是否离职查询员工信息
     * @param dimission
     * @param currentPage
     * @param sizePage
     * @return
     */
    @Override
    public Page<Emp> findEmpIsDimission(int dimission, int currentPage, int sizePage) {
        return empDao.findEmpIsDimission(dimission, currentPage, sizePage);
    }

    /**
     * 查询：根据员工等级查询员工信息
     * @param etid
     * @param currentPage
     * @param sizePage
     * @return
     */
    @Override
    public Page<Emp> findEmpByEtid(int etid, int currentPage, int sizePage) {
        return empDao.findEmpByEtid(etid, currentPage, sizePage);
    }

    /**
     * 查询：查询总记录数
     * @return
     */
    @Override
    public int findEmpCount() {
        return empDao.findEmpCount();
    }

    /**
     * 查询：根据员工姓名和密码查询员工信息
     * @param empname
     * @param password
     * @return
     */
    @Override
    public Emp findEmpByNameAndPwd(String empname, String password) {
        return empDao.findEmpByNameAndPwd(empname, password);
    }

    /**
     * 查询：根据账号和密码查询员工信息(登录)
     * @param account
     * @param password
     * @return
     */
    @Override
    public Emp findEmpByAccountAndPwd(String account, String password) {
        return empDao.findEmpByAccountAndPwd(account, password);
    }
}
