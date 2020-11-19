package com.liziczh.archetype.redis.common;

/**
 * @author zhehao.chen
 */
public class RedisConstants {
	public static enum CACHE_KEY {
		KEY("KEY:", "正常");

		private String code;
		private String name;

		private CACHE_KEY(String code, String name) {
			this.code = code;
			this.name = name;
		}
		public String getCode() {
			return code;
		}
		public String getName() {
			return name;
		}
	}
}
