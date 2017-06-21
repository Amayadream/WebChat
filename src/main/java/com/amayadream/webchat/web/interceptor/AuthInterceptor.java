package com.amayadream.webchat.web.interceptor;

import com.amayadream.webchat.common.util.Constants;
import com.amayadream.webchat.web.exception.AuthorizationException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2017.06.20 21:09
 */
public class AuthInterceptor implements HandlerInterceptor {


    private List<String> excludedUrls;  //排除URI(精确)
    private List<String> excludedRegex; //排除URI(前缀匹配)

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        HttpSession session = request.getSession();

        //获取URI后缀
        String requestUri = request.getServletPath();

//        if(requestUri.equalsIgnoreCase("/"))    return true;

        //首段匹配排除拦截地址
        for(String uri : excludedRegex){
            if (requestUri.startsWith(uri)) {
                return true;
            }
        }

        //过滤不需要拦截的地址
        for (String uri : excludedUrls) {
            if (requestUri.startsWith(uri)) {
                return true;
            }
        }

        //登录拦截器
        if (session.getAttribute(Constants.SESSION_USERID) == null) {
            throw new AuthorizationException();
        }

        //通过
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

    public void setExcludedRegex(List<String> excludedRegex) {
        this.excludedRegex = excludedRegex;
    }

}
