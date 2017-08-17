package com.htf.mapper;

import com.htf.entity.UserRoleRel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by PC-FENG on 2017/8/17.
 */
@Mapper
public interface UserRoleRelMapper extends BaseMapper<UserRoleRel,String>{
    List<UserRoleRel> getByUserId(String userId);
    void delByUserId(String userId);
    void delByRoleId(String roleId);

}
