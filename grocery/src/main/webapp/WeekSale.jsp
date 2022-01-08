<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.grocery.model.Feature"%>
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
<title>Weekly Sale</title>
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
<a href="Sale.jsp"><i class="fa fa-fw fa-wrench"></i> Back</a>
  <a href="Logout.jsp"><i class="fa fa-fw fa-wrench"></i> Logout</a>
 
</div>

<div class="main"></div>
  <% OrderDaoImpl obj =new OrderDaoImpl();
List<Feature> sale =obj.weekSale();
double b =obj.weekSales();%>
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
<%
         Date date = new Date();
         out.print( "<h2 align = \"center\">" +date.toString()+"</h2>");
      %>
<h1>Total </h1>
<h1><%out.print(b); %></h1>
<h3><%
String todaydates =null;
String lastdates=null;
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
Calendar cal = Calendar.getInstance();
// get starting date
cal.add(Calendar.DAY_OF_YEAR, -8);

// loop adding one day in each iteration
for(int i = 0; i<8; i++){
			    cal.add(Calendar.DAY_OF_YEAR, 1);

   if(i==1)
		   {
	    lastdates =sdf.format(cal.getTime());
	   
   }
    if(i==7)
   {
    	  todaydates =sdf.format(cal.getTime());

   }
    
}
out.print("Sale Between  " +lastdates+" and "+todaydates);


 %></h3>
</tbody>
</table>
</div>
  
</div>
</body>
</html>


