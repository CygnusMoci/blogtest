package com.moci.blogtest.service.serviceImpl;

import com.moci.blogtest.dao.BlogTypeDao;
import com.moci.blogtest.entity.BlogType;
import com.moci.blogtest.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author moci
 * @create 2017-11-27 3:39 PM
 **/
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

    @Autowired
    BlogTypeDao blogTypeDao;

    @Override
    public List<BlogType> getBlogTypeData() {
        return blogTypeDao.getBlogTypeData();
    }

}
