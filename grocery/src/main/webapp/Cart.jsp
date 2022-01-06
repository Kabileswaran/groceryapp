
<%@page import="com.grocery.daoimpl.OrderDaoImpl"%>
<%@page import="com.grocery.model.Order"%>
<%@page import="com.grocery.daoimpl.CartDaoImpl"%>
<%@page import="com.grocery.model.Cart"%>
<%@page import="com.grocery.model.Feature"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.grocery.model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.grocery.daoimpl.CustomerDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, Helvetica, sans-serif;
        }
     #allusers{
       position: absolute;
       top:100px;
       left:200px;
       right: 200px;
       bottom: 100px;
       }
       
   
        body{
            background-color: white;

            }
        #allusers table,th,tr,td{
        border: 1px solid black;
        border-collapse: collapse;
        padding: 10px;
        }
    </style>
</head>
<h1><a href="Logout.jsp">logout</a></h1>
<body>
<% 
int oid = 0;

Customer customer = (Customer) session.getAttribute("logincustomer");
 
	int cid=customer.getCustomerid();
	Order order = new Order();
	order.setCustomerid(cid);
	OrderDaoImpl obj1 = new OrderDaoImpl();
	int ojid = obj1.cartCheck(order);
	if(ojid>0)
	{
		oid=ojid;
	}  
	session.setAttribute("logincustomerorderId", oid); 
%>
<% Feature feature = new Feature();
feature.setOrderId(oid);
CartDaoImpl obj =new CartDaoImpl();
List<Feature> cartlist= obj.showCartin(feature);
double total= obj.showCartinTotal(feature);%>
<div id="allusers">
<table>
<thead>
<tr>
<th>Product Name</th>
<th>Price</th>
<th>Quantity</th>
<th>total</th>
<th>Delete</th>
</tr>
</thead>
<tbody>
<%for(Feature list: cartlist){ %>
<tr>
<td><%=list.getProductName()%></td>
<td><%=list.getPrice() %></td>
<td><%=list.getQuantity()%></td>
<td><%=list.getCost() %></td>
<td ><a href="Deleteproductincart?pId=<%=list.getProductId()%>">delete </a><td>
</tr>
<%} %>
</tbody>
</table>
<h4><a href="ConformOrder">conform </a></h4>
<% out.print( total); %>
<h2></h2>
</div>
</body>

</html>