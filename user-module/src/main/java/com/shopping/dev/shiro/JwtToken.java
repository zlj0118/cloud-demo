package com.shopping.dev.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author:毕胜朋
 * @date:2018/11/6 9:42
 */
public class JwtToken implements AuthenticationToken {

    public JwtToken(String token) {
        this.token = token;
    }

    private String token;

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
