package com.htf.service.impl;

import com.htf.controller.request.RoleRequest;
import com.htf.controller.response.RoleCascadeResponse;
import com.htf.controller.response.RoleResponse;
import com.htf.controller.response.RoleSubResponse;
import com.htf.controller.response.RoleToUserResponse;
import com.htf.entity.Role;
import com.htf.exception.ExceptionResponse;
import com.htf.mapper.RoleMapper;
import com.htf.mapper.UserRoleRelMapper;
import com.htf.util.UUIDGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.htf.service.RoleService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC-FENG on 2017/8/17.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private UserRoleRelMapper userRoleRelMapper;

    @Override
    public Role findById(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addRole(RoleRequest request) {
        request.setId(UUIDGenerator.creatUUID());
        Role role = this.toRole(request);
        roleMapper.insert(role);
    }

    @Override
    public RoleResponse getRole(String id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        if(role == null){
            throw new ExceptionResponse("没用这个角色");
        }
        RoleResponse roleResponse = new RoleResponse();
        BeanUtils.copyProperties(role,roleResponse);
        return roleResponse;
    }

    @Override
    public void updateRole(RoleRequest request) {
        Role role = roleMapper.selectByPrimaryKey(request.getId());
        if(role == null){
            throw new ExceptionResponse("没用这个角色");
        }
        role = toRole(request);
        roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public void delRole(String id) {
        roleMapper.deleteByPrimaryKey(id);
        userRoleRelMapper.delByRoleId(id);
    }

    @Override
    public List<RoleSubResponse> getSubRoles() {
        List<Role> list = roleMapper.findByParentRole();
        List<RoleSubResponse> subList = new ArrayList<RoleSubResponse>();
        if(list != null && list.size() != 0){
            return subList = this.toChild(list);
        }
        return  null;
    }

    @Override
    public List<RoleSubResponse> getChildRoles(String id) {
        List<Role> list =roleMapper.findRoleIsChild(id);
        List<RoleSubResponse> subList = new ArrayList<RoleSubResponse>();
        if(list != null && list.size() != 0){
            return subList = this.toChild(list);
        }
        return  null;
    }

    @Override
    public List<RoleToUserResponse> findAllRole() {
        List<Role> list = roleMapper.findAllRole();
        List<RoleToUserResponse> responses = new ArrayList();
        list.forEach(item -> {
            RoleToUserResponse response = new RoleToUserResponse();
            BeanUtils.copyProperties(item , response);
            responses.add(response);
        });
        return responses;
    }

    @Override
    public List<RoleCascadeResponse> findAdllRoleBeltCascade() {
        List<RoleSubResponse> roleSubResponses = this.getSubRoles();
        List<RoleCascadeResponse> roleCascadeResponses = new ArrayList<>();
        roleCascadeResponses = this.convert(roleSubResponses);
        return roleCascadeResponses;
    }

    private List<RoleCascadeResponse> convert(List<RoleSubResponse> roleSubResponses) {



        return null;
    }

    private Role toRole(RoleRequest request) {
        Role role = new Role();
        BeanUtils.copyProperties(request,role);
        return role;
    }
    private List<RoleSubResponse> toChild(List<Role> list){
        List<RoleSubResponse> subList = new ArrayList<RoleSubResponse>();
        list.forEach(item -> {
            RoleSubResponse role_ = new RoleSubResponse();
            role_.setId(item.getId());
            role_.setName(item.getName());
            if(roleMapper.findRoleIsChild(item.getId()).size() > 0){
                role_.setHasNextLevel(true);
            }
            subList.add(role_);
        });
        return subList;
    }
}
