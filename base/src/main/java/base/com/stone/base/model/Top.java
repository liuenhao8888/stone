package com.stone.base.model;

import java.io.Serializable;

public abstract class Top implements Serializable {

	/**
	 * 
	 */
	 static final long serialVersionUID = 1L;
	protected int id; // 主键

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
