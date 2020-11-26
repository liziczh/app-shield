package com.liziczh.app.shield.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liziczh.app.shield.api.entity.TAppInfo;
import com.liziczh.app.shield.api.service.AESService;
import com.liziczh.app.shield.api.utils.AESUtils;
import com.liziczh.app.shield.internal.service.AppInfoCommonService;

import lombok.extern.slf4j.Slf4j;

/**
 * Demo服务
 * @author zhehao.chen
 */
@Slf4j
@Service
public class AESServiceImpl implements AESService {
	@Autowired
	private AppInfoCommonService appInfoCommonService;

	@Override
	public String aesEncrypt(String from, String appKey, String sourceData) {
		TAppInfo appInfo = appInfoCommonService.getAppInfoByFromAndAppKey(from, appKey);
		return AESUtils.aesEncrypt(sourceData, appInfo.getAesKey());
	}
	@Override
	public String aesDecrypt(String from, String appKey, String encryptedData) {
		TAppInfo appInfo = appInfoCommonService.getAppInfoByFromAndAppKey(from, appKey);
		return AESUtils.aesDecrypt(encryptedData, appInfo.getAesKey());
	}
}
