package com.imooc.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by 廖师兄
 * 2016-11-03 23:07
 */
@Entity
public class User extends BaseEntity {



    private String userid;
    @NotEmpty(message = "电话不能为空")
    private String phone;

    @Size(min = 3, max = 15, message = "用户名长度应当在 3 ~ 15 个字符之间")
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Size(min = 6, max = 30, message = "密码长度应当在 6 ~ 30 个字符之间")
    private String password;
    private int status;


    public String getPhone() {
        return phone;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public User() {
    }



}
