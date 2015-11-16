package com.stone.site.model;

import java.io.Serializable;

import com.stone.base.model.Top;

public class RecSite extends Top implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String url;
	private String comment;
	private String time;
	private int cid;
	private int uid;
	private int posnum;
	private int negnum;
	
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
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getPosnum() {
		return posnum;
	}
	public void setPosnum(int posnum) {
		this.posnum = posnum;
	}
	public int getNegnum() {
		return negnum;
	}
	public void setNegnum(int negnum) {
		this.negnum = negnum;
	}
	
}
