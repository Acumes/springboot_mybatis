package com.htf.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by PC-FENG on 2017/8/25.
 */
@ApiModel(description = "计量单位类型")
public class MeasureunitConversion implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("编码")
    private String code;

    @ApiModelProperty("类型编码")
    private String typeCode;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("换算率")
    private BigDecimal ratio;

    @ApiModelProperty("排序值")
    private Integer sortSeq;

    @ApiModelProperty(required = true, value = "创建时间")
    protected Date createDate;

    @ApiModelProperty(required = true, value = "创建人")
    protected String creator;

    @ApiModelProperty(required = false, value = "修改时间")
    protected Date modifyDate;

    @ApiModelProperty(required = false, value = "修改人")
    protected String modifier;

    @ApiModelProperty(required = false, value = "状态")
    protected Integer status = 1;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public Integer getSortSeq() {
        return sortSeq;
    }

    public void setSortSeq(Integer sortSeq) {
        this.sortSeq = sortSeq;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
