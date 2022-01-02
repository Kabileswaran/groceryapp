package com.grocery.model;

public class Feature {
private String	ProductName;
private double	price;
private int	quantity;
private double	Cost;
private double	total;
public String getProductName() {
	return ProductName;
}
public void setProductName(String productName) {
	ProductName = productName;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getCost() {
	return Cost;
}
public void setCost(double cost) {
	Cost = cost;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public Feature(String productName, double price, int quantity, double cost, double total) {
	super();
	ProductName = productName;
	this.price = price;
	this.quantity = quantity;
	Cost = cost;
	this.total = total;
}
@Override
public String toString() {
	return "Feature [ProductName=" + ProductName + ", price=" + price + ", quantity=" + quantity + ", Cost=" + Cost
			+ ", total=" + total + "]";
}
public Feature() {
	super();
	// TODO Auto-generated constructor stub
}


}
