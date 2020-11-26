package com.liziczh.app.shield.web.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.liziczh.base.common.exception.BizInfoException;
import com.liziczh.base.common.response.Response;
import com.liziczh.base.common.util.JacksonUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 异常通知
 * @author zhehao.chen
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {
	public final String DEFAULT_CODE = Response.RESPONSE_CODE.ERROR.getCode();
	public final String DEFAULT_MESSAGE = Response.RESPONSE_CODE.ERROR.getMsg();

	@ExceptionHandler(BizInfoException.class)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Map<String, Object> handleBizInfoException(BizInfoException e) {
		return buildErrorMessage(e.getCode(), e.getMessage());
	}
	/**
	 * 构建错误响应信息
	 * @param code 错误码
	 * @param message 错误信息
	 * @return Map
	 */
	private Map<String, Object> buildErrorMessage(String code, String message) {
		Map<String, Object> model = new HashMap<>(2);
		model.put("code", code == null ? DEFAULT_CODE : code);
		model.put("message", message == null ? DEFAULT_MESSAGE : message);
		log.info("error：{}", JacksonUtils.toJSONString(model));
		return model;
	}
	/**
	 * 构建错误响应信息
	 * @param message 错误信息
	 * @return Map
	 */
	private Map<String, Object> buildErrorMessage(String message) {
		Map<String, Object> model = new HashMap<>(2);
		model.put("code", DEFAULT_CODE);
		model.put("message", message == null ? DEFAULT_MESSAGE : message);
		log.info("error：{}", JacksonUtils.toJSONString(model));
		return model;
	}
}
