package com.moci.blogtest.service.serviceImpl;

import com.moci.blogtest.dao.BloggerDao;
import com.moci.blogtest.entity.Blogger;
import com.moci.blogtest.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author moci
 * @create 2017-11-24 3:22 PM
 **/
@Service("BloggerService")
public class BloggerServiceImpl implements BloggerService {

    @Autowired
    BloggerDao bloggerDao;

    @Override
    public Blogger findByUsername(String username) {
        return bloggerDao.selectByUsername(username);
    }

    public Blogger findByUserId(Integer id){
        return bloggerDao.selectById(id);
    }

}
