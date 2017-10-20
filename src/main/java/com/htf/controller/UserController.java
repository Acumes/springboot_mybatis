package com.htf.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.htf.controller.request.UserRequest;
import com.htf.controller.response.UserResponse;
import com.htf.entity.User;
import com.htf.service.CacheService;
import com.htf.service.UserService;
import com.htf.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by PC-FENG on 2017/8/16.
 */
@RestController()
@RequestMapping(value="/user")
@Api(value = "user",description = "用户请求相关的controller")
public class UserController {

    @Autowired
    UserService userService;
    @Value("${resources.user.photo.path}")
    private String imageDir;
    @Autowired
    CacheService cacheService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public PageInfoResult list(@ModelAttribute PageRequest pageRequest) {
//        FilterOrderAndPage foapObj = JSONObject.parseObject(foap, FilterOrderAndPage.class);
//        System.out.println();
//        PagesInfo<UserResponse> pi = null;
//        FilterAndOrder fao = null;
//        if (null != foapObj) {
//            fao = foapObj.getFao();
//            pi = foapObj.getPage();
//        }
//
//        if (null == pi) { // 设置默认值
//            pi = new PagesInfo<UserResponse>();
//            pi.setPageNum(1);
//            pi.setPageSize(10);
//        }
//        return userService.list(pi,fao,roleId,groupId);
        System.out.println(ShiroUtils.getUserId());
        PageInfoResult  result= userService.list(pageRequest);
        return result;
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
    public User getCurrentUserInfo(@RequestParam String token){
        String userId = this.cacheService.getValue(token).split("_")[1];
        UserResponse response = this.userService.findById(userId);
        User user = new User();
        BeanUtils.copyProperties(response,user);
        return user;
    }
    @ApiOperation(value = "修改用户",notes = "根据请求参数添加用户")
    @RequestMapping(value = "/updateUserPhoto",method = RequestMethod.PUT)
    public void updateUserPhoto(@RequestParam String resourceURI){
        userService.updateUserPhoto(resourceURI);
    }

    @ApiOperation(value = "修改用户密码",notes = "修改用户密码")
    @RequestMapping(value = "/updatePassword",method = RequestMethod.PUT)
    @ApiImplicitParam(value = "Map",dataType = "Map")
    public void updatePassword(@RequestBody Map<String ,String> map){



//        userService.updateUserPhoto();
    }

    @RequestMapping(value = "/getUserPhoto",method = RequestMethod.GET)
    public void readImg(HttpServletResponse response,@RequestParam String token){
        if(token != null && !"".equals(token)){
            String userId = this.cacheService.getValue(token).split("_")[1];
            if(userId != null){
                UserResponse userResponse = this.getUserInfo(userId);
                File file = new File(imageDir +  userResponse.getPhoto());
                try{
                    InputStream is = new FileInputStream(file);
                    // 循环取出流中的数据
                    byte[] b = new byte[1024];
                    int len;
                    response.setContentType("image/png");
                    while ((len = is.read(b)) > 0) {
                        response.getOutputStream().write(b, 0, len);
                    }
                    is.close();
                }catch (Exception e){

                }
            }
        }
    }
}
