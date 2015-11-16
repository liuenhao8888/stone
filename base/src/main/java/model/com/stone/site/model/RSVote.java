package com.stone.site.model;

import java.io.Serializable;

import com.stone.base.model.Top;

public class RSVote extends Top implements Serializable {

	private static final long serialVersionUID = 1L;
	private int rsid;
	private String ip;
	private int type;//1:顶    0： 踩
	
	
	
	public int getRsid() {
		return rsid;
	}
	public void setRsid(int rsid) {
		this.rsid = rsid;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

}
