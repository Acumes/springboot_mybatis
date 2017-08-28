package com.htf.shiro;

import org.apache.shiro.authc.AuthenticationToken;

import java.util.Objects;

/**
 * Created by PC-FENG on 2017/8/28.
 */
public class LoginToken implements AuthenticationToken {
    private static final long serialVersionUID = 1L;

    private String username;
    public LoginToken(String username){
        Objects.requireNonNull(username);
        this.username = username;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public Object getCredentials() {
        return "";
    }
}
