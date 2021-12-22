package com.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.grocery.connection.GetConnection;
import com.grocery.model.Customer;

public class CustomerDao {
	Scanner sc = new Scanner(System.in);
	int b = 0;

	public void signup(Customer str1) throws ClassNotFoundException, SQLException {

		Connection con = GetConnection.getConnections();
		String query = "insert into customer (user_name ,password,first_name,last_name,address,phone, email) values(?,?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, str1.getUsername());
		stmt.setString(2, str1.getPassword());
		stmt.setString(3, str1.getFirstName());
		stmt.setString(4, str1.getLastName());
		stmt.setString(5, str1.getAddress());
		stmt.setLong(6, str1.getPhonenumber());
		stmt.setString(7, str1.getEmailid());
		stmt.executeUpdate();
		System.out.println("successful ");

	}

	public void changepassword(Customer str3) throws ClassNotFoundException, SQLException {

		Connection con = GetConnection.getConnections();
		String query = "update  customer set password = ? where customer_id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		// System.out.println(str3.getCustomerid());
		stmt.setString(1, str3.getPassword());
		stmt.setInt(2, str3.getCustomerid());
		stmt.executeUpdate();
		System.out.println("password update successful ");
	}

	public int login(Customer str) throws ClassNotFoundException, SQLException {

		// List <Customer> productList= new ArrayList<Customer>();
		Connection con = GetConnection.getConnections();
		String query = "select first_name,customer_id from customer where user_name= ? and password= ? ";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, str.getUsername());
		stmt.setString(2, str.getPassword());
		// stmt.executeUpdate();

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			System.out.println("welcome " + rs.getString("first_name"));
			b = rs.getInt("customer_id");
			//System.out.println(b);

		} else {
			System.out.println("error");
			System.exit(0);

		}
		return b;

	}

	public void viewLoginUser(Customer str2) throws ClassNotFoundException, SQLException {
		Connection con = GetConnection.getConnections();
		String query = "select first_name,last_name,address,phone,email from customer where customer_id = ?";
		PreparedStatement stmt = con.prepareStatement(query);

		// Customer str = new Customer();
		// System.out.println(str2.getFindcustomerid());
		stmt.setInt(1, str2.getCustomerid());
		// stmt.executeUpdate();
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			System.out.println("FIRSTNAME " + rs.getString("first_name") + "\nLASTNAME " + rs.getString("last_name")
					+ "\nADDRESS " + rs.getString("address") + "\nPHONE " + rs.getLong("phone") + "\nEMAIL "
					+ rs.getString("email"));
		} else {
			System.out.println("error");
		}

	}
	
	
	
	
	
	
	
	public void viewallLoginUser() throws ClassNotFoundException, SQLException {
		Connection con = GetConnection.getConnections();
		String query = "select first_name,last_name,address,phone,email from customer";
		PreparedStatement stmt = con.prepareStatement(query);

		// Customer str = new Customer();
		// System.out.println(str2.getFindcustomerid());
		// stmt.executeUpdate();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println("FIRSTNAME " + rs.getString("first_name") + "\nLASTNAME " + rs.getString("last_name")
					+ "\nADDRESS " + rs.getString("address") + "\nPHONE " + rs.getLong("phone") + "\nEMAIL\n "
					+ rs.getString("email"));
		} 
		

	}
	
	
	
	
	
	
	
	
	
	
	
}