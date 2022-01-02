package com.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.grocery.connection.GetConnection;
import com.grocery.model.Product;
import com.interfaces.Productinterface;


public class ProductDao implements Productinterface {
	Scanner sc = new Scanner(System.in);
	int	b1 = 0;
	public void addproduct(Product str) throws ClassNotFoundException, SQLException {
			Connection con = GetConnection.getConnections();
			String query = " insert into product (products_name,standard_cost)values(?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, str.getProductName());
			stmt.setDouble(2, str.getProductPrice());
			stmt.executeUpdate();
			System.out.println("Product Added");
	}

	public void delete(Product str) throws ClassNotFoundException, SQLException {
			Connection con = GetConnection.getConnections();
			String query = "update product set status='n' where products_id=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, str.getProductId());
			stmt.executeUpdate();
			System.out.println("Product deleted");
	}
	public void changePrice(Product str) throws ClassNotFoundException, SQLException {

			Connection con = GetConnection.getConnections();
			String query = "update product set standard_cost =? where products_id=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setDouble(1, str.getProductPrice());
			stmt.setInt(2, str.getProductId());
			stmt.executeUpdate();
			System.out.println("Product price update");
	}

	public void changeName(Product str) throws ClassNotFoundException, SQLException {
			Connection con = GetConnection.getConnections();
			String query = "update product set products_name =? where products_id=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, str.getProductName());
			stmt.setInt(2, str.getProductId());
			stmt.executeUpdate();
			System.out.println("Product name change");
	}

	public List<Product> viewAllProducts() throws ClassNotFoundException, SQLException {
		Connection con = GetConnection.getConnections();
		Statement stmt = con.createStatement();
		List<Product> productList = new ArrayList<Product>();
		String view = " SELECT products_name,products_id,standard_cost FROM product where status ='y'";
		ResultSet rs = stmt.executeQuery(view);
		while (rs.next()) {
			// System.out.println(rs.getInt(2) + " " + rs.getString(1)+" "+ rs.getInt(3));
			Product product = new Product(rs.getInt(2), rs.getString(1), rs.getDouble(3));
			productList.add(product);
		}
		return productList;

	}
	public  int gettingRate(Product str11) throws ClassNotFoundException, SQLException
	{
			Connection con = GetConnection.getConnections();
			String query = " select standard_cost from product where products_id=? ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1,str11.getProductId() );
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				b1 = rs.getInt("standard_cost");
				//System.out.println(b);

			} else {
				System.out.println("error pr");
				System.exit(0);

			}
	         
			return b1;
	}	
}

