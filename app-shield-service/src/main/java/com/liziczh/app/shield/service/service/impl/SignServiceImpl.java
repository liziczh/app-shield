package com.liziczh.app.shield.service.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liziczh.app.shield.api.entity.TAppInfo;
import com.liziczh.app.shield.api.service.SignService;
import com.liziczh.app.shield.api.utils.SignUtils;
import com.liziczh.app.shield.internal.service.AppInfoCommonService;

import lombok.extern.slf4j.Slf4j;

/**
 * Demo服务
 * @author zhehao.chen
 */
@Slf4j
@Service
public class SignServiceImpl implements SignService {
	@Autowired
	private AppInfoCommonService appInfoCommonService;

	@Override
	public String generateSign(String from, String appKey, Map<String, Object> paramMap) {
		TAppInfo appInfo = appInfoCommonService.getAppInfo(from, appKey);
		return SignUtils.generateSign(paramMap, appInfo.getAppSecret());
	}
	@Override
	public Boolean checkSign(String from, String appKey, Map<String, Object> paramMap, String sign) {
		TAppInfo appInfo = appInfoCommonService.getAppInfo(from, appKey);
		return SignUtils.checkSign(paramMap, appInfo.getAppSecret(), sign);
	}
}
