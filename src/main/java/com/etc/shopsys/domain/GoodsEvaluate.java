package com.etc.shopsys.domain;

import java.io.Serializable;

public class GoodsEvaluate implements Serializable {
    private String odid;//订单编号
    private String gid;//商品编号
    private String evaluate;//评价

    public GoodsEvaluate() {
    }

    public GoodsEvaluate(String odid, String gid, String evaluate) {
        this.odid = odid;
        this.gid = gid;
        this.evaluate = evaluate;
    }

    @Override
    public String toString() {
        return "GoodsEvaluate{" +
                "odid='" + odid + '\'' +
                ", gid='" + gid + '\'' +
                ", evaluate='" + evaluate + '\'' +
                '}';
    }

    public String getOdid() {
        return odid;
    }

    public void setOdid(String odid) {
        this.odid = odid;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }
}
