package com.liziczh.archetype.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liziczh.archetype.admin.service.DemoMgmService;
import com.liziczh.archetype.api.common.Constants;
import com.liziczh.archetype.api.condition.DemoCondition;
import com.liziczh.archetype.api.entity.TDemo;
import com.liziczh.archetype.mybatisplus.mapper.TDemoMapper;
import com.liziczh.base.common.condition.PageCondition;
import com.liziczh.base.common.condition.SortCondition;

@Service
public class DemoMgmServiceImpl implements DemoMgmService {
	@Autowired
	private TDemoMapper demoMapper;

	@Override
	public List<TDemo> selectByCondition(DemoCondition condition) {
		PageCondition pageCondition = condition.getPageCondition();
		List<SortCondition> sortConditionList = condition.getSortConditionList();
		QueryWrapper<TDemo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().like(TDemo::getName, condition.getName()).lt(TDemo::getCreateTime, new Date()).eq(TDemo::getValid, Constants.COMMON_STATUS.VALID.getCode());
		for (SortCondition sortCondition : sortConditionList) {
			queryWrapper.orderByDesc(sortCondition.getColumnName());
		}
		Page<TDemo> demoPage = demoMapper.selectPage(new Page<>(pageCondition.getPageNum(), pageCondition.getPageSize()), queryWrapper);
		return demoPage.getRecords();
	}
	@Override
	public List<TDemo> getAll() {
		return demoMapper.selectList(new QueryWrapper<>());
	}
	@Override
	public void addItem(TDemo entity) {
		entity.setCreateTime(new Date());
		entity.setCreateUser(Constants.SYS_USER);
		entity.setValid(Constants.COMMON_STATUS.VALID.getCode());
		demoMapper.insert(entity);
	}
	@Override
	public void updateItem(TDemo entity) {
		entity.setUpdateTime(new Date());
		entity.setUpdateUser(Constants.SYS_USER);
		demoMapper.updateById(entity);
	}
	@Override
	public TDemo get(Integer id) {
		return demoMapper.selectById(id);
	}
	@Override
	public void delete(Integer id) {
		demoMapper.deleteById(id);
	}
}
