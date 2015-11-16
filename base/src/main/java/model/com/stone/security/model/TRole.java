package com.stone.security.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TRole implements Serializable {
    private Integer id;

    private String name;
    
    private List<TResource> resourcesList = new ArrayList<TResource>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public List<TResource> getResourcesList() {
		return resourcesList;
	}

	public void setResourcesList(List<TResource> resourcesList) {
		this.resourcesList = resourcesList;
	}
    
    
}