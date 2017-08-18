package com.htf.mapper;

import com.htf.entity.RoleMenuRel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by PC-FENG on 2017/8/17.
 */
@Mapper
public interface RoleMenuRelMapper extends BaseMapper<RoleMenuRel,String>{
    List<RoleMenuRel> getByRoleId(String roleId);
    void delByRoleId(String roleId);
    void delByMenuId(String menuId);

}
