package com.etc.shopsys.domain;

import java.io.Serializable;

public class OrderState implements Serializable {
    private int osid; // 状态编号
    private int state; // 订单状态

    public OrderState() {
    }

    public OrderState(int osid, int state) {
        this.osid = osid;
        this.state = state;
    }

    @Override
    public String toString() {
        return "OrderState{" +
                "osid=" + osid +
                ", state=" + state +
                '}';
    }

    public int getOsid() {
        return osid;
    }

    public void setOsid(int osid) {
        this.osid = osid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
