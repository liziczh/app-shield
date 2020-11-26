package com.liziczh.app.shield.internal.service;

import com.liziczh.app.shield.api.entity.TAppInfo;

public interface AppInfoCommonService {
	/**
	 * @param from
	 * @param appKey
	 * @return
	 */
	TAppInfo getAppInfoByFromAndAppKey(String from, String appKey);
}
