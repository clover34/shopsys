package com.etc.shopsys.domain;

import com.etc.shopsys.utils.DBUtil;

import java.io.Serializable;

/**
 * @ClassName Emp
 * @Description TODO
 * @Author Administrator
 * @Date 20/09/30 15:08
 * @Version 1.0
 **/
public class Emp implements Serializable {
    private String UUID;// UUID唯一标识
    private String empid;// 员工编号
    private String empname;// 员工姓名
    private String empaccount;// 员工账号
    private String password;// 密码
    private int dimission;// 是否离职：1-离职 0-在职
    private EmpType etid;// 职位编号

    // 全参构造方法
    public Emp(String empid, String empname, String empaccount, String password, int dimission, EmpType etid) {
        this.UUID = DBUtil.getUUID();
        this.empid = empid;
        this.empname = empname;
        this.empaccount = empaccount;
        this.password = password;
        this.dimission = dimission;
        this.etid = etid;
    }

    // 无参构造方法
    public Emp() {

    }

    // toString 方法
    @Override
    public String toString() {
        return "Emp{" +
                "UUID='" + UUID + '\'' +
                ", empid='" + empid + '\'' +
                ", empname='" + empname + '\'' +
                ", empaccount='" + empaccount + '\'' +
                ", password='" + password + '\'' +
                ", dimission=" + dimission +
                ", etid=" + etid +
                '}';
    }

    // get & set 方法
    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpaccount() {
        return empaccount;
    }

    public void setEmpaccount(String empaccount) {
        this.empaccount = empaccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDimission() {
        return dimission;
    }

    public void setDimission(int dimission) {
        this.dimission = dimission;
    }

    public EmpType getEtid() {
        return etid;
    }

    public void setEtid(EmpType etid) {
        this.etid = etid;
    }
}
