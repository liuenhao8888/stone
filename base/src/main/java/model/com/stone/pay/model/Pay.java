package com.stone.pay.model;

import java.util.Date;

public class Pay{
	private Integer id ;
	private int payType;
	private String payMethod;
	private String payName;
	private String bankusername;
	private String bankname;
	private String bankaccount;
	private String bankurl;
	private String postaccount;
	private String postpayee;
	private String bizId;
	private String secretkey;
	private Date createTime;
	private String description;
	private String logopath;
	private int isuse;
	private int isdefined;
	private String registerUrl;

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPayType() {
		return this.payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public String getPayMethod() {
		return this.payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getPayName() {
		return this.payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public String getBankusername() {
		return this.bankusername;
	}

	public void setBankusername(String bankusername) {
		this.bankusername = bankusername;
	}

	public String getBankname() {
		return this.bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBankaccount() {
		return this.bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	public String getBankurl() {
		return this.bankurl;
	}

	public void setBankurl(String bankurl) {
		this.bankurl = bankurl;
	}

	public String getPostaccount() {
		return this.postaccount;
	}

	public void setPostaccount(String postaccount) {
		this.postaccount = postaccount;
	}

	public String getPostpayee() {
		return this.postpayee;
	}

	public void setPostpayee(String postpayee) {
		this.postpayee = postpayee;
	}

	public String getBizId() {
		return this.bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getSecretkey() {
		return this.secretkey;
	}

	public void setSecretkey(String secretkey) {
		this.secretkey = secretkey;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogopath() {
		return this.logopath;
	}

	public void setLogopath(String logopath) {
		this.logopath = logopath;
	}

	public int getIsuse() {
		return this.isuse;
	}

	public void setIsuse(int isuse) {
		this.isuse = isuse;
	}

	public int getIsdefined() {
		return this.isdefined;
	}

	public void setIsdefined(int isdefined) {
		this.isdefined = isdefined;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRegisterUrl() {
		return registerUrl;
	}

	public void setRegisterUrl(String registerUrl) {
		this.registerUrl = registerUrl;
	}
}