package com.grocery.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.grocery.daoimpl.ProductDaoImpl;
import com.grocery.model.Product;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the product");
		String Productname = sc.nextLine();
		 Product product = new Product();
	       product.setProductName(Productname);
	       ProductDaoImpl obj5 = new ProductDaoImpl();
	       List<Product> productList =obj5.sortproduct(product);
	       for(Product products:productList){ 
	    	   System.out.println("hi");
	    	   System.out.println(products.getProductImage());
	    	   System.out.println(products.getProductName());
	    	   System.out.println(products.getProductPrice());
	    	   System.out.println(products.getProductPrice());
	    	   
	       }

	}

}
