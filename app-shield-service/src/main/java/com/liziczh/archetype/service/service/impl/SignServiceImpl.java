package com.liziczh.archetype.service.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liziczh.archetype.api.entity.TAppInfo;
import com.liziczh.archetype.api.service.SignService;
import com.liziczh.archetype.api.utils.SignUtils;
import com.liziczh.archetype.mybatisplus.mapper.TAppInfoMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * Demo服务
 * @author zhehao.chen
 */
@Slf4j
@Service
public class SignServiceImpl implements SignService {
	@Autowired
	private TAppInfoMapper tAppInfoMapper;

	@Override
	public String generateSign(String from, String appKey, Map<String, Object> paramMap) {
		QueryWrapper<TAppInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(TAppInfo::getAppCode, from).eq(TAppInfo::getAppKey, appKey);
		TAppInfo appInfo = tAppInfoMapper.selectOne(queryWrapper);
		return SignUtils.generateSign(paramMap, appInfo.getAppSecret());
	}
	@Override
	public Boolean checkSign(String from, String appKey, Map<String, Object> paramMap, String sign) {
		QueryWrapper<TAppInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(TAppInfo::getAppCode, from).eq(TAppInfo::getAppKey, appKey);
		TAppInfo appInfo = tAppInfoMapper.selectOne(queryWrapper);
		return SignUtils.checkSign(paramMap, appInfo.getAppSecret(), sign);
	}
}
