package com.htf.entity;

import java.io.Serializable;

/**
 * Created by PC-FENG on 2017/8/18.
 */
public class RoleMenuRel implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String id;
    private String roleId;
    private String menuId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
