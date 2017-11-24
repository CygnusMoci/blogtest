package com.moci.blogtest;

import com.moci.blogtest.service.BloggerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

}
