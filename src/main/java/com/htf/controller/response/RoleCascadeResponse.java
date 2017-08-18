package com.htf.controller.response;

import java.util.List;

/**
 * Created by PC-FENG on 2017/8/17.
 */
public class RoleCascadeResponse {
    private String id;
    private String name;
    private List<RoleCascadeResponse> child;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RoleCascadeResponse> getChild() {
        return child;
    }

    public void setChild(List<RoleCascadeResponse> child) {
        this.child = child;
    }
}
