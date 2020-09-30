package com.etc.shopsys.dao;

import com.etc.shopsys.domain.Emp;
import com.etc.shopsys.domain.EmpType;

import java.util.List;

public interface EmpTypeDao {
    // 增：新增职位类型
    EmpType insertEmpType(EmpType empType);

    // 删：根据编号删除职位信息
    boolean deleteEmpTypeById(String etid);

    // 改：根据编号修改职位信息
    boolean updateEmpTypeById(String etid);

    // 查：根据编号查询职位信息
    EmpType findEmpTypeById(String etid);

    // 查：查询所有职位信息
    List<EmpType> findAllEmpType();
}
