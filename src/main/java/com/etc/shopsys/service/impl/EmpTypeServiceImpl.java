package com.etc.shopsys.service.impl;

import com.etc.shopsys.dao.EmpTypeDao;
import com.etc.shopsys.dao.impl.EmpTypeDaoImpl;
import com.etc.shopsys.domain.EmpType;
import com.etc.shopsys.service.EmpTypeService;
import com.etc.shopsys.utils.CounterUtil;

import java.util.List;

/**
 * @ClassName EmpTypeServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/05 13:09
 * @Version 1.0
 **/
public class EmpTypeServiceImpl implements EmpTypeService {
    private EmpTypeDao etDao = new EmpTypeDaoImpl();
    /**
     * 新增：员工等级信息
     * @param empType
     * @return
     */
    @Override
    public String insertEmpType(EmpType empType) {
        // 查询员工等级是否存在
        EmpType et = etDao.findEmpTypeByEtName(empType.getEtname());
        if(et == null){
            empType.setEtid(CounterUtil.getCounterStr("et", etDao.findEmpTypeCount()));
            return etDao.insertEmpType(empType) ? "职位添加成功" : "职位添加失败";
        } else {
            return "职位已存在,添加失败";
        }
    }

    /**
     * 删除：根据职位类型编号删除类型信息
     * @param etid
     * @return
     */
    @Override
    public String deleteEmpTypeById(String etid) {
        return etDao.deleteEmpTypeById(etid) ? "删除成功" : "删除失败";
    }

    /**
     * 修改：根据编号修改职位信息
     * @param empType
     * @return
     */
    @Override
    public String updateEmpTypeById(EmpType empType) {
        return etDao.updateEmpTypeById(empType) ? "修改成功" : "修改失败";
    }

    /**
     * 查询：根据编号查询类型信息
     * @param etid
     * @return
     */
    @Override
    public EmpType findEmpTypeById(String etid) {
        return etDao.findEmpTypeById(etid);
    }

    /**
     * 查询：查询所有职位信息
     * @return
     */
    @Override
    public List<EmpType> findAllEmpType() {
        return etDao.findAllEmpType();
    }

    /**
     * 查询：查询职位信息总记录数
     * @return
     */
    @Override
    public int findEmpTypeCount() {
        return etDao.findEmpTypeCount();
    }

    /**
     * 查询：根据名称查询查询类型信息
     * @param etname
     * @return
     */
    @Override
    public EmpType findEmpTypeByEtName(String etname) {
        return etDao.findEmpTypeByEtName(etname);
    }
}
