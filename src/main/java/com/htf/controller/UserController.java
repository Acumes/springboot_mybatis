package com.htf.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.htf.controller.request.UserRequest;
import com.htf.controller.response.UserResponse;
import com.htf.entity.User;
import com.htf.service.UserService;
import com.htf.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by PC-FENG on 2017/8/16.
 */
@RestController()
@RequestMapping(value="/user")
@Api(value = "user",description = "用户请求相关的controller")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public PageInfo<UserResponse> list(@RequestParam(value = "foap",required = false) String foap,
                                        @RequestParam(value = "roleId",required = false) String roleId,
                                        @RequestParam(value = "groupId",required = false) String groupId) {
        FilterOrderAndPage foapObj = JSONObject.parseObject(foap, FilterOrderAndPage.class);
        System.out.println();
        PagesInfo<UserResponse> pi = null;
        FilterAndOrder fao = null;
        if (null != foapObj) {
            fao = foapObj.getFao();
            pi = foapObj.getPage();
        }

        if (null == pi) { // 设置默认值
            pi = new PagesInfo<UserResponse>();
            pi.setPageNum(1);
            pi.setPageSize(10);
        }
        return userService.list(pi,fao,roleId,groupId);
    }

    @ApiOperation(value = "添加用户",notes = "根据请求参数添加用户")
    @ApiImplicitParam(value = "UserRequest",required = true,dataType = "UserRequest")
    @RequestMapping(value = "",method = RequestMethod.POST)
    public void addUser(@RequestBody UserRequest request){
        request.setId(UUIDGenerator.creatUUID());
        userService.addUser(request);
    }
    @ApiOperation(value = "查询用户",notes = "根据用户ID查询相应用于")
    @ApiImplicitParam(value = "id",required = true,dataType = "string")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public UserResponse getUserInfo(@PathVariable String id){
        return userService.findById(id);
    }

    @ApiOperation(value = "修改用户",notes = "根据请求参数添加用户")
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserRequest request){
        userService.updateUser(request);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "根据ID删除用户",notes = "传递用户ID")
    @ApiImplicitParam(value = "id",required = true,dataType = "string")
    public void delUser(@PathVariable String id){
        userService.delUser(id);
    }

    @RequestMapping(value = "/allUser",method = RequestMethod.GET)
    @ApiOperation(value = "获取所有用户",notes = "获取所有用户")
    public List<UserResponse> getAllUser(){
        return userService.getAllUser();
    }

    @ApiOperation(value = "获取当前登录用户",notes = "获取当前登录用户")
    @RequestMapping(value = "/getCurrentUser",method = RequestMethod.GET)
    public User getCurrentUserInfo(){
        return ShiroUtils.getUser();
    }
    @ApiOperation(value = "修改用户",notes = "根据请求参数添加用户")
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public void updateUserPhoto(@RequestParam String resourceURI){
        userService.updateUserPhoto(resourceURI);
    }
}
