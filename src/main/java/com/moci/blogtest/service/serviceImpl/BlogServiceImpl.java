package com.moci.blogtest.service.serviceImpl;

import com.moci.blogtest.dao.BlogDao;
import com.moci.blogtest.entity.Blog;
import com.moci.blogtest.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author moci
 * @create 2017-11-28 1:56 PM
 **/
@Service("blogService")
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogDao blogDao;

    @Override
    public Blog findById (Integer id){
        return blogDao.selectById(id);
    }

    @Override
    public Blog getBlogTypeById(Integer id) {
        return blogDao.getBlogTypeById(id);
    }


    @Override
    public List<Blog> getBlogArticle() {
        return blogDao.getBlogArticle();
    }

    @Override
    public List<Blog> searchBlog(String searchParam) {
        return blogDao.searchBlog(searchParam);
    }

}
