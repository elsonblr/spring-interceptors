package com.example.springboot.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class AuthHandlerIntercepter implements HandlerInterceptor {

    private String USER = "admin";
    private String PASSWORD = "admin";
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("AuthHandlerIntercepter::preHandle()");


        String authInfo = request.getHeader("Authorization");
        if(authInfo != null && authInfo.startsWith("Basic")) {
            String base64Creds = authInfo.substring("Basic ".length());
            byte[] decodeCreds = Base64.getDecoder().decode(base64Creds);
            String creds = new String(decodeCreds, StandardCharsets.UTF_8);
            String[] credsParts = creds.split(":");

            if (USER.equals(credsParts[0]) && PASSWORD.equals(credsParts[1])) {
                return true;
            }
        }

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UnAuthorised");
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("AuthHandlerIntercepter::postHandle()");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
        System.out.println("AuthHandlerIntercepter::afterCompletion()");
    }

}
