<%@page import="com.grocery.model.Order"%>
<%@page import="com.grocery.daoimpl.OrderDaoImpl"%>
<%@page import="com.grocery.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.grocery.daoimpl.ProductDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New product</title>
</head>
<style>
body {font-family: "Lato", sans-serif;}

.sidebar {
  height: 100%;
  width: 160px;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: lightgreen;
  overflow-x: hidden;
  padding-top: 16px;
}

.sidebar a {
  padding: 20px 2px 8px 16px;
  text-decoration: none;
  font-size: 15px;
  color: black;
  display: block;
  font-family:Arial Black;
}

.sidebar a:hover {
  color: #f1f1f1;
}

.main {
  margin-left: 160px; /* Same as the width of the sidenav */
  padding: 0px 10px;
}
 #allusers table,th,tr,td{
        border: 1px solid black;
        border-collapse: collapse;
        padding: 10px;
        }
             #allusers{
       position: absolute;
       top:100px;
       left:200px;
       right: 200px;
       bottom: 100px;
       }
        
@media screen and (max-height: 450px) {
  .sidebar {padding-top: 15px;}
  .sidebar a {font-size: 18px;}
}
</style>
<body>


<div class="sidebar">
<a href="AdminView.jsp"><i class="fa fa-fw fa-home"></i> HOME</a>
  <a href="Orders.jsp"><i class="fa fa-fw fa-home"></i> BACK</a>
   <a href="Logout.jsp"><i class="fa fa-fw fa-wrench"></i> LOGOUT</a>
</div>

<div class="main"></div>
 <% OrderDaoImpl obj =new OrderDaoImpl();
 Order order =new Order();
List<Order> OrderList =obj.orderdetails();%>
<div id="allusers">
<table>
<thead>
<tr>
<th>OrderId</th>
<th>Status</th>
<th>Date</th>
</tr>
</thead>
<tbody>
<%for(Order product:OrderList){ %>
<tr>
<td><%=product.getOrderid()%></td>
<td><%=product.getStatus()%></td>
<td><%=product.getOrderdate()%></td>

</tr>
<%} %>
</tbody>
</table>
  
</div>
</body>
</html>


