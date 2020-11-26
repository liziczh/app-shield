package com.liziczh.app.shield.internal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liziczh.app.shield.redis.RedisApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = RedisApplication.class)
@SpringBootTest
@ActiveProfiles("test")
public class InternalTest {
	@Test
	void contextLoads() {
	}
}
