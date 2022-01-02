
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
<% %>
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
</tr>
</thead>
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
</body>

</html>