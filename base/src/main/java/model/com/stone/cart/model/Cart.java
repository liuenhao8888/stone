
package com.stone.cart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Cart  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<CartItem> items = new ArrayList<CartItem>();

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	
	public void add(CartItem ci) {
		int newId = ci.getProduct().getId();
		for (Iterator<CartItem> iter = items.iterator(); iter.hasNext();) {
			CartItem item = iter.next();
			int oldId = item.getProduct().getId();
			if( newId == oldId) {
				item.setCount(item.getCount() + 1);
				return;
			}
		}//这可以用while遍历
		
		items.add(ci);
	}
	
	public double getTotalPrice() {
		double d = 0.0;
		for(Iterator<CartItem> it = items.iterator(); it.hasNext(); ) {
			CartItem current = it.next();
			d += current.getProduct().getPrice() * current.getCount();
		}
		return d;
	}
	
	public void deleteItemById(int productId) {
		for (Iterator<CartItem> iter = items.iterator(); iter.hasNext();) {
			CartItem item = iter.next();
			if(item.getProduct().getId().equals(productId)) {
				iter.remove();
				return;
			}
		}
	}
	
	
	public static void main(String[] s){
		
		Integer a = 99;
		Integer b = 99;
		
		System.out.println(a==b);
	}
	
}

