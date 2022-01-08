<%@page import="com.grocery.model.Customer"%>
<%@page import="com.grocery.daoimpl.CustomerDaoImpl"%>
<%@page import="com.grocery.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.grocery.daoimpl.ProductDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of User</title>
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
  <a href="AdminView.jsp"><i class="fa fa-fw fa-home"></i> Home</a>
  <a href="Logout.jsp"><i class="fa fa-fw fa-wrench"></i> Logout</a>
</div>

<div class="main"></div>
  <% CustomerDaoImpl obj=new CustomerDaoImpl();
List<Customer> userList= obj.viewallLoginUser();
%>
<div id="allusers">
<table>
<thead>
<tr>
<th>Customer ID</th>
<th>First Name</th>
<th>Last Name</th>
<th>Address</th>
<th>mobile</th>
<th>UserName</th>
<th>Email</th>
</tr></thead>
<tbody>
<%for(Customer customer:userList){ %>
<tr>
<td><%=customer.getCustomerid() %></td>
<td><%=customer.getFirstName()%></td>
<td><%=customer.getLastName() %></td>
<td><%=customer.getAddress() %></td>
<td><%=customer.getPhonenumber() %></td>
<td><%=customer.getUsername()%></td>
<td><%=customer.getEmailid()%></td>
</tr>
<%} %>
</tbody>
</table>
</div>
  
</div>
</body>
</html>


