package com.taotao.common.pojo;

import java.util.List;

/** 
 * 类说明 
 * @author wangfan 
 * @version 创建时间：2017年2月21日 下午1:13:03 
 */
public class EasyUIDataGridResult {
	private long total;
	private List<?> rows;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
