package com.etc.shopsys.service;

import com.etc.shopsys.domain.EmpType;

import java.util.List;

/**
 * @ClassName EmpTypeService
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/05 13:07
 * @Version 1.0
 **/
public interface EmpTypeService {
    // 增：新增职位类型
    String insertEmpType(EmpType empType);

    // 删：根据编号删除职位信息
    String deleteEmpTypeById(String etid);

    // 改：根据编号修改职位信息
    String updateEmpTypeById(EmpType empType);

    // 查：根据编号查询职位信息
    EmpType findEmpTypeById(String etid);

    // 查：查询所有职位信息
    List<EmpType> findAllEmpType();

    // 查：查询记录数
    int findEmpTypeCount();

    // 查：根据职位名称查询职位信息
    EmpType findEmpTypeByEtName(String etname);
}
