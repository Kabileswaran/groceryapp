package com.grocery.model;

public class Product {
	private int ProductId;
	private String ProductName;
	private Double ProductPrice;

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public Product(int productId, String productName, Double productPrice) {
		super();
		ProductId = productId;
		ProductName = productName;
		ProductPrice = productPrice;
	}

	public Double getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(double price) {
		ProductPrice = price;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "\nProductId=" + ProductId + "\nProductName=" + ProductName + "\nProductPrice=" + ProductPrice;
	}

}
