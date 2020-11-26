package com.liziczh.archetype.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.archetype.api.service.AESService;
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
	public Response<String> encrypt(String from, String appKey, String sourceData) {
		String result = aesService.aesEncrypt(from, appKey, sourceData);
		return new Response<String>().complete(result);
	}
	@ApiOperation(value = "AES解密", notes = "AES解密")
	@PostMapping(value = "decrypt")
	public Response<String> decrypt(String from, String appKey, String encryptedData) {
		String result = aesService.aesDecrypt(from, appKey, encryptedData);
		return new Response<String>().complete(result);
	}
}
