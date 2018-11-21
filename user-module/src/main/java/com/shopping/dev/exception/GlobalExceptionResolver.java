package com.shopping.dev.exception;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.OffsetDateTime;

/**
 * @author:毕胜朋
 * @date:2018/11/1 20:21
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 打印错误信息
        ex.printStackTrace();
        ModelAndView mv = new ModelAndView();
        if (ex instanceof AuthenticationException) {
            mv.setView(new MappingJackson2JsonView());
            mv.addObject("status", false);
            mv.addObject("code", 401);
            mv.addObject("message", "账户名或密码错误");
        }
        return mv;
    }
}
