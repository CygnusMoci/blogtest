package com.moci.blogtest.dao;

import com.moci.blogtest.entity.Blog;
import com.moci.blogtest.entity.BlogType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author moci
 * @create 2017-11-28 1:56 PM
 **/

@RestController
@Mapper
public interface BlogDao {

    /**
     * 通过ID查询博客
     * @return
     */
    @Select("select * from t_blog where id = #{id}")
    Blog selectById (Integer id);

    /**
     * 通过id查询文章种类
     * @paramkj id
     * @return
     */
    @Select("select b.* from t_blog a,t_blogtype b where a.type_id = #{id} and a.type_id = b.id")
    BlogType getBlogTypeById(Integer id);


    /**
     * 展示所有的Blog
     * @return
     */
    @Select("select * from t_blog")
    List<Blog> selectAll();


}
