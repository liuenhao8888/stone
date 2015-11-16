package com.stone.site.model;

import java.io.Serializable;

import com.stone.base.model.Top;

public class Catalog extends Top implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int status ; //0:未审批 1：审批未通过 2：审批通过 3：前台显示
	private String time;
	private int pid;
	private int priority;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
}
