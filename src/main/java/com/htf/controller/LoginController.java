package com.htf.controller;

import com.htf.controller.response.ResultResponse;
import com.htf.entity.User;
import com.htf.exception.ExceptionResponse;
import com.htf.service.CacheService;
import com.htf.service.MenuService;
import com.htf.service.UserService;
import com.htf.util.ImgValidateCode;
import com.htf.util.ShiroUtils;
import com.htf.util.UUIDGenerator;
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
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "用户登录",notes = "根据用户名密码判断用户")
    @ApiImplicitParam(value = "Map",required = true,dataType = "Map")
    public Map<String,Object> login(@RequestBody Map<String, String> map) {
        Map<String , Object> resurt = new HashMap<>();
        UsernamePasswordToken token = null;

            String username = map.get("username");
            //sha256加密
            String password = new Sha256Hash(map.get("password")).toHex();
            User user = userService.findByUserName(username);
//      账号不存在
        if(user == null) {
            throw new ExceptionResponse("用户名不正确");
        }
        //密码错误
        if(!password.equals(user.getPassword())) {
            throw new ExceptionResponse("密码不正确");
        }
        //账号禁用
        if("0".equals(user.getStatus())){
            throw new ExceptionResponse("用户已被禁用,请联系管理员");
        }
        try {
            Subject subject = ShiroUtils.getSubject();
            token = new UsernamePasswordToken(username, password);
            String uuid = UUIDGenerator.creatUUID();
            resurt.put("uuid",uuid);
            resurt.put("status","200");
            cacheService.setValue(uuid,uuid + "_" + user.getId() + "_" + user.getUsername() + "_" + user.getPassword());
            subject.login(token);
        }catch (Exception e){
            System.out.println(e);
        }
        return resurt;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ApiOperation(value = "用户退出",notes = "用户退出")
    public ResultResponse logout() {
        ShiroUtils.logout();
        return ResultResponse.ok();
    }

    //test
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

    @RequestMapping(value = "/loginVerImg", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> loginVerImg(HttpServletRequest request, HttpSession session) {
        ImgValidateCode vCode = new ImgValidateCode(120, 30, 4, 10);

        String handle = UUIDGenerator.creatUUID();
//        cacheService.setValue(handle, vCode.getCode());

        // 图片加密返回字符串，data-url展示
        BufferedImage imgbuf = vCode.getBuffImg();
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        try {
            ImageIO.write(imgbuf, "png", os);
            BASE64Encoder encoder = new BASE64Encoder();
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("src", "data:image/png;base64," + encoder.encode(os.toByteArray()).replace("\r\n", ""));
            resultMap.put("handle", handle);
            return resultMap;
        } catch (IOException e) {
            throw new ExceptionResponse("验证码生成失败", e);
        }
    }
}
