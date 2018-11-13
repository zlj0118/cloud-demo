package com.shopping.dev.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:毕胜朋
 * @date:2018/11/1 20:21
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView mv = new ModelAndView();
        if (ex instanceof NullPointerException) {
            mv.setView(new MappingJackson2JsonView());
            mv.addObject("status", false);
            mv.addObject("code", 401);
            mv.addObject("message", ex.getMessage());
        }
        return mv;
    }
}
