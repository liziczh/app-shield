package com.liziczh.archetype.mybatisplus;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liziczh.archetype.api.common.Constants;
import com.liziczh.archetype.api.condition.DemoCondition;
import com.liziczh.archetype.api.entity.TDemo;
import com.liziczh.archetype.mybatisplus.mapper.TDemoMapper;
import com.liziczh.base.common.util.JacksonUtils;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = MybatisPlusApplication.class)
@SpringBootTest
@ActiveProfiles("test")
public class MybatisPlusTest {
	@Autowired
	private TDemoMapper demoMapper;

	@Test
	public void selectByConditionTest() {
		DemoCondition condition = new DemoCondition();
		QueryWrapper<TDemo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().like(TDemo::getName, "");
		List<TDemo> demoList = demoMapper.selectList(queryWrapper);
		System.out.println(JacksonUtils.toJSONString(demoList));
	}
	@Test
	public void getAllTest() {
		QueryWrapper<TDemo> queryWrapper = new QueryWrapper<>();
		List<TDemo> demoList = demoMapper.selectList(queryWrapper);
		System.out.println(JacksonUtils.toJSONString(demoList));
	}
	@Test
	public void insertDemoTest() {
		TDemo entity = new TDemo();
		entity.setName("liziczh");
		entity.setCreateTime(new Date());
		entity.setCreateUser("lizi");
		entity.setValid(Constants.COMMON_STATUS.VALID.getCode());
		demoMapper.insert(entity);
	}
	@Test
	public void updateDemoTest() {
		TDemo entity = new TDemo();
		entity.setId(24);
		entity.setName("liziczh");
		entity.setUpdateTime(new Date());
		entity.setUpdateUser("lizi");
		demoMapper.updateById(entity);
	}
	@Test
	public void getDemoTest() {
		demoMapper.selectById(24);
	}
	@Test
	public void delDemoTest() {
		demoMapper.deleteById(1);
	}
}
