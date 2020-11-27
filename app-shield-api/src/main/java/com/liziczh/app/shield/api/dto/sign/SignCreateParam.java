package com.liziczh.app.shield.api.dto.sign;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignCreateParam implements Serializable {
	private static final long serialVersionUID = 7331243098903255531L;
	@ApiModelProperty(value = "请求来源")
	@JsonProperty("from")
	private String from;
	@ApiModelProperty(value = "app_key")
	@JsonProperty("appKey")
	private String appKey;
	@ApiModelProperty(value = "参数Map")
	@JsonProperty("paramMap")
	private Map<String, Object> paramMap;
}
