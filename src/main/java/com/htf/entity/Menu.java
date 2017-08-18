package com.htf.entity;

import java.io.Serializable;

/**
 * Created by PC-FENG on 2017/8/18.
 */
public class Menu extends BaseEntity implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String name;
    private String type;
    private String parentId;
    private String title;
    private String order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
