package com.htf.entity;

import java.util.Date;

/**
 * Created by PC-FENG on 2017/8/25.
 */
public class Version {
    private String branchId;
    private Type type;
    private int forkVersion;
    private int curVersion;
    private RefType refType;
    private String refId;
    private int status;
    private Date crtTime;
    private String creatorName;
    private String creatorId;

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getForkVersion() {
        return forkVersion;
    }

    public void setForkVersion(int forkVersion) {
        this.forkVersion = forkVersion;
    }

    public int getCurVersion() {
        return curVersion;
    }

    public void setCurVersion(int curVersion) {
        this.curVersion = curVersion;
    }

    public RefType getRefType() {
        return refType;
    }

    public void setRefType(RefType refType) {
        this.refType = refType;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    /**
     * 关联字段类型
     * @author trytocatch
     * @date 2016年10月19日
     */
    public static enum RefType{
        /**
         * 主线，ref_id无意义
         */
        master,
        /**
         * ref_id为transCode
         */
        transCode,
        /**
         * 临时分支，ref_id为null
         */
        temporary
    }

    public static enum Type{
        spu,sku
    }
}
