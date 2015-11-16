package com.stone.category.model;

import java.io.Serializable;
import java.util.List;

public class CategoryTree implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	List<CategoryTree> subList;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CategoryTree> getSubList() {
		return subList;
	}
	public void setSubList(List<CategoryTree> subList) {
		this.subList = subList;
	}
	
	

}
