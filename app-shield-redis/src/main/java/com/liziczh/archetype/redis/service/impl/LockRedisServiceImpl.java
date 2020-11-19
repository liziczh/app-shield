package com.liziczh.archetype.redis.service.impl;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.liziczh.archetype.redis.service.LockRedisService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhehao.chen
 */
@Slf4j
@Service
public class LockRedisServiceImpl implements LockRedisService {
	@Resource(name = "redisCustomTemplate")
	private RedisTemplate redisTemplate;

	@Override
	public boolean lock(String key) {
		return redisTemplate.opsForValue().setIfAbsent(key, key, 30, TimeUnit.SECONDS);
	}
	@Override
	public void unlock(String key) {
		redisTemplate.delete(key);
	}
}
