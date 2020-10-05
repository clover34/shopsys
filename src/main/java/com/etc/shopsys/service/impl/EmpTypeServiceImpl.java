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
     *
     * @param etid
     * @return
     */
    @Override
    public String deleteEmpTypeById(String etid) {
        return null;
    }

    @Override
    public String updateEmpTypeById(EmpType empType) {
        return null;
    }

    @Override
    public EmpType findEmpTypeById(String etid) {
        return null;
    }

    @Override
    public List<EmpType> findAllEmpType() {
        return null;
    }

    @Override
    public int findEmpTypeCount() {
        return 0;
    }

    @Override
    public EmpType findEmpTypeByEtName(String etname) {
        return null;
    }
}
