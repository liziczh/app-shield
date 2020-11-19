package com.liziczh.archetype.admin.service;

import com.liziczh.archetype.api.condition.DemoCondition;

/**
 * @author zhehao.chen
 */
public interface ExcelService {
	/**
	 * 导出订单表
	 * @param condition 条件
	 * @return 文件流
	 * @throws Exception e
	 */
	void export(DemoCondition condition) throws Exception;
}
