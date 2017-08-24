package com.htf.entity;

import java.io.Serializable;

/**
 * Created by PC-FENG on 2017/8/24.
 */
public class SkuType extends BaseEntity implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String name;
    private String comment;
    private String parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
