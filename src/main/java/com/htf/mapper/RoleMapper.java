package com.htf.mapper;

import com.htf.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by PC-FENG on 2017/8/17.
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role,String>{
//    public Role findById(String s);
    List<Role> findByParentRole();
    List<Role> findRoleIsChild(String parentId);
    List<Role> findAllRole();
}
