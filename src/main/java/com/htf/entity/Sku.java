package com.htf.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by PC-FENG on 2017/8/24.
 */
public class Sku implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String skuCode;
    private String name;
    private Integer status;
    private Integer bomStatus;
    private String pictures;
    private String comment;

    private Date modifyTime;
    private Date createTime;
    /**
     * 修改者名称
     */
    private String modifierName;

    private String modifierId;
    /**
     * 创建者名称
	 */
    private String creatorName;

    private String creatorId;

//    private List<SkuAttributeValue> values;

    private List<SkuBom> boms;

//    private List<SkuCostWagesBo> costWages;

//    private List<SkuCostProcedureBo> costProcedures;

//    private List<SkuCostProviderBo> costProviders;

    /**
     * 皮费
     */
    private BigDecimal piffer;

    private Integer verify;

    /**
     * 审核人
     */
    private String verifier;

    private String verifyName;

    /**
     * 审核时间
     */
    private Date verifyTime;

    /**
     * 是否有BOM
     */
    private boolean hasBom;

    /**
     * 一级分类
     */
    private String level1CatId;

    /**
     * 一级商品分类名称
     */
    private String level1CatName;

    /**
     * 二级分类
     */
    private String level2CatId;

    /**
     * 二级商品分类名称
     */
    private String level2CatName;

    /**
     * 三级分类
     */
    private String level3CatId;

    /**
     * 三级商品分类名称
     */
    private String level3CatName;

    /**
     * 计量单位
     */
//    private MeasureUnitDto measureUnit;

    private String measureunitCode;

    private String measureunitName;

    private String measureType;

//    private UserGroupDto userGroup;

    /**
     * 部门负责人
     */
//    private UserDto userDto;

    private Integer bomVerify;

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBomStatus() {
        return bomStatus;
    }

    public void setBomStatus(Integer bomStatus) {
        this.bomStatus = bomStatus;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    public String getModifierId() {
        return modifierId;
    }

    public void setModifierId(String modifierId) {
        this.modifierId = modifierId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public BigDecimal getPiffer() {
        return piffer;
    }

    public void setPiffer(BigDecimal piffer) {
        this.piffer = piffer;
    }

    public Integer getVerify() {
        return verify;
    }

    public void setVerify(Integer verify) {
        this.verify = verify;
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    public String getVerifyName() {
        return verifyName;
    }

    public void setVerifyName(String verifyName) {
        this.verifyName = verifyName;
    }

    public Date getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }

    public boolean isHasBom() {
        return hasBom;
    }

    public void setHasBom(boolean hasBom) {
        this.hasBom = hasBom;
    }

    public String getLevel1CatId() {
        return level1CatId;
    }

    public void setLevel1CatId(String level1CatId) {
        this.level1CatId = level1CatId;
    }

    public String getLevel1CatName() {
        return level1CatName;
    }

    public void setLevel1CatName(String level1CatName) {
        this.level1CatName = level1CatName;
    }

    public String getLevel2CatId() {
        return level2CatId;
    }

    public void setLevel2CatId(String level2CatId) {
        this.level2CatId = level2CatId;
    }

    public String getLevel2CatName() {
        return level2CatName;
    }

    public void setLevel2CatName(String level2CatName) {
        this.level2CatName = level2CatName;
    }

    public String getLevel3CatId() {
        return level3CatId;
    }

    public void setLevel3CatId(String level3CatId) {
        this.level3CatId = level3CatId;
    }

    public String getLevel3CatName() {
        return level3CatName;
    }

    public void setLevel3CatName(String level3CatName) {
        this.level3CatName = level3CatName;
    }

    public String getMeasureunitCode() {
        return measureunitCode;
    }

    public void setMeasureunitCode(String measureunitCode) {
        this.measureunitCode = measureunitCode;
    }

    public String getMeasureunitName() {
        return measureunitName;
    }

    public void setMeasureunitName(String measureunitName) {
        this.measureunitName = measureunitName;
    }

    public String getMeasureType() {
        return measureType;
    }

    public void setMeasureType(String measureType) {
        this.measureType = measureType;
    }

    public Integer getBomVerify() {
        return bomVerify;
    }

    public void setBomVerify(Integer bomVerify) {
        this.bomVerify = bomVerify;
    }

    public List<SkuBom> getBoms() {
        return boms;
    }

    public void setBoms(List<SkuBom> boms) {
        this.boms = boms;
    }
}
