package com.moci.blogtest.controller;

import com.moci.blogtest.entity.BO.RestResponseBo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.moci.blogtest.service.BloggerService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author moci
 * @create 2017-11-24 4:21 PM
 **/
@Controller
public class BloggerController {
    @Autowired
    @Qualifier("bloggerService")
    private BloggerService bloggerService;

    @GetMapping("/login")
    public String login(){
        return "/themes/login";
    }


    @PostMapping("/login")
    @ResponseBody
    public RestResponseBo login(@RequestParam(name ="username",required=false) String username,
                                @RequestParam(name = "password",required=false) String password,
                                Model model,
                                RedirectAttributes redirectAttributes) {
        Subject subject = SecurityUtils.getSubject();

        System.out.println("*******************登陆页面*******************");
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        System.out.println(token.getPassword());
        try {
            subject.login(token);// 会交给MyRealm中的doGetAuthenticationInfo方法去验证
            redirectAttributes.addFlashAttribute("username",username);
            return RestResponseBo.ok();//重定向到此路径，进入后台管理系统。
        } catch (AuthenticationException e) {
            e.printStackTrace();
            model.addAttribute("message", "用户名或密码错误");
            return RestResponseBo.fail();//返回登录视图
        }
    }

    @GetMapping("/logout")
    public String logout(){
        System.out.println("退出登陆");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/themes/login";
    }
}
