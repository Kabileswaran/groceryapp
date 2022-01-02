package com.grocery.controller;

import java.sql.SQLException;
import java.util.List;

import com.grocery.daoimpl.CustomerDaoImpl;
import com.grocery.model.Customer;

public class Testclass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		CustomerDaoImpl obj=new CustomerDaoImpl();
		List<Customer> userList= obj.viewallLoginUser();
		
		
		for (int i = 0; i < userList.size(); i++) {
			System.out.print(userList.get(i));
		}
		
		
		
		
		for(Customer customer:userList){ 
		
	System.out.println(	customer.getCustomerid() +"\n"+
		customer.getFirstName()+" "+
		customer.getLastName() +" "+
		customer.getAddress() +" "+
		customer.getPhonenumber() +" "+
		customer.getUsername()+" "+
		customer.getEmailid()
);		
		
		} 

	}

}
