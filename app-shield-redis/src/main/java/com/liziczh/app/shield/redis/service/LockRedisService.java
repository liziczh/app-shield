package com.liziczh.app.shield.redis.service;

/**
 * @author zhehao.chen
 */
public interface LockRedisService {
	/**
	 * 加锁
	 * @param key
	 * @return
	 */
	boolean lock(String key);
	/**
	 * 解锁
	 * @param key
	 */
	void unlock(String key);
}
