package com.shopping.dev.interceptor;
import com.shopping.dev.shiro.JwtToken;
import org.apache.shiro.SecurityUtils;
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
        String token = request.getHeader("Authentication");
        try {
//            String newToken = JwtUtils.autoRequire(token);
            JwtToken jwtToken = new JwtToken(token);
            SecurityUtils.getSubject().login(jwtToken);
            String newToken = (String) SecurityUtils.getSubject().getPrincipal();
            response.addHeader("Authentication", newToken);
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            throw  new NullPointerException("请重新登录");
        }
    }
}
