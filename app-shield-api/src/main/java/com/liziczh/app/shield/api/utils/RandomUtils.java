package com.liziczh.app.shield.api.utils;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;

/**
 * 随机字符串
 * @author zhehao.chen
 */
@Slf4j
public class RandomUtils {
	private static final String LETTER_POOL = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String NUMBER_POOL = "0123456789";

	/**
	 * 随机字符串
	 * @param size 数量
	 * @return 随机串
	 */
	private String randomString(int size, String charPool) {
		String allChar = LETTER_POOL + NUMBER_POOL;
		StringBuilder stringBuilder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			stringBuilder.append(allChar.charAt(random.nextInt() % allChar.length()));
		}
		return stringBuilder.toString();
	}
}
