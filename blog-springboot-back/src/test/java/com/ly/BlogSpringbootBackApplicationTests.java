package com.ly;

import com.ly.dao.TypeRepository;
import com.ly.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogSpringbootBackApplicationTests {

	@Autowired
	private TypeRepository typeService;
	@Test
	void contextLoads() {
		System.out.println(typeService.findByName("22222"));
	}

}
