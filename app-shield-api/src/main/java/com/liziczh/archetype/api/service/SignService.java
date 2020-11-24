package com.liziczh.archetype.api.service;

import java.util.Map;

import com.liziczh.base.common.service.BaseService;

/**
 * 数字签名服务
 * @author zhehao.chen
 */
public interface SignService extends BaseService {
	/**
	 * 生成签名
	 * @param paramMap 参数Map
	 * @param cipher 密钥
	 * @return sign
	 */
	String generateSign(Map<String, Object> paramMap, String cipher);
	/**
	 * 校验签名
	 * @param paramMap 参数Map
	 * @param cipher 密钥
	 * @param sign 数字签名
	 * @return 签名校验结果
	 */
	Boolean checkSign(Map<String, Object> paramMap, String cipher, String sign);
}
