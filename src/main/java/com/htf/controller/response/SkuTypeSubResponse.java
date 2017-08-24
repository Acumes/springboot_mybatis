package com.htf.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by PC-FENG on 2017/8/24.
 */
@ApiModel("返回SKU类型实体")
public class SkuTypeSubResponse {
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
