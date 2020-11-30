package com.liziczh.app.shield.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.app.shield.admin.service.AppInfoService;
import com.liziczh.app.shield.api.condition.AppInfoCondition;
import com.liziczh.app.shield.api.entity.TAppInfo;
import com.liziczh.base.common.service.BaseMgmService;
import com.liziczh.base.mvc.controller.BaseMgmController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/demo/")
@RestController
public class AppInfoController extends BaseMgmController<TAppInfo, Integer, AppInfoCondition> {
	@Autowired
	private AppInfoService appInfoService;

	@Override
	public String getIndex() {
		return "modules/appInfo/appInfo.html";
	}
	@Override
	public BaseMgmService<TAppInfo, Integer, AppInfoCondition> getService() {
		return appInfoService;
	}
}
