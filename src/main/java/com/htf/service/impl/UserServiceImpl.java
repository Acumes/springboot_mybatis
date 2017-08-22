package com.htf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.htf.controller.request.UserRequest;
import com.htf.controller.response.RoleToUserResponse;
import com.htf.controller.response.UserResponse;
import com.htf.entity.Role;
import com.htf.entity.User;
import com.htf.entity.UserRoleRel;
import com.htf.exception.ExceptionResponse;
import com.htf.mapper.RoleMapper;
import com.htf.mapper.UserMapper;
import com.htf.mapper.UserRoleRelMapper;
import com.htf.util.FilterAndOrder;
import com.htf.util.PagesInfo;
import com.htf.util.ShiroUtils;
import com.htf.util.UUIDGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.htf.service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC-FENG on 2017/8/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private UserRoleRelMapper userRoleRelMapper;
    @Override
    public UserResponse findById(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user,userResponse);
        List<UserRoleRel> userRoleRels = userRoleRelMapper.getByUserId(user.getId());
        List<RoleToUserResponse> roles = new ArrayList<>();
        if(userRoleRels.size() > 0){
            userRoleRels.forEach(item -> {
                Role role = roleMapper.selectByPrimaryKey(item.getRoleId());
                if(role != null){
                    RoleToUserResponse roleToUserResponse = new RoleToUserResponse();
                    BeanUtils.copyProperties(role, roleToUserResponse);
                    roles.add(roleToUserResponse);
                }
            });
        }
        userResponse.setRoles(roles);
        return userResponse;
    }

    @Override
    public void addUser(UserRequest request) {
        User user = this.toUser(request);
        //处理角色
        if(request.getRoles().size() > 0){
            this.disposeUserRoleRel(request.getRoles(),user.getId());
        }
//        User getCurrentUser
        user.setCreator(ShiroUtils.getUserId());
        userMapper.insert(user);
    }

    @Override
    public void updateUser(UserRequest request) {

        User user = getUserById(request.getId());
        if(user == null){
            throw new ExceptionResponse("没有找到相应用户");
        }
        user = toUser(request);
        //角色相关
        userRoleRelMapper.delByUserId(user.getId());
        if(request.getRoles().size() > 0){
            this.disposeUserRoleRel(request.getRoles(),user.getId());
        }
        user.setModifier(ShiroUtils.getUserId());
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void delUser(String id) {
        userMapper.deleteByPrimaryKey(id);
        userRoleRelMapper.delByUserId(id);
    }

    @Override
    public PageInfo<UserResponse> list(PagesInfo<UserResponse> pi, FilterAndOrder fao, String roleId, String groupId) {
        return null;
    }

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    private User toUser(UserRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request,user);
        user.setStatus("1");
        String password = "";
        if(request.getPassword() != null){
            password = new Sha256Hash(request.getPassword()).toHex();
        }
        user.setPassword(password);
        return user;
    }
    private User getUserById(String id){
        return userMapper.selectByPrimaryKey(id);
    }
    private void disposeUserRoleRel(List<Role> roles,String userId){
        roles.forEach(item -> {
        Role role = roleMapper.selectByPrimaryKey(item.getId());
        if(role == null){
            throw new ExceptionResponse(item.getName() + ">>> 没有找到这个角色");
        }
        UserRoleRel userRoleRel = new UserRoleRel();
        userRoleRel.setId(UUIDGenerator.creatUUID());
        userRoleRel.setUserId(userId);
        userRoleRel.setRoleId(item.getId());
        userRoleRelMapper.insert(userRoleRel);
    });
    }
}
