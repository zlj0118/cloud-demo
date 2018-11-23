package com.shopping.dev.config;

import com.shopping.dev.shiro.JwtRealm;
import com.shopping.dev.shiro.SimpleRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author:毕胜朋
 * @date:2018/11/2 20:18
 */
@Configuration
public class ShiroConfig {
    @Resource
    private SimpleRealm simpleRealm;
    @Resource
    private JwtRealm jwtRealm;

    @Bean
    public SecurityManager securityManager() {
        List<Realm> realms = Arrays.asList(simpleRealm, jwtRealm);
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealms(realms);
        securityManager.setSessionManager(new DefaultSessionManager());
        SecurityUtils.setSecurityManager(securityManager);
        return securityManager;
    }
}
