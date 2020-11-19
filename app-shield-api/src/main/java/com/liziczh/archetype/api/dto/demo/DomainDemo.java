package com.liziczh.archetype.api.dto.demo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomainDemo implements Serializable {
	private static final long serialVersionUID = -3640216333547585805L;
	@ApiModelProperty(value = "姓名")
	@JsonProperty("name")
	private String name;
}
