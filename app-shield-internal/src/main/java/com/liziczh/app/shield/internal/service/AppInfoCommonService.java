package com.liziczh.app.shield.internal.service;

import com.liziczh.app.shield.api.entity.TAppInfo;

public interface AppInfoCommonService {
	/**
	 * 根据from&appKey查询AppInfo
	 * @param from 请求来源
	 * @param appKey app key
	 * @return AppInfo
	 */
	TAppInfo getAppInfo(String from, String appKey);
}
