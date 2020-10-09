package com.etc.shopsys.domain;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {
    private String UUID; // uuid;
    private String oid; //订单编号
    private User uid; // 用户编号
    private double total; // 金额
    private Date createdate; // 订单创建时间
    private OrderState osid; // 状态编号

    public Orders() {
    }

    public Orders(String UUID, String oid, User uid, double total, Date createdate, OrderState osid) {
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

    public User getUid() {
        return uid;
    }

    public void setUid(User uid) {
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

    public OrderState getOsid() {
        return osid;
    }

    public void setOsid(OrderState osid) {
        this.osid = osid;
    }
}
