package com.amayadream.webchat.web.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Amayadream
 * @date :   2017-05-26 18:11
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("e", e);
        if(e instanceof AuthorizationException){
            model.put("overtime", true);
            String uri = request.getRequestURI().substring(request.getContextPath().length());
            return new ModelAndView("redirect:/auth/login?target=" + uri, model);
        } else if(e instanceof UndeclaredThrowableException){   //这里造成这个异常的原因是切面代理里抛出的异常但是被切的方法并没有抛这个异常,所以jdk无法识别异常
            UndeclaredThrowableException exception = (UndeclaredThrowableException) e;
            model.put("button", "close");
            model.put("e", exception.getUndeclaredThrowable());
            return new ModelAndView("error", model);
        } else {
            return new ModelAndView("error", model);
        }
    }


}
