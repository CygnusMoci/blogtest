package com.moci.blogtest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author moci
 * @create 2017-11-24 4:27 PM
 * 管理页面跳转
 **/
@Configuration
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");//首页
        registry.addViewController("/login").setViewName("login");//登录页面
        registry.addViewController("/admin/main").setViewName("admin/main");//后台管理的主页
    }
}
