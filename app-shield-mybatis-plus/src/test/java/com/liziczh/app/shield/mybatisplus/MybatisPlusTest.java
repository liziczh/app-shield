package com.liziczh.app.shield.mybatisplus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = MybatisPlusApplication.class)
@SpringBootTest
@ActiveProfiles("test")
public class MybatisPlusTest {
	@Test
	public void selectByConditionTest() {
	}
	@Test
	public void getAllTest() {
	}
	@Test
	public void insertDemoTest() {
	}
	@Test
	public void updateDemoTest() {
	}
	@Test
	public void getDemoTest() {
	}
	@Test
	public void delDemoTest() {
	}
}
