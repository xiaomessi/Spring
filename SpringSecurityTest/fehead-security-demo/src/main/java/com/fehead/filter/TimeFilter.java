package com.fehead.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Created by xiaoaxiao on 2019/6/24
 * Description: 定义一个过滤器，实现对所有Controller层访问的过滤
 */
//@Component
public class TimeFilter implements Filter {

    @Override
    /**
     * 在启动spring容器时就会加载
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("time filter start");
        long start = new Date().getTime();
        // 这个方法相当于是启动调用的方法
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("time filter 耗时:"+(new Date().getTime()-start)+"ms");
        System.out.println("time filter finish");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }
}
