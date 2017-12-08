package com.moci.blogtest.controller;

import com.moci.blogtest.entity.Blogger;
import com.moci.blogtest.utils.MapCache;
import com.moci.blogtest.utils.TaleUtils;
import org.json.HTTP;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/**
 * 共同基础控制
 * @author moci
 * @create 2017-12-06 4:53 PM
 **/
public abstract class BaseController {
    public static String THEME = "themes";

    protected MapCache cache = MapCache.single(); //return1024个缓存


    /**
     * 选择页面主题 (主要用于分页(其实没用
     * @param viewName
     * @return
     */
    public String render(String viewName){
        return THEME+"/"+viewName;
    }

    public BaseController title(Model request, String title) {
        request.addAttribute("title", title);
        return this;
    }

    public BaseController keywords(Model request,String keywords){
        request.addAttribute("keywords",keywords);
        return this;
    }

    /**
     * 绑定登陆对象
     * @param request
     * @return
     */

    public Blogger blogger(HttpServletRequest request){
        return TaleUtils.getLoginUser(request);
    }



}
