package com.liziczh.archetype.redis.service;

public interface DemoRedisService {
	/**
	 * 缓存<K,V>
	 * @param key
	 * @param value
	 */
	void setValue(String key, String value);
	/**
	 * 获取value
	 * @param key
	 * @return
	 */
	String getValue(String key);
	/**
	 * 是否存在key
	 * @param key
	 * @return
	 */
	Boolean hasKey(String key);
	/**
	 * 删除key
	 * @param key
	 */
	void delKey(String key);
}
