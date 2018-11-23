package com.shopping.dev.config;

import com.shopping.dev.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author:毕胜朋
 * @date:2018/11/1 16:22
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Override
    // 配置添加 拦截器
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/user/check");
        super.addInterceptors(registry);
    }
}
