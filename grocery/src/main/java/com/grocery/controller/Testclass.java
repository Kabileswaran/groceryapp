package com.grocery.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.grocery.daoimpl.CustomerDaoImpl;
import com.grocery.daoimpl.ProductDaoImpl;
import com.grocery.model.Customer;
import com.grocery.model.Product;

public class Testclass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner c=new Scanner(System.in);
		System.out.println("enter the productId");
		int pid= Integer.parseInt(c.nextLine());
		System.out.println("enter the product name");
		String pname= c.nextLine();
		Product producte =new Product();
		producte.setProductId(pid);
		producte.setProductName(pname);
		ProductDaoImpl p=new ProductDaoImpl();
	boolean flag=	p.changeName(producte);
	

}

}