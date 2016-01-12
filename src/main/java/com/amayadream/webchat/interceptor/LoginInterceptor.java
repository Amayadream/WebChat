package com.amayadream.webchat.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * NAME   :  EmailSystem/com.amayadream.interceptor
 * Author :  Amayadream
 * Date   :  2015.10.06 17:33
 * TODO   :
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final String[] IGNORE_URI = {"user/login","/login","/user/logout"};  //忽略的URI
    private static final String LOGIN_URI = "/login";   //登陆URI

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        String contextPath = request.getContextPath();
        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
//                System.out.printf(url + "=>>>>>=>拦截器已自动忽略!" + "\n");
                return true;
            }
        }
        HttpSession session = request.getSession();
        if(session != null && session.getAttribute("login_status") != null){
//            System.out.printf(url + "=>>>>>拦截器=>已登录,欢迎访问!" + "\n");
            return true;
        }else{
//            System.out.printf(url + "=>>>>>拦截器=>未登录,已拦截!" + "\n");
            response.sendRedirect(contextPath + "/login?timeout=true");
            return false;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
