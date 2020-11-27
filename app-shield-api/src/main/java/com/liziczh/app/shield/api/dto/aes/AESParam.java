package com.liziczh.app.shield.api.dto.aes;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AESParam implements Serializable {
	private static final long serialVersionUID = -3640216333547585805L;
	@ApiModelProperty(value = "请求来源")
	@JsonProperty("from")
	private String from;
	@ApiModelProperty(value = "app_key")
	@JsonProperty("appKey")
	private String appKey;
	@ApiModelProperty(value = "数据")
	@JsonProperty("data")
	private String data;
}
