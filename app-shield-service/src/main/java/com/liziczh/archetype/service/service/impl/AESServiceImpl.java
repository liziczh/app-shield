package com.liziczh.archetype.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liziczh.archetype.api.entity.TAppInfo;
import com.liziczh.archetype.api.service.AESService;
import com.liziczh.archetype.api.utils.AESUtils;
import com.liziczh.archetype.mybatisplus.mapper.TAppInfoMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * Demo服务
 * @author zhehao.chen
 */
@Slf4j
@Service
public class AESServiceImpl implements AESService {
	@Autowired
	private TAppInfoMapper tAppInfoMapper;

	@Override
	public String aesEncrypt(String from, String appKey, String sourceData) {
		QueryWrapper<TAppInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(TAppInfo::getAppCode, from).eq(TAppInfo::getAppKey, appKey);
		TAppInfo appInfo = tAppInfoMapper.selectOne(queryWrapper);
		return AESUtils.aesEncrypt(sourceData, appInfo.getAesKey());
	}
	@Override
	public String aesDecrypt(String from, String appKey, String encryptedData) {
		QueryWrapper<TAppInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(TAppInfo::getAppCode, from).eq(TAppInfo::getAppKey, appKey);
		TAppInfo appInfo = tAppInfoMapper.selectOne(queryWrapper);
		return AESUtils.aesDecrypt(encryptedData, appInfo.getAesKey());
	}
}
