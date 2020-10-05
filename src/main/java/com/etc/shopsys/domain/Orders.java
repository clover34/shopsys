package com.etc.shopsys.domain;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {
    private String UUID; // uuid;
    private String oid; //订单编号
    private String uid; // 用户编号
    private double total; // 金额
    private Date createdate; // 订单创建时间
    private int osid; // 状态编号

    public Orders() {
    }

    public Orders(String UUID, String oid, String uid, double total, Date createdate, int osid) {
        this.UUID = UUID;
        this.oid = oid;
        this.uid = uid;
        this.total = total;
        this.createdate = createdate;
        this.osid = osid;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "UUID='" + UUID + '\'' +
                ", oid='" + oid + '\'' +
                ", uid=" + uid +
                ", total=" + total +
                ", createdate=" + createdate +
                ", osid=" + osid +
                '}';
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public int getOsid() {
        return osid;
    }

    public void setOsid(int osid) {
        this.osid = osid;
    }
}
