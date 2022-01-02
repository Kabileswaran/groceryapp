package com.grocery.dao;

import java.sql.SQLException;

import com.grocery.model.Order;

public interface OrderDaoinferace {
	public void creatingOrderId(Order str);
	public int GettingOrderID(Order str);
	public void todaySale() throws ClassNotFoundException, SQLException;
	public void weekSale() throws ClassNotFoundException, SQLException;
	public void orderdetails(Order order1) throws ClassNotFoundException, SQLException;
	public void userOrderDetails(Order order) throws ClassNotFoundException, SQLException;

}
