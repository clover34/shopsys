package com.etc.shopsys.domain;

import java.io.Serializable;

/**
 * @ClassName UserAddress 用户地址
 * @Description TODO
 * @Author Administrator
 * @Date 20/09/30 15:14
 * @Version 1.0
 **/
public class UserAddress implements Serializable {
    private String UUID;// UUID主键
    private String uid;// 用户编号
    private String contactname;// 联系人姓名
    private String phone;;// 联系电话
    private String uaddress;// 用户收件地址

    // 全参构造方法
    public UserAddress(String UUID, String uid, String contactname, String phone, String uaddress) {
        this.UUID = UUID;
        this.uid = uid;
        this.contactname = contactname;
        this.phone = phone;
        this.uaddress = uaddress;
    }

    // 无参构造方法
    public UserAddress() {
    }

    // toString 方法
    @Override
    public String toString() {
        return "UserAddress{" +
                "UUID='" + UUID + '\'' +
                ", uid='" + uid + '\'' +
                ", contactname='" + contactname + '\'' +
                ", phone='" + phone + '\'' +
                ", uaddress='" + uaddress + '\'' +
                '}';
    }
    // get & set 方法
    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }
}
