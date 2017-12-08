package com.moci.blogtest.controller;

import com.moci.blogtest.entity.Blog;
import com.moci.blogtest.entity.Test;
import com.moci.blogtest.service.BlogService;
import com.moci.blogtest.utils.Commons;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author moci
 * @create 2017-12-06 3:04 PM
 **/
@Controller
public class TestController {

    @Resource
    BlogService blogService;
    @Resource
    Commons commons;

    @RequestMapping("/test")
    public String test(Model model, String test){
        Test test1 = new Test();
        test1.setName("哈哈哈哈哈哈");
        model.addAttribute("test1",test1);
        model.addAttribute("commons",commons);
        List<Blog> blogs = blogService.selectAll();
        System.out.println(blogs.get(2));
        System.out.println("************T E S T**************");
        return "test";
    }
}
