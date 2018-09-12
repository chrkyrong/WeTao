package com.weitao.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by lzr on 2018/9/1.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //得到url
        String url=httpServletRequest.getRequestURI();

        //判断是否为公开的url，是则放行
        if(url.indexOf("login")>=0)
        {
            return true;
        }
        //判断用户身份在session是否存在
        HttpSession session=httpServletRequest.getSession();
        String user= (String) session.getAttribute("user");
        if(user!=null) {
            return true;
        }
        httpServletRequest.getRequestDispatcher("login.html").forward(httpServletRequest,httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
