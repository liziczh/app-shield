package com.liziczh.app.shield.api.common;

public class Constants {
	public static final String SYS_CODE = "app-shield";
	public static final String SYS_USER = "app-shield";
	/**
	 * 通用状态
	 */
	public static enum COMMON_STATUS {
		VALID("0", "正常"),
		INVALID("1", "失效");

		private String code;
		private String name;

		private COMMON_STATUS(String code, String name) {
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
