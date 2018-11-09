package com.shopping.dev.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author:毕胜朋
 * @date:2018/11/2 16:22
 */
public class SimpleUsernameToken  implements AuthenticationToken {

    private String username;
    private String password;

    public SimpleUsernameToken() {
    }

    public SimpleUsernameToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public Object getCredentials() {
        return password;
    }
}
