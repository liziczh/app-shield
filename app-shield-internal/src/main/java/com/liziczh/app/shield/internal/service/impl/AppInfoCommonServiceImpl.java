package com.liziczh.app.shield.internal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liziczh.app.shield.api.entity.TAppInfo;
import com.liziczh.app.shield.internal.service.AppInfoCommonService;
import com.liziczh.app.shield.mybatisplus.mapper.TAppInfoMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AppInfoCommonServiceImpl implements AppInfoCommonService {
	@Autowired
	private TAppInfoMapper tAppInfoMapper;

	@Override
	public TAppInfo getAppInfoByFromAndAppKey(String from, String appKey) {
		QueryWrapper<TAppInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(TAppInfo::getAppCode, from).eq(TAppInfo::getAppKey, appKey);
		return tAppInfoMapper.selectOne(queryWrapper);
	}
}
