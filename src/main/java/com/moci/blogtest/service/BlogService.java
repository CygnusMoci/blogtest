package com.moci.blogtest.service;

import com.moci.blogtest.entity.Blog;
import com.moci.blogtest.entity.BlogType;

import java.util.List;

/**
 * @author moci
 * @create 2017-11-28 1:56 PM
 **/
public interface BlogService {

    Blog findById (Integer id);
    BlogType getBlogTypeById(Integer id);

}
