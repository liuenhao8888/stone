package com.stone.product.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

public class ProductExtend extends ProductExtendKey implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}