package com.liziczh.app.shield.api.condition;

import java.util.Date;

import com.liziczh.base.common.condition.BaseCondition;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AppInfoCondition extends BaseCondition {
	private static final long serialVersionUID = -7473402179827602416L;
	private Integer id;
	private String appName;
	private String appCode;
	private String appKey;
	private Date startTime;
	private Date endTime;
	private String valid;
}
