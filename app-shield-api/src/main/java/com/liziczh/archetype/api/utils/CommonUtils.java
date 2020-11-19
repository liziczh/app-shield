package com.liziczh.archetype.api.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

/**
 * @author zhehao.chen
 */
public class CommonUtils {
	/**
	 * 逗号分隔字符串 to List
	 * @param str 逗号分隔字符串
	 * @return list
	 */
	public static List<String> string2ListByComma(String str) {
		if (StringUtils.isBlank(str)) {
			return new ArrayList<>();
		} else {
			return Arrays.asList(str.split(","));
		}
	}
	/**
	 * List to 逗号分隔字符串
	 * @param list List
	 * @return str
	 */
	public static String list2StringByComma(List<String> list) {
		if (CollectionUtils.isEmpty(list)) {
			return "";
		} else {
			StringBuilder str = new StringBuilder();
			for (String element : list) {
				str.append(element).append(",");
			}
			return str.toString();
		}
	}
}
