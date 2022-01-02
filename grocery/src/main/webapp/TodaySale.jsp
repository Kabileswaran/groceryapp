
<%@page import="com.grocery.model.Feature"%>
<%@page import="java.util.List"%>
<%@page import="com.grocery.daoimpl.OrderDaoImpl"%>
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
<% OrderDaoImpl obj =new OrderDaoImpl();
List<Feature> sale =obj.todaySale();
double b =obj.todaySales();%>
<div id="allusers">
<table>
<thead>
<tr>
<th>ProductName</th>
<th>UnitPrice</th>
<th>Quantity</th>
<th>Cost</th>
</tr>
</thead>
<tbody>
<%for(Feature feature:sale){ %>
<tr>
<td><%=feature.getProductName() %></td>
<td><%=feature.getPrice()%></td>
<td><%=feature.getQuantity() %></td>
<td><%=feature.getCost() %></td>

</tr>
<%} %>
<h1>Total </h1>
<h1><%out.print(b); %></h1>
</tbody>
</table>

</div>
</body>

</html>