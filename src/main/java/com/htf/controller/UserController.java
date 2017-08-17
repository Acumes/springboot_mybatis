package com.htf.controller;

import com.github.pagehelper.PageInfo;
import com.htf.controller.request.UserRequest;
import com.htf.controller.response.UserResponse;
import com.htf.service.UserService;
import com.htf.util.UUIDGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by PC-FENG on 2017/8/16.
 */
@RestController()
@RequestMapping(value="/user")
@Api(value = "user",description = "用户请求相关的controller")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/query/{pageIndex}/{pageSize}",method = RequestMethod.GET)
    public PageInfo query(@PathVariable Integer pageIndex, @PathVariable Integer pageSize) {

        PageInfo  page= userService.list(pageIndex,pageSize);
        return page;
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
}
