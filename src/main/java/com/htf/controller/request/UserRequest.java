package com.htf.controller.request;

import com.htf.entity.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 用户请求类
 * Created by PC-FENG on 2017/8/17.
 */
@ApiModel
public class UserRequest {

    private String id;
    @ApiModelProperty(required = true,notes = "用户名，用于登录")
    private String username;
    @ApiModelProperty(required = true,notes = "昵称，用于显示用户昵称")
    private String nickName;
    private String englishName;
    @ApiModelProperty(required = true,notes = "性别")
    private String gender;
    @ApiModelProperty(required = true)
    private String email;
    @ApiModelProperty(required = true)
    private String mobile;
    @ApiModelProperty(required = true)
    private String password;
    private String remark;
    private List<Role> roles;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
