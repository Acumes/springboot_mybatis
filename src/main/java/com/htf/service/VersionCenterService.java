package com.htf.service;

import com.htf.entity.Version;
import com.htf.entity.Version.Type;
import com.htf.entity.Version.RefType;

/**
 * Created by PC-FENG on 2017/10/20.
 */
public interface VersionCenterService {

    /**
     * 获取当前主线版本号
     * @param type
     * @return
     */
    public int getMasterVersion(Type type);

    /**
     * 获取分支版本号
     * @param branchId
     * @return
     */
    public Integer getBranchVersion(String branchId);

    /**
     * 主线版本号+1并返回新版本号
     * @param type
     * @return
     */
    public int increaseAndGetMasterVersion(Type type);

    /**
     * 分支版本号+1并返回新版本号
     * @param branchId
     * @return
     */
    public int increaseBranchVersion(String branchId);

    /**
     * 先增加了版本，发现其实不需要时，再调用此方法回退（同一事务内），其它地方不要调用此方法
     * @param type
     * @param interimVersion
     */
    public void revertMasterVersion(Type type, int interimVersion);

    /**
     * 先增加了版本，发现其实不需要时，再调用此方法回退（同一事务内），其它地方不要调用此方法
     * @param branchId
     * @param interimVersion
     */
    public void revertBranchVersion(String branchId, int interimVersion);

    /**
     * 创建分支，实际场景也几乎不可能同时创建相同的分支，如果有，直接让后者报违反唯一索引的错吧
     * @param type
     * @param masterVersion
     * @param refType
     * @param refId
     * @param creatorId
     * @return branchId
     */
    public String createBranch(Type type, int masterVersion, RefType refType, String refId, String creatorId);

    /**
     * 暂定只能给sku打临时分支
     * @param masterVersion 从主线哪个版本打分支，如果为null则获取当前主线版本
     * @param creatorId
     * @return
     */
    public String createTemporaryBranch(Integer masterVersion, String creatorId);

    /**
     * 将临时分支转为正式分支，如果branchId为null或空，则创建新的正式分支，type固定为Type.sku
     * @param branchId
     * @param refType
     * @param refId
     * @param creatorId
     * @return branchId
     */
    public String temporaryBranch2Formal(String branchId, RefType refType, String refId, String creatorId);

    public Version getByBranchId(String branchId);

    public Version getByRefInfo(Type type, RefType refType, String refId);

}
