package com.example.springboot;

import com.example.springboot.model.AuthHandlerIntercepter;
import com.example.springboot.model.LogHandlerIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogHandlerIntercepter()).order(2);
        registry.addInterceptor(new AuthHandlerIntercepter()).order(1).addPathPatterns("/products/new");
    }
}
