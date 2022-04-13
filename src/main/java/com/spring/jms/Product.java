package com.spring.jms;

import java.io.Serializable;

public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int product_Id;
	private String name;
	private int quantity;
	
	
	@Override
	public String toString() {
		return "Product [product_Id=" + product_Id + ", name=" + name + ", quantity=" + quantity + "]";
	}
	public Product() {
		super();
	}
	public int getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product(int product_Id, String name, int quantity) {
		super();
		this.product_Id = product_Id;
		this.name = name;
		this.quantity = quantity;
	}

}
