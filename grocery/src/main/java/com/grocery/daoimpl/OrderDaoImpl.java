package com.grocery.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import com.grocery.dao.OrderDaoinferace;
import com.grocery.model.Feature;
import com.grocery.model.Order;
import com.grocery.util.GetConnection;




public class OrderDaoImpl implements OrderDaoinferace {
	int custmerid=0;
	public void creatingOrderId(Order str)
	{
		Connection con = null;
		try {
			con = GetConnection.getConnections();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query =" INSERT INTO order_details (customer_id,status) VALUES (?,?)";
	//	String query1="  SELECT order_id FROM buses where customer_id = customer_id  order by order_date desc fetch first rows only";
		try {
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setInt(1, str.getCustomerid());
			stmt.setString(2, str.getStatus());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int GettingOrderID(Order str)
	{Connection con=null;
		try {
			 con =GetConnection.getConnections();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query1="  SELECT order_id FROM order_details where customer_id = ?  order by order_date desc fetch first rows only";
		try {
			PreparedStatement stmt =con.prepareStatement(query1);
			stmt.setInt(1, str.getCustomerid());
			//stmt.executeUpdate();
			ResultSet rs= stmt.executeQuery();
			if(rs.next())
			{
				 custmerid= rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return custmerid;
}
	
	
	
	
	
	
	public List<Feature> todaySale() throws ClassNotFoundException, SQLException {
		Connection con = GetConnection.getConnections();
		List<Feature> todaysale=new ArrayList<Feature>();
		String query = " SELECT * FROM today_product_sale";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
		Feature feature =new Feature();
		feature.setProductName( rs.getString(1));
		feature.setPrice(rs.getDouble(2));
		feature.setQuantity(rs.getInt(3));
		feature.setCost(rs.getDouble(4));
		todaysale.add(feature);
		
		}
		return todaysale; 
	}
		public double todaySales() throws ClassNotFoundException, SQLException {
			double total=0;
			Connection con = GetConnection.getConnections();
		String query1 = " select * from today_product_amount_sale";
		Statement stmt1 = con.createStatement();
		ResultSet rs1 = stmt1.executeQuery(query1);
		if(rs1.next())
		{
			System.out.println(" total "+rs1.getInt(1));
			 total=rs1.getDouble(1);
		}
		return total;

	}
	
		
		
		
		
		
		
		
		
		
		public List<Feature> weekSale() throws ClassNotFoundException, SQLException {
			Connection con = GetConnection.getConnections();
			List<Feature> todaysale=new ArrayList<Feature>();
			String query = " select* from week_product_sale";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
			Feature feature =new Feature();
			feature.setProductName( rs.getString(1));
			feature.setPrice(rs.getDouble(2));
			feature.setQuantity(rs.getInt(3));
			feature.setCost(rs.getDouble(4));
			todaysale.add(feature);
			
			}
			return todaysale; 
		}
			public double weekSales() throws ClassNotFoundException, SQLException {
				double total=0;
				Connection con = GetConnection.getConnections();
			String query1 = "  SELECT * FROM week_product_amount_sale";
			Statement stmt1 = con.createStatement();
			ResultSet rs1 = stmt1.executeQuery(query1);
			if(rs1.next())
			{
				System.out.println(" total "+rs1.getInt(1));
				 total=rs1.getDouble(1);
			}
			return total;

		}
		
		
		
		
	

public Order orderdetails() throws ClassNotFoundException, SQLException
{
	Connection con = GetConnection.getConnections();
	String query = "  SELECT order_id,status,order_date FROM order_details where order_date=trunc(sysdate )";
	PreparedStatement stmt =con.prepareStatement(query);
	Order order=new Order();
	//stmt.executeUpdate();
	ResultSet rs= stmt.executeQuery();
	while(rs.next())
	{
		order.setOrderid(rs.getInt(1));
		order.setStatus(rs.getString(2));
		order.setOrderdate(rs.getDate(3));
		 //System.out.println("\norderId :"+rs.getInt(1)+"\nstatus :"+rs.getString(2)+"\norderDate :"+rs.getDate(3));
	}
	return order;
}

public void userOrderDetails(Order order) throws ClassNotFoundException, SQLException {
	Connection con = GetConnection.getConnections();
	String query = "  select p.products_name,c.quantity,c.price,(c.quantity*c.price) as cost from order_details o join cart c on o.order_id =c.order_id join product p on p.products_id=c.product_id where o.order_id=?";
	PreparedStatement stmt =con.prepareStatement(query);
	stmt.setInt(1, order.getOrderid());
	//stmt.executeUpdate();               
	ResultSet rs= stmt.executeQuery();
	while(rs.next())
	{
		 System.out.println("\nproductname: "+rs.getString(1)+"\nquantity :"+rs.getInt(2)+"\nprice: "+rs.getInt(3)+"\ncost :"+rs.getInt(4));
	}
	String query1 = "select sum(c.quantity*c.price) as cost from order_details o join cart c on o.order_id =c.order_id join product p on p.products_id=c.product_id where o.order_id=?";
	PreparedStatement stmt1 =con.prepareStatement(query1);
	stmt1.setInt(1,order.getOrderid());
	//stmt.executeUpdate();
	ResultSet rs1= stmt1.executeQuery();
	if(rs1.next())
	{
		 System.out.println("\ntotal :"+rs1.getInt(1));
	}
}
@Override
public Order orderdetails(Order order1) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	return null;
}

	
}
