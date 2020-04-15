package com.project.liikunta;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.liikunta.web.SuoritusController;
import com.project.liikunta.web.UserController;

//Controllereiden smoke -testaus.

@RunWith(SpringRunner.class)
@SpringBootTest
class LiikuntaApplicationTests {
	
	@Autowired
	private SuoritusController suorcontroller;
	
	@Autowired
	private UserController usercontroller;

	@Test
	void contextLoads() throws Exception {
		assertThat(suorcontroller).isNotNull();
		assertThat(usercontroller).isNotNull();
	}
	
	
}
