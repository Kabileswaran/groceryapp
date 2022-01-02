package com.interfaces;

import java.sql.SQLException;

import com.grocery.model.Customer;

public interface Customerinterface {
	public void signup(Customer str1) throws ClassNotFoundException, SQLException;
	public void changepassword(Customer str3) throws ClassNotFoundException, SQLException;
	public int login(Customer str) throws ClassNotFoundException, SQLException;
	public void viewLoginUser(Customer str2) throws ClassNotFoundException, SQLException;
	public void viewallLoginUser() throws ClassNotFoundException, SQLException;

}
