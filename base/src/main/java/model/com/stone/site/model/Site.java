package com.stone.site.model;

import java.io.Serializable;

import com.stone.base.model.Top;

public class Site extends Top implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String url;
	private int priority;
	private int status ; //0:未审批 1：审批未通过 2：审批通过 3：前台显示
	private String time;
	private int cid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
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
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	

}
