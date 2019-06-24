package com.fehead.config;

import com.fehead.filter.TimeFilter;
import com.fehead.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

/**
 * Created by xiaoaxiao on 2019/6/24
 * Description: 设置一个Spring的配置类，在类中配置Filter、Interceptor，用于将第三方配置文件加入到Spring容器中
 */
// 声明该类配置类
@Configuration
// 继承WebMvcConfigurerAdapter，完成拦截器的相关配置
public class WebConfig extends WebMvcConfigurerAdapter {

    // 添加已经配置好的拦截器
    @Autowired
    private TimeInterceptor timeInterceptor;

    //配置过滤器
    @Bean
    public FilterRegistrationBean timeFilter(){

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);

        return registrationBean;
    }

    //配置拦截器

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(timeInterceptor);
    }
}
