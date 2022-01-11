<%@page import="com.grocery.daoimpl.CartDaoImpl"%>
<%@page import="com.grocery.model.Feature"%>
<%@page import="com.grocery.daoimpl.OrderDaoImpl"%>
<%@page import="com.grocery.model.Order"%>
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
<title>Cart</title>
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
<a href="CustomerView.jsp"><i class="fa fa-fw fa-home"></i> Home</a>
   <a href="Logout.jsp"><i class="fa fa-fw fa-wrench"></i> Logout</a>
</div>

<div class="main"></div>
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
<th>Product </th>
<th>Product Name</th>
<th>Price</th>
<th>Quantity</th>
<th>Total</th>
<th>Delete</th>
</tr>
</thead>
<tbody>
<%for(Feature list: cartlist){ %>
<tr>
<td><img alt="" src="assets/<%=list.getProductImage()%>"width="120" height="80"></td>
<td><%=list.getProductName()%></td>
<td><%=list.getPrice() %></td>
<td><input type="button" value="-" onclick="window.location='DecreaseQuantity?pId=<%=list.getProductId()%>'" ><%=list.getQuantity()%>
<input type="button" value="+" onclick="window.location='IncreaseQuantity?pId=<%=list.getProductId()%>'" ></td>
<td><%=list.getCost() %></td>
<td><input type="button" value="Remove" onclick="window.location='Deleteproductincart?pId=<%=list.getProductId()%>'" ></td>
</tr>
<%} %>
</tbody>
</table><br>
Total Price = <% out.print( total) ;%>/-
<h4><input type="button" value="Place the order" onclick="window.location='ConformOrder'" ></h4>
</div>
</body>
</html>


