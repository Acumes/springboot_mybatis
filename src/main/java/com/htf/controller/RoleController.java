package com.htf.controller;

import com.htf.controller.request.RoleRequest;
import com.htf.controller.response.RoleCascadeResponse;
import com.htf.controller.response.RoleResponse;
import com.htf.controller.response.RoleSubResponse;
import com.htf.controller.response.RoleToUserResponse;
import com.htf.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by PC-FENG on 2017/8/17.
 */
@RestController
@RequestMapping("/role")
@Api(value = "role",description = "角色相关controller")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ApiOperation(value = "添加角色")
    public void addRole(@RequestBody RoleRequest request){
        roleService.addRole(request);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "获取角色")
    public RoleResponse getRole(@PathVariable String id){
        return roleService.getRole(id);
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    @ApiOperation(value = "修改角色")
    public void updateRole(@RequestBody RoleRequest request){
        roleService.updateRole(request);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除角色")
    public void delRole(@PathVariable  String id){
        roleService.delRole(id);
    }
    @RequestMapping(value = "/sub_roles", method = RequestMethod.GET)
    @ApiOperation(value = "获取顶层角色信息", notes = "获取所有最顶部的角色信息")
    public List<RoleSubResponse> getSubRoles() {
        return roleService.getSubRoles();
    }

    @RequestMapping(value = "/child/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根据角色ID获取子角色", notes = "获取子角色")
    public List<RoleSubResponse> getChildRoles(@PathVariable String id) {
        return roleService.getChildRoles(id);
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有角色", notes = "获取所有角色")
    public List<RoleToUserResponse> findAllRole() {
        return roleService.findAllRole();
    }

    @RequestMapping(value = "/all_cascade", method = RequestMethod.GET)
    @ApiOperation(value = "获取角色树", notes = "获取所有角色带级联")
    public List<RoleCascadeResponse> findAdllRoleBeltCascade() {
        return roleService.findAdllRoleBeltCascade();
    }
    @RequestMapping(value = "/all_cascade_", method = RequestMethod.GET)
    @ApiOperation(value = "获取角色树", notes = "获取所有角色带级联")
    public List<RoleCascadeResponse> findAdllRoleBeltCascade_() {
        return roleService.findAdllRoleBeltCascade_();
    }


}
