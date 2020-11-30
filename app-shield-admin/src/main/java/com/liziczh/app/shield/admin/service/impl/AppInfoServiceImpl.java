package com.liziczh.app.shield.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liziczh.app.shield.admin.service.AppInfoService;
import com.liziczh.app.shield.api.common.Constants;
import com.liziczh.app.shield.api.condition.AppInfoCondition;
import com.liziczh.app.shield.api.entity.TAppInfo;
import com.liziczh.app.shield.mybatisplus.mapper.TAppInfoMapper;
import com.liziczh.base.common.condition.PageCondition;
import com.liziczh.base.common.condition.SortCondition;

@Service
public class AppInfoServiceImpl implements AppInfoService {
	@Autowired
	private TAppInfoMapper tAppInfoMapper;

	@Override
	public List<TAppInfo> selectByCondition(AppInfoCondition condition) {
		PageCondition pageCondition = condition.getPageCondition();
		List<SortCondition> sortConditionList = condition.getSortConditionList();
		QueryWrapper<TAppInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(TAppInfo::getAppCode, condition.getAppCode()).lt(TAppInfo::getCreateTime, new Date()).eq(TAppInfo::getValid, Constants.COMMON_STATUS.VALID.getCode());
		for (SortCondition sortCondition : sortConditionList) {
			queryWrapper.orderByDesc(sortCondition.getColumnName());
		}
		Page<TAppInfo> demoPage = tAppInfoMapper.selectPage(new Page<>(pageCondition.getPageNum(), pageCondition.getPageSize()), queryWrapper);
		return demoPage.getRecords();
	}
	@Override
	public List<TAppInfo> getAll() {
		return tAppInfoMapper.selectList(new QueryWrapper<>());
	}
	@Override
	public void addItem(TAppInfo entity) {
		entity.setCreateTime(new Date());
		entity.setCreateUser(Constants.SYS_USER);
		entity.setValid(Constants.COMMON_STATUS.VALID.getCode());
		tAppInfoMapper.insert(entity);
	}
	@Override
	public void updateItem(TAppInfo entity) {
		entity.setUpdateTime(new Date());
		entity.setUpdateUser(Constants.SYS_USER);
		tAppInfoMapper.updateById(entity);
	}
	@Override
	public TAppInfo get(Integer id) {
		return tAppInfoMapper.selectById(id);
	}
	@Override
	public void delete(Integer id) {
		tAppInfoMapper.deleteById(id);
	}
}
