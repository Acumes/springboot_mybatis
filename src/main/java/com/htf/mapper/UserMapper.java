package com.htf.mapper;

import com.htf.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by PC-FENG on 2017/8/17.
 */
@Mapper
public interface UserMapper extends BaseMapper<User,String>{
    /**
     * 根据id查询用户
     * @return
     */
//    User findById(String id);

    public List<User> list();

    User findByUserName(String username);

    List<User> getAllUser();

    void updateUserPhoto(String resourceURI);
}
