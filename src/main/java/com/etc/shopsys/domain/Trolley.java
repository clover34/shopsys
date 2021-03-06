package com.etc.shopsys.domain;

public class Trolley {
    private String uid;//用户编号
    private String gid;//商品编号
    private int trcount;//购买数量

    public Trolley() {
    }

    public Trolley(String uid, String gid, int trcount) {
        this.uid = uid;
        this.gid = gid;
        this.trcount = trcount;
    }

    @Override
    public String toString() {
        return "Trolley{" +
                "uid='" + uid + '\'' +
                ", gid='" + gid + '\'' +
                ", trcount=" + trcount +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public int getTrcount() {
        return trcount;
    }

    public void setTrcount(int trcount) {
        this.trcount = trcount;
    }
}
