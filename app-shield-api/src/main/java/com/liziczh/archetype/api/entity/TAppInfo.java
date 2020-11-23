package com.liziczh.archetype.api.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName(value = "t_app_info")
public class TAppInfo implements Serializable {
	private static final long serialVersionUID = -3399850105386695874L;
	@ApiModelProperty(value = "ID")
	@JsonProperty("id")
	@TableId(value = "ID", type = IdType.AUTO)
	private Integer id;
	@ApiModelProperty(value = "APP名称")
	@JsonProperty("app_name")
	@TableField(value = "APP_NAME")
	private String appName;
	@ApiModelProperty(value = "AppCode")
	@JsonProperty("app_code")
	@TableField(value = "APP_CODE")
	private String appCode;
	@ApiModelProperty(value = "APPKEY")
	@JsonProperty("app_key")
	@TableField(value = "APP_KEY")
	private String appKey;
	@ApiModelProperty(value = "APP密钥")
	@JsonProperty("app_secret")
	@TableField(value = "APP_SECRET")
	private String appSecret;
	@ApiModelProperty(value = "AES密钥")
	@JsonProperty("aes_key")
	@TableField(value = "AES_KEY")
	private String aesKey;
	@ApiModelProperty(value = "创建时间")
	@JsonProperty("create_time")
	@TableField(value = "CREATE_TIME")
	private Date createTime;
	@ApiModelProperty(value = "创建人")
	@JsonProperty("create_user")
	@TableField(value = "CREATE_USER")
	private String createUser;
	@ApiModelProperty(value = "更新时间")
	@JsonProperty("update_time")
	@TableField(value = "UPDATE_TIME")
	private Date updateTime;
	@ApiModelProperty(value = "更新人")
	@JsonProperty("update_user")
	@TableField(value = "UPDATE_USER")
	private String updateUser;
	@ApiModelProperty(value = "权限角色")
	@JsonProperty("permit_role")
	@TableField(value = "PERMIT_ROLE")
	private String permitRole;
	@ApiModelProperty(value = "是否有效")
	@JsonProperty("valid")
	@TableField(value = "VALID")
	private String valid;
}
