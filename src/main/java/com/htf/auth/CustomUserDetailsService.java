package com.htf.auth;

import com.htf.entity.User;
import com.htf.service.MenuService;
import com.htf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by PC-FENG on 2017/8/23.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //SUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        //本例使用SUser中的email作为用户名:
        User user = userService.findByUserName(userName);

        if (user == null) {
            throw new UsernameNotFoundException("UserName " + userName + " not found");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if("admin".equals(user.getUsername())){
            authorities.add(new SimpleGrantedAuthority("admin"));
        }else{
            authorities.add(new SimpleGrantedAuthority("user"));
        }
//        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
//        Set<String> set =  menuService.getPermissions(user.getId());
////        while (iterator.hasNext()){
////        }
//        if(set.size() > 0){
//            for(String s : set){
//                collection.add(new SimpleGrantedAuthority("ROLE_" + s));
//            }
//        }
        // SecurityUser实现UserDetails并将SUser的Email映射为username
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), authorities);

    }
}
