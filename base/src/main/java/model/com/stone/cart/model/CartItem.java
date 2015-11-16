package com.stone.cart.model;

import java.io.Serializable;

import com.stone.product.model.Product;

public class CartItem implements Serializable{
	
	private Product product;
	
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
