package com.etc.shopsys.domain;

import java.io.Serializable;

public class Goods implements Serializable {
    private String UUID;//UUID
    private String gid;//商品编号
    private String gname;//商品名称
    private int gcount;//商品库存
    private double gprice;//商品价格
    private int gtid;//商品类型
    private int isdelete;//商品是否删除
    private String gdepict;//商品描述
    private String gimg;//图片

    public Goods() {
    }

    public Goods(String UUID, String gid, String gname, int gcount, double gprice, int gtid, int isdelete, String gdepict, String gimg) {
        this.UUID = UUID;
        this.gid = gid;
        this.gname = gname;
        this.gcount = gcount;
        this.gprice = gprice;
        this.gtid = gtid;
        this.isdelete = isdelete;
        this.gdepict = gdepict;
        this.gimg = gimg;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "UUID='" + UUID + '\'' +
                ", gid='" + gid + '\'' +
                ", gname='" + gname + '\'' +
                ", gcount=" + gcount +
                ", gprice=" + gprice +
                ", gtid=" + gtid +
                ", isdelete=" + isdelete +
                ", gdepict='" + gdepict + '\'' +
                ", gimg='" + gimg + '\'' +
                '}';
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getGcount() {
        return gcount;
    }

    public void setGcount(int gcount) {
        this.gcount = gcount;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public int getGtid() {
        return gtid;
    }

    public void setGtid(int gtid) {
        this.gtid = gtid;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public String getGdepict() {
        return gdepict;
    }

    public void setGdepict(String gdepict) {
        this.gdepict = gdepict;
    }

    public String getGimg() {
        return gimg;
    }

    public void setGimg(String gimg) {
        this.gimg = gimg;
    }
}
