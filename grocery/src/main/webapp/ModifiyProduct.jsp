<%@page import="com.grocery.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.grocery.daoimpl.ProductDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Product Name</title>
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
  <a href="Product.jsp"><i class="fa fa-fw fa-home"></i> BACK</a>
   <a href="Logout.jsp"><i class="fa fa-fw fa-wrench"></i> LOGOUT</a>
</div>

<div class="main"></div>
  
<div id="allusers">
<form action="ModifiyProduct">
<label>Enter the product ID</label>
<input type="text" name="pID" pattern="[1-9]{1,}" required><br><br>
<label>Enter the New product Name</label>
<input type="text" name="pName" required><br><br>
<button type="submit" >submit</button>
</form>
</div>
  
</div>
</body>
</html>


