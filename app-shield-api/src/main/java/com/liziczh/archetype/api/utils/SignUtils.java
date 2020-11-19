package com.liziczh.archetype.api.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.DigestUtils;

/**
 * 签名生成与校验
 * @author zhehao.chen
 */
public class SignUtils {
	/**
	 * 生成签名
	 * @param paramMap 参数
	 * @param cipher 密钥
	 * @return 签名
	 */
	public static String generateSign(Map<String, Object> paramMap, String cipher) {
		return DigestUtils.md5DigestAsHex(ksort(kfilter(paramMap), cipher).getBytes());
	}
	/**
	 * 签名校验
	 * @param paramMap 参数
	 * @param cipher 密钥
	 * @param sign 签名
	 * @return 签名验证结果
	 */
	public static boolean checkSign(Map<String, Object> paramMap, String cipher, String sign) {
		String from = String.valueOf(paramMap.get("from"));
		return sign.equals(generateSign(kfilter(paramMap), cipher));
	}
	/**
	 * 参数排序
	 * @param paramMap 参数
	 * @param cipher 密钥
	 * @return 参数排序串
	 */
	public static String ksort(Map<String, Object> paramMap, String cipher) {
		List<String> keys = new ArrayList<String>(paramMap.keySet());
		// 排序
		Collections.sort(keys);
		StringBuilder paramSortStr = new StringBuilder();
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = paramMap.get(key).toString();
			try {
				value = java.net.URLEncoder.encode(value, "utf-8").replace("*", "%2A");
			} catch (UnsupportedEncodingException e) {
				value = "";
			}
			paramSortStr.append(key).append("=").append(value).append("&");
		}
		paramSortStr.append("key=").append(cipher);
		return paramSortStr.toString();
	}
	/**
	 * 参数过滤
	 * @param paramMap 参数
	 * @return 过滤后的参数Map
	 */
	private static Map<String, Object> kfilter(Map<String, Object> paramMap) {
		Map<String, Object> paramFilterMap = new HashMap<>();
		for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue().toString();
			// 过滤sign参数
			if ("sign".equals(key)) {
				continue;
			}
			paramFilterMap.put(key, value);
		}
		return paramFilterMap;
	}
}
