package com.liziczh.archetype.admin.dto.excel;

import java.util.Date;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import lombok.Data;

/**
 * 对接百度健康订单信息
 * @author zhehao.chen
 */
@Data
public class DemoModel {
	private static final long serialVersionUID = -4759455543086580031L;
	@ExcelProperty(value = "ID", index = 0)
	@ColumnWidth(6)
	private Integer id;
	@ExcelProperty(value = "名称", index = 1)
	@ColumnWidth(10)
	private String name;
	@ExcelProperty(value = "创建时间", index = 23)
	@ColumnWidth(20)
	private Date createDate;
	@ExcelProperty(value = "创建用户", index = 24)
	@ColumnWidth(12)
	private String createUser;
	@ExcelProperty(value = "更新时间", index = 25)
	@ColumnWidth(20)
	private Date updateDate;
	@ExcelProperty(value = "更新用户", index = 26)
	@ColumnWidth(12)
	private String updateUser;
}
