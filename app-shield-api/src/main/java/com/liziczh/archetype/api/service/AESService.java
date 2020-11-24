package com.liziczh.archetype.api.service;

import com.liziczh.base.common.service.BaseService;

/**
 * AES加解密服务
 * @author zhehao.chen
 */
public interface AESService extends BaseService {
	/**
	 * AES加密
	 * @param data 数据
	 * @param aesKey AES密钥
	 * @return 加密数据
	 */
	String aesEncrypt(String data, String aesKey);
	/**
	 * AES解密
	 * @param data 加密数据
	 * @param aesKey AES密钥
	 * @return 解密数据
	 */
	String aesDecrypt(String data, String aesKey);
}
