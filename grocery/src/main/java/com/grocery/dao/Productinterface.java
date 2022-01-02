package com.grocery.dao;

import java.sql.SQLException;
import java.util.List;

import com.grocery.model.Product;

public interface Productinterface {
	public void addproduct(Product str) throws ClassNotFoundException, SQLException;
	public void delete(Product str) throws ClassNotFoundException, SQLException;
	public void changePrice(Product str) throws ClassNotFoundException, SQLException;
	public void changeName(Product str) throws ClassNotFoundException, SQLException;
	public List<Product> viewAllProducts() throws ClassNotFoundException, SQLException;
	public  int gettingRate(Product str11) throws ClassNotFoundException, SQLException;
}
