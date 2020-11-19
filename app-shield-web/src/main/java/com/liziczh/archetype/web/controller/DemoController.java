package com.liziczh.archetype.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.archetype.api.condition.DemoCondition;
import com.liziczh.archetype.api.entity.TDemo;
import com.liziczh.archetype.api.service.DemoService;
import com.liziczh.archetype.redis.service.DemoRedisService;
import com.liziczh.base.common.controller.BaseController;
import com.liziczh.base.common.result.Result;
import com.liziczh.base.common.result.ResultBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "示例接口", tags = "示例接口")
@RequestMapping(value = "/demo/")
@RestController
public class DemoController extends BaseController {
	@Autowired
	private DemoService demoService;
	@Autowired
	private DemoRedisService demoRedisService;

	@ApiOperation(value = "hello", notes = "测试接口")
	@GetMapping(value = "hello")
	public Result<String> hello() {
		return new ResultBuilder<String>().complete("HelloWorld");
	}
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@PostMapping(value = "/page")
	public Result<List<TDemo>> selectPage(@RequestBody DemoCondition condition) throws Exception {
		List<TDemo> demoPage = demoService.selectPage(condition);
		return new ResultBuilder<List<TDemo>>().complete(demoPage);
	}
	@ApiOperation(value = "条件查询", notes = "分页查询")
	@GetMapping(value = "/select")
	public Result<List<TDemo>> selectByCondition(@RequestBody DemoCondition condition) throws Exception {
		List<TDemo> demoList = demoService.selectByCondition(condition);
		return new ResultBuilder<List<TDemo>>().complete(demoList);
	}
	@ApiOperation(value = "新增接口", notes = "新增接口")
	@PostMapping(value = "add")
	public Result<String> addDemo(TDemo demo) throws Exception {
		demoService.addDemo(demo);
		return new ResultBuilder<String>().success();
	}
	@ApiOperation(value = "更新接口", notes = "更新接口")
	@PutMapping(value = "update")
	public Result<String> updateDemo(TDemo demo) throws Exception {
		demoService.updateDemo(demo);
		return new ResultBuilder<String>().success();
	}
	@ApiOperation(value = "获取接口", notes = "获取接口")
	@GetMapping(value = "/get/{id}")
	public Result<TDemo> getDemo(@PathVariable String id) throws Exception {
		TDemo demo = demoService.getDemo(id);
		return new ResultBuilder<TDemo>().complete(demo);
	}
	@ApiOperation(value = "删除接口", notes = "删除接口")
	@DeleteMapping(value = "/delete/{id}")
	public Result<String> deleteDemo(@PathVariable String id) throws Exception {
		demoService.deleteDemo(id);
		return new ResultBuilder<String>().success();
	}
	@ApiOperation(value = "缓存", notes = "缓存")
	@GetMapping(value = "/cache/{key}/{value}")
	public Result<String> cache(@PathVariable String key, @PathVariable String value) throws Exception {
		demoRedisService.setValue(key, value);
		return new ResultBuilder<String>().success();
	}
	@ApiOperation(value = "REST引用接口测试", notes = "REST引用接口测试")
	@PostMapping(value = "ref/hello")
	public Result<String> refHello() {
		String hello = demoService.refHello();
		return new ResultBuilder<String>().complete(hello);
	}
}
