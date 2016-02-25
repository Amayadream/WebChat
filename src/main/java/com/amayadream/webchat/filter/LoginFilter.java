package com.amayadream.webchat.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * NAME   :  EmailSystem/com.amayadream.filter
 * Author :  Amayadream
 * Date   :  2015.10.06 22:28
 * TODO   :
 */
public class LoginFilter extends OncePerRequestFilter {
    private static final String LOGIN_URI = "/login";
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String[] notFilter = new String[] { "login","login.jsp","user/logout","user/login" };  // 不过滤的uri
        String contextPath = request.getContextPath();  //主路径
        String uri = request.getRequestURI();   // 请求的uri
        // uri中包含jsp时才进行过滤
        if (uri.indexOf("jsp") != -1) {
            // 是否过滤
            boolean doFilter = true;
            for (String s : notFilter) {
                if (uri.indexOf(s) != -1) {
                    // 如果uri中包含不过滤的uri，则不进行过滤
                    doFilter = false;
                    break;
                }
            }
            if (doFilter) {
                // 执行过滤
                if (null == request.getSession().getAttribute("login_status")) {
//                    System.out.println(uri+">>>>>>>=>过滤器执行过滤");
                    response.sendRedirect(contextPath + "/login?timeout=true");
                } else {
                    // 如果session中存在登录者实体，则继续
//                    System.out.println(uri+">>>>>>>=>过滤器=>已登录");
                    filterChain.doFilter(request, response);
                }
            } else {
                // 如果不执行过滤，则继续
//                System.out.println(uri+">>>>>>>=>过滤器自动忽略");
                filterChain.doFilter(request, response);
            }
        } else {
            // 如果uri中不包含jsp，则继续
            filterChain.doFilter(request, response);
        }
    }


}
