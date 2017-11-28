package com.moci.blogtest.service;

import com.moci.blogtest.entity.Blog;

import java.util.List;

/**
 * @author moci
 * @create 2017-11-28 1:56 PM
 **/
public interface BlogService {

    Blog findById (Integer id);
    Blog getBlogTypeById(Integer id);
    /**
     * 详情请看dao层
     * @return
     */

    List<Blog> getBlogArticle();
    List<Blog> searchBlog(String searchParam);
}
