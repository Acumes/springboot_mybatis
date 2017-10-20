package com.htf.service.impl;

import com.google.common.base.Strings;
import com.htf.entity.Version;
import com.htf.entity.Version.Type;
import com.htf.entity.Version.RefType;
import com.htf.mapper.VersionCenterMapper;
import com.htf.service.*;
import com.htf.service.VersionCenterService;
import com.htf.util.Status;
import com.htf.util.UUIDGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by PC-FENG on 2017/10/20.
 */
@Service("versionCenterService")
public class VersionCenterServiceImpl implements VersionCenterService{

    @Resource
    private VersionCenterMapper vcMapper;
    /**
     * 获取当前主线版本号
     * @param type
     * @return
     */
    @Override
    public int getMasterVersion(Type type){
        return vcMapper.getMasterVersion(type);
    }

    /**
     * 获取分支版本号
     * @param branchId
     * @return
     */
    @Override
    public Integer getBranchVersion(String branchId){
        return vcMapper.getBranchVersion(branchId);
    }

    /**
     * 主线版本号+1并返回新版本号
     * @param type
     * @return
     */
    @Override
    @Transactional
    public int increaseAndGetMasterVersion(Type type){
        vcMapper.increaseMasterVersion(type);
        return vcMapper.getMasterVersion(type);
    }

    /**
     * 分支版本号+1并返回新版本号
     * @param branchId
     * @return
     */
    @Override
    @Transactional
    public int increaseBranchVersion(String branchId){
        if(vcMapper.increaseBranchVersion(branchId) != 1)
            throw new IllegalArgumentException("错误的分支ID："+branchId);
        return vcMapper.getBranchVersion(branchId);
    }

    /**
     * 先增加了版本，发现其实不需要时，再调用此方法回退（同一事务内），其它地方不要调用此方法
     * @param type
     * @param interimVersion
     */
    @Override
    @Transactional
    public void revertMasterVersion(Type type, int interimVersion){
        vcMapper.revertMasterVersion(type, interimVersion);
    }

    /**
     * 先增加了版本，发现其实不需要时，再调用此方法回退（同一事务内），其它地方不要调用此方法
     * @param branchId
     * @param interimVersion
     */
    @Override
    @Transactional
    public void revertBranchVersion(String branchId, int interimVersion){
        vcMapper.revertBranchVersion(branchId, interimVersion);
    }

    /**
     * 创建分支，实际场景也几乎不可能同时创建相同的分支，如果有，直接让后者报违反唯一索引的错吧
     * @param type
     * @param masterVersion
     * @param refType
     * @param refId
     * @param creatorId
     * @return branchId
     */
    @Override
    @Transactional
    public String createBranch(Type type, int masterVersion, RefType refType, String refId, String creatorId){
        if(RefType.master.equals(refType))
            throw new IllegalArgumentException("主线版本对象只允许在初始化脚本中创建");
        Version vp = new Version();
        vp.setBranchId(UUIDGenerator.creatUUID());
        vp.setCreatorId(creatorId);
        vp.setCrtTime(new Date());
        vp.setCurVersion(masterVersion);
        vp.setForkVersion(masterVersion);
        vp.setRefId(refId);
        vp.setRefType(refType);
        vp.setStatus(Status.Enabled.getCode());
        vp.setType(type);
        vcMapper.insert(vp);
        return vp.getBranchId();
    }

    /**
     * 暂定只能给sku打临时分支
     * @param masterVersion 从主线哪个版本打分支，如果为null则获取当前主线版本
     * @param creatorId
     * @return
     */
    @Override
    @Transactional
    public String createTemporaryBranch(Integer masterVersion, String creatorId){
        if(masterVersion == null)
            masterVersion = vcMapper.getMasterVersion(Type.sku);
        return createBranch(Type.sku, masterVersion, RefType.temporary, null, creatorId);
    }

    /**
     * 将临时分支转为正式分支，如果branchId为null或空，则创建新的正式分支，type固定为Type.sku
     * @param branchId
     * @param refType
     * @param refId
     * @param creatorId
     * @return branchId
     */
    @Override
    @Transactional
    public String temporaryBranch2Formal(String branchId, RefType refType, String refId, String creatorId){
        if(Strings.isNullOrEmpty(branchId))
            return createBranch(Type.sku, vcMapper.getMasterVersion(Type.sku), refType, refId, creatorId);
        if(vcMapper.temporaryBranch2Formal(branchId, refType, refId, new Date(), creatorId) == 1)
            return branchId;
        else
            throw new IllegalArgumentException("转换临时分支失败，临时分支ID错误或类型错误，branchId："+branchId);
    }

    @Override
    public Version getByBranchId(String branchId){
        return vcMapper.getByBranchId(branchId);
    }

    @Override
    public Version getByRefInfo(Type type, Version.RefType refType, String refId){
        return vcMapper.getByRefInfo(type, refType, refId);
    }
}
