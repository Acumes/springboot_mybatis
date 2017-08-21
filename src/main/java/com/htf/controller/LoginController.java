package com.htf.controller;

import com.htf.controller.response.ResultResponse;
import com.htf.entity.User;
import com.htf.service.MenuService;
import com.htf.service.UserService;
import com.htf.util.ShiroUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by PC-FENG on 2017/8/21.
 */
@RestController
@RequestMapping("/api")
@Api(value = "api",description = "用户登陆Controller")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "用户登录",notes = "根据用户名密码判断用户")
    @ApiImplicitParam(value = "Map",required = true,dataType = "Map")
    public ResultResponse login(@RequestBody Map<String, String> map) {
        UsernamePasswordToken token = null;
        try {
            String password = map.get("password");
            String username = map.get("username");
            Subject subject = ShiroUtils.getSubject();
            //sha256加密
            password = new Sha256Hash(password).toHex();
            token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return ResultResponse.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return ResultResponse.error(e.getMessage());
        } catch (LockedAccountException e) {
            return ResultResponse.error(e.getMessage());
        }
        return ResultResponse.ok();
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ApiOperation(value = "用户退出",notes = "用户退出")
    public ResultResponse logout() {
        ShiroUtils.logout();
        return ResultResponse.ok();
    }

    @RequestMapping(value = "/getCurrentUser",method = RequestMethod.GET)
    @ApiOperation(value = "当前用户",notes = "当前用户")
    public User getCurrentUser() {
        User user = ShiroUtils.getUser();
        if(user == null){
            user = new User();
            user.setId("asdasdsa");
        }
        return user;
    }



}
