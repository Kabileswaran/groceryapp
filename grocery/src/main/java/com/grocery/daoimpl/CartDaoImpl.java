package com.grocery.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.grocery.dao.CartInterface;
import com.grocery.model.Cart;
import com.grocery.util.GetConnection;


public class CartDaoImpl implements CartInterface{
	Scanner sc = new Scanner(System.in);

	public void addToCart(Cart stt) throws ClassNotFoundException, SQLException {
			Connection con = GetConnection.getConnections();
			String query = "insert into cart(order_id,product_id,quantity,price) values (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, stt.getOrderid());
			stmt.setInt(2, stt.getProductid());
			stmt.setInt(3, stt.getQuantity());
			stmt.setInt(4, stt.getPrice());
			stmt.executeUpdate();
			System.out.println("order place success");
			

	}
	public void toShowOrder() throws ClassNotFoundException, SQLException
	{
		Connection con = GetConnection.getConnections();
		Statement stmt = con.createStatement();
		String view = "   SELECT p.products_name,c.quantity,c.price ,(c.quantity*c.price) as total from buses o join  bsus c on o.order_id=c.order_id join busesd p on p.products_id=c.product_id ";
		ResultSet rs = stmt.executeQuery(view);
		while (rs.next()) {
			 System.out.println( rs.getString(1) + " " + rs.getInt(2)+" "+ rs.getInt(3)+" "+rs.getDouble(4));
			//Product product = new Product(rs.getInt(2), rs.getString(1), rs.getDouble(3));
			
		}
	}
	

}
