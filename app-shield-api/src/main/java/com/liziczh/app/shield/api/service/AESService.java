package com.liziczh.app.shield.api.service;

import com.liziczh.base.common.service.BaseService;

/**
 * AES加解密服务
 * @author zhehao.chen
 */
public interface AESService extends BaseService {
	/**
	 * AES加密
	 * @param from 请求来源
	 * @param appKey app key
	 * @param sourceData 源数据
	 * @return 加密数据
	 */
	String aesEncrypt(String from, String appKey, String sourceData);
	/**
	 * AES解密
	 * @param from 请求来源
	 * @param appKey app key
	 * @param encryptedData 加密数据
	 * @return 源数据
	 */
	String aesDecrypt(String from, String appKey, String encryptedData);
}
