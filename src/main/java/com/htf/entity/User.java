package com.htf.entity;

import java.io.Serializable;

/**
 * 用户实体类
 * Created by PC-FENG on 2017/8/17.
 */
public class User extends BaseEntity implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String gender;
    private String email;
    private String mobile;
    private String nickName;
    private Object englishName;
    private String status;
    private String remark;
    private String photo;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Object getEnglishName() {
        return englishName;
    }

    public void setEnglishName(Object englishName) {
        this.englishName = englishName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
