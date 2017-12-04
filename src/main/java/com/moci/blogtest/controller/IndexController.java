package com.moci.blogtest.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moci.blogtest.entity.Blog;
import com.moci.blogtest.entity.BlogType;
import com.moci.blogtest.entity.Blogger;
import com.moci.blogtest.service.BlogTypeService;
import com.moci.blogtest.service.BloggerService;
import com.moci.blogtest.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author moci
 * @create 2017-11-28 1:49 PM
 **/
@Controller
public class IndexController {
    @Autowired
    @Qualifier("bloggerService")
    private BloggerService bloggerService;// 负责博主信息

    @Autowired
    @Qualifier("blogTypeService")
    private BlogTypeService blogTypeService;

    @Autowired
    @Qualifier("blogService")
    private BlogService blogService;

    @RequestMapping("/index")
    public String index(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                        @RequestParam(required = true, defaultValue = "5") Integer pageSize,
                        Model model) {

        Blogger blogger = bloggerService.findByUsername("moci");// 因为只是自已是主人，所以直接传入名字
        List<BlogType> blogTypeList = blogTypeService.getBlogTypeData();// 获取文章类型信息
        PageHelper.startPage(pageNum, pageSize);// 默认从第一页开始，每页五条
        Blog[] blogs = new Blog[10];
        for (int i = 0; i <blogs.length ; i++) {
            blogs[i] = blogService.findById(i);
        }

        System.out.println("个人资料: " + blogger);
        System.out.println("文章类型: " + blogTypeList);

        for (int i = 0; i <blogs.length ; i++) {
            model.addAttribute("blog ["+i+"]",blogs[i]); //存入每章博客
        }

        model.addAttribute("blogger", blogger);// 存入个人资料
        model.addAttribute("blogTypeList", blogTypeList);// 存入文章类型

        return "index";
    }
}
