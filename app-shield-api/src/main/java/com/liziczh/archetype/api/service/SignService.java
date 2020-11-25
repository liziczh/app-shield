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
	 * @param from 请求来源
	 * @param appKey AppKey
	 * @param paramMap 参数Map
	 * @return sign
	 */
	String generateSign(String from, String appKey, Map<String, Object> paramMap);
	/**
	 * 校验签名
	 * @param from 请求来源
	 * @param appKey AppKey
	 * @param paramMap 参数Map
	 * @param sign 数字签名
	 * @return 签名校验结果
	 */
	Boolean checkSign(String from, String appKey, Map<String, Object> paramMap, String sign);
}
