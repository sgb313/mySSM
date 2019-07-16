package com.sgb.controller;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class isNullInterceptor implements HandlerInterceptor {
    @Override

    public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("password");
        if((username.equals("")||username==null)||(password.equals("")||password==null)){
            System.out.println("isNullInterceptor");
            request.setAttribute("err","不能为空");
            request.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(request,response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
