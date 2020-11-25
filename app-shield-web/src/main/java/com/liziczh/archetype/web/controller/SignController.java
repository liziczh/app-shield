package com.liziczh.archetype.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.archetype.api.service.SignService;
import com.liziczh.base.common.controller.BaseController;
import com.liziczh.base.common.response.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author zhehao.chen
 */
@Api(value = "数字签名接口", tags = "数字签名接口")
@RequestMapping(value = "/sign/")
@RestController
public class SignController extends BaseController {
	@Autowired
	private SignService signService;

	@ApiOperation(value = "生成数字签名", notes = "生成数字签名")
	@PostMapping(value = "create")
	public Response<String> create(String from, String appKey, Map<String, Object> paramMap) {
		String sign = signService.generateSign(from, appKey, paramMap);
		return new Response<String>().complete(sign);
	}
	@ApiOperation(value = "校验数字签名", notes = "校验数字签名")
	@PostMapping(value = "check")
	public Response<String> check(String from, String appKey, Map<String, Object> paramMap, String sign) {
		Boolean result = signService.checkSign(from, appKey, paramMap, sign);
		return new Response<String>().complete(String.valueOf(result));
	}
}
