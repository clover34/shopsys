package com.etc.shopsys.domain;

import java.io.Serializable;

public class OrderDetails implements Serializable {
    private String oid; // 订单表编号
    private String gid; // 商品编号
    private int odnum; // 购买数量
    private double gprice; // 商品单价
    private double odtotal; // 商品总价

    public OrderDetails() {
    }

    public OrderDetails(String oid, String gid, int odnum, double gprice, double odtotal) {
        this.oid = oid;
        this.gid = gid;
        this.odnum = odnum;
        this.gprice = gprice;
        this.odtotal = odtotal;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "oid='" + oid + '\'' +
                ", gid='" + gid + '\'' +
                ", odnum=" + odnum +
                ", gprice=" + gprice +
                ", odtotal=" + odtotal +
                '}';
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public int getOdnum() {
        return odnum;
    }

    public void setOdnum(int odnum) {
        this.odnum = odnum;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public double getOdtotal() {
        return odtotal;
    }

    public void setOdtotal(double odtotal) {
        this.odtotal = odtotal;
    }
}
