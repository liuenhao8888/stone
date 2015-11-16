package com.stone.util;

public class Area {
	
	Area(){}
	
	Area(String preName,String cName,String areaCode){
		this.preName = preName;
		this.cName = cName;
		this.areaCode = areaCode;
	}
	
	private long id;
	private String preName;
	private String cName;
	private String areaCode;
	private int version = 0;
	private int grade = 1;
	private int orderNum = 0;
	private int isLeaf = 0;
	private long parentId = 0;
	private int shopId = 0;
	
	public String getPreName() {
		return preName;
	}
	public void setPreName(String preName) {
		this.preName = preName;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(int isLeaf) {
		this.isLeaf = isLeaf;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	
	
	
	

}
