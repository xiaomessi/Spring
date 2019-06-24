package com.fehead.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by xiaoaxiao on 2019/6/24
 * Description:
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

    @Override
    /**
     * 调用控制器中的方法前
     * 若返回false，则不执行控制器方法以及其他两个方法
     * 若返回true，进入控制器方法
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        System.out.println("preHandle");

        // 获取对应控制器的类名
        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        // 获取对应控制器的方法名
        System.out.println(((HandlerMethod)handler).getMethod().getName());

        // 设置开始时间，由于和结束方法没在一个方法内，所以只能使用request.attribute
        httpServletRequest.setAttribute("start",new Date().getTime());
        return true;
    }

    @Override
    /**
     * 调用控制器中的方法后，若该方法抛出异常则不执行
     *
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        long start = (long) httpServletRequest.getAttribute("start");
        System.out.println("time interceptor 耗时："+(new Date().getTime()-start));
    }

    @Override
    /**
     * 调用控制器中的方法的最后，无论抛不抛异常都会执行
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) throws Exception {
        System.out.println("afterCompletion");
        long start = (long) httpServletRequest.getAttribute("start");
        System.out.println("time method 耗时："+(new Date().getTime()-start));
        System.out.println("ex is "+ex);
    }
}
