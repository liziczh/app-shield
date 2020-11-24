package com.liziczh.archetype.service.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public String generateSign(Map<String, Object> paramMap, String cipher) {
		return SignUtils.generateSign(paramMap, cipher);
	}
	@Override
	public Boolean checkSign(Map<String, Object> paramMap, String cipher, String sign) {
		return SignUtils.checkSign(paramMap, cipher, sign);
	}
}
