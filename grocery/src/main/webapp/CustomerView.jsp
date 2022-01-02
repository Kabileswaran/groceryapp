<%@page import="com.grocery.model.Customer"%>
<%@page import="com.grocery.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.grocery.daoimpl.ProductDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>customer view</h1>
	<ul> 
	<li></li>
	<li></li>
	<li></li>
	<li></li>
	<li></li>
	</ul>
	<% Customer customer = (Customer) session.getAttribute("logincustomer");%>
	<% out.print( customer.getFirstName()); %>
<a href="ProfileView.jsp">profile</a>
	<%
	ProductDaoImpl obj = new ProductDaoImpl();
	List<Product> productList = obj.viewAllProducts();
	for (int i = 0; i < productList.size(); i++) {
		out.print(productList.get(i));
	}
	%>
</body>
</html>