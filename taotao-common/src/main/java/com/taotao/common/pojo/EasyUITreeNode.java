package com.taotao.common.pojo;
/** 
 * EasyUI的异步Tree节点
 * @author wangfan 
 * @version 创建时间：2017年2月22日 上午10:34:35 
 */
public class EasyUITreeNode {
	private long id;
	private String text;
	private String state;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
