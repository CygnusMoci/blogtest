package com.moci.blogtest.service;

import com.moci.blogtest.entity.Blogger;

import java.util.List;

/**
 * @author moci
 * @create 2017-11-24 3:20 PM
 **/
public interface BloggerService {
    Blogger findByUsername(String username);
    Blogger findByUserId(Integer id);

}
