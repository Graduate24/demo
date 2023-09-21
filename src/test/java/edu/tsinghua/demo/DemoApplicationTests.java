package edu.tsinghua.demo;

import edu.tsinghua.demo.controller.Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private Controller controller;


	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
