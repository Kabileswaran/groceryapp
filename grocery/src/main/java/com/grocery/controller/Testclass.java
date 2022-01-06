package com.grocery.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import com.grocery.daoimpl.CartDaoImpl;
import com.grocery.daoimpl.CustomerDaoImpl;
import com.grocery.daoimpl.OrderDaoImpl;
import com.grocery.daoimpl.ProductDaoImpl;
import com.grocery.model.Cart;
import com.grocery.model.Customer;
import com.grocery.model.Order;
import com.grocery.model.Product;

public class Testclass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner c=new Scanner(System.in);
		System.out.println("enter the productId");
		int pid= Integer.parseInt(c.nextLine());
		int cid=2;
		Order order =new Order();
		order.setCustomerid(cid);
		OrderDaoImpl obj= new OrderDaoImpl();
		int oid=  obj.cartCheck(order);
		//check user if order id already exist in cart
		if(!(oid>0) )
		{
			//creating new order id
			//pass cusid to create order id
			//get order id
			System.out.println("creating new orderid");
			Order str = new Order();  
			  
			
			str.setCustomerid(cid);
			str.setStatus("in cart");
			
			obj.creatingOrderId(str);
			// getting orderid
			 oid = obj.GettingOrderID(str);
	
		}
		Cart stt = new Cart();
		stt.setOrderid(oid);
		stt.setProductid(pid);
	
		CartDaoImpl obj1 =new CartDaoImpl();
		int qty=obj1.check(stt);
		if(qty>0)
		{
			System.out.println("increase quantiy");
			stt.setQuantity(qty+1);
			obj1.incease(stt);

		}
		else
		{
			System.out.println("add to cart");
			
			stt.setQuantity(1);
			stt.setPrice(0);
			obj1.addToCart(stt);
			
		}
	

}

}