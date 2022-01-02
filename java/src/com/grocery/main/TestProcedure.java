package com.grocery.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.grocery.connection.GetConnection;

import oracle.jdbc.OracleTypes;

public class TestProcedure {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn =null;
		try {
		 conn = GetConnection.getConnections();
		CallableStatement cs = conn.prepareCall("{call test_cursor(?)}");
		cs.registerOutParameter("p_cursor", OracleTypes.CURSOR);

		cs.execute();//Running the call
		//Retrieving the cursor as ResultSet
		ResultSet rs = (ResultSet)cs.getObject("p_cursor");
		//Iterating the returned rows
		while(rs.next()){
		    //Getting column values
		    System.out.println("ID: " + rs.getString("name"));
		}
	}finally {
		conn.close();
	}
	}
}

