package com.moci.blogtest.service;

import com.moci.blogtest.entity.BlogType;

import java.util.List;

/**
 * @author moci
 * @create 2017-11-27 3:38 PM
 **/
public interface BlogTypeService {

    /**
     * 获取博客类别信息的服务方法
     * @return
     */
    List<BlogType> getBlogTypeData();

}
