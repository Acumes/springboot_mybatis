package com.htf.service;


import com.github.pagehelper.PageInfo;
import com.htf.controller.request.UserRequest;
import com.htf.controller.response.UserResponse;
import com.htf.entity.User;
import com.htf.util.FilterAndOrder;
import com.htf.util.PageInfoResult;
import com.htf.util.PageRequest;
import com.htf.util.PagesInfo;

import java.util.List;

/**
 * Created by PC-FENG on 2017/8/17.
 */
public interface UserService {
    UserResponse findById(String id);
    void addUser(UserRequest request);
    void updateUser(UserRequest request);

    void delUser(String id);

    User findByUserName(String username);

    List<UserResponse> getAllUser();

    void updateUserPhoto(String resourceURI);

    PageInfoResult list(PageRequest pageRequest);
}
