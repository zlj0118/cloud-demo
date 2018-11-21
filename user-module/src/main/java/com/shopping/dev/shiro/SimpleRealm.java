package com.shopping.dev.shiro;

import com.shopping.dev.entity.User;
import com.shopping.dev.service.UserService;
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
    private UserService service;


    @Override
    public String getName() {
        return "simpleRealm";
    }

    /**
     * 用来判断自定义的realm是否支持某个token
     * 前提：在登录的时候， 需要调用login方法，并传递一个token对象
     * 如果把该realm设置给securityManager, 那么使用shiro登录时候
     * 登录的逻辑就在该realm里。
     * 所以需要判断， 该realm是否可以处理login时传递的token
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof SimpleUsernameToken;
    }

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 应该做的事:
        // 去数据库查询当前登录的用户的所有角色和权限


        // 因为认证的时候存储的是userInfo对象,所以这里取出来
        // 也是userInfo对象
//      SecurityUtils.getSubject().getPrincipal();
        // 获取登录成功时存储的主要信息
        Object principal = principals.getPrimaryPrincipal();
        // 实际上是token
        String jwtToken = (String) principal;
        // 从token信息中获取出用户id
        Integer userId = JwtUtils.getUserId(jwtToken);

        return null;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        User user = new User();
        // 拿到用户名
        String username = (String) token.getPrincipal();
        // 密码
        String password = (String) token.getCredentials();

        user.setUsername(username);
        user.setPassword(password);
        // 查询数据库
        User user1 = this.service.findByUsername(user);

        if (user1 != null) {

            String jwtToken = JwtUtils.newToken(user.getId());
            // 说明从数据库中能查到用户信息
            // 为了方便之后的调用, 主要信息存的是该用户的详情
            // 认证信息 配置
            // 登录失败
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(jwtToken, password, getName());
            return info;
        }

        throw new AuthenticationException("登录失败");
    }
}
