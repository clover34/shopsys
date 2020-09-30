package com.etc.shopsys.domain;

import java.io.Serializable;
//商品类型表
public class GoodsTyple implements Serializable {
    private int gtid;//类型编号
    private String gtname;//类型名称

    public GoodsTyple() {
    }

    public GoodsTyple(int gtid, String gtname) {
        this.gtid = gtid;
        this.gtname = gtname;
    }

    @Override
    public String toString() {
        return "GoodsTyple{" +
                "gtid=" + gtid +
                ", gtname='" + gtname + '\'' +
                '}';
    }

    public int getGtid() {
        return gtid;
    }

    public void setGtid(int gtid) {
        this.gtid = gtid;
    }

    public String getGtname() {
        return gtname;
    }

    public void setGtname(String gtname) {
        this.gtname = gtname;
    }
}
