package com.etc.shopsys.domain;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author Administrator
 * @Date 20/09/30 15:18
 * @Version 1.0
 **/
public class User implements Serializable {
    private String UUID;// 唯一标识
    private String uid;// 用户编号
    private String username;// 用户姓名
    private String password;// 用户密码
    private String phone;// 用户联系方式
    private String email;// 邮箱

    // 全参构造方法
    public User(String UUID, String uid, String username, String password, String phone, String email) {
        this.UUID = UUID;
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    // 无参构造方法
    public User() {
    }

    // toString 方法
    @Override
    public String toString() {
        return "User{" +
                "UUID='" + UUID + '\'' +
                ", uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
