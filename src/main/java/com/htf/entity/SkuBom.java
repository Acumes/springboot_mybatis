package com.htf.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by PC-FENG on 2017/8/24.
 */
public class SkuBom implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String skuCode;
    private Sku bomSku;
//    private MeasureUnitDto measureUnit;
    private BigDecimal qty;
    private Integer qtyDenominator;
    private BigDecimal wasteRate;
    private Boolean isDeletedRecord;
    private String comment;
    private Integer skuVersion;
    private Date crtTime;
    private String creatorName;
    private String creatorId;

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public Sku getBomSku() {
        return bomSku;
    }

    public void setBomSku(Sku bomSku) {
        this.bomSku = bomSku;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public Integer getQtyDenominator() {
        return qtyDenominator;
    }

    public void setQtyDenominator(Integer qtyDenominator) {
        this.qtyDenominator = qtyDenominator;
    }

    public BigDecimal getWasteRate() {
        return wasteRate;
    }

    public void setWasteRate(BigDecimal wasteRate) {
        this.wasteRate = wasteRate;
    }

    public Boolean getDeletedRecord() {
        return isDeletedRecord;
    }

    public void setDeletedRecord(Boolean deletedRecord) {
        isDeletedRecord = deletedRecord;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getSkuVersion() {
        return skuVersion;
    }

    public void setSkuVersion(Integer skuVersion) {
        this.skuVersion = skuVersion;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
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
}
