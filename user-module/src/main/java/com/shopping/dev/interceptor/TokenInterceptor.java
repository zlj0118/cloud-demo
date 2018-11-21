package com.shopping.dev.interceptor;

import com.shopping.dev.shiro.JwtToken;
import com.shopping.dev.utils.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:毕胜朋
 * @date:2018/11/1 15:45
 */
public class TokenInterceptor implements HandlerInterceptor {
    @Resource
    private RedisTemplate redisTemplate;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        System.out.println("TokenInterceptor.preHandle");
//        return  true;
        String token = request.getHeader("Authentication");
        System.out.println("i token" + token);

        JwtToken jwtToken = new JwtToken(token);
        SecurityUtils.getSubject().login(jwtToken);
        String newToken = (String) SecurityUtils.getSubject().getPrincipal();
        response.addHeader("Authentication", newToken);
        return true;
    }
}
