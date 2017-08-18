package com.htf.mapper;

import com.htf.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by PC-FENG on 2017/8/18.
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu,String>{
    Integer findMaxOrderByParentId(@Param(value="parentId") String parentId);

    Integer checkIncludeChild(@Param(value="parentId")String parentId);

    List<String> getPermissions(String userId);
}
