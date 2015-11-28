package com.szmt.sec.myHandlerInterceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2015-11-12.
 */
public class MyHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
       String url=httpServletRequest.getRequestURI();
        if(url.contains("Login")||url.contains("Regist")){
            return true;
        }
        if(httpServletRequest.getSession().getAttribute("uname")!=null){
            return true;
        }
        httpServletRequest.setAttribute("errorMsg","请您先登录！");
        httpServletRequest.getRequestDispatcher("Login.jsp").forward(httpServletRequest,httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
