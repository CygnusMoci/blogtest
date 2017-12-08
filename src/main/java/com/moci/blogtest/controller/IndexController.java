package com.moci.blogtest.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moci.blogtest.constant.WebConst;
import com.moci.blogtest.entity.Blog;
import com.moci.blogtest.entity.BlogType;
import com.moci.blogtest.entity.Blogger;
import com.moci.blogtest.service.BlogTypeService;
import com.moci.blogtest.service.BloggerService;
import com.moci.blogtest.service.BlogService;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * @author moci
 * @create 2017-11-28 1:49 PM
 **/
@Controller
public class IndexController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    @Qualifier("bloggerService")
    private BloggerService bloggerService;// 负责博主信息


    @Autowired
    @Qualifier("blogTypeService")
    private BlogTypeService blogTypeService;

    @Autowired
    @Qualifier("blogService")
    private BlogService blogService;


    /**
     * 首页
     * @param request
     * @param limit
     * @return
     */
    @GetMapping(value = {"index"})
    public String index(Model request, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        return this.index(request, 1, limit);
    }



    /**
     * 首页分页(虽然我只想要一页面)
     * @param request
     * @param p
     * @param limit
     * @return
     */
    @GetMapping("page/{p}")
    public String index(Model request,
                        @PathVariable int p,
                        @RequestParam(value = "limit", defaultValue = "12") int limit){
         p = p<0||p> WebConst.MAX_PAGE?1:p; //页数限定了页数P的范围
        List<Blog> blogs = blogService.selectAll();
        request.addAttribute("blogs",blogs);
        System.out.println("添加了articles请求相应");
        if (p > 1) {
            this.title(request, "第" + p + "页");
        }
        return this.render("index");
    }
}
