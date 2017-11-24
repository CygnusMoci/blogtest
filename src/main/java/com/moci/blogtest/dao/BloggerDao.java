package com.moci.blogtest.dao;

import com.moci.blogtest.entity.Blogger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moci
 * @create 2017-11-24 3:17 PM
 **/

@RestController
@Mapper
public interface BloggerDao {

    /**
     * 根据用户名查询
     * @param username
     * @return
     */

    @Select("select * from t_blogger where USERNAME = #{USERNAME}")
    Blogger selectByUsername(String username);

    @Select("select * from t_blogger where id = #{id}")
    Blogger selectById(Integer id);
}