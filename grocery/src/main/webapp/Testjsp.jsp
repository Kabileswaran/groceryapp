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
<% Customer customer = (Customer) session.getAttribute("logincustomer");%>
	
  <a href="#AddProduct.jsp"><i class="fa fa-fw fa-home"></i><% out.print( customer.getFirstName()); %> </a>
  <a href="LoginUserProfile.jsp"><i class="fa fa-fw fa-wrench"></i> UserProfile</a>
  <a href="CustomerOrder.jsp"><i class="fa fa-fw fa-user"></i> ViewOrder</a>
  <a href="Logout.jsp"><i class="fa fa-fw fa-envelope"></i> Logout</a>
</div>

<div class="main"></div>
  <% ProductDaoImpl obj = new ProductDaoImpl();
List<Product> productList =obj.ViewAllProducts();
     session.setAttribute("productList", productList);%>
<div id="allusers">
<table>
<thead>
<tr>
<th>ProductName</th>
<th>UnitPrice</th>
<th>Quantity</th>
</tr>
</thead>
<tbody>
<form action="PlaceOrder">
<%for(Product product:productList){ %>
<tr>
<td><%=product.getProductName()%></td>
<td><%=product.getProductPrice() %></td>
<td><input type="number" name="<%=product.getProductName()%>" min="0"></td>

</tr>
<%} %>
<button type="submit">conform</button>
</form>
</tbody>
</table>
</div>
  
</div>
</body>
</html>


