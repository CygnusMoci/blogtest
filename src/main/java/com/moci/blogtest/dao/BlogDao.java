package com.moci.blogtest.dao;

import com.moci.blogtest.entity.Blog;
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
    @Select("select * from" +
            "t_blog" +
            "where id=#{id}")
    Blog getBlogTypeById(Integer id);


    /**
     * 获取博客文章主体
     * @return
     */
    @Select("select t1.*,t2.type_name,date_format(t1.release_date,'%Y-%m-%d %h:%i') as releaseDateBlog\n" +
            "\t\tfrom\n" +
            "\t\tt_blog t1,t_blogtype t2\n" +
            "\t\twhere t1.type_id = t2.id\n" +
            "\t\torder by\n" +
            "\t\tt1.id desc")
    List<Blog> getBlogArticle();

    /**
     * 按查询参数查询博客
     * @param searchParam
     * @return
     */
    List<Blog> searchBlog(String searchParam);

}
