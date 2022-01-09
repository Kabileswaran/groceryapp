
<%@page import="com.grocery.model.Order"%>
<%@page import="com.grocery.model.Feature"%>
<%@page import="com.grocery.daoimpl.OrderDaoImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Details</title>
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
<a href="CustomerView.jsp"><i class="fa fa-fw fa-envelope"></i> Home</a>
<a href="CustomerOrder.jsp"><i class="fa fa-fw fa-envelope"></i> Back</a>
  <a href="Logout.jsp"><i class="fa fa-fw fa-envelope"></i> Logout</a>
</div>

<div class="main"></div>
<% int b=Integer.parseInt(request.getParameter("orderId"));
Feature feature= new Feature();
feature.setOrderId(b);
Order str =new Order();
str.setOrderid(b);
OrderDaoImpl obj =new OrderDaoImpl ();
List<Feature> orderlist=obj.userOrderDetails(feature);
String status = obj.status(str);
double c=obj.userOrderDetailse(feature);
%>

<div id="allusers">
<table>
<thead>
<tr>
<th>Product</th>
<th>ProductName</th>
<th>Price</th>
<th>Quantity</th>
<th>Cost</th>
</tr>
</thead>
<tbody>
<%for(Feature orders:orderlist){ %>
<tr>
<td><img alt="" src="assets/<%=orders.getProductImage()%>"width="120" height="80"></td>
<td><%=orders.getProductName()%></td>
<td><%=orders.getPrice()%></td>
<td><%=orders.getQuantity()%></td>
<td><%=orders.getCost()%></td>



</tr>
<%} %>
</tbody>
</table>
<h3><% out.print("Total ="+c); %></h3>
<% 
if(status.equalsIgnoreCase("conform"))
{%>

 <input type="button" value="cancel order" onclick="window.location='CancelOrder?orderId=<%=b%>'" >
<% }%>
</div>
  
</div>
</body>
</html>

