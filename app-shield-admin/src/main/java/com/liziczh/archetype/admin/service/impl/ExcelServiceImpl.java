package com.liziczh.archetype.admin.service.impl;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liziczh.archetype.admin.dto.excel.DemoModel;
import com.liziczh.archetype.admin.service.ExcelService;
import com.liziczh.archetype.api.condition.DemoCondition;
import com.liziczh.archetype.api.entity.TDemo;
import com.liziczh.archetype.mybatisplus.mapper.TDemoMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * Excel导出
 * @author zhehao.chen
 */
@Slf4j
@Service
public class ExcelServiceImpl implements ExcelService {
	@Autowired
	HttpServletResponse response;
	@Autowired
	private TDemoMapper tDemoMapper;

	@Override
	public void export(DemoCondition condition) {
		// 导出
		ServletOutputStream out;
		ExcelWriter writer = null;
		try {
			out = response.getOutputStream();
			writer = EasyExcelFactory.write(out, DemoModel.class).build();
			WriteSheet sheet = EasyExcelFactory.writerSheet("sheet1").build();
			writer.write(data(condition), sheet);
			// response stream
			String fileName = URLEncoder.encode("Demo列表", "UTF-8");
			download(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.finish();
			}
		}
	}
	/**
	 * 条件查询数据
	 * @param condition 条件
	 * @return BaseRowModel
	 */
	private List<DemoModel> data(DemoCondition condition) {
		// 条件查询订单
		QueryWrapper<TDemo> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByDesc("CREATE_DATE");
		List<TDemo> demoList = tDemoMapper.selectList(queryWrapper);
		List<DemoModel> modelList = new ArrayList<>();
		demoList.parallelStream().forEach(demo -> {
			DemoModel model = new DemoModel();
			model.setId(demo.getId());
			model.setName(demo.getName());
			model.setCreateDate(demo.getCreateTime());
			model.setCreateUser(demo.getCreateUser());
			model.setUpdateDate(demo.getUpdateTime());
			model.setUpdateUser(demo.getUpdateUser());
			modelList.add(model);
		});
		return modelList;
	}
	/**
	 * 下载Excel文件
	 * @param fileName 文件名
	 */
	private void download(String fileName) {
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
	}
}
