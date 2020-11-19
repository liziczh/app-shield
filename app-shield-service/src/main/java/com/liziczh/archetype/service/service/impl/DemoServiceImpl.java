package com.liziczh.archetype.service.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liziczh.archetype.api.common.Constants;
import com.liziczh.archetype.api.condition.DemoCondition;
import com.liziczh.archetype.api.entity.TDemo;
import com.liziczh.archetype.api.service.DemoService;
import com.liziczh.archetype.mybatisplus.mapper.TDemoMapper;
import com.liziczh.archetype.ref.service.DemoRefService;
import com.liziczh.base.common.condition.PageCondition;
import com.liziczh.base.common.condition.SortCondition;

import lombok.extern.slf4j.Slf4j;

/**
 * Demo服务
 * @author zhehao.chen
 */
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {
	@Autowired
	private TDemoMapper demoMapper;
	@Autowired
	private DemoRefService demoRefService;

	@Override
	public List<TDemo> selectPage(DemoCondition condition) {
		PageCondition pageCondition = condition.getPageCondition();
		List<SortCondition> sortConditionList = condition.getSortConditionList();
		QueryWrapper<TDemo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().like(TDemo::getName, condition.getName()).ge(TDemo::getCreateTime, condition.getStartTime()).lt(TDemo::getCreateTime, condition.getEndTime()).eq(TDemo::getValid, Constants.COMMON_STATUS.VALID.getCode());
		for (SortCondition sortCondition : sortConditionList) {
			queryWrapper.orderByDesc(sortCondition.getColumnName());
		}
		Page<TDemo> demoPage = demoMapper.selectPage(new Page<>(pageCondition.getPageNum(), pageCondition.getPageSize()), queryWrapper);
		return demoPage.getRecords();
	}
	@Override
	public List<TDemo> selectByCondition(DemoCondition condition) {
		List<SortCondition> sortConditionList = condition.getSortConditionList();
		QueryWrapper<TDemo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().like(TDemo::getName, condition.getName()).lt(TDemo::getCreateTime, new Date()).eq(TDemo::getValid, Constants.COMMON_STATUS.VALID.getCode());
		for (SortCondition sortCondition : sortConditionList) {
			queryWrapper.orderByDesc(sortCondition.getColumnName());
		}
		return demoMapper.selectList(queryWrapper);
	}
	@Override
	public Integer addDemo(TDemo demo) {
		demoMapper.insert(demo);
		return demo.getId();
	}
	@Override
	public void updateDemo(TDemo demo) {
		demoMapper.updateById(demo);
	}
	@Override
	public TDemo getDemo(String id) {
		return demoMapper.selectById(Integer.valueOf(id));
	}
	@Override
	public void deleteDemo(String id) {
		demoMapper.deleteById(Integer.valueOf(id));
	}
	@Override
	public String refHello() {
		return demoRefService.hello();
	}
}
