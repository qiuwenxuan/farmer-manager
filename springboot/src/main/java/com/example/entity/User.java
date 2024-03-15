package com.example.entity;

import java.io.Serializable;

//用户类
public class User extends Account implements Serializable {
    private static final long serialiVersionUID = 1L;

    //id
    private Integer id;

    //用户名
    private String username;

    //密码
    private String password;

    //名字
    private String name;

    //角色
    private String role;

    //电话
    private String phone;

    //邮箱
    private String email;

    //等级
    private String level;

    //余额
    private String account;

    //头像
    private String avatar;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String acount) {
        this.account = acount;
    }

    @Override
    public String getAvatar() {
        return avatar;
    }

    @Override
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
