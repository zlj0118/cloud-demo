package com.shopping.dev.shiro;
import com.shopping.dev.entity.User;
import com.shopping.dev.service.LoginService;
import com.shopping.dev.utils.JwtUtils;
import com.shopping.dev.utils.ResultWrapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * @author:毕胜朋
 * @date:2018/11/2 16:27
 */
@Component
public class SimpleRealm extends AuthorizingRealm {
    @Resource
    private LoginService service;


    @Override
    public String getName() {
        return "simpleRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof SimpleUsernameToken;
    }

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 因为认证的时候存储的是userInfo对象,所以这里取出来
        // 也是userInfo对象
        // 获取登录成功时存储的主要信息
        Object principal = principals.getPrimaryPrincipal();
        // 实际上是token
        String jwtToken = (String) principal;
        // 从token信息中获取出用户id
        Integer userId = JwtUtils.getUserId(jwtToken);
        return  null;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = (String) token.getCredentials();
       ResultWrapper resultWrapper = this.service.findByUsername(username, password);
        User  user = (User) resultWrapper.getData();
        if (user != null) {
            String jwtToken = JwtUtils.newToken(user.getId());
            // 说明从数据库中能查到用户信息
            // 为了方便之后的调用, 主要信息存的是该用户的详情
            SimpleAuthenticationInfo info
                    = new SimpleAuthenticationInfo(jwtToken, password, getName());
            return info;
        }
        throw new AuthenticationException("登录失败");
    }
}
