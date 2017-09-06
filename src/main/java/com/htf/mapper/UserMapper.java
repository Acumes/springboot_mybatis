package com.htf.mapper;

import com.htf.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    void updateUserPhoto(@Param("photo") String photo,@Param("id") String id);

    List<Map<String,Object>> getUserByPage(@Param("searchKeyWord")String searchKeyWord);
}
