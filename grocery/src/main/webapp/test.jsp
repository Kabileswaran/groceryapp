<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.grocery.util.GetConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	// TODO Auto-generated method stub
	
	String total =null;
	Connection con = GetConnection.getConnections();
	String query1 = " SELECT products_image FROM images where customers_id =8  ";
	Statement stmt1 = con.createStatement();
	ResultSet rs1 = stmt1.executeQuery(query1);
	while (rs1.next()) {
		System.out.println(" total "+rs1.getString(1));
		total = rs1.getString(1);
	}


 %>
 

</body>
</html>