package com.liziczh.archetype.ref;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = RefApplication.class)
@SpringBootTest
@ActiveProfiles("test")
class RefTest {
	@Test
	void contextLoads() {
	}
}
