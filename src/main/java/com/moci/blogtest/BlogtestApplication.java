package com.moci.blogtest;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.moci.blogtest.dao")
public class BlogtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogtestApplication.class, args);
	}
}
