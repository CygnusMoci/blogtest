package com.moci.blogtest.controller;

import com.github.pagehelper.PageHelper;
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
    public String index(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                        @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                        Model model) {

        return "index";
    }
}
