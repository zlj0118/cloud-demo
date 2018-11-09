package com.shopping.dev.shiro;
import com.shopping.dev.utils.JwtUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.springframework.stereotype.Component;

/**
 * @author:毕胜朋
 * @date:2018/11/6 9:44
 */
@Component
public class JwtRealm extends SimpleRealm {
    @Override
    public String getName() {
        return "jwtRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return  token instanceof  JwtToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String jwtToken = (String) token.getPrincipal();
        try {
            String newToken = JwtUtils.autoRequire(jwtToken);
            SimpleAuthenticationInfo info =
                    new SimpleAuthenticationInfo(newToken,newToken,getName());
            return info;
        } catch (Exception e) {
            throw new AuthenticationException("请从新登录");

        }

    }
}
