package com.liziczh.app.shield.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.app.shield.admin.service.DemoMgmService;
import com.liziczh.app.shield.admin.service.ExcelService;
import com.liziczh.app.shield.api.condition.DemoCondition;
import com.liziczh.app.shield.api.entity.TDemo;
import com.liziczh.base.common.service.BaseMgmService;
import com.liziczh.base.mvc.controller.BaseMgmController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/demo/")
@RestController
public class DemoController extends BaseMgmController<TDemo, Integer, DemoCondition> {
	@Autowired
	private DemoMgmService demoMgmService;
	@Autowired
	private ExcelService excelService;

	@Override
	public String getIndex() {
		return "modules/demo/demo.html";
	}
	@Override
	public BaseMgmService<TDemo, Integer, DemoCondition> getService() {
		return demoMgmService;
	}
	@RequestMapping(value = "download", method = RequestMethod.POST)
	public void download(@ModelAttribute DemoCondition condition) throws Exception {
		excelService.export(condition);
	}
}
