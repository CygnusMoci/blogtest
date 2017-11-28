package com.moci.blogtest;

import com.moci.blogtest.service.BlogTypeService;
import com.moci.blogtest.service.BloggerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogtestApplicationTests {

	@Autowired
	BloggerService bloggerService;

	@Test
	public void testSelectByUsername() {
		System.out.println(bloggerService.findByUsername("moci"));
		System.out.println(bloggerService.findByUserId(1));
	}

	@Autowired
	@Qualifier("blogTypeService")
	private BlogTypeService blogTypeService;

	@Test
	public void testGetBlogTypeData(){
		System.out.println(blogTypeService.getBlogTypeData());
	}

}
