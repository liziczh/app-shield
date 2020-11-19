package com.liziczh.archetype.redis.service.impl;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.liziczh.archetype.redis.service.DemoRedisService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DemoRedisServiceImpl implements DemoRedisService {
	@Resource(name = "redisCustomStringTemplate")
	private StringRedisTemplate stringRedisTemplate;
	@Resource(name = "redisCustomTemplate")
	private RedisTemplate<String, Serializable> redisTemplate;

	@Override
	public void setValue(String key, String value) {
		stringRedisTemplate.opsForValue().set(key, value, 1, TimeUnit.HOURS);
	}
	@Override
	public String getValue(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}
	@Override
	public Boolean hasKey(String key) {
		return stringRedisTemplate.hasKey(key);
	}
	@Override
	public void delKey(String key) {
		stringRedisTemplate.delete(key);
	}
}
