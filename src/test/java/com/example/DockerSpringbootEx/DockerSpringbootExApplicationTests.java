package com.example.DockerSpringbootEx;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ALL)
class DockerSpringbootExApplicationTests {

	@Test
	void contextLoads() {
	}

}
