package com.shopping.dev.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:毕胜朋
 * @date:2018/11/1 15:45
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println("LoginInterceptor.preHandle");
        return  true;
//        String token = request.getHeader("Authentication");
//        try {
////            String newToken = JwtUtils.autoRequire(token);
//            JwtToken jwtToken = new JwtToken(token);
//            SecurityUtils.getSubject().login(jwtToken);
//            String newToken = (String) SecurityUtils.getSubject().getPrincipal();
//            response.addHeader("Authentication", newToken);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw  new NullPointerException("请重新登录");
//        }
    }
}