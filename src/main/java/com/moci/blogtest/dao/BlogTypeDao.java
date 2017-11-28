package com.moci.blogtest.dao;

import com.moci.blogtest.entity.BlogType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author moci
 * @create 2017-11-27 2:57 PM
 **/
@RestController
@Mapper
public interface BlogTypeDao {

    //获取博客类别信息
    @Select("select " +
            "t2.*," +
            "COUNT(t1.id) AS blogTypeCount " +
            "from t_blog t1 " +
            "join t_blogtype t2 " +
            "on t1.type_id = t2.id " +
            "GROUP BY t2.type_name " +
            "ORDER BY t2.order_num")
    List<BlogType> getBlogTypeData();
    @Select("select * from" +
            "t_blog" +
            "where id=#{id}")
    BlogTypeDao getBlogTypeById(Integer id);

}
