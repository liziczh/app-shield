package com.liziczh.archetype.mybatisplus.cache;

import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;

public class MybatisRedisCache implements Cache {
	private final String cacheId;
	private final RedisTemplate<Object, Object> redisTemplate = SpringContextHolder.getBean("redisTemplate");
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	public MybatisRedisCache(final String cacheId) {
		if (cacheId == null) {
			throw new IllegalArgumentException("缓存实例ID不可为空");
		}
		this.cacheId = cacheId;
	}
	@Override
	public String getId() {
		return cacheId;
	}
	@Override
	public void putObject(Object key, Object value) {
		redisTemplate.boundHashOps(cacheId).put(key, value);
	}
	@Override
	public Object getObject(Object key) {
		return redisTemplate.boundHashOps(cacheId).get(key);
	}
	@Override
	public Object removeObject(Object key) {
		return redisTemplate.boundHashOps(cacheId).delete(key);
	}
	@Override
	public void clear() {
		redisTemplate.delete(cacheId);
	}
	@Override
	public int getSize() {
		Map<Object, Object> entries = redisTemplate.boundHashOps(cacheId).entries();
		if (entries != null) {
			return entries.size();
		} else {
			return 0;
		}
	}
	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}
}
