package com.etc.shopsys.domain;

import java.io.Serializable;

/**
 * @ClassName EmpType
 * @Description TODO
 * @Author Administrator
 * @Date 20/09/30 15:03
 * @Version 1.0
 **/
public class EmpType implements Serializable {
    private String etid;// 职位编号
    private String etname;// 职位名称

    // 全参构造方法
    public EmpType(String etid, String etname) {
        this.etid = etid;
        this.etname = etname;
    }

    // 无参构造方法
    public EmpType() {
    }

    // 重写 toString 方法
    @Override
    public String toString() {
        return "EmpType{" +
                "etid='" + etid + '\'' +
                ", etname='" + etname + '\'' +
                '}';
    }

    // get & set 方法
    public String getEtid() {
        return etid;
    }

    public void setEtid(String etid) {
        this.etid = etid;
    }

    public String getEtname() {
        return etname;
    }

    public void setEtname(String etname) {
        this.etname = etname;
    }
}
