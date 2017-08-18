package com.htf.service.impl;

import com.htf.controller.request.RoleRequest;
import com.htf.controller.response.RoleCascadeResponse;
import com.htf.controller.response.RoleResponse;
import com.htf.controller.response.RoleSubResponse;
import com.htf.controller.response.RoleToUserResponse;
import com.htf.entity.Menu;
import com.htf.entity.Role;
import com.htf.entity.RoleMenuRel;
import com.htf.exception.ExceptionResponse;
import com.htf.mapper.MenuMapper;
import com.htf.mapper.RoleMapper;
import com.htf.mapper.RoleMenuRelMapper;
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
    @Resource
    private MenuMapper menuMapper;
    @Resource
    private RoleMenuRelMapper roleMenuRelMapper;

    @Override
    public Role findById(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addRole(RoleRequest request) {
        request.setId(UUIDGenerator.creatUUID());
        Role role = this.toRole(request);
        //处理与菜单绑定
        if(request.getMenus() != null && request.getMenus().size() > 0){
            this.disposeRoleMenuRel(request.getMenus(),role.getId());
        }
        roleMapper.insert(role);
    }

    private void disposeRoleMenuRel(List<Menu> menus, String roleId) {
        menus.forEach(item -> {
            Menu menu = menuMapper.selectByPrimaryKey(item.getId());
            if(menu == null){
                throw new ExceptionResponse(item.getName() + ">>> 没有找到这个菜单");
            }
            RoleMenuRel roleMenuRel = new RoleMenuRel();
            roleMenuRel.setId(UUIDGenerator.creatUUID());
            roleMenuRel.setRoleId(roleId);
            roleMenuRel.setMenuId(item.getId());
            roleMenuRelMapper.insert(roleMenuRel);
        });
    }

    @Override
    public RoleResponse getRole(String id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        if(role == null){
            throw new ExceptionResponse("没有这个角色");
        }
        RoleResponse roleResponse = new RoleResponse();
        BeanUtils.copyProperties(role,roleResponse);
        return roleResponse;
    }

    @Override
    public void updateRole(RoleRequest request) {
        Role role = roleMapper.selectByPrimaryKey(request.getId());
        if(role == null){
            throw new ExceptionResponse("没有这个角色");
        }
        role = toRole(request);

        //菜单相关
        roleMenuRelMapper.delByRoleId(request.getId());
        if(request.getMenus().size() > 0){
            this.disposeRoleMenuRel(request.getMenus(),request.getId());
        }
        roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public void delRole(String id) {
        roleMapper.deleteByPrimaryKey(id);
        userRoleRelMapper.delByRoleId(id);
        roleMenuRelMapper.delByRoleId(id);
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

    /**
     * 以后修改递归方法
     * @return
     */
    @Override
    public List<RoleCascadeResponse> findAdllRoleBeltCascade() {
        List<RoleSubResponse> roleSubResponses = this.getSubRoles();
        List<RoleCascadeResponse> roleCascadeResponses = new ArrayList<>();
        roleSubResponses.forEach(item -> {
            RoleCascadeResponse roleCascadeResponse = new RoleCascadeResponse();
            BeanUtils.copyProperties(item,roleCascadeResponse);
            if(item.isHasNextLevel()){
                List<RoleSubResponse> childs = this.getChildRoles(item.getId());
                List<RoleCascadeResponse> roleCascadeResponseChilds = new ArrayList<>();
                childs.forEach(child -> {
                    RoleCascadeResponse roleCascadeResponseChild = new RoleCascadeResponse();
                    BeanUtils.copyProperties(child,roleCascadeResponseChild);
                    if(child.isHasNextLevel()){
                        List<RoleSubResponse> childs_ = this.getChildRoles(child.getId());
                        List<RoleCascadeResponse> roleCascadeResponseChilds_ = new ArrayList<>();
                        childs_.forEach(child_ -> {
                            RoleCascadeResponse roleCascadeResponseChild_ = new RoleCascadeResponse();
                            List<RoleCascadeResponse> roleCascadeResponseChilds_s = new ArrayList<>();
                            BeanUtils.copyProperties(child_,roleCascadeResponseChild_);
                            roleCascadeResponseChilds_.add(roleCascadeResponseChild_);
                        });
                        roleCascadeResponseChild.setChild(roleCascadeResponseChilds_);
                    }
                    roleCascadeResponseChilds.add(roleCascadeResponseChild);
                });
                roleCascadeResponse.setChild(roleCascadeResponseChilds);
            }
            roleCascadeResponses.add(roleCascadeResponse);
        });
        return roleCascadeResponses;
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
