package com.htf.conf;

import com.htf.entity.User;
import com.htf.exception.ExceptionResponse;
import com.htf.service.MenuService;
import com.htf.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by oukingtim
 */
@Component
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    /**
     * @Author : oukingtim
     * @Description : 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User)principalCollection.getPrimaryPrincipal();
        String userId = user.getId();

        //用户权限列表
        Set<String> permsSet = menuService.getPermissions(userId);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * @Author : oukingtim
     * @Description : 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());

        //查询用户信息
        User user = userService.findByUserName(username);
//
//        //账号不存在
//        if(user == null) {
//            throw new ExceptionResponse("用户名不正确");
//        }
//
//        //密码错误
//        if(!password.equals(user.getPassword())) {
//            throw new ExceptionResponse("密码不正确");
//        }
//
//        //账号禁用
//        if("0".equals(user.getStatus())){
//            throw new ExceptionResponse("用户已被禁用,请联系管理员");
//        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }

}
