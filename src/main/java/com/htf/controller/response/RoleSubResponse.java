package com.htf.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回父层角色
 * Created by PC-FENG on 2017/8/12.
 */
@ApiModel("返回角色实体")
public class RoleSubResponse {
    private String id;
    private String name;
    @ApiModelProperty("是否还有下级")
    private boolean hasNextLevel = false;

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

    public boolean isHasNextLevel() {
        return hasNextLevel;
    }

    public void setHasNextLevel(boolean hasNextLevel) {
        this.hasNextLevel = hasNextLevel;
    }
}
