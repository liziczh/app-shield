package com.liziczh.app.shield.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.app.shield.api.dto.aes.AESParam;
import com.liziczh.app.shield.api.service.AESService;
import com.liziczh.base.common.controller.BaseController;
import com.liziczh.base.common.response.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "AES加解密", tags = "AES加解密")
@RequestMapping(value = "/aes/")
@RestController
public class AESController extends BaseController {
	@Autowired
	private AESService aesService;

	@ApiOperation(value = "AES加密", notes = "AES加密")
	@PostMapping(value = "encrypt")
	public Response<String> encrypt(@RequestBody AESParam param) {
		String result = aesService.aesEncrypt(param.getFrom(), param.getAppKey(), param.getData());
		return new Response<String>().complete(result);
	}
	@ApiOperation(value = "AES解密", notes = "AES解密")
	@PostMapping(value = "decrypt")
	public Response<String> decrypt(@RequestBody AESParam param) {
		String result = aesService.aesDecrypt(param.getFrom(), param.getAppKey(), param.getData());
		return new Response<String>().complete(result);
	}
}
