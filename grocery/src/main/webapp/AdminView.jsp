<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
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

@media screen and (max-height: 450px) {
  .sidebar {padding-top: 15px;}
  .sidebar a {font-size: 18px;}
}
</style>
<body>


<div class="sidebar">
  <a href="AdminAllUser.jsp"><i class="fa fa-fw fa-home"></i> ALL USERS</a>
  <a href="Sale.jsp"><i class="fa fa-fw fa-wrench"></i> SALE DETAILS</a>
  <a href="Orders.jsp"><i class="fa fa-fw fa-user"></i> ORDERS</a>
  <a href="Product.jsp"><i class="fa fa-fw fa-envelope"></i> PRODUCTS</a>
</div>

<div class="main">
  <h1>WELCOME ADMIN</h1>
</div>
</body>
</html>


