package com.htf.mapper;


import java.util.Date;

import com.htf.entity.Version;
import com.htf.entity.Version.Type;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by PC-FENG on 2017/8/25.
 */
@Mapper
public interface VersionCenterMapper {
    int getMasterVersion(@Param("type") Type type);

    Integer getBranchVersion(@Param("branchId") String branchId);

    int increaseMasterVersion(@Param("type") Type type);

    int increaseBranchVersion(@Param("branchId") String branchId);

    int revertMasterVersion(@Param("type") Type type, @Param("interimVersion") int interimVersion);

    int revertBranchVersion(@Param("branchId") String branchId, @Param("interimVersion") int interimVersion);

    int insert(@Param("version") Version version);

    Version getByBranchId(@Param("branchId") String branchId);

    Version getByRefInfo(@Param("type") Type type, @Param("refType") Version.RefType refType,
                             @Param("refId") String refId);

    int temporaryBranch2Formal(@Param("branchId") String branchId, @Param("refType") Version.RefType refType,
                               @Param("refId") String refId, @Param("crtTime") Date crtTime, @Param("creatorId") String creatorId);
}

