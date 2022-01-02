<%@page import="com.grocery.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Customer customer = (Customer) session.getAttribute("logincustomer");%>
<%out.print(customer.getFirstName()); %>
<%out.print(customer.getLastName()); %>
<%out.print(customer.getEmailid()); %>
<%out.print(customer.getAddress()); %>
<%out.print(customer.getPhonenumber()); %>
<%out.print(customer.getUsername()); %>
</body>
</html>