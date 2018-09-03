package com.weitao.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.MarshalledObject;

/**
 * Created by lzr on 2018/9/1.
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
       CustomException customException;
        if(e instanceof  CustomException)
        {
            customException=(CustomException)e;
        }
        else
        {
            customException =new CustomException("未知错误");
        }
        String message=customException.getMessage();

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("message",message);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
