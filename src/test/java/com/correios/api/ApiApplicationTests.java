package com.correios.api;

import com.correios.api.application.ApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = ApiApplication.class)
class ApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
