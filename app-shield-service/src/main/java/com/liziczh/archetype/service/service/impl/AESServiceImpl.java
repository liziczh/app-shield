package com.liziczh.archetype.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public String aesEncrypt(String data, String aesKey) {
		return AESUtils.aesEncrypt(data, aesKey);
	}
	@Override
	public String aesDecrypt(String data, String aesKey) {
		return AESUtils.aesDecrypt(data, aesKey);
	}
}
